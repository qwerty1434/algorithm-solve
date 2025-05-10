package _2025_05.week2;

import java.util.*;
public class codility_lessons10_Peaks {

    public static void main(String[] args) {
        int[] A = new int[] {5};
        List<Integer> peak = makePeaks(A);
        if(peak.isEmpty()) return;

        for(int blockCount = A.length; blockCount >= 1; blockCount--) {
            if(A.length % blockCount != 0) continue;
            if(isAllBlockContainsPeak(peak, blockCount, A.length)) {
                System.out.println(blockCount);
                return;
            }
        }

        System.out.println(1);

    }


    public static boolean isAllBlockContainsPeak(List<Integer> peak, Integer blockCount, int N) {
        int blockSize = N/blockCount;

        boolean[] blockContains = new boolean[blockCount];
        for(int peakIdx : peak) {
            blockContains[peakIdx/blockSize] = true;
        }

        for(int i = 0; i < blockCount; i++) {
            if(!blockContains[i]) return false;
        }

        return true;
    }

    public static List<Integer> makePeaks(int[] arr) {
        List<Integer> peak = new ArrayList<>();
        if(arr.length < 3) {
            return peak;
        }

        for(int i = 1; i < arr.length-1; i++) {
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                peak.add(i);
            }
        }

        return peak;
    }
}
