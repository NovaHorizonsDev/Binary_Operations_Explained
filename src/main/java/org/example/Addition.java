package org.example;

public class Addition{

    public double add (double a, double b){
        if(b==0)
            return a;
        if(a==0)
            return b;
        if(b>0){
            a++;
            return add(a,b-1);}
        else{
            b++;
            return add(a-1,b);}
    }

    public double additiveInverse(double a){
        return add(a,-add(a,a));
    }

}
