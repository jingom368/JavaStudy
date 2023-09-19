package com.test.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberInfoView {
    public static void main(String[] args) {
        
        // Member member = new Member("김철수","남성", 23);

        List<Member> list = new ArrayList<>(); // 동적 배열을 지원하는 Collector Framework
        list.add(new Member("김철수","남성",23));
        list.add(new Member("장진웅","남성",29));
        list.add(new Member("김철웅","남성",36));
        list.add(new Member("유지희","여성",21));
        list.add(new Member("변수현","여성",32));

        for(Member member : list) {
            System.out.println(member.getName() + "\t" + member.getGender() + "\t" + member.getAge());
        }

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i).getName() + "\t" + list.get(i).getGender() 
                + "\t" + list.get(i).getAge());
        }

        List<Map<Integer, Integer>> listFruits = new ArrayList<>();

        int aa = 0;
        for (int i=0; i<3; i++) {
            Map<Integer, Integer> map = new HashMap<>();
        
            map.put(i, aa*10);
            aa ++;
            listFruits.add(map);
            System.out.println(listFruits.get(i).toString());
        }

        // Map<String, Integer> map = new HashMap<>();
        // List<Map<String, Integer>> listFruits = new ArrayList<>();

        // map.put("사과",10);
        // listFruits.add(map);

        // map.put("배",20);
        // listFruits.add(map);

        // map.put("수박",30);
        // listFruits.add(map);

        // for(int i=0; i<listFruits.size(); i++) {
        //     System.out.println(listFruits.get(i).toString());
        // }

        // for(Map<String, Integer> m : listFruits) {
        //     System.out.println(m.toString());
        // }
    }
}
