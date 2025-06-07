package _2025_06.week1;

import java.io.*;
import java.util.*;

public class boj_1561_놀이공원 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long minimumPossibleTime = binarySearch(arr, N);
        if(minimumPossibleTime == 0) {
            System.out.println(N);
        }else{
            long beforeChildCount = getChildCount(minimumPossibleTime-1, arr);
            int cnt = 0;
            for(int i = 0; i < M; i++) {
                if(minimumPossibleTime % arr[i] == 0) {
                    cnt++;
                    if(beforeChildCount + cnt == N) {
                        System.out.println(i+1);
                        break;
                    }
                }
            }
        }

    }

    public static long binarySearch(int[] arr, int N) {
        long left = 0;
        long right = 2_000_000_000L * 30L;
        long time = -1;
        while(left <= right) {
            long mid = (left + right) / 2;
            if(isPossible(mid, arr, N)) {
                time = mid;
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return time;
    }

    public static boolean isPossible(long time, int[] arr, int N) {
        return getChildCount(time,arr) >= N;
    }

    public static long getChildCount(long time, int[] arr) {
        long childCount = arr.length;
        for(int i = 0; i < arr.length; i++) {
            childCount += time / arr[i];
        }
        return childCount;
    }

}
