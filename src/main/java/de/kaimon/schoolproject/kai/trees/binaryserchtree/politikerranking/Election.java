package de.kaimon.schoolproject.kai.trees.binaryserchtree.politikerranking;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinarySearchTree;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.SearchTreeViewGUI;
import sas.Text;
import sas.Tools;
import sas.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Election {

    View view;
    Text text;

    public Election(String sortBy, View view) throws IOException {
        this.view = view;
        setup();
        if(sortBy.equals("name")){
            BinarySearchTree<Politician> tree = new BinarySearchTree<>();
            tree.insert(new Politician(Tools.randomNumber(0,100), "Mogusa", false));
            tree.insert(new Politician(Tools.randomNumber(0,100), "Hallo", false));
            tree.insert(new Politician(Tools.randomNumber(0,100), "LOL", false));
            tree.insert(new Politician(Tools.randomNumber(0,100), "XD", false));
            tree.insert(new Politician(Tools.randomNumber(0,100), "SUS", false));
            tree.insert(new Politician(Tools.randomNumber(0,100), "LAAAL", false));
            tree.insert(new Politician(Tools.randomNumber(0,100), "SHEESH", false));
            new SearchTreeViewGUI(tree);
        } else if (sortBy.equals("fame")){
            BinarySearchTree<Politician> tree = new BinarySearchTree<>();
            tree.insert(new Politician(50, "Mogusa", false));
            tree.insert(new Politician(Tools.randomNumber(0,100), "Hallo", true));
            tree.insert(new Politician(Tools.randomNumber(0,100), "LOL", true));
            tree.insert(new Politician(Tools.randomNumber(0,100), "XD", true));
            tree.insert(new Politician(Tools.randomNumber(0,100), "SUS", true));
            tree.insert(new Politician(Tools.randomNumber(0,100), "LAAAL", true));
            tree.insert(new Politician(Tools.randomNumber(0,100), "SHEESH", true));
            new SearchTreeViewGUI(tree);
        }
        else return;
        boolean exit = false;
        while (!exit){
            if(view.keyPressed('0')) exit = true;
            view.wait(10);
        }
        end();
    }

    private void setup(){
        view.setSize(200,40);
        text = new Text(10,10,"Press 0 to exit");
    }

    private void end(){
        view.remove(text);
        view.setSize(0,0);
    }
}
