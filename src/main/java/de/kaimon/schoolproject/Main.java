package de.kaimon.schoolproject;

import de.kaimon.schoolproject.kai.SchoolProjectKai;
import de.kaimon.schoolproject.simon.SchoolProjectSimon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean firstStart = true;
    public static void main(String[] args) {
        if(firstStart) {
            System.out.println("--- School Projects of Simon AKA Asedem and Kai AKA kaigoe ---\n");
            firstStart = !firstStart;
        }
        String arg = args.length == 1 ? args[0] : "";
        try {
            switch (arg){
                case "kai", "k" -> SchoolProjectKai.main(cutFirstOf(args));
                case "simon", "s" -> SchoolProjectSimon.main(cutFirstOf(args));
                default -> throw new IllegalArgumentException();
            }
            return;
        } catch (IllegalArgumentException e){
            System.out.println("No Valid Input!");
        }
        System.out.print("Choose between Kai(k) and Simon(s): ");
        main(scanner.nextLine().trim().toLowerCase().split(" "));
    }

    public static String[] cutFirstOf(String[] args){
        return args.length > 1 ? Arrays.copyOfRange(args,1,args.length) : new String[]{};
    }
}
