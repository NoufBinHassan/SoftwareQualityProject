package edu.pnu.badcalc;

import java.util.*;

public class App {
    public static Calculator c = new Calculator();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bad Calculator v0.0.1");
        while (true) {
            System.out.print("> ");
            String line = s.nextLine();
            if (line.equals("quit")) break;
            try {
                System.out.println("= " + c.parseAndCompute(line));
            } catch (Exception e) {
                System.out.println("err");
            }
        }
    }
}