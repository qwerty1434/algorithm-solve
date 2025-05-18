package _2025_05.week3;

import java.io.*;

public class boj_1786_찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();
        KMP(T,P);
    }

    public static void KMP(String text, String pattern) {
        int textIdx = 0;
        int patternIdx = 0;
        int[] lps = getLPS(pattern);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        while(textIdx < text.length()) {
            if(text.charAt(textIdx) == pattern.charAt(patternIdx)) {
                textIdx++;
                patternIdx++;
                if(patternIdx == pattern.length()) {
                    cnt++;

                    sb.append(textIdx - pattern.length() + 1);
                    sb.append(" ");
                    patternIdx = lps[patternIdx-1];
                }
            }else {
                if(patternIdx > 0) {
                    patternIdx = lps[patternIdx-1];
                }else {
                    textIdx++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());

    }

    public static int[] getLPS(String s) {
        int[] arr = new int[s.length()];

        int prefixIdx = 0;
        for(int suffixIdx = 1; suffixIdx < s.length(); suffixIdx++) {

            while(prefixIdx > 0 && s.charAt(prefixIdx) != s.charAt(suffixIdx)) {
                prefixIdx = arr[prefixIdx-1];
            }


            if(s.charAt(prefixIdx) == s.charAt(suffixIdx)) {
                prefixIdx++;
                arr[suffixIdx] = prefixIdx;
            }
        }
        return arr;
    }
}
