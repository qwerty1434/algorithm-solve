package _2025_09.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1629_곱셈 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(func(A,B,C));
    }

    public static long func(int num, int count, int div) {
        if(count == 1) return num%div;
        long half = 1L * func(num, count/2, div);
        if(count%2 == 0) return (half * half) % div;
        return ((num) * ((half * half) % div)) % div;
    }
}

/**
 * (A * B)%C = (A%C * B%C)%C다
     * A = x*C+a, B = y*C+b로 표현할 수 있다
     * 이때 A*B = (...)*C + a*b다
     * A%C = a
     * B%C = b
     * (A*B)%C = a*b 따라서 A%C * B%C = (A*B)%C
 * (A + B)%C = (A%C + B%C)%C다
     * A = x*C+a, B = y*C+b로 표현할 수 있다
     * 이때 A+B = (x+y)*C + (a+b)다
 * Integer.MAX_VALUE^2은 long을 초과하지 않는다
 * Integer.MAX_VALUE^3은 long을 초과한다
 */

