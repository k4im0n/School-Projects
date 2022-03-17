package de.kaimon.schoolproject.kai.trees.binaryserchtree.politikerranking;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinarySearchTree;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.SearchTreeViewGUI;
import sas.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Election {

    public Election(String sortBy) throws IOException {
        if(sortBy.equals("name")){
            BinarySearchTree<PoliticianName> tree = new BinarySearchTree<>();
            tree.insert(new PoliticianName(Tools.randomNumber(0,100), "Hallo"));
            tree.insert(new PoliticianName(Tools.randomNumber(0,100), "LOL"));
            tree.insert(new PoliticianName(Tools.randomNumber(0,100), "XD"));
            tree.insert(new PoliticianName(Tools.randomNumber(0,100), "SUS"));
            tree.insert(new PoliticianName(Tools.randomNumber(0,100), "LAAAL"));
            tree.insert(new PoliticianName(Tools.randomNumber(0,100), "SHEESH"));
            new SearchTreeViewGUI(tree);
        }
        if(sortBy.equals("fame")){
            BinarySearchTree<PoliticianFame> tree = new BinarySearchTree<>();
            tree.insert(new PoliticianFame(Tools.randomNumber(0,100), "Hallo"));
            tree.insert(new PoliticianFame(Tools.randomNumber(0,100), "LOL"));
            tree.insert(new PoliticianFame(Tools.randomNumber(0,100), "XD"));
            tree.insert(new PoliticianFame(Tools.randomNumber(0,100), "SUS"));
            tree.insert(new PoliticianFame(Tools.randomNumber(0,100), "LAAAL"));
            tree.insert(new PoliticianFame(Tools.randomNumber(0,100), "SHEESH"));
            new SearchTreeViewGUI(tree);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("press enter: ");
        reader.readLine();

    }
}
