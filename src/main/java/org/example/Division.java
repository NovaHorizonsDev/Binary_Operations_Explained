package org.example;

public class Division extends Multiply{
    double divide(double a , double b){
        if(a==0)
            return 0;
        if(b==0)
            throw new ArithmeticException("\nCannot Divide by Zero\n");
        return multiply(a,multiplicativeInverse(b));
    }
}

