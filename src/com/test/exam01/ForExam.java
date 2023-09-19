package com.test.exam01;

public class ForExam {
    public static void main(String[] args) {
        int a=3;
        if(a>5) {
            System.out.println("5보다 크네요...");
            System.out.println("값이 뭔가요?");
        }
        else if (a>3) {
            System.out.println("3보다 크네요...");
            System.out.println("값이 뭔가요?");
        }
        else if (a>2) {
            System.out.println("2보다 크네요...");
            System.out.println("값이 뭔가요?");
        }

        int b;
        b = a==3?5:6;
        System.out.println("b의 값은 "+ b + "입니다");

        int c=4;
        switch(c) {
            case 3: System.out.println("3입니다");
                    break; // 조건에 맞으면 블록에서 빠져 나와라...
            case 4: System.out.println("4입니다");
                    break;
            default: System.out.println("무슨 값인지 모르겠습니다"); //생략 가능, 맞는 조건이 없을 때 수정
        }

        /////////////////// 반복문 예제 ////////////////////////

        int i=0;
        int sum=0;

        // for(시작; 조건; 증가) {}
        for(i=0; i<=100; sum+= i++);
        System.out.println("\n" + "#1 For문을 이용한 계산1 : sum =" + sum);

        sum=0;
        for(i=0; i<=100; i++) {
            sum = sum + i;
            System.out.println(sum);
        }
        System.out.println("\n" + "#1 For문을 이용한 계산2 : sum =" + sum);

        // while(조건) {};
        i=0; sum=0;
        while(i<=100) sum += i++;
        System.out.println("\n" + "#2 while문을 이용한 계산 : sum =" + sum);
        
        i=0; sum=0;
        while(true) {
            sum += i++;
            if(i>100) break;
        }
        System.out.println("\n" + "#3 while문 + break을 이용한 계산 : sum =" + sum);
   
        i=0; sum=0;
        while(true) {
            sum += i++;
            if(i<=100) continue;
                else break;
        }
        System.out.println("\n" + "#4 while문 + continue + break을 이용한 계산 : sum =" + sum);
       
        i=0; sum=0;
        do {
            sum += i++;
        } while(i<=100);
        System.out.println("\n" + "#5 do-while문을 이용한 계산 : sum =" + sum);
    }
}
