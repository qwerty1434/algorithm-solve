package _2025_05.week3;

import java.io.*;
import java.util.*;

public class boj_1701_Cubeditor {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            String pattern = s.substring(i,s.length());
            int[] lps = getLPS(pattern);
            for(int j = 0; j < lps.length; j++) {
                answer = Math.max(answer, lps[j]);
            }
        }
        System.out.println(answer);

    }

    public static int[] getLPS(String s) {
        int n = s.length();
        int[] arr = new int[n];

        int prefixIndex = 0;
        for(int suffixIndex = 1; suffixIndex < n; suffixIndex++) {

            while(prefixIndex > 0 && s.charAt(prefixIndex) != s.charAt(suffixIndex)) {
                prefixIndex = arr[prefixIndex - 1];
            }

            if(s.charAt(prefixIndex) == s.charAt(suffixIndex)) {
                prefixIndex++;
                arr[suffixIndex] = prefixIndex;
            }

        }
        return arr;
    }

}
