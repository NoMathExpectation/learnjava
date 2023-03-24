package nme.cs209a.assignment1;

import nme.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This is just a demo for you, please run it on JDK17 (some statements may be not allowed in lower version).
 * This is just a demo, and you can extend and implement functions
 * based on this demo, or implement it in a different way.
 */
public class OnlineCoursesAnalyzer {
    private final List<Course> courses = new ArrayList<>();

    public OnlineCoursesAnalyzer(String datasetPath) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try (BufferedReader br = new BufferedReader(new FileReader(datasetPath, StandardCharsets.UTF_8));) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", -1);
                Course course = new Course(info[0], info[1], LocalDate.parse(info[2], pattern), info[3], info[4], info[5],
                        Integer.parseInt(info[6]), Integer.parseInt(info[7]), Integer.parseInt(info[8]),
                        Integer.parseInt(info[9]), Integer.parseInt(info[10]), Double.parseDouble(info[11]),
                        Double.parseDouble(info[12]), Double.parseDouble(info[13]), Double.parseDouble(info[14]),
                        Double.parseDouble(info[15]), Double.parseDouble(info[16]), Double.parseDouble(info[17]),
                        Double.parseDouble(info[18]), Double.parseDouble(info[19]), Double.parseDouble(info[20]),
                        Double.parseDouble(info[21]), Double.parseDouble(info[22]));
                courses.add(course);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //1
    public Map<String, Integer> getPtcpCountByInst() {
        return courses.stream()
                .parallel()
                .collect(Collectors.groupingBy(c -> c.institution, TreeMap::new, Collectors.summingInt(c -> c.participants)));
    }

    //2
    public Map<String, Integer> getPtcpCountByInstAndSubject() {
        return courses.stream()
                .parallel()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(c -> c.institution + '-' + c.subject, Collectors.summingInt(c -> c.participants)), map -> {
                    TreeSet<Map.Entry<String, Integer>> sortedEntries = new TreeSet<>(Comparator.comparingInt((Map.Entry<String, Integer> e) -> -e.getValue()).thenComparing(Map.Entry::getKey));
                    sortedEntries.addAll(map.entrySet());
                    Map<String, Integer> sorted = new LinkedHashMap<>();
                    sortedEntries.forEach(e -> sorted.put(e.getKey(), e.getValue()));
                    return sorted;
                }));
    }

    //3
    public Map<String, List<List<String>>> getCourseListOfInstructor() {
        Map<String, List<List<String>>> instructorCourseMap = new TreeMap<>();
        courses.forEach(c -> {
            boolean single = c.instructors.size() <= 1;
            c.instructors.forEach(i -> {
                List<List<String>> courseList = instructorCourseMap.computeIfAbsent(i, k -> List.of(new ArrayList<>(), new ArrayList<>()));
                List<String> list;
                if (single) {
                    list = courseList.get(0);
                } else {
                    list = courseList.get(1);
                }
                if (!list.contains(c.title)) {
                    list.add(c.title);
                }
            });
        });
        instructorCourseMap.values().forEach(l -> l.forEach(x -> x.sort(null)));
        return instructorCourseMap;
    }

    //4
    public List<String> getCourses(int topK, String by) {
        Comparator<Course> comparator;
        switch (by) {
            case "hours":
                comparator = Comparator.comparingDouble((Course c) -> c.totalHours).reversed();
                break;
            case "participants":
                comparator = Comparator.comparingInt((Course c) -> c.participants).reversed();
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting argument: " + by);
        }
        comparator = comparator.thenComparing(c -> c.title);
        return courses.stream()
                .parallel()
                .sorted(comparator)
                .distinct()
                .limit(topK)
                .map(c -> c.title)
                .collect(Collectors.toList());
    }

    //5
    public List<String> searchCourses(String courseSubject, double percentAudited, double totalCourseHours) {
        return courses.stream()
                .parallel()
                .filter(c -> c.subject.toLowerCase().contains(courseSubject.toLowerCase()) && c.percentAudited >= percentAudited && c.totalHours <= totalCourseHours)
                .map(c -> c.title)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    //6
    public List<String> recommendCourses(int age, int gender, int isBachelorOrHigher) {
        return courses.stream()
                .parallel()
                .collect(Collectors.groupingBy(c -> c.number, Collectors.collectingAndThen(Collectors.toList(), set -> {
                    double diffMedianAge = age - set.stream().mapToDouble(c -> c.medianAge).average().orElse(0);
                    double diffPercentMale = gender * 100 - set.stream().mapToDouble(c -> c.percentMale).average().orElse(0);
                    double diffPercentBachelorOrHigher = isBachelorOrHigher * 100 - set.stream().mapToDouble(c -> c.percentDegree).average().orElse(0);
                    return diffMedianAge * diffMedianAge + diffPercentMale * diffPercentMale + diffPercentBachelorOrHigher * diffPercentBachelorOrHigher;
                }))).entrySet()
                .stream()
                .parallel()
                .map(e -> new Pair<>(e.getValue(), courses.stream()
                        .filter(c -> c.number.equals(e.getKey()))
                        .max(Comparator.comparing(c -> c.launchDate))
                        .orElseThrow()
                        .title))
                .sorted(Comparator.comparingDouble((Pair<Double, String> e) -> e.first).thenComparing(e -> e.second))
                .map(e -> e.second)
                .distinct()
                .limit(10)
                .collect(Collectors.toList());
    }
}
