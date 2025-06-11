package _2025_06.week2;

import java.util.*;
import java.io.*;
public class boj_1595_북쪽나라의도로{

    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        Map<Integer,List<int[]>> graph = new HashMap<>();
        while((str=br.readLine()) != null && !str.equals("")){
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            makeGraph(a,b,d,graph);
        }

        int tempRoot = 1;
        boolean[] v = new boolean[graph.size() + 2];
        v[tempRoot] = true;
        int[] dist = new int[graph.size() + 2];
        DFS(tempRoot,graph,v,dist);

        int farthestIdxFromTempRoot = 0;
        int maxDist = 0;
        for(int i = 0; i < dist.length; i++){
            if(maxDist < dist[i]) {
                farthestIdxFromTempRoot = i;
                maxDist = dist[i];
            }
        }

        int pointOnDiameter = farthestIdxFromTempRoot;
        v = new boolean[graph.size() + 2];
        v[pointOnDiameter] = true;
        dist = new int[graph.size() + 2];
        DFS(pointOnDiameter,graph,v,dist);
        int answer = 0;
        for (int i = 0; i < dist.length; i++) {
            answer = Math.max(answer,dist[i]);
        }

        System.out.println(answer);
    }


    public static int DFS(int now, Map<Integer,List<int[]>> graph, boolean[] v, int[] dist) {
        if(graph.containsKey(now)) {
            for (int[] next : graph.get(now)) {
                if(v[next[0]]) continue;
                v[next[0]] = true;
                dist[next[0]] = dist[now] + next[1];
                DFS(next[0],graph,v,dist);
            }
        }
        return dist[now];
    }


    public static void makeGraph(int a, int b, int d, Map<Integer,List<int[]>> graph) {
        if(graph.containsKey(a)){
            graph.get(a).add(new int[]{b,d});
        }else {
            List<int[]> temp = new ArrayList<>();
            temp.add(new int[]{b,d});
            graph.put(a,temp);
        }
        if(graph.containsKey(b)){
            graph.get(b).add(new int[]{a,d});
        }else {
            List<int[]> temp = new ArrayList<>();
            temp.add(new int[]{a,d});
            graph.put(b,temp);
        }
    }
}
