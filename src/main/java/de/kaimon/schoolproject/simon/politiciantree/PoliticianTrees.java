package de.kaimon.schoolproject.simon.politiciantree;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.*;
import sas.Tools;

public class PoliticianTrees {

    private final Politician[] politicians = new Politician[10];

    public PoliticianTrees() {
        politicians[0] = new Politician("Olaf", "Scholz", Tools.randomNumber(0, 10));
        politicians[1] = new Politician("Robert", "Habeck", Tools.randomNumber(0, 10));
        politicians[2] = new Politician("Christian", "Lindner", Tools.randomNumber(0, 10));
        politicians[3] = new Politician("Nancy", "Faeser", Tools.randomNumber(0, 10));
        politicians[4] = new Politician("Analena", "Baerbock", Tools.randomNumber(0, 10));
        politicians[5] = new Politician("Marco", "Buschmann", Tools.randomNumber(0, 10));
        politicians[6] = new Politician("Hubertus", "Heil", Tools.randomNumber(0, 10));
        politicians[7] = new Politician("Christine", "Lambrecht", Tools.randomNumber(0, 10));
        politicians[8] = new Politician("Cem", "Özdemir", Tools.randomNumber(0, 10));
        politicians[9] = new Politician("Anne", "Spiegel", Tools.randomNumber(0, 10));
    }
    
    public void buildTree(CompareType compareType) {
        BinarySearchTree<Politician> tree = new BinarySearchTree<>();
        for (int i = 0; i < politicians.length; i++) {
            politicians[i].setCompareType(compareType);
            tree.insert(politicians[i]);
        }
        new SearchTreeView(600, 1000, tree);
    }
}
