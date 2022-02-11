package src.main.java.de.kaimon.schoolproject.kai.fibonachi;

public class Fibonachi {

    public Fibonachi(int n){
        double first = 1;
        double second = 1;
        if(n>1) {
            System.out.println("fib1: 1");
            System.out.println("fib2: 1");
            for (int i = 2 ; i<n; i++){
                double temp = second;
                second = first;
                first = first + temp;
                System.out.println("fib" + (i+1) + ": " + (int)(first+second));
            }
        } else second = 0;
    }
}
