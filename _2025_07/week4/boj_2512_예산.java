package _2025_07.week4;

import java.util.*;
import java.io.*;
public class boj_2512_예산 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            now += arr[i];
            max = Math.max(max,arr[i]);
        }
        int budget = Integer.parseInt(br.readLine());
        if(now <= budget) {
            System.out.println(max);
        }else{
            binarySearch(N,arr,budget);
        }

    }

    public static void binarySearch(int N, int[] arr, int budget) {
        int start = 0;
        int end = budget;
        int answer = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            if(isPossible(mid,arr,budget)) {
                start = mid+1;
                answer = Math.max(answer,mid);
            }else {
                end = mid-1;
            }
        }
        System.out.println(answer);
    }

    public static boolean isPossible(int limit, int[] arr, int budget) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            num += Math.min(arr[i],limit);
        }
        return budget >= num;
    }
}