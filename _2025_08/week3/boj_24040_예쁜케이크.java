package _2025_08.week3;

import java.io.*;
import java.util.*;
public class boj_24040_예쁜케이크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());
            sb.append(N%9 == 0 || N%3 == 2 ? "TAK\n" : "NIE\n");
        }
        System.out.println(sb.toString());
    }
}
