package _2025_07.week3;

import java.util.*;
import java.io.*;
public class boj_1418_K세준수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        boolean[] primes = primeNumbers();
        int answer = 0;
        for(int i = 1; i <=N; i++) {
            int x = getLargestPrimeInDividors(i,primes);
            if (x <= K) answer++;
        }
        System.out.println(answer);
    }

    public static int getLargestPrimeInDividors(int num, boolean[] primes) {
        int largest = 0;
        for(int i = 1; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                if(primes[i]) {
                    largest = Math.max(largest, i);
                }
                if(primes[num/i]) {
                    largest = Math.max(largest, num/i);
                }
            }
        }
        return largest;
    }

    public static boolean[] primeNumbers() {
        boolean[] isPrime = new boolean[100_001];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < 100_001; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < 100_001; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;

    }
}
