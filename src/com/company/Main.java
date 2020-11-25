package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int coins[] = new int[3];
        for (int i = 0; i <coins.length ; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.print(coinsCombine(coins,total));
    }

    public static int coinsCombine(int [] coins,int total){
        int dp[] = new int[total+1];
        for (int i = 1; i <=total; i++) {
            dp[i] = total+1;
        }
        dp[0] = 0;
        for(int i=1;i<=total;i++){
            for(int j=0;j<coins.length;j++){
                if(coins[j]-i<=0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[total]>total?-1:dp[total];
    }
}
