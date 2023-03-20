package nme.cs209a.lab5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class FileType {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String fileString = sc.nextLine();
            File file = new File(fileString);
            try (FileInputStream fin = new FileInputStream(file)) {
                byte[] header = new byte[4];
                fin.read(header);

                String type = null;

                if (Arrays.equals(header, new byte[]{(byte) 0x89, 0x50, 0x4e, 0x47})) {
                    type = "png";
                }

                if (Arrays.equals(header, new byte[]{(byte) 0x50, 0x4b, 0x03, 0x04})) {
                    type = "zip or jar";
                }

                if (Arrays.equals(header, new byte[]{(byte) 0xca, (byte) 0xfe, (byte) 0xba, (byte) 0xbe})) {
                    type = "class";
                }

                if (type == null) {
                    throw new IllegalArgumentException("Unknown type.");
                }

                System.out.printf("File name: %s\n", file.getName());
                System.out.printf("File header: %s\n", Arrays.toString(header));
                System.out.printf("File type: %s\n", type);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
