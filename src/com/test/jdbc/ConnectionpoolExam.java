// 23.09.21(목) HikariConnection Pool

package com.test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.member.Member;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionpoolExam {
    public static void main(String[] args) {

        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        hikariConfig.setUsername("springdev");
        hikariConfig.setPassword("12345");
        hikariConfig.setConnectionInitSql("select sysdate from dual"); // 확인
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setLeakDetectionThreshold(30000); // 30초까지는 기다려준다는 의미
        hikariConfig.setPoolName("Oracle-HikariCP"); 

        String query = "select id, name, gender, age from tbl_test order by id desc";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        HikariDataSource ds = new HikariDataSource(hikariConfig);

        List<Member> list = new ArrayList<>();

        try {
            con = ds.getConnection(); // HikariConnection Pool을 통해서 DB 접속이 이루어짐...
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()) {
                list.add(new Member.Builder()
                                    .id(rs.getInt("id"))
                                    .name(rs.getString("name"))
                                    .gender(rs.getString("gender"))
                                    .age(rs.getInt("age"))
                                    .build());
            }

            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(con != null) con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        list.stream().filter(member -> member != null).forEach(member ->System.out.println("번호 : " + member.getId() + "\t" +
        "이름 : " + member.getName() + "\t" +
        "성별 : " + member.getGender() + "\t" +
        "나이 : " + member.getAge()));
    }
}
