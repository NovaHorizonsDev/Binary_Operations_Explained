package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Group<T> {
    Exponent operations = new Exponent();
    String operation;
    String groupName;
    ArrayList<T> set;

    public Group(String operation, String groupName, ArrayList<T> set) {
        this.operation = operation;
        this.groupName = groupName;
        this.set = set;
    }

    public boolean checkGroup() throws IllegalStateException {
       return (closure()&&inverse());
    }


    boolean closure (){
        for (T x : set) {
            for (T y: set){
                if(x instanceof Number && y instanceof Number && x!=y){
                    double v = switch(operation){
                        case "+" : yield operations.add((double)y , (double)x);
                        case "*" : yield operations.multiply((double)y , (double)x);
                        default  : throw new IllegalStateException("Unexpected value: " + operation);

                    };

                    if (!(set.contains(v)))
                        return false;
                }
            }
        }
        return true;
    }

//Add Associativity and Identity
    boolean inverse(){
        switch (operation){
            case "+"-> {
                for (T x:set) {
                    double c;
                    try{ c= operations.additiveInverse((double)x);}
                    catch (Exception e){
                        return false;
                    }
                    if(!set.contains(c))
                        return false;

                }
                return true;
            }
            case "*"-> {
                for (T x:set) {
                    double c;
                    try{ c= operations.multiplicativeInverse((double)x);}
                    catch (Exception e){
                        return false;
                    }
                    if(!set.contains(c))
                        return false;
                }
                return true;
            }
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        }
    }



}
