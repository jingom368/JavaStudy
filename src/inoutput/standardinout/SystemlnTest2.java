// 23.10.06(금) SystemIn

package inoutput.standardinout;

import java.io.IOException;

public class SystemlnTest2 {
    public static void main(String[] args) {
        System.out.println("알파벳 여러 개를 쓰고 [Enter]를 누르세요");

        int i;
        try {
            while((i = System.in.read( )) != '\n') {
                System.out.print((char)i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
