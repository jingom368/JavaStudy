// 23.10.06(금) FileInputStream

package inoutput.bytestream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {
    public static void main(String[] args) {

        try(FileInputStream fis = new FileInputStream("input.txt");) {
            System.out.println(fis.read());
            int i;
            while((i=fis.read()) != -1) {
                System.out.println((char)i);
            }
            System.out.println("end");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
