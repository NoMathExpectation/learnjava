package nme.cs102.assignment1;

import java.util.*;

public class Data {
    public static void main(String[] args) {
        long id;
        float temp;
        String PCR;

        try (Scanner sc = new Scanner(System.in)) {
            id = sc.nextLong();
            temp = sc.nextFloat();
            PCR = sc.next();
        }

        List<String> errors = new ArrayList<>();

        if (String.valueOf(id).length() != 8) {
            errors.add(" Student ID");
        }
        if(temp <= 35.0 || temp >= 45.0) {
            errors.add(" Temperature");
        }
        if (PCR.length() != 1 || !(PCR.equals("Y") || PCR.equals("N"))) {
            errors.add(" Nucleic Acid PCR test");
        }

        if(errors.isEmpty()) {
            System.out.print("Submit successfully");
        } else {
            System.out.printf("Error in%s", String.join(" and", errors.toArray(new String[0])));
        }
    }
}
