package _2025_07.week4;

import java.util.*;
import java.io.*;
public class boj_1946_신입사원 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a-1] = b;
            }
            int answer = 1;
            int lowestGrade = arr[0];
            for (int j = 1; j < N; j++) {
                if(arr[j] < lowestGrade) {
                    answer ++;
                    lowestGrade = Math.min(lowestGrade, arr[j]);
                }
            }

            System.out.println(answer);
        }


    }
}
