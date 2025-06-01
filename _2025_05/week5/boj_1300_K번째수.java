package _2025_05.week5;

import java.io.*;
import java.util.*;

public class boj_1300_K번째수 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.println(binarySearch(N, k-1));

    }

    public static long binarySearch(int N, int k) {
        long left = 0;
        long right = 1l*N*N;
        long answer = Long.MAX_VALUE;
        while(left <= right) {
            long mid = (left+right)/2;
            if(k >= getLowerOrEqualCount(N,mid)) {
                left = mid+1;
            }else {
                answer = Math.min(mid,answer);
                right = mid-1;
            }
        }
        return answer;
    }

    public static long getLowerOrEqualCount(int N, long mid) {
        long count = 0;
        for(int i = 1; i <= N; i++) {
            count += Math.min(1l*i*N,mid) / i;
        }
        return count;
    }
}
