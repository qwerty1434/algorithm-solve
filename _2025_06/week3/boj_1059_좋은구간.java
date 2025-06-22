package _2025_06.week3;

import java.util.*;
import java.io.*;
public class boj_1059_좋은구간 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int[] arr = new int[L+1];
        arr[0] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int n = Integer.parseInt(br.readLine());
        int leftNum = arr[L];
        int rightNum = arr[L];
        for(int i = 0; i < L; i++){
            if(arr[i] < n && n < arr[i+1]) {
                leftNum = arr[i];
                rightNum = arr[i+1];
                break;
            }
        }
        int cnt = 0;
        for(int i = leftNum+1; i <= rightNum-1; i++) {
            for(int j = i+1; j <= rightNum-1; j++) {
                if(i <= n && n <= j) cnt++;
            }
        }

        System.out.println(cnt);
    }
}

