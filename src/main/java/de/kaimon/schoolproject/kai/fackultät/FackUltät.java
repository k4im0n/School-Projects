package de.kaimon.schoolproject.kai.fackultät;

public class FackUltät {
     public FackUltät(double n){
         for(int i = (int)n-1; i>0; i--)n = n * i;
         System.out.println(n);
     }
}
