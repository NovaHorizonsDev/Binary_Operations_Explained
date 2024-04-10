package org.example;

import java.util.ArrayList;
import java.lang.Math;
public class QuadraticResidue {
        //Theoretically, one could change the input of p to be custom \ user input driven.
    public void giveMeInfo(int num){
            //for each prime we will find residues

                ArrayList<Integer> A = new ArrayList<>();
                ArrayList<Integer> B = new ArrayList<>();
                int x = 1;
                while(x<= num-1){
                    if(Math.floorMod((x*x),num)!=0 && !A.contains(Math.floorMod((x*x),num)) )
                        A.add(Math.floorMod((x*x),num));
                    x++;
                }
                //finding non-residues
                for(int i=1; i<=num-1;i++){
                    if(!A.contains(i)){
                        B.add(i);
                    }
                }
                // summing lists
                int sumOfA = A.stream().mapToInt(Integer::intValue).sum();
                int sumOfB = B.stream().mapToInt(Integer::intValue).sum();

                //printing results for each modulo prime
                System.out.printf("\n\n Modulo %d\n", num);
                System.out.println("Quadratic Residues(A):");
                A.forEach(integer -> System.out.printf(" %d ",integer));
                System.out.println("\n Non-Residue(B):");
                B.forEach(integer -> System.out.printf(" %d ",integer));

                System.out.printf("\nA total : %d, B total: %d\n", sumOfA, sumOfB);
                if(sumOfA == sumOfB)
                    System.out.println(" A=B");
                else if (sumOfA > sumOfB) System.out.println(" A>B");
                else System.out.println(" A<B");



        }
}
