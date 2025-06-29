package _2025_06.week4;

import java.util.*;
import java.io.*;
public class boj_1049_기타줄 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] packagePrice = new int[M];
        int[] eachPrice = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packagePrice[i] = Integer.parseInt(st.nextToken());
            eachPrice[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(packagePrice);
        Arrays.sort(eachPrice);
        System.out.println(
                Math.min((N / 6) * packagePrice[0], (N/6) * 6 * eachPrice[0])
                + Math.min(packagePrice[0],(N%6) * eachPrice[0])
        );
    }
}
