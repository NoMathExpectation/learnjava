package nme.cs102.lab9;

import java.io.File;

public class FileList {
    public static void main(String[] args) {
        for (File f: new File(".").listFiles()) {
            System.out.println(f.getName());
        }
    }
}
