package LeetcodeDailyChallenge;

import java.util.Arrays;

//https://leetcode.com/problems/buy-two-chocolates/

public class BuyTwoChocolates {
    public static void main(String[] args) {
        int[] prices = {1, 2, 2};
        int money = 3;
        System.out.println(buyChoco(prices, money));
        System.out.println(buyChocoII(prices, money));
    }

    private static int buyChocoII(int[] prices, int money) {
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price < min) {
                secondMin = min;
                min = price;
            } else {
                secondMin = Math.min(secondMin, price);
            }
        }
        int totalSpent = min + secondMin;
        return money >= totalSpent ? money - totalSpent : money;
    }

    private static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int moneyRemaining = money - (prices[0] + prices[1]);

        return moneyRemaining >= 0 ? moneyRemaining : money;
    }
}
