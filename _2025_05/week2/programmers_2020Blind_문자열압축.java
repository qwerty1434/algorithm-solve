package _2025_05.week2;

import java.io.*;
public class programmers_2020Blind_문자열압축 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = s.length();

        for(int splitSize = 1; splitSize <= s.length()/2; splitSize++) {
            answer = compareWordLength(compressWord(s, splitSize),answer);
        }

        System.out.println(answer);
    }

    public static int compareWordLength(String s, int minLength) {
        return Math.min(s.length(),minLength);
    }
    public static String compressWord(String s, int splitSize) {
        StringBuilder sb = new StringBuilder();
        String baseWord = s.substring(0,splitSize);
        int cnt = 1;
        for(int idx = splitSize; idx <= s.length()-splitSize; idx += splitSize) {
            String next = s.substring(idx, idx+splitSize);
            if(baseWord.equals(next)) {
                cnt++;
            }else{
                if(cnt > 1) {
                    sb.append(cnt);
                }
                sb.append(baseWord);
                cnt = 1;
                baseWord = next;
            }
        }
        if(cnt > 1) {
            sb.append(cnt);
        }
        sb.append(baseWord);
        sb.append(s.substring(splitSize * (s.length() / splitSize),s.length()));

        return sb.toString();

    }
}
