package com.company;

import java.text.DecimalFormat;
import java.util.function.DoubleUnaryOperator;

public class Main {
    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
        System.out.println(decimalFormat.format(integrate(x -> 1, 0, 10)));//10
        System.out.println(decimalFormat.format(integrate(x -> x + 2, 0, 10)));//70
        System.out.println(decimalFormat.format(integrate( x -> Math.sin(x) / x , 1, 5)));//0.604
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        int i;
        double result, h;

        result = 0;

        h = 10E-6;
        int n = (int)((b - a) / h);

        for(i = 0; i < n; i++)
        {
            result += f.applyAsDouble(a + h * (i + 0.5)); //Вычисляем в средней точке и добавляем в сумму
        }

        result *= h;

        return result;
    }
}
