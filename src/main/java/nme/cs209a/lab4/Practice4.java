package nme.cs209a.lab4;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Practice4 {
    public static class City {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public int getPopulation() {
            return population;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", state='" + state + '\'' +
                    ", population=" + population +
                    '}';
        }
    }

    public static Stream<City> readCities(String filename) throws IOException {
        Scanner sc = new Scanner(Objects.requireNonNull(Practice4.class.getResourceAsStream(filename)));
        return Stream.iterate(sc.nextLine(), s -> {
                    boolean result = sc.hasNextLine();
                    if (!result) {
                        sc.close();
                    }
                    return result;
                }, s -> sc.nextLine())
                .map(line -> {
                    String[] parts = line.split(", ");
                    return new City(parts[0], parts[1], Integer.parseInt(parts[2]));
                });
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Stream<City> cities = readCities("/cs209a/lab4/cities.txt");
        // Q1: count how many cities there are for each state
        // TODO: Map<String, Long> cityCountPerState = ...
        Map<String, Long> cityCountPerState = cities.collect(Collectors.groupingBy(City::getState, Collectors.counting()));
        System.out.println(cityCountPerState);


        cities = readCities("/cs209a/lab4/cities.txt");
        // Q2: count the total population for each state
        // TODO: Map<String, Integer> statePopulation = ...
        Map<String, Integer> statePopulation = cities.collect(Collectors.groupingBy(City::getState, Collectors.summingInt(City::getPopulation)));
        System.out.println(statePopulation);


        cities = readCities("/cs209a/lab4/cities.txt");
        // Q3: for each state, get the set of cities with >500,000 population
        // TODO: Map<String, Set<City>> largeCitiesByState = ...
        Map<String, Set<City>> largeCitiesByState = cities.filter(city -> city.getPopulation() > 500000)
                .collect(Collectors.groupingBy(City::getState, Collectors.toSet()));
        System.out.println(largeCitiesByState);
    }
}
