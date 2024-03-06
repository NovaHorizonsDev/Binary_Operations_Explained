package org.example;

public class Multiply extends Addition {

    public double multiply(double a ,double b){

        if(a<b){
            multiply(b,a);
        }

        if(b!=0){
            if (b>0)
                return add(a,multiply(a,b-1));
            else
                return add(-a,multiply(a,add(b,1)));
        }

        else
            return 0;

    }
    double multiplicativeInverse(double a){
        return 1/a;
    }

}
