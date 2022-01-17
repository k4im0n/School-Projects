package de.kaimon.schoolproject.kai.trees.morseconverter;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.TreeViewGUI;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MorseConverter {

    private BinaryTree<String> morseTree;

    public MorseConverter() throws IOException {
        fillTree();
        new TreeViewGUI(morseTree);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;
        while (run) {
            System.out.println("in Input");
            System.out.println("out Output");
            System.out.println("exit Exit");
            System.out.print("ihre Auswahl: ");
            String input = reader.readLine();
            if (input.equals("in")) {
                System.out.print("input - Location code: ");
                String input1 = reader.readLine();
                System.out.print("input - Input String: ");
                String input2 = reader.readLine();
                insertByCode(input1, input2);
            } else if (input.equals("out")) {
                System.out.print("output - Location codes: ");
                String input1 = reader.readLine();
                System.out.println(outByCode(input1, null));
            } else if(input.equals("exit")){
                run = false;
            }
        }
    }

    private String outByCode(String code, @Nullable String given){
        String input = code;
        String string;
        if(given != null) string = given;
        else string = "";
        if(code.length() < 3) return string;
        char part1 = code.charAt(0);
        char part2 = code.charAt(1);
        char part3 = code.charAt(2);
        if(part1 == '0'){
            if(part2 == '0'){
                if(part3 == '0'){
                    string = string + morseTree.getLeftTree().getLeftTree().getLeftTree().getContent();
                } else {
                    string = string + morseTree.getLeftTree().getLeftTree().getRightTree().getContent();
                }
            } else {
                if(part3 == '0'){
                    string = string + morseTree.getLeftTree().getRightTree().getLeftTree().getContent();
                } else {
                    string = string + morseTree.getLeftTree().getRightTree().getRightTree().getContent();
                }
            }
        }
        else {
            if(part2 == '0'){
                if(part3 == '0'){
                    string = string + morseTree.getRightTree().getLeftTree().getLeftTree().getContent();
                } else {
                    string = string + morseTree.getRightTree().getLeftTree().getRightTree().getContent();
                }
            } else {
                if(part3 == '0'){
                    string = string + morseTree.getRightTree().getRightTree().getLeftTree().getContent();
                } else {
                    string = string + morseTree.getRightTree().getRightTree().getRightTree().getContent();
                }
            }
        }

        input = input.substring(1);
        input = input.substring(1);
        input = input.substring(1);

        return outByCode(input, string);
    }

    private void insertByCode(String input, String code){
        if(code.length() != 3) return;
        char part1 = code.charAt(0);
        char part2 = code.charAt(1);
        char part3 = code.charAt(2);
        if(part1 == '0'){
            if(part2 == '0'){
                if(part3 == '0'){
                    morseTree.getLeftTree().getLeftTree().getLeftTree().setContent(input);
                } else {
                    morseTree.getLeftTree().getLeftTree().getRightTree().setContent(input);
                }
            } else {
                if(part3 == '0'){
                    morseTree.getLeftTree().getRightTree().getLeftTree().setContent(input);
                } else {
                    morseTree.getLeftTree().getRightTree().getRightTree().setContent(input);
                }
            }
        }
        else {
            if(part2 == '0'){
                if(part3 == '0'){
                    morseTree.getRightTree().getLeftTree().getLeftTree().setContent(input);
                } else {
                    morseTree.getRightTree().getLeftTree().getRightTree().setContent(input);
                }
            } else {
                if(part3 == '0'){
                    morseTree.getRightTree().getRightTree().getLeftTree().setContent(input);
                } else {
                    morseTree.getRightTree().getRightTree().getRightTree().setContent(input);
                }
            }
        }
    }

    private void fillTree(){
        BinaryTree<String> treeLL = new BinaryTree<>("lo");
        treeLL.setLeftTree(new BinaryTree<>("l"));
        treeLL.setRightTree(new BinaryTree<>("o"));
        BinaryTree<String> treeLR = new BinaryTree<>("ls");
        treeLR.setLeftTree(new BinaryTree<>("l"));
        treeLR.setRightTree(new BinaryTree<>("s"));
        BinaryTree<String> treeRL = new BinaryTree<>("he");
        treeRL.setLeftTree(new BinaryTree<>("h"));
        treeRL.setRightTree(new BinaryTree<>("e"));
        BinaryTree<String> treeRR = new BinaryTree<>("xD");
        treeRR.setLeftTree(new BinaryTree<>("x"));
        treeRR.setRightTree(new BinaryTree<>("D"));

        BinaryTree<String> treeL = new BinaryTree<>("lols");
        treeL.setLeftTree(treeLL);
        treeL.setRightTree(treeLR);
        BinaryTree<String> treeR = new BinaryTree<>("hexD");
        treeR.setLeftTree(treeRL);
        treeR.setRightTree(treeRR);

        morseTree = new BinaryTree<>("lolshexD");
        morseTree.setLeftTree(treeL);
        morseTree.setRightTree(treeR);
    }
}
