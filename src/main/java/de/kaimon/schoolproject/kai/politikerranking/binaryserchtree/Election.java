package de.kaimon.schoolproject.kai.politikerranking.binaryserchtree;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.TreeViewGUI;
import sas.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Election {

    public Election(String sortBy) throws IOException {
        Politician politicians[] = new Politician[6];
        politicians[0] = new Politician(Tools.randomNumber(0,100), "Hallo");
        politicians[1] = new Politician(Tools.randomNumber(0,100), "LOL");
        politicians[2] = new Politician(Tools.randomNumber(0,100), "XD");
        politicians[3] = new Politician(Tools.randomNumber(0,100), "SUS");
        politicians[4] = new Politician(Tools.randomNumber(0,100), "LAAAL");
        politicians[5] = new Politician(Tools.randomNumber(0,100), "SHEESH");
        new TreeViewGUI(sortAndCreateTree(politicians, sortBy));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("press enter: ");
        reader.readLine();

    }

    public BinaryTree<String> sortAndCreateTree(Politician[] politicians, String sortBy){
        if(sortBy.equals("fame")){
            Politician temp;
            for(int i = 0; i < politicians.length; i++){
                for (int j = 0; j < politicians.length - 1; j++) {
                    if(politicians[j].getFame() >= politicians[j+1].getFame()){
                        temp = politicians[j];
                        politicians[j] = politicians[j+1];
                        politicians[j+1] = temp;
                    }
                }
            }
        }
        if(sortBy.equals("name")){
            Politician temp;
            for(int i = 0; i < politicians.length; i++){
                for (int j = 0; j < politicians.length - 1; j++) {
                    if(politicians[j].getName().compareTo(politicians[j+1].getName()) < 0){
                        temp = politicians[j];
                        politicians[j] = politicians[j+1];
                        politicians[j+1] = temp;
                    }
                }
            }
        }
        return createSearchTree(politicians);
    }

    private BinaryTree<String> createSearchTree(Politician[] politicians){
        if(politicians.length == 1) return new BinaryTree<String>(politicians[0].getName() + " fame: " + politicians[0].getFame());
        Politician[] first = new Politician[Math.round(politicians.length/2)];
        Politician[] second = new Politician[politicians.length - (Math.round(politicians.length/2)+1)];
        for (int i = 0; i < first.length; i++) first[i] = politicians[i];
        for (int i = 0; i < second.length; i++) second[i] = politicians[Math.round(politicians.length/2)+1+i];
        BinaryTree<String> tree = new BinaryTree<>(politicians[Math.round(politicians.length/2)].getName() + " fame: " + politicians[Math.round(politicians.length/2)].getFame());
        if(first.length > 0) tree.setLeftTree(createSearchTree(first));
        if(second.length > 0) tree.setRightTree(createSearchTree(second));
        return tree;
    }
}
