package _2025_05.week4;

import java.util.*;
import java.io.*;
public class boj_13506_카멜레온부분문자열 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer = findAnswer(s);
        System.out.println(answer);
    }

    public static String findAnswer(String s) {
        int[] lps = getLPS(s);
        for(int i = lps[lps.length-1]; i >= 1; i--){
            if(!s.substring(0,i).equals(s.substring(s.length()-i,s.length()))) continue;
            if(KMP(s.substring(0,i), s.substring(1,s.length()-1))){
                return s.substring(0,i);
            }
        }
        return "-1";

    }

    public static boolean KMP(String pattern, String text) {
        int patternIdx = 0;
        int textIdx = 0;
        int[] lps = getLPS(pattern);

        while(textIdx < text.length()) {
            if(text.charAt(textIdx) == pattern.charAt(patternIdx)) {
                patternIdx++;
                textIdx++;
                if(patternIdx == pattern.length()) {
                    return true;
                }
            }else{
                if(patternIdx > 0) {
                    patternIdx = lps[patternIdx - 1];
                }else {
                    textIdx++;
                }
            }
        }

        return false;
    }

    public static int[] getLPS(String s) {
        int[] arr = new int[s.length()];
        int prefixIdx = 0;
        for (int suffixIdx = 1; suffixIdx < s.length(); suffixIdx++) {
            while(prefixIdx > 0 && s.charAt(prefixIdx) != s.charAt(suffixIdx)) {
                prefixIdx = arr[prefixIdx-1];
            }

            if(s.charAt(suffixIdx) == s.charAt(prefixIdx)) {
                prefixIdx++;
                arr[suffixIdx] = prefixIdx;
            }
        }
        return arr;
    }
}
