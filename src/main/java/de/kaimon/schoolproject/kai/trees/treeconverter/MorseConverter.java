package de.kaimon.schoolproject.kai.trees.treeconverter;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.TreeViewGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class MorseConverter {

    private BinaryTree<String> morseTree;

    public MorseConverter() throws IOException {
        fillTree();
        new TreeViewGUI(morseTree);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;
        while (run) {
            System.out.print("String, Morsecode oder exit: ");
            String input = reader.readLine();
            if (input.charAt(0) == '.' || input.charAt(0) == '-' || input.charAt(0) == '/') {
                String out = "";
                while(input.length() > 0) {
                    if (input.charAt(0) == ' ') input = input.substring(1);
                    StringBuilder in = new StringBuilder();
                    while (input.length() > 0 && input.charAt(0) != ' ') {
                        in.append(input.charAt(0));
                        input = input.substring(1);
                    }
                    out = out + morseToString(morseTree, in.toString());
                }
                System.out.println(out);
            }
            else if(input.equals("exit")) run = false;
            else System.out.println(stringToMorse(input));
        }
    }

    private String morseToString(BinaryTree<String> morseTree, String morse) {
        if(morse.length() == 0) return morseTree.getContent();
        else{
            if(morse.charAt(0) == '.') return morseToString(morseTree.getLeftTree(), morse.substring(1));
                else if(morse.charAt(0) == '-') return morseToString(morseTree.getRightTree(), morse.substring(1));
                else if(morse.charAt(0) == '/') return " ";
                else return "  !!ERROR!!  ";
        }
    }

    private String stringToMorse(String input){
        String out = "";
        while (input.length() > 0) {
            out += switchh(input);
            input = input.substring(1);
        }
        return out;
    }
    
    private String switchh(String input){
        String out = "";
        switch ("" + input.toLowerCase(Locale.ROOT).charAt(0)) {
                case "a" : return".- ";
                case "b" : return "-... ";
                case "c" : return "-.-. ";
                case "d" : return "-.. ";
                case "e" : return ". ";
                case "f" : return "..-. ";
                case "g" : return "--. ";
                case "h" : return ".... ";
                case "i" : return ".. ";
                case "j" : return ".--- ";
                case "k" : return "-.- ";
                case "l" : return ".-.. ";
                case "m" : return "-- ";
                case "n" : return "-. ";
                case "o" : return "--- ";
                case "p" : return ".--. ";
                case "q" : return "--.- ";
                case "r" : return ".-. ";
                case "s" : return "... ";
                case "t" : return "- ";
                case "u" : return "..- ";
                case "v" : return "...- ";
                case "w" : return ".-- ";
                case "x" : return "-..- ";
                case "y" : return "-.-- ";
                case "z" : return "--.. ";
                case "??" : return ".-.- ";
                case "??" : return "---. ";
                case "??" : return "..-- ";
                case "??" : return "---- ";
                case "+" : return ".-.-. ";
                case "." : return ".-.-.- ";
                case "6" : return "-.... ";
                case "-" : return "-....- ";
                case "=" : return "-...- ";
                case "/" : return "-..-. ";
                case ":" : return "---... ";
                case "8" : return "---.. ";
                case "??" : return "--..- ";
                case "," : return "--..-- ";
                case " " : return "/ ";
                default : return input + " ";
            }
    }

    private void fillTree(){
        BinaryTree<String> treeRLLLL = new BinaryTree<>("6");
        treeRLLLL.setRightTree(new BinaryTree<>("-"));
        BinaryTree<String> treeLRLRL = new BinaryTree<>("+");
        treeLRLRL.setRightTree(new BinaryTree<>("."));
        BinaryTree<String> treeRRLLR = new BinaryTree<>("??");
        treeRRLLR.setRightTree(new BinaryTree<>(","));
        BinaryTree<String> treeRRRLL = new BinaryTree<>("8");
        treeRRRLL.setLeftTree(new BinaryTree<>(":"));

        BinaryTree<String> treeRRLL = new BinaryTree<>("Z");
        treeRRLL.setRightTree(treeRRLLR);
        BinaryTree<String> treeRLLR = new BinaryTree<>("X");
        treeRLLR.setLeftTree(new BinaryTree<>("/"));
        BinaryTree<String> treeRLLL = new BinaryTree<>("B");
        treeRLLL.setLeftTree(treeRLLLL);
        treeRLLL.setRightTree(new BinaryTree<>("="));
        BinaryTree<String> treeLRLR = new BinaryTree<>("??");
        treeLRLR.setLeftTree(treeLRLRL);
        BinaryTree<String> treeRRRL = new BinaryTree<>("??");
        treeRRRL.setLeftTree(treeRRRLL);

        BinaryTree<String> treeLLL = new BinaryTree<>("S");
        treeLLL.setLeftTree(new BinaryTree<>("H"));
        treeLLL.setRightTree(new BinaryTree<>("V"));
        BinaryTree<String> treeLRL = new BinaryTree<>("R");
        treeLRL.setLeftTree(new BinaryTree<>("L"));
        treeLRL.setRightTree(treeLRLR);
        BinaryTree<String> treeRLL = new BinaryTree<>("D");
        treeRLL.setLeftTree(treeRLLL);
        treeRLL.setRightTree(treeRLLR);
        BinaryTree<String> treeRRL = new BinaryTree<>("G");
        treeRRL.setLeftTree(treeRRLL);
        treeRRL.setRightTree(new BinaryTree<>("Q"));

        BinaryTree<String> treeLLR = new BinaryTree<>("U");
        treeLLR.setLeftTree(new BinaryTree<>("F"));
        treeLLR.setRightTree(new BinaryTree<>("??"));
        BinaryTree<String> treeLRR = new BinaryTree<>("W");
        treeLRR.setLeftTree(new BinaryTree<>("P"));
        treeLRR.setRightTree(new BinaryTree<>("J"));
        BinaryTree<String> treeRLR = new BinaryTree<>("K");
        treeRLR.setLeftTree(new BinaryTree<>("C"));
        treeRLR.setRightTree(new BinaryTree<>("Y"));
        BinaryTree<String> treeRRR = new BinaryTree<>("O");
        treeRRR.setLeftTree(treeRRRL);
        treeRRR.setRightTree(new BinaryTree<>("??"));

        BinaryTree<String> treeLL = new BinaryTree<>("I");
        treeLL.setLeftTree(treeLLL);
        treeLL.setRightTree(treeLLR);
        BinaryTree<String> treeLR = new BinaryTree<>("A");
        treeLR.setLeftTree(treeLRL);
        treeLR.setRightTree(treeLRR);
        BinaryTree<String> treeRL = new BinaryTree<>("N");
        treeRL.setLeftTree(treeRLL);
        treeRL.setRightTree(treeRLR);
        BinaryTree<String> treeRR = new BinaryTree<>("M");
        treeRR.setLeftTree(treeRRL);
        treeRR.setRightTree(treeRRR);

        BinaryTree<String> treeL = new BinaryTree<>("E");
        treeL.setLeftTree(treeLL);
        treeL.setRightTree(treeLR);
        BinaryTree<String> treeR = new BinaryTree<>("T");
        treeR.setLeftTree(treeRL);
        treeR.setRightTree(treeRR);

        morseTree = new BinaryTree<>("-");
        morseTree.setLeftTree(treeL);
        morseTree.setRightTree(treeR);
    }
}
