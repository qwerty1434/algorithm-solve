package _2025_06.week3;

import java.io.*;
import java.util.*;
public class boj_16437_양구출작전 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Node> nodeMap = new HashMap<>();
        Node root = new Node(1,0,"");
        nodeMap.put(1,root);
        boolean[] v = new boolean[N+1];
        v[1] = true;

        for(int num = 2 ; num < N+1; num++){
            st = new StringTokenizer(br.readLine());
            String kind = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            Node e = new Node(num,count,kind);
            nodeMap.put(num,e);
            int next = Integer.parseInt(st.nextToken());
            if(graph.containsKey(num)){
                graph.get(num).add(next);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(next);
                graph.put(num,temp);
            }
            if(graph.containsKey(next)){
                graph.get(next).add(num);
            }else{
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                graph.put(next,temp);
            }
        }

        root = makeTree(root, graph, nodeMap, v);
        System.out.println(root.shipCount);
    }

    public static Node makeTree(Node e, Map<Integer,List<Integer>> graph, Map<Integer,Node> nodeMap, boolean[] v) {
        if(e.kind.equals("S")) {
            e.shipCount += e.count;
        }

        long childShipSum = 0;
        if(graph.containsKey(e.num)) {
            for(int next : graph.get(e.num)) {
                if(v[next]) continue;
                v[next] = true;
                Node nextNode = nodeMap.get(next);
                makeTree(nextNode, graph, nodeMap, v);
                childShipSum += nextNode.shipCount;
                e.child.add(nextNode);
            }
        }

        if(e.kind.equals("W")) {
            e.shipCount += Math.max(0, childShipSum - e.count);
        }else{
            e.shipCount += childShipSum;
        }
        nodeMap.put(e.num, e);
        return e;
    }

    public static class Node{
        int num;
        int count;
        long shipCount;
        String kind;
        List<Node> child = new ArrayList<>();

        public Node(int num, int count, String kind) {
            this.num = num;
            this.count = count;
            this.kind = kind;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", count=" + count +
                    ", kind=" + kind +
                    ", child=" + child +
                    ", shipCount=" + shipCount +
                    '}';
        }
    }
}
