package _2025_06.week4;

import java.util.*;
import java.io.*;
public class boj_1684_같은나머지 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = arr[1] - arr[0];
        for(int i = 1; i < N; i++){
            int diff = arr[i] - arr[i - 1];
            answer = gcd(answer,diff);
        }
        System.out.println(answer);
    }

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}

/**
 * N = p * Q + r (Q : 몫, r : 나머지)
 * 나머지가 같다 : N1 - p1 * Q1 = N2 - p2 * Q2
 * 같은 수 D로 나눴다 했으므로 N1 - p1 * D = N2 - p2 * D
 * N2 - N1 = p2*D - p1*D = (p2-p1) * D
 * => 같은 수 D로 나눴을 때 나머지가 같다는 건 두 수의 차가 D의 배수라는거다
 *
 * N개의 수 전부 D로 나눈 나머지가 같다는 건 N개의 값 중 아무거나 2개를 뽑아서 그 둘을 빼면 D의 배수라는 얘기다
 * 이걸 만족하는 가장 큰 D는 이 뺀 숫자들의 최대공약수를 찾는것과 같다
 * 아무 수나 빼도 되기 때문에 정렬해서 큰수 - 작은수를 한다
 */