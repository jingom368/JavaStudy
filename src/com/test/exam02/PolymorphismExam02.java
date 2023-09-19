package com.test.exam02;

public class PolymorphismExam02 {
    public static void main(String[] args) {
        new Animalmove(new Human1());
        new Animalmove(new Tiger1());
        new Animalmove(new Eagle1());
    }
}

class Animalmove { // 스프링 배울 때 의존성 주입의 기본 작동 원리...
    Animal1 animal; // 멤버 변수
    public Animalmove(Animal1 animal) {
        this.animal = animal;
        animal.move();
    }
}

interface Animal1 {
    public void move();
}

class Human1 implements Animal1 {

    @Override
    public void move() {
        System.out.println("사람이 두발로 걷습니다.");
    }
}

class Tiger1 implements Animal1 {

    @Override
    public void move() {
        System.out.println("호랑이가 네발로 뜁니다.");
    }
}

class Eagle1 implements Animal1 {

    @Override
    public void move() {
        System.out.println("독수리가 하늘로 납니다.");
    }
}


