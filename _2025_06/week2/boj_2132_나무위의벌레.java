package _2025_06.week2;

import java.util.*;
import java.io.*;
public class boj_2132_나무위의벌레 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] apples = new int[N];
        for (int i = 0; i < N; i++) {
            apples[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer,List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            makeGraph(graph,a,b);
        }

        int certainPoint = 0;
        boolean[] v = new boolean[N];
        v[certainPoint] = true;
        int[] takenApples = new int[N];
        DFS(certainPoint, graph, apples, v, takenApples);
        int root = 0;
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(takenApples[i] > count) {
                root = i;
                count = takenApples[i];
            }
        }

        v = new boolean[N];
        v[root] = true;
        takenApples = new int[N];
        DFS(root, graph, apples, v, takenApples);
        int index = 0;
        int maxCount = 0;
        for(int i = 0; i < N; i++) {
            if(takenApples[i] > maxCount) {
                index = i;
                maxCount = takenApples[i];
            }
        }

        System.out.println(maxCount+" "+(Math.min(root,index)+1));
    }

    public static void DFS(int now, Map<Integer,List<Integer>> graph, int[] apples, boolean[] v, int[] takenApples) {
        takenApples[now] += apples[now];
        if(graph.containsKey(now)) {
            for (int next : graph.get(now)) {
                if(v[next]) continue;
                v[next] = true;
                takenApples[next] += takenApples[now];
                DFS(next, graph, apples, v, takenApples);
            }
        }
    }


    public static void makeGraph(Map<Integer,List<Integer>> graph, int a, int b) {
        make(graph,a,b);
        make(graph,b,a);
    }

    public static void make(Map<Integer,List<Integer>> graph, int from, int to) {
        if(graph.containsKey(from)){
            graph.get(from).add(to);
        }else{
            List<Integer> temp = new ArrayList<>();
            temp.add(to);
            graph.put(from,temp);
        }
    }
}
