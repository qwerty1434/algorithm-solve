package _2025_08.week3;

import java.io.*;
import java.util.*;

public class boj_21318_피아노체조 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] cumSum = new int[N+1];
        for(int i = 1; i < N; i++){
            cumSum[i] = cumSum[i-1] + ((arr[i-1] > arr[i]) ? 1 : 0);
        }
        cumSum[N] = cumSum[N-1];

        Integer Q = Integer.parseInt(br.readLine());
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(cumSum[y-1] - cumSum[x-1]);
        }
    }
}
