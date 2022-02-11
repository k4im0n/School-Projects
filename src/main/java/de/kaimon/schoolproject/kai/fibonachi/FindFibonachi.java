package src.main.java.de.kaimon.schoolproject.kai.fibonachi;

public class FindFibonachi {
    public FindFibonachi(int n){
        if(n == 1 || n==2){
            System.out.println("true");
        } else{
        double first = 1;
        double second = 1;
        if(n>=1) {
            System.out.println("fib1: 1");
            System.out.println("fib2: 1");
            int i = 2;
            while ((first + second) < n) {
                double temp = second;
                second = first;
                first = first + temp;
                System.out.println("fib" + (i + 1) + ": " + (int) (first + second));
                i++;
            }
            if ((first + second) == n) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        }
    }
}
