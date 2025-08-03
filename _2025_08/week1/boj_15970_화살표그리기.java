package _2025_08.week1;

import java.util.*;
import java.io.*;
public class boj_15970_화살표그리기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(map.containsKey(y)) {
                map.get(y).add(x);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                map.put(y, temp);
            }
        }
        int answer = 0;
        for(int k : map.keySet()) {
            List<Integer> points = map.get(k);
            int len = points.size();
            Collections.sort(points);
            answer += points.get(len-1) - points.get(len-2);
            answer += points.get(1) - points.get(0);
            for (int i = 1; i < len - 1; i++) {
                answer += Math.min(points.get(i) - points.get(i-1),points.get(i+1) - points.get(i));
            }
        }
        System.out.println(answer);
    }
}
