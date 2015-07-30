package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        if(i < 0)
            throw new IllegalArgumentException("compute() does not accept negative argument values");
        else if(i == 1 || i == 0)
            return 1;
        else {
            int product = 1;
            while (i > 0) {
                product *= i;
                i--;
            }
            return product;
        }
    }
}
