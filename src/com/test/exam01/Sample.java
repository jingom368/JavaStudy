package com.test.exam01;

public class Sample {
    int x, y; // 전역 변수 (Global 변수) --> Property
    static int result;

    void add1(int a, int b) { // 매개변수, Parameter
        x=a;
        y=b;
        int sum = x+y; // 로컬변수, 지역변수
        System.out.println("Sum = "+sum);    
    }

    void add2(int a, int b) { // 매개변수, Parameter
        x=a;
        y=b;
        int sum = x+y; // 로컬변수, 지역변수
        System.out.println("Sum = "+sum);    
        System.out.println("합을 출력");
    }

    public static void main(String args[]) {
        Sample obj = new Sample();
        obj.add1(10,20);
    }
}