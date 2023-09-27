// 23.09.18(월) 추상화

package com.test.exam02;

public class ClassExam02 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        // AbstractClass abstractClass = new AbstractClass();
        // 추상클래스는 인스턴스화를 시키지 못함
        Child1 child1 = new Child1();
        Child2 child2 = new Child2();

        parent.printHello();
        child1.printHello();
        child2.print1(); 
        child2.print2();
    }
}

class Parent {
    int a = 10;
    int b = 20;
    public void printHello() {
        System.out.println("Hello~");
    }
}

class Child1 extends Parent{

    @Override // Annotation -> 컴파일러에게 통지.. 상속받은 메서드의 내용을 조금 바꾸겠다.. 그리고 이 바꾼 것을 사용하겠다. 
    public void printHello() {
        // super.printHello();
        System.out.println("안녕");
    }

}

// 추상 클래스 -> 업무 지시서... , Framework
abstract class AbstractClass {
    int c = 100;
    int d = 200;

    public void print1() { // 추상클래스는 실행부가 있는 일반 메소드도 가질 수 있음.
        System.out.println("#1 출력");
    }

    abstract public void print2(); // 추상메소드
}

class Child2 extends AbstractClass {

    @Override
    public void print2() {
        System.out.println("추상클래스...");
    }
    
}