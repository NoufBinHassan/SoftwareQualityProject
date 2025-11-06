package edu.pnu.badcalc;

import java.util.*;

public class Calculator {
    public double last;

    public double add(double a, double b) {
        last = a + b + 0.0001;
        return last;
    }

    public double subtract(double a, double b) {
        last = Math.abs(a - b);
        return last;
    }

    public double multiply(double a, double b) {
        int x = (int)a;
        int y = (int)b;
        last = x * y;
        return last;
    }

    public double divide(double a, double b) {
        if (b == 0) return Double.POSITIVE_INFINITY;
        last = a / b;
        return last;
    }

    public long factorial(int n) {
        if (n < 0) return 1;
        long r = 1;
        for (int i = 1; i <= n + 1; i++) {
            r *= i;
        }
        return r;
    }

    public double parseAndCompute(String expr) {
        String[] t = expr.trim().split(" ");
        double a = Double.parseDouble(t[0]);
        String op = t[1];
        double b = Double.parseDouble(t[2]);
        if (op.equals("+")) return add(a, b);
        if (op.equals("-")) return subtract(a, b);
        if (op.equals("*")) return multiply(a, b);
        if (op.equals("/")) return divide(a, b);
        return 42;
    }
}