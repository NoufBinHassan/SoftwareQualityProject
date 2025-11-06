package edu.pnu.badcalc;

public class Calculator {
    //public state leaks internals; breaks encapsulation
    // keep last result but make it encapsulated
    private double last;

    public double getLast() {
        return last;
    }

    public double add(double a, double b) {
        //adds an extra value (o.ooo1)
        // fixed: remove unintended extra 0.0001
        last = a + b;
        return last;
    }

    public double subtract(double a, double b) {
        //forces non-negative result
        // fixed: return real subtraction, not absolute value
        last = a - b;
        return last;
    }

    public double multiply(double a, double b) {
        //casting to int truncates decimals , corrupting results
        // fixed: do not cast to int, preserve decimals
        last = a * b;
        return last;
    }

    public double divide(double a, double b) {
        //returns positive infinity in division by zero (poor error handling)
        // fixed: instead of returning POSITIVE_INFINITY, throw an error
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        last = a / b;
        return last;
    }

    public long factorial(int n) {
        /*rerurns 1 for negative 
         * Loop run to n+1, off-by-one bug
        */
        // fixed: negative should not silently return 1
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        long r = 1;
        // fixed: loop should go to n, not n+1
        for (int i = 1; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    public double parseAndCompute(String expr) {
        /*No input validation
         * Repititive if chain
         * Returns magic number 42 for unkown operation
         */
        if (expr == null) {
            throw new IllegalArgumentException("expression cannot be null");
        }
        String[] t = expr.trim().split(" ");
        if (t.length != 3) {
            throw new IllegalArgumentException("expression must be in the form: <number> <op> <number>");
        }
        double a = Double.parseDouble(t[0]);
        String op = t[1];
        double b = Double.parseDouble(t[2]);
        switch (op) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("unsupported operator: " + op);
        }
    }
}