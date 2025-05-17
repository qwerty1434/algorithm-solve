package _2025_05.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_16916_부분문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String pattern = br.readLine();


        System.out.println(KMP(text, pattern) ? 1 : 0);

    }

    public static boolean KMP(String text, String pattern) {
        int textIndex = 0;
        int patternIndex = 0;
        int[] lps = getLPS(pattern);
        while(textIndex < text.length()) {
            if(text.charAt(textIndex) == pattern.charAt(patternIndex)) {
                textIndex++;
                patternIndex++;

                if(patternIndex == pattern.length()) {
                    return true;
                }
            }else {

                if(patternIndex > 0) {
                    patternIndex = lps[patternIndex - 1];
                }else {
                    textIndex++;
                }

            }
        }
        return false;

    }

    public static int[] getLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];

        int prefixIndex = 0;
        for(int suffixIndex = 1; suffixIndex < n; suffixIndex++) {
            while(prefixIndex > 0 && s.charAt(prefixIndex) != s.charAt(suffixIndex)) {
                prefixIndex = lps[prefixIndex-1];
            }

            if(s.charAt(prefixIndex) == s.charAt(suffixIndex)) {
                prefixIndex++;
                lps[suffixIndex] = prefixIndex;
            }
        }

        return lps;
    }
}
