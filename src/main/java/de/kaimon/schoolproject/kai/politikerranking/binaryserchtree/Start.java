package de.kaimon.schoolproject.kai.politikerranking.binaryserchtree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

    public Start() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean start = true;
        while (start) {
            System.out.print("please enter the type of the sort(name|fame|exit): ");
            String input = reader.readLine();
            if(input.equals("exit")) start = false;
            else new Election(input);
        }
    }
}
