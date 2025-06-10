package _2025_06.week2;

import java.util.*;
import java.io.*;
public class boj_1322_X와K {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String binaryX = Integer.toBinaryString(X);
        String binaryK = Integer.toBinaryString(K);

        int binaryXIndex = binaryX.length() - 1;
        int binaryKIndex = binaryK.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(binaryKIndex >= 0){
            if(binaryXIndex < 0) {
                sb.append(binaryK.charAt(binaryKIndex--));
            }else if(binaryX.charAt(binaryXIndex) == '0') {
                sb.append(binaryK.charAt(binaryKIndex--));
            }else{
                sb.append(0);
            }
            binaryXIndex--;
        }
        System.out.println(Long.parseLong(sb.reverse().toString(),2));

    }

}
