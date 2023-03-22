package nme.cs209a.lab6;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ReadingZip {
    public static void readZip(InputStream in) {
        try (ZipInputStream zipInputStream = new ZipInputStream(in)) {
            ZipEntry entry;
            int count = 0;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                String name = entry.getName();
                if (name.startsWith("java/io") || name.startsWith("java/nio")) {
                    count++;
                    System.out.println(entry.getName());
                }
            }
            System.out.printf("%d entries in total.\n", count);
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) {
        System.out.println("Reading src:");
        readZip(ReadingZip.class.getResourceAsStream("/cs209a/lab5/src.zip"));
        System.out.println();
        System.out.println("Reading class:");
        readZip(ReadingZip.class.getResourceAsStream("/cs209a/lab5/rt.jar"));
    }
}
