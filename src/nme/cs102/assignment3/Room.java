package nme.cs102.assignment3;

import java.util.Locale;
import java.util.Scanner;

public class Room {
    public static String getFence(String cipher) {
        int n = Integer.parseInt(String.valueOf(cipher.charAt(cipher.length() - 1)));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < cipher.length() - 1) {
                char c = cipher.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    c = String.valueOf(c).toUpperCase(Locale.ROOT).charAt(0);
                }
                sb.append(c);
                j += n;
            }
        }

        return sb.toString();
    }

    public static String getCaesar(String cipher, int N) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);

            if (c >= 'a' && c <= 'z') {
                c = String.valueOf(c).toUpperCase(Locale.ROOT).charAt(0);
            }

            if (c < 'A' || c > 'Z') {
                sb.append(c);
                continue;
            }

            c += N;
            if (c < 'A') {
                c += 26;
            }
            if (c > 'Z') {
                c -= 26;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static String getAnswer(String fenceCipher, String caesarCipher, int caesarN, int M) {
        String vigenereCipher = getCaesar(caesarCipher, caesarN);
        String keys = getFence(fenceCipher).substring(0, M);
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (int j = 0; j < vigenereCipher.length(); j++) {
            char c = vigenereCipher.charAt(j);

            if (c < 'A' || c > 'Z') {
                sb.append(c);
                continue;
            }

            c += keys.charAt(i++ % keys.length()) - 'A';
            if (c > 'Z') {
                c -= 26;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            String f = sc.nextLine();
            String c = sc.nextLine();
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(getAnswer(f, c, n, m));
        }
    }
}
