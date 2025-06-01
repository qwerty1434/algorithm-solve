package _2025_05.week5;

import java.math.BigInteger;
import java.util.*;
import java.io.*;
public class boj_1334_다음팰린드롬수 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int midIdx = s.length() / 2;
        String left;
        String right;

        if(s.length() == 1) {
            int num = Integer.parseInt(s);
            if(num == 9) {
                System.out.println("11");
            }else{
                System.out.println(num+1);
            }

        } else if(s.length() % 2 == 0) {
            left = s.substring(0, midIdx);
            right = s.substring(midIdx);

            BigInteger rightNum = new BigInteger(right);
            if(new BigInteger(reverse(left)).compareTo(rightNum) > 0 && !reverse(left).equals(right)) {
                System.out.println(left + reverse(left));
            }else{
                BigInteger nextNum = new BigInteger(left).add(BigInteger.ONE);
                if(isCarryOccur(left)) {
                    System.out.println(nextNum + reverse(nextNum.toString()).substring(1));
                }else{
                    System.out.println(nextNum + reverse(nextNum.toString()));
                }
            }
        }else {
            left = s.substring(0, midIdx);
            right = s.substring(midIdx + 1);
            BigInteger rightNum = new BigInteger(right);

            if(new BigInteger(reverse(left)).compareTo(rightNum) > 0 && !reverse(left).equals(right)) {
                System.out.println(left + s.charAt(midIdx) + reverse(left));
            }else if(s.charAt(midIdx) != '9') {
                int num = (s.charAt(midIdx) - '0')+1;
                System.out.println(left + num + reverse(left));
            }else if(s.charAt(midIdx) == '9') {
                BigInteger nextNum = new BigInteger(left).add(BigInteger.ONE);

                if(isCarryOccur(left)) {
                    System.out.println(nextNum + reverse(nextNum.toString()));
                }else{
                    System.out.println(nextNum + "0" +reverse(nextNum.toString()));
                }
            }
        }

    }

    public static boolean isCarryOccur(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '9') return false;
        }
        return true;
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = s.length()-1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
