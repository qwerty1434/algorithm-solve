package _2025_05.week2;

import java.util.*;
import java.io.*;
public class boj_1035_조각움직이기 {
    public static int[] dx = new int[]{1,0,-1,0};
    public static int[] dy = new int[]{0,-1,0,1};
    public static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 5;
        char[][] board = new char[N][N];
        List<int[]> positions = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = s.charAt(j);
                if(board[i][j] == '*') {
                    positions.add(new int[]{i, j});
                }
            }
        }

        int pieceCount = positions.size();
        comb(0,0,new int[pieceCount],pieceCount,N, positions);
        System.out.println(minVal);
    }

    public static void comb(int depth, int start, int[] answer, int count, int N, List<int[]> positions) {
        if(depth == count) {
            char[][] res = makeBoard(answer,N);
            if(isAdjacent(res,findPosition(answer[0],N),count,N)) {
                calcMinDistance(answer,positions,N);
            }

            return;
        }
        for(int i = start; i < N*N; i++) {

            answer[depth] = i;
            comb(depth+1, i+1, answer, count, N, positions);
            answer[depth] = 0;

        }
    }

    public static void calcMinDistance(int[] answer, List<int[]> positions,int N) {
        makeOrder(0,answer.length,new boolean[answer.length],new int[answer.length],answer,positions,N);
    }

    public static void makeOrder(int depth, int count, boolean[] v, int[] result, int[] answer, List<int[]> positions, int N){
        if(depth == count) {
            int dist = 0;
            for(int i = 0; i < count; i++) {
                dist += calcDist(findPosition(answer[i],N),positions.get(result[i]));
            }
            minVal = Math.min(minVal,dist);
            return;
        }

        for(int i = 0; i < count; i++) {
            if(v[i]) continue;
            result[depth] = i;
            v[i] = true;
            makeOrder(depth+1, count, v, result,answer,positions,N);
            v[i] = false;
            result[depth] = 0;
        }

    }

    public static int calcDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static char[][] makeBoard(int[] answer, int N) {
        char[][] board = new char[N][N];
        for(int i = 0; i < answer.length; i++) {
            int[] pos = findPosition(answer[i],N);
            board[pos[0]][pos[1]] = '*';
        }
        return board;
    }

    public static int[] findPosition(int num, int N) {
        int x = num%N;
        int y = num/N;
        return new int[]{x,y};
    }

    public static int makeShape(char[][] board, int N) {
        int num = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == '.') continue;
                num += (int)Math.pow(2,(i * 5 + j));
            }
        }
        return num;
    }

    public static boolean isAdjacent(char[][] board, int[] pos, int count, int N){
        return count == BFS(board,pos,N);
    }

    public static int BFS(char[][] board, int[] pos, int N) {
        int cnt = 0;
        boolean[][] v = new boolean[N][N];
        v[pos[0]][pos[1]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(pos);
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !v[nx][ny] && board[nx][ny] == '*'){
                    v[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return cnt;
    }
}
