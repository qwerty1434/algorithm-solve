package _2025_06.week1;

import java.io.*;
import java.util.*;

public class boj_2606_바이러스 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            makeGraph(graph,a,b);
        }
        DFS(1,N,graph);
    }

    public static void DFS(int num, int N,Map<Integer,List<Integer>> graph) {
        boolean[] v = new boolean[N+1];
        v[num] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        int cnt = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            if(!graph.containsKey(now)) continue;
            for(int next : graph.get(now)) {
                if(v[next]) continue;
                v[next] = true;
                cnt++;
                q.add(next);
            }
        }

        System.out.println(cnt);

    }

    public static void makeGraph(Map<Integer,List<Integer>> graph,int a,int b) {
        make(graph,a,b);
        make(graph,b,a);
    }

    public static void make(Map<Integer,List<Integer>> graph, int parent, int child) {
        if(graph.containsKey(parent)){
            graph.get(parent).add(child);
        }else {
            List<Integer> temp = new ArrayList<>();
            temp.add(child);
            graph.put(parent,temp);
        }
    }
}
