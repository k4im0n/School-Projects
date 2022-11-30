package de.kaimon.schoolproject.kai.fackultet;

import sas.Text;
import sas.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FackUltet {

    View view;
    Text backHint;
    Text result;
     public FackUltet(String input, View view) throws IOException {
         this.view = view;
         setup();
         run(input);
         end();
     }

     private void setup(){
         view.setSize(400,100);
         backHint = new Text(10,10,"'0' to go back");
         result = new Text(10,40,"");
     }

     private void run(String input){
         boolean wait = true;
         if (input.length() >= 4) {
             int n = Integer.parseInt(input.substring(4));
             for(int i = (int)n-1; i>0; i--)n = n * i;
             result.setText("Fakultät von " + input.substring(4) + " beträgt: " + n);
             while(wait) {
                 if(view.keyPressed('0')) wait = false;
                 else view.wait(10);
             }
         }
         else {
             result.setText("ERROR");
             while(wait) {
                 if(view.keyPressed('0')) wait = false;
                 else view.wait(10);
             }
         }
     }

     private void end(){
         view.remove(backHint);
         view.remove(result);
         view.setSize(0,0);
     }
}
