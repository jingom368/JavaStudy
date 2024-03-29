// 23.09.18(월) Generic

package com.test.exam02;

public class GenericTest01 {
    public static void main(String[] args) {
        Gstack<String> stringStack = new Gstack<String>(); // String 타입 자체를 인자로 넘김.

        stringStack.push("Seoul");
        stringStack.push("Busan");
        stringStack.push("LA");

        for (int i=0; i<3; i++) {
            System.out.println(stringStack.pop());
        }    
    }
}    

class Gstack<T> {
    int tos; // 선언 -> 컴파일러에게 공지
    Object [] stck; // 배열 요소의 타입은 Object... 선언

    public Gstack() { // 생성자
        tos = 0;
        stck = new Object[10];
    }

    public void push (T item) {
        if (tos==10) return;
        stck[tos] = item;
        tos++;
    }

    /*
     *  1. tos = 0, 0번째에 'Seoul', tos = 1
     *  2. tos = 1, 0번째에 'Busan', tos = 2
     *  3. tos = 2, 0번째에 'LA', tos = 3
     */

    public T pop() { 
        // 넣은 순서 반대로. 즉, 가장 늦게 넣은 값이 가장 먼저 나온다 -> Last Input First Out(LIFO)
        // 자료 구조에서 LIFO 방식으로 데이터를 관리하는 메모리 공간을 Stack
        // 반대로 가장 먼저 넣은 값이 가장 먼저 나오는 방식을 -> First Input First Out(FIFO)
        // 자료 구조에서 FIFO 방식으로 데이터를 관리하는 메모리 공간을 Queue
        if (tos==0) return null; // T가 뭐가 들어 올지 아직 정해지지 않았지만 뭔가 리턴해줘야 할 때 null을 리턴
        tos--;
        return (T)stck[tos];
    }

    /*
     *  1. tos = 3, tos = 2, stck[2] -> LA
     *  2. tos = 2, tos = 1, stck[1] -> Busan
     *  3. tos = 1, tos = 0, stck[0] -> Seoul
     */
}