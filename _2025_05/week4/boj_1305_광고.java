package _2025_05.week4;

import java.util.*;
import java.io.*;

public class boj_1305_광고 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[] lps = getLPS(s);
        System.out.println(L - lps[L-1]);
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
