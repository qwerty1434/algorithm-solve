package _2025_09.week3;

import java.io.*;
import java.util.*;
public class boj_11582_치킨TOPN {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int groupSize = N/k;
        for(int i = 0; i < N; i+=groupSize) {
            int[] copy = Arrays.copyOfRange(arr, i, i + groupSize);
            Arrays.sort(copy);
            for(int j = 0; j < groupSize; j++) {
                sb.append(copy[j]);
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

    }



}
