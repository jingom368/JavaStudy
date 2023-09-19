package com.test.exam02;

interface InterfaceTest {

    public void print1();
    public void print2();

}

class InterfaceChild implements InterfaceTest { // implements : 구현하다.

    @Override
    public void print1() {
        System.out.println("#1 출력");
    }

    @Override
    public void print2() {
        System.out.println("#2 출력");
    }

}

public class InterfaceExam {
    public static void main(String[] args) {
        InterfaceChild interfaceChild = new InterfaceChild();
        interfaceChild.print1();
        interfaceChild.print2();       
    }    
}