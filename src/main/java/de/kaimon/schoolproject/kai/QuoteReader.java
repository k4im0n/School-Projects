package de.kaimon.schoolproject.kai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuoteReader {
    public QuoteReader(String s) {
    }

    public static void main(String[] args) throws IOException {
        lol();
    }

    private static void lol() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/java/de/kaimon/schoolproject/kai/Einfachezitate.txt"));
        System.out.println(reader.lines());
        reader.lines().forEach(s -> {
            if(s.length() > 0 && s.charAt(0) == '"'){
                System.out.println("quote: " +s.substring(1,s.length()-1));
                return;
            }
            if(s.length() > 0 && s.charAt(0) == '-'){
                String args[] = toSpace(s.substring(1, s.length()-1));
                String author = "";
                List<String> receiver = new ArrayList<>();
                List<String> obj = new ArrayList<>();
                boolean to = false;
                boolean about = false;
                for (int i = 0; i < args.length; i++) {
                    if(args.length == 1 || i == 0) author = args[i];
                    else if (args[i].toLowerCase().equals("zu")) {
                        to = true;
                        about = false;
                    }else if (args[i].toLowerCase().equals("über")) {
                        about = true;
                        to = false;
                    } else if(to){
                        receiver.add(args[i]);
                    } else if(about){
                        obj.add(args[i]);
                    }
                }
                System.out.println("Author: " + author);
                if(!receiver.isEmpty()) {
                    System.out.print("An: ");
                    receiver.forEach(s1 -> System.out.print(s1 + " "));
                    System.out.println("");
                }
                if(!obj.isEmpty()) {
                    System.out.print("Über: ");
                    obj.forEach(s1 -> System.out.print(s1 + " "));
                    System.out.println("");
                }
            }
            else {
                System.out.println(s);
            }
        });
    }

    private static String[] toSpace(String in){
        int lenght = 1;
        for (int i = 0; i < in.length(); i++) {
            if(in.charAt(i) == ' '){
                lenght ++;
            }
        }
        String args[] = new String[lenght];
        String str = in;
        for (int i = 0; i < lenght; i++) {
            args[i] = "";
            int strlen = str.length();
            for (int a = 0; a < strlen; a++) {
                if(str.charAt(0) == ' '){
                    str = str.substring(1);
                    a = strlen;
                }
                else{
                    args[i] += str.charAt(0);
                    str = str.substring(1);
                }
            }
        }
        return args;
    }
}
