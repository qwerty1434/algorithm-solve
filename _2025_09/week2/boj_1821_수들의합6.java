package _2025_09.week2;

import java.io.*;
import java.util.*;
public class boj_1821_수들의합6 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        boolean[] v = new boolean[N];
        func(N,F,arr,v,0);
    }

    public static boolean func(int N, int F, int[] arr, boolean[] v, int depth) {
        if(depth == N) {
            if(F == drawTriangle(N,Arrays.copyOf(arr,N))) {
                for (int i = 0; i < N; i++) {
                    System.out.print(arr[i]+" ");
                }
                return true;
            }
            return false;
        }

        for(int i = 0; i < N; i++) {
            if(v[i]) continue;
            v[i] = true;
            arr[depth] = i+1;
            if(func(N, F, arr, v, depth + 1)) return true;
            v[i] = false;
        }

        return false;
    }

    public static int drawTriangle(int N, int[] arr) {
        for(int count = 0; count < N-1; count++) {
            for(int i = 0; i < N-1; i++) {
                arr[i] = arr[i] + arr[i+1];
            }
        }
        return arr[0];
    }
}
