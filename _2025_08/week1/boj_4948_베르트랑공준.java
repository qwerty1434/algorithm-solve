package _2025_08.week1;

import java.util.*;
import java.io.*;
public class boj_4948_베르트랑공준 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maximum = 123_456 * 2;
        boolean[] primeSet = getPrimeSet(maximum);
        int[] cumSum = new int[maximum + 1];
        for (int i = 1; i <= maximum; i++) {
            cumSum[i] = cumSum[i-1] + ((primeSet[i]) ? 1 : 0);
        }

        StringBuffer sb = new StringBuffer();
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            sb.append(cumSum[2*N] - cumSum[N]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean[] getPrimeSet(int maximum) {
        boolean[] primeSet = new boolean[maximum + 1];
        Arrays.fill(primeSet, true);
        primeSet[0] = false;
        primeSet[1] = false;
        for(int i = 2; i < primeSet.length; i++) {
            if(primeSet[i]) {
                for(int j = i*2; j < primeSet.length; j+=i) {
                    primeSet[j] = false;
                }
            }
        }
        return primeSet;
    }
}
