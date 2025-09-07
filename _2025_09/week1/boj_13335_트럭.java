package _2025_09.week1;

import java.util.*;
import java.io.*;

public class boj_13335_트럭 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> waitTrucks = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            waitTrucks.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        int time = 0;
        int weight = 0;
        while(!waitTrucks.isEmpty()){
            weight -= bridge.poll();
            int nextTruckWeight = waitTrucks.peek();
            if(L >= weight + nextTruckWeight){
                weight += waitTrucks.poll();
                bridge.add(nextTruckWeight);
            }else{
                bridge.add(0);
            }
            time++;
        }

        System.out.println(time + w);


    }
}
