package _2025_06.week1;

import java.io.*;
import java.util.*;

public class boj_1135_뉴스전하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer,List<Integer>> graph = makeGraph(arr);
        Node e = makeTree(0,graph);
        System.out.println(e.spreadTime);
    }

    public static Node makeTree(int num, Map<Integer,List<Integer>> graph) {
        Node e = new Node(num);
        if(!graph.containsKey(num)) return e;
        List<Integer> childSpreadTime = new ArrayList<>();

        for(int nextNum : graph.get(num)){
            Node c = makeTree(nextNum, graph);
            e.child.add(c);
            childSpreadTime.add(c.spreadTime);
        }
        Collections.sort(childSpreadTime,Collections.reverseOrder());
        for (int i = 0; i < childSpreadTime.size(); i++) {
            e.spreadTime = Math.max(e.spreadTime,childSpreadTime.get(i) + (i+1));
        }

        // 자식 3명, 그 자식들이 모두 전파하는데 5초가 걸림 -> 마지막 + 5초 = 8초
        // 내 자식들 중 가장 오래 걸리는 녀석 + 내가 모두 전파하기까지 걸리는 시간
        return e;
    }

    public static Map<Integer,List<Integer>> makeGraph(int[] arr) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=1;i<arr.length;i++){
            if(graph.containsKey(arr[i])) {
                graph.get(arr[i]).add(i);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                graph.put(arr[i],temp);
            }
        }
        return graph;

    }

    public static class Node {
        int number;
        List<Node> child = new ArrayList<>();
        int spreadTime = 0;

        public Node(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", child=" + child +
                    ", spreadTime=" + spreadTime +
                    "}";
        }
    }
}
