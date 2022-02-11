package de.kaimon.schoolproject.kai.fackultet;

public class FackUltet {
     public FackUltet(double n){
         for(int i = (int)n-1; i>0; i--)n = n * i;
         System.out.println(n);
     }
}
