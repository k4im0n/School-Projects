package de.kaimon.schoolproject.simon;

import de.kaimon.schoolproject.simon.globalutils.Color;
import de.kaimon.schoolproject.simon.politiciantree.CompareType;
import de.kaimon.schoolproject.simon.politiciantree.Politician;
import de.kaimon.schoolproject.simon.politiciantree.PoliticianTrees;

import java.util.Scanner;

public class SchoolProjectSimon {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(Color.PURPLE + "Liste alles Projekte:");
        System.out.println(Color.GREEN + "01." + Color.CYAN + " PoliticianTreeFame " + Color.BLUE + "[PTF]");
        System.out.println(Color.GREEN + "01." + Color.CYAN + " PoliticianTreeName " + Color.BLUE + "[PTN]");
        while (true) {
            System.out.print(Color.YELLOW + "Deine Wahl: ");
            String input = scanner.next();
            if (input.equals("EXIT")) break;
            switch (input) {
                case "PTF":
                    PoliticianTrees politicianTreesFame = new PoliticianTrees();
                    politicianTreesFame.buildTree(CompareType.FAME);
                    break;
                case "PTN":
                    PoliticianTrees politicianTreesName = new PoliticianTrees();
                    politicianTreesName.buildTree(CompareType.NAME);
                    break;
                default:
                    System.out.println(Color.RED + input + " ist keine gültige Eingabe!");
                    break;
            }
        }
        System.out.println(Color.YELLOW + "Bye...");
    }
}
