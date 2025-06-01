package _2025_05.week5;

import java.io.*;
import java.util.*;

public class boj_13276_Prefix와Suffix {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String A = br.readLine();
        String B = br.readLine();
        int[] EndIdxOfA = KMP(S,A);
        int[] EndIdxOfB = KMP(S,B);
        Set<String> answer = new HashSet<>();
        for(int i=0;i<EndIdxOfA.length;i++){
            if(EndIdxOfA[i] == 0) continue;
            for(int j = i;j<EndIdxOfA.length;j++){
                if(EndIdxOfB[j] == 0) continue;
                int startIdxOfA = i - A.length()+1;
                int startIdxOfB = j - B.length()+1;
                if(startIdxOfB < startIdxOfA) continue;
                answer.add(S.substring(startIdxOfA,j+1));
            }
        }

        System.out.println(answer.size());

    }

    public static int[] KMP(String text, String pattern) {
        int textIdx = 0;
        int patternIdx = 0;
        int[] patternLps = getLPS(pattern);
        int[] arr = new int[text.length()];

        while(textIdx < text.length()) {
            if(text.charAt(textIdx) == pattern.charAt(patternIdx)) {
                textIdx++;
                patternIdx++;
                if(patternIdx == pattern.length()) {
                    arr[textIdx-1] = 1;
                    patternIdx = patternLps[patternIdx-1];
                }
            }else{
                if(patternIdx > 0) {
                    patternIdx = patternLps[patternIdx-1];
                }else{
                    textIdx++;
                }
            }
        }

        return arr;

    }

    public static int[] cumSumArr(int[] arr) {
        int[] cumSum = new int[arr.length];
        cumSum[0] = arr[0];
        for(int i = 1; i < arr.length; i++) {
            cumSum[i] = cumSum[i-1] + arr[i];
        }
        return cumSum;
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
