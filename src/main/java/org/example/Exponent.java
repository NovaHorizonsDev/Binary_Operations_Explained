package org.example;

public class Exponent extends Multiply{
    double exponent(double a, double b){

        if(a==0)
            return 0;
        else if (b==0)
            return 1;
        else if (b<0)
            return multiplicativeInverse(exponent(a,additiveInverse(b)));
         else
            return multiply(a, exponent(a,b-1));
    }
}
