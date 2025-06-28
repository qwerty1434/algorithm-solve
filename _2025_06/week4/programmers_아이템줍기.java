package _2025_06.week4;

import java.util.*;
public class programmers_아이템줍기 {
    public static int[] dx = new int[]{1,0,-1,0,1,-1,1,-1};
    public static int[] dy = new int[]{0,-1,0,1,1,-1,-1,1};
    public static final int RANGE = 11 * 2;

    public static void main(String[] args) throws Exception {
        int[][] rectangle = new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1 * 2;
        int characterY = 3 * 2;
        int itemX = 1 * 2;
        int itemY = 4 * 2;

        int[][] board = new int[RANGE][RANGE];
        for(int[] pos : rectangle) {
            for(int i = pos[0] * 2; i <= pos[2] * 2; i++) {
                for(int j = pos[1] * 2; j <= pos[3] * 2; j++) {
                    board[j][i] = 1;
                }
            }
        }

        boolean[][] canMovable = new boolean[RANGE][RANGE];
        for(int i = 0; i < RANGE; i++) {
            for(int j = 0; j < RANGE; j++) {
                if(board[i][j] == 1 && !isInner(board,i,j)) {
                    canMovable[i][j] = true;
                }
            }
        }

        System.out.println(BFS(canMovable,characterY,characterX,itemY,itemX));

    }

    public static int BFS(boolean[][] moveable, int characterX, int characterY, int itemX, int itemY) {
        boolean[][] v = new boolean[RANGE][RANGE];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX, characterY});
        v[characterX][characterY] = true;
        int cnt = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            cnt++;
            while(--size >= 0) {
                int[] now = q.poll();
                if(now[0] == itemX && now[1] == itemY) return cnt;
                for(int d = 0; d < 4; d++) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];
                    if(0 <= nx && nx < RANGE && 0 <= ny && ny < RANGE && moveable[nx][ny] && !v[nx][ny]) {
                        v[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }

    public static boolean isInner(int[][] board, int x, int y) {
        int cnt = 0;
        for(int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if(0 <= nx && nx < RANGE && 0 <= ny && ny < RANGE) {
                if(board[nx][ny] == 1) cnt++;
            }
        }
        return cnt == 8;
    }
}
