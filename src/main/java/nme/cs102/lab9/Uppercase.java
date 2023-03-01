package nme.cs102.lab9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Uppercase {
    public static void main(String[] args) throws Exception {
        InputStream input = new FileInputStream("labs/lab9/uppercase_input.txt");
        OutputStream output = new FileOutputStream("labs/lab9/uppercase_output.txt");
        int i;
        while ((i = input.read()) != -1) {
            if (i >= 'a' && i <= 'z') {
                i -= 'a' - 'A';
            }
            output.write(i);
        }
        input.close();
        output.close();
    }
}
