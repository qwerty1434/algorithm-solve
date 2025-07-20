package _2025_07.week3;

import java.io.*;
import java.util.*;

public class boj_1063_킹 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String k = st.nextToken();
        String s = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        int[] kingPosition = new int[]{getRowIndex(k), getColumnIndex(k)};
        int[] stonePosition = new int[]{getRowIndex(s), getColumnIndex(s)};
        for (int i = 0; i < N; i++) {
            String d = br.readLine();
            int[] m = move(d);
            int kingTempX = kingPosition[0] + m[0];
            int kingTempY = kingPosition[1] + m[1];
            if(isOutOfBoard(kingTempX, kingTempY)) continue;
            if(stonePosition[0] == kingTempX && stonePosition[1] == kingTempY){
                int stoneTempX = stonePosition[0] + m[0];
                int stoneTempY = stonePosition[1] + m[1];
                if(isOutOfBoard(stoneTempX, stoneTempY)) continue;
                stonePosition[0] = stoneTempX;
                stonePosition[1] = stoneTempY;
            }
            kingPosition[0] = kingTempX;
            kingPosition[1] = kingTempY;
        }
        System.out.println(makePosition(kingPosition));
        System.out.println(makePosition(stonePosition));
    }

    public static String makePosition(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        StringBuilder sb = new StringBuilder();
        sb.append((char)(y + 'A'));
        sb.append(8 - x);
        return sb.toString();
    }

    public static boolean isOutOfBoard(int x, int y) {
        return 0 > x || x >= 8 || 0 > y || y >= 8;
    }

    public static int getRowIndex(String S) {
        return 8 - (S.charAt(1) - '0');
    }

    public static int getColumnIndex(String S) {
        return S.charAt(0) - 'A';
    }

    public static int[] move(String d) {
        switch (d){
            case "R" :
                return new int[]{0,1};
            case "L" :
                return new int[]{0,-1};
            case "B" :
                return new int[]{1,0};
            case "T" :
                return new int[]{-1,0};
            case "RT" :
                return new int[]{-1,1};
            case "LT" :
                return new int[]{-1,-1};
            case "RB" :
                return new int[]{1,1};
            case "LB" :
                return new int[]{1,-1};
        }
        return new int[]{0,0};
    }
}
