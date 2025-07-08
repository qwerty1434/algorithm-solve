package _2025_07.week2;

import java.util.*;
import java.io.*;
public class boj_2665_미로만들기 {
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(BFS(N,board));
    }

    public static int BFS(int N, int[][] board) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        boolean[][] v = new boolean[N][N];
        v[0][0] = true;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(now[0] == N-1 && now[1] == N-1) return now[2];
            for(int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny]) {
                    v[nx][ny] = true;
                    int blackRooms = now[2] + (board[nx][ny] == 0 ? 1 : 0);
                    pq.add(new int[]{nx, ny, blackRooms});
                }
            }
        }
        return 0;
    }
}
