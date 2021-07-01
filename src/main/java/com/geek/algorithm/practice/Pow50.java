package com.geek.algorithm.practice;

/**
 *
 * @author nick
 * @date 2021/7/1 9:01 PM
 * @package com.geek.algorithm.practice
 * @description
 *
 */
public class Pow50 {

    public double myPow(double x, int n) {
        return quickPow(x, n);
    }

    public double quickPow(double x, int n) {
        if (n < 0) return 1 / quickPow(x, -n);
        if (n == 0)
            return 1;

        double y = quickPow(x, n/2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        double x = 2d;
        int n = -2;
        Pow50 pow50 = new Pow50();

        System.out.println("pow50, x:" + x + ", n:" + n + ", result:" +  pow50.myPow(x, n));
    }
}
