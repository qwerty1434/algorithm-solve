package _2025_09.week2;

import java.io.*;
import java.util.*;
public class boj_1030_프렉탈평면 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int R1 = Integer.parseInt(st.nextToken());
        int R2 = Integer.parseInt(st.nextToken());
        int C1 = Integer.parseInt(st.nextToken());
        int C2 = Integer.parseInt(st.nextToken());

        int finalSquareLength = (int)Math.pow(N,s);

        StringBuilder sb = new StringBuilder();
        for(int i = R1; i <= R2; i++) {
            for(int j = C1; j <= C2; j++) {
                sb.append(recursive(i,j,N,K,finalSquareLength));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int recursive(int i, int j, int N, int K, int squareLength) {
        int dividedSquareLength = squareLength/N;
        if(squareLength == 1) return 0;
        if(isBlackArea(i,j,N,K,dividedSquareLength)) return 1;
        return recursive(i%dividedSquareLength,j%dividedSquareLength,N,K,squareLength/N);
    }

    public static boolean isBlackArea(int i, int j, int N, int K, int dividedSquareLength) {
        int startIdx = dividedSquareLength * (N-K)/2;
        int endIdx = (dividedSquareLength * (N-K)/2) + (dividedSquareLength * K);
        return startIdx <= i && i < endIdx && startIdx <= j && j < endIdx;
    }

}

/*
1. 직접 그려서 확인하기에는 너무 크다. 또한 그리기도 어렵다. 그리려는 생각 자체를 하지 말자
2. 그러면 어떻게?
    - 가장 큰 도형에서부터 계산한다
    - 현재 도형을 N*N으로 나눴을 때
        - 중앙(K범위)이면 해당하면 1이다
        - 가운데 블록이 아니면 지금 위치가 하나 더 작은 블록에서 중앙인지 확인한다
    - 중앙 계산
        - N = 8, K = 2를 생각해보자 00011000
            - 이는 중앙(N/2)을 기준으로 왼쪽에 1(K/2)개, 오른쪽에 1(K/2)개
        - N = 8, K = 4를 생각해보자 00111100
            - 이는 중앙(N/2)을 기준으로 왼쪽에 2(K/2)개, 오른쪽에 2(K/2)개
        - N = 9, K = 3을 싱객해보자 000111000
            - 이는 중앙(N/2)을 포함해서 중앙 왼쪽에 1(K/2)개, 오른쪽에 1(K/2)개
        즉, (N-K)/2 부터 시작해 K개가 중앙이다
            - (N-K)/2인 이유는 N/2 - K/2이기 때문
 */

/**
N = 4, K = 2 일 때
[s = 1]
0000
0110
0110
0000

[s = 2]
 0000 0000 0000 0000
 0110 0110 0110 0110
 0110 0110 0110 0110
 0000 0000 0000 0000

 0000 1111 1111 0000
 0110 1111 1111 0110
 0110 1111 1111 0110
 0000 1111 1111 0000

 0000 1111 1111 0000
 0110 1111 1111 0110
 0110 1111 1111 0110
 0000 1111 1111 0000

 0000 0000 0000 0000
 0110 0110 0110 0110
 0110 0110 0110 0110
 0000 0000 0000 0000

-> (5,5) : 지금 도형을 4x4로 나눴을 때 중앙에 해당하므로 1이다
-> (12,0) : 지금 도형을 4x4로 나눴을 때 중앙이 아니다. (12,0)은 하나 더 작은 블록에서 (0,0)과 같다. (12%4,0%4)
-> (1,1) : 지금 도형을 4x4로 나눴을 때 중앙이 아니다. (1,1)은 하나 더 작은 블록에서 (1,1)과 같다. (1%4,1%4)
 */