package de.kaimon.schoolproject.simon;

import de.kaimon.schoolproject.simon.globalutils.Color;

import java.util.Scanner;

public class SchoolProjectSimon {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(Color.PURPLE + "Liste alles Projekte:");
        System.out.println(Color.RED + "01." + Color.CYAN + " TestProject " + Color.BLUE + "[TEST]");
        System.out.println(Color.RED + "02." + Color.CYAN + " SaS2 " + Color.BLUE + "[SAS2]");
        System.out.println(Color.RED + "03." + Color.CYAN + " CookieClicker " + Color.BLUE + "[CC]");
        System.out.print(Color.YELLOW + "Deine Wahl: ");
        while (true) {
            String input = scanner.next();
            if (input.equals("EXIT")) break;
            switch (input) {
                case "TEST":

                    break;
            }
        }
        System.out.println(Color.YELLOW + "Bye...");
    }
}
