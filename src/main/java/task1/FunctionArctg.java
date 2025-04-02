package task1;

import static java.lang.Math.abs;

public class FunctionArctg {
    public static double calc(double x, int n) {
        if (abs(x) > 1) throw new IllegalArgumentException("Incorrect input. X must be [-1; 1]");
        if (n < 1) throw new IllegalArgumentException("Incorrect input. N must be [1; inf]");

        if (Math.abs(x) == 1) {
            return Math.PI / 4 * x;
        }

        //ряд тейлора
        double sum = 0.0;
        for (int k = 0; k < n; k++) {
            double term = Math.pow(-1, k) * Math.pow(x, 2 * k + 1) / (2 * k + 1);
            sum += term;
        }
        return sum;
    }
}