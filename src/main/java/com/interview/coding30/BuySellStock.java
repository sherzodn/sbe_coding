package com.interview.coding30;

public class BuySellStock {

    public static void main(String[] args) {
        double[] priceArray =  {10, 7, 5, 8, 11, 9};
        System.out.println(getMaxProfit(priceArray));
    }

    public static double getMaxProfit(double[] priceArray) {
        var maxDiff = Double.MIN_VALUE;
        var max = Double.MIN_VALUE;
        var bottom = priceArray[0];
        var diff = 0;
        for (int i = 1; i < priceArray.length; i++) {
            diff += priceArray[i] - priceArray[i - 1];
            if (diff > maxDiff) {
                maxDiff = diff;
                max = priceArray[i];
            }
            if (priceArray[i] < bottom) {
                bottom = priceArray[i];
                diff = 0;
            }
        }
        var buy = max - maxDiff;
        var sell = max;
        return sell - buy;
    }
}
