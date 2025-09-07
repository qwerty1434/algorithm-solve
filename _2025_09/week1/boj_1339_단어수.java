package _2025_09.week1;

import java.io.*;
import java.util.*;

public class boj_1339_단어수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Integer[] nums = new Integer[26];
        Arrays.fill(nums, 0); // Integer라 초기값 필요
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++){
                nums[s.charAt(j) - 'A'] += (int) Math.pow(10, s.length() - 1 - j);;
            }
        }
        Arrays.sort(nums,Collections.reverseOrder());

        int answer = 0;
        for(int i = 0; i < 10; i++){
            answer += nums[i] * (9 - i);
        }
        System.out.println(answer);


    }

}
