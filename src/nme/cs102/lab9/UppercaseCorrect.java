package nme.cs102.lab9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UppercaseCorrect {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String sentence = sc.nextLine();
            Pattern p = Pattern.compile("(?<=\\? |! |\"|\" |[a-z]\\. |^)[a-z]");
            Matcher m = p.matcher(sentence);

            StringBuilder sb = new StringBuilder();
            int start = 0;
            while (m.find()) {
                char c = (char) (sentence.charAt(m.start()) - ('a' - 'A'));
                sb.append(sentence.substring(start, m.start()));
                sb.append(c);

                start = m.end();
            }

            sb.append(sentence.substring(start));

            System.out.println(sb);
        }
    }
}
