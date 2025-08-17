package _2025_08.week3;

import java.io.*;

public class boj_1515_수이어쓰기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int idx = 0;
        int answer = 0;

        while(idx < s.length()) {
            answer++;
            for(int i = 0; i < Integer.toString(answer).length(); i++) {
                if(Integer.toString(answer).charAt(i) == s.charAt(idx)) {
                    idx++;
                    if(idx == s.length()) {
                        System.out.println(answer);
                        return;
                    }
                }
            }
        }

    }

}
