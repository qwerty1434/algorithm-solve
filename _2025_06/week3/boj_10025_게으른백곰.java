package _2025_06.week3;

import java.io.*;
import java.util.*;
public class boj_10025_게으른백곰 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[1_000_001];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr[x] = g;
        }

        int[] cumSum = new int[1_000_002];
        for(int i = 1; i < 1_000_002; i++){
            cumSum[i] = cumSum[i-1] + arr[i-1];
        }
        int answer = 0;
        for(int position = 1; position < 1_000_002; position++){
            int leftRange = Math.max(position - K,1);
            int rightRange = Math.min(position + K,1_000_001);
            answer = Math.max(answer,cumSum[rightRange] - cumSum[leftRange - 1]);
        }
        System.out.println(answer);
    }
}
