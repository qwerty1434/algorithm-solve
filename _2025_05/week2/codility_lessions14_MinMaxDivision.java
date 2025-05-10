package _2025_05.week2;

import java.util.Arrays;

public class codility_lessions14_MinMaxDivision {
    public static void main(String[] args) {
        int K = 3;
        int M = 5;
        int[] A = new int[]{2,1,5,1,2,2,2};

        System.out.println(binarySearch(0,M * A.length,A,K));

    }

    public static int binarySearch(int startNum, int endNum, int[] arr, int K) {
        int answer = endNum;
        while(startNum <= endNum) {
            int mid = (startNum + endNum) / 2;
            if(isPossible(mid,arr,K)) {
                answer = Math.min(answer,mid);
                endNum = mid-1;
            }else{
                startNum = mid+1;
            }
        }
        return answer;
    }

    public static boolean isPossible(int largeSum, int[] arr, int groupCount) {
        int cnt = 1;
        int num = arr[0];
        if(num > largeSum) return false;
        for(int i = 1; i < arr.length; i++) {
            if(largeSum < arr[i]) return false;
            if(num + arr[i] > largeSum) {
                cnt++;
                num = arr[i];
            }else{
                num += arr[i];
            }
        }
        if(num > largeSum) return false;
        return cnt <= groupCount;
    }
}
