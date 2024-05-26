package org.example;

public class Division {
    // Not actual division (just division algorithm, Greatest Common Divisor)


    public static int divisionAlgorithm(int x,int y) {
        // We will first set up our equation in the form a = bq+r where a>=b and a,b,q,r are non-zero Natural Numbers.
        //We will use x, and y instead of a, and b in this case.
        //We will assume this means x/y where x>=y.
        //For this scenario we will fix is so x>=y.

        if (y > x) {
            int temp = x;
            x = y;
            y = temp;
        }
//In java, we will skip to finding a q where bq < a.
        int q = 1;
        while (y * q < x) {
            q++;
        }
        --q;
        // Now we have a q value that x-yq <= y. Complete this we will subtract yq from q

        int r = x-(y*q);

        //Thus we have our remainder r to complete the form x= yq+r.
        //We read this as "y is congruent to r (mod x)".
        return r;
    }
public static int GCD(int x,int y){
        //We can utilize the division algorithm to find the greatest common divisor.

    //We first check our base cases
       if(x==y)
           return x;
       if(divisionAlgorithm(x,y) == Math.min(x, y)) //if the D.A. is equal to teh the lowest value then the GCD is the lowest value.
           return Math.min(x, y);

//we keep doing the D.A. until we get a number above 0 that with one more iteration becomes 0.
       int r = divisionAlgorithm(x,y);
        while(r> 0  && r==y){
            x=y;
            y=r;
            r= divisionAlgorithm(x,y);
        }
        //Thus r is our GCD.
    return r;
}

}

