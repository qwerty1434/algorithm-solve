package _2025_05.week2;

import java.util.*;

public class codility_lessons6_Triangle {
    public static void main(String[] args) {
        int[] A = new int[]{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
        Arrays.sort(A);

        System.out.println(isContainsTriangle(A) ? 1 : 0);
    }

    public static boolean isContainsTriangle(int[] A){
        for(int i = 0; i < A.length -2; i++) {
            long a = 1l * A[i];
            long b = 1l * A[i+1];
            long c = 1l * A[i+2];
            if(a+b > c) return true;
        }
        return false;
    }
}
