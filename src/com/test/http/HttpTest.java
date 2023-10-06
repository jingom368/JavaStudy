// 23.10.05(목) HTTP 통신

package com.test.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {
    public static void main(String[] args) {
        String targetURL = "http://127.0.0.1/servlet/jdbctest_registry";
        String parameters = "rname=장진엉&gender=남자&age=28";
        TestHttpRequest.TestHttpRequest(targetURL, parameters);
    }
}

class TestHttpRequest {
    public static void TestHttpRequest(String targetURL, String parameters) {

        HttpURLConnection connection = null;

        // connection 생성, IOT 프로그램에서 쓰이는
        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("content-Language", "ko-KR");
            connection.setUseCaches(false); // 캐시를 남기지 않겠다.
            connection.setDoOutput(true); // OutputStream으로 POST 데이터를 넘겨주겠다는 옵션

            // Request 처리
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(parameters.getBytes("UTF-8"));
            wr.flush(); // flush : 불어넣는다
            wr.close();

            // Response 처리
            int responseCode = connection.getResponseCode();
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            
            StringBuffer response = new StringBuffer();
            String line;
            while((line = rd.readLine()) != null) {
                response.append(line).toString();
                response.append("\r\n");
            }
            rd.close();
            

            System.out.println("HTTP 응답 코드 : " + responseCode);
            System.out.println("HTTP 응답 헤더 : " + connection.getHeaderFields());
            System.out.println("HTTP BODY : " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(connection != null)
                connection.disconnect();
        }
    }
}