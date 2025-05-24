package _2025_05.week4;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;


public class boj_1036_36진수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, BigDecimal> map = new HashMap<>();
        for(int i = 0; i <N; i++) {
            String s = br.readLine();
            makeMap(map,s);
        }
        int K = Integer.parseInt(br.readLine());

        List<Map.Entry<Character,BigDecimal>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1,o2) -> {
            BigDecimal diff1 = o1.getValue().multiply(BigDecimal.valueOf((35 - (Character.isDigit(o1.getKey()) ? o1.getKey() - '0' : o1.getKey() - 'A' + 10))));
            BigDecimal diff2 = o2.getValue().multiply(BigDecimal.valueOf((35 - (Character.isDigit(o2.getKey()) ? o2.getKey() - '0' : o2.getKey() - 'A' + 10))));

            return diff2.compareTo(diff1);
        });

        int transformCount = 0;
        BigDecimal sum = BigDecimal.ZERO;
        for (Map.Entry<Character, BigDecimal> entry : entryList) {
            Character key = entry.getKey();
            BigDecimal value = entry.getValue();

            if(key != 'Z' && transformCount < K) {
                sum = sum.add(
                        value.multiply(BigDecimal.valueOf(35))
                );
                transformCount++;
            }else {
                sum = sum.add(
                        value.multiply(BigDecimal.valueOf((Character.isDigit(key) ? key - '0' : key - 'A' + 10)))
                );
            }
        }
        String answer = sum.toBigInteger().toString(36);
        System.out.println(answer.toUpperCase());
    }


    private static void makeMap(Map<Character,BigDecimal> map, String s) {
        for(int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            map.put(key, map.getOrDefault(key,BigDecimal.ZERO).add(
                    BigDecimal.valueOf(36).pow(s.length()-1-i)
            ));
        }
    }
}
