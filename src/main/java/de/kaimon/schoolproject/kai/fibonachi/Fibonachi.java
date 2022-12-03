package de.kaimon.schoolproject.kai.fibonachi;

import sas.Text;
import sas.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonachi {

    View view;
    Text backHint;
    Text result;
    Text result2;

    public Fibonachi(String input, View view){
        this.view = view;
        setup();
        run(input);
        end();
    }

    private void setup(){
        view.setSize(200,150);
        backHint = new Text(10,10,"'0' to go back");
        result = new Text(10,40,"");
        result2 = new Text(10,70,"");
    }

    private void run(String input){
        if (input.length() >= 1) {
            int n = Integer.parseInt(input);
            double first = 1;
            double second = 1;
            if(n>1) {
                System.out.println("fib1: 1");
                System.out.println("fib2: 1");
                for (int i = 2 ; i<n; i++){
                    if(view.keyPressed('0')) return;
                    else view.wait(10);
                    double temp = second;
                    second = first;
                    first = first + temp;
                    result.setText("Die " + (i+1) + ". Fibonachizahl ist: ");
                    result2.setText("" + (long)(first+second));
                }
            } else second = 0;
        }
        else System.out.println("ERROR");
        boolean wait = true;
        while(wait) {
            if(view.keyPressed('0')) wait = false;
            else view.wait(10);
        }
    }

    private void end(){
        view.remove(backHint);
        view.remove(result);
        view.remove(result2);
        view.setSize(0,0);
    }
}
