package _2025_09.week3;

import java.io.*;
import java.util.*;
public class boj_10830_행렬제곱 {
    public static final int MODULER = 1_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % MODULER;
            }
        }

        int[][] result = divideAndConquer(arr,N,B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static int[][] divideAndConquer(int[][] arr, int N, long B) {
        if(B == 1) return arr;
        int[][] half = divideAndConquer(arr,N,B/2);
        if(B%2 == 0) return multiple(half,half,N);
        return multiple(arr,multiple(half,half,N),N);
    }

    public static int[][] multiple(int[][] arr1, int[][] arr2, int N) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res[i][j] += (arr1[i][k] * arr2[k][j]) % MODULER;
                }
                res[i][j] %= MODULER;
            }
        }
        return res;
    }
}

/**
 * 1. 분할정복할때 half 계산을 각각 하지말고 한번만 계산해두고 쓴다
 * 2. 행렬의 원소가 1000이고 B가 1일 경우 multiple을 수행하지 않아 moduler 연산이 적용되지 않는다. 입력받을 때 한번 moduler연산을 하자
 */