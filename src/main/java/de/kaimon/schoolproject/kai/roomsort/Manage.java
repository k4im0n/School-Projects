package de.kaimon.schoolproject.kai.roomsort;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinarySearchTree;
import sas.Tools;

public class Manage {

    public Manage(){
        BinarySearchTree<Raum> tree = new BinarySearchTree<>();
        int free = Tools.randomNumber(0,33);
        for (int i = 0; i < 33; i++) {
            if(i < free) tree.insert(new Raum(i+1, false));
            else tree.insert(new Raum(i+1, true));
        }
        boolean run = true;
        while(run){
            Raum room = searchFreeRoom(tree);
            if(room != null) System.out.println("Raum: E" + room.getNumber() + " / E33 ist frei");
            else {
                run = false;
                System.out.println("Kein Raum mehr frei");
            }
        }
    }

    public Raum searchFreeRoom(BinarySearchTree<Raum> searchTree){
        if(!searchTree.getContent().isBelegt()) {
            searchTree.getContent().setBelegt(true);
            return searchTree.getContent();
        }
        else if(!searchTree.getLeftTree().isEmpty()){
            return searchFreeRoom(searchTree.getLeftTree());
        }
        else if(!searchTree.getRightTree().isEmpty()){
            return searchFreeRoom(searchTree.getRightTree());
        }
        else return null;
    }
}
