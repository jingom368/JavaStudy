// 23.10.06(금) SystemIn

package inoutput.standardinout;

import java.io.IOException;

public class SystemlnTest1 {
    public static void main(String[] args) {
        System.out.println("알파벳 하나만 쓰고 [Enter]를 누르세요");

        int i;
        try {
            i = System.in.read();
            System.out.println(i);
            System.out.println((char)i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
