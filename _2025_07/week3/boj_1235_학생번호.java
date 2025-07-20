package _2025_07.week3;

import java.io.*;
import java.util.*;

public class boj_1235_학생번호 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        int length = arr[0].length();

        for(int k = 1; k <= length; k++) {
            if(possible(N,length,k,arr)) {
                System.out.println(k);
                return;
            }
        }
    }

    public static boolean possible(int N, int length, int k, String[] arr) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(arr[i].substring(length-k));
        }
        return set.size() == N;

    }

}
