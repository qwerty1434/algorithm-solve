package _2025_07.week4;

import java.util.*;
import java.io.*;
public class boj_23758_중앙값제거 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < (N+1)/2; i++) {
            answer += divideCount(arr[i]);
        }
        System.out.println(answer + 1);

    }

    public static int divideCount(int num) {
        int cnt = 0;
        while(num > 1) {
            num = num / 2;
            cnt++;
        }
        return cnt;

    }
}
