package de.kaimon.schoolproject.kai.trees.treeconverter;
import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;
import sas.Text;
import sas.View;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Locale;

public class MorseConverter {

    View view;
    Text title;
    Text inputText;
    Text result;
    String output = "";
    public MorseConverter(String input, View view){

        this.view = view;
        setup();
        if (input.length() >= 1) startConverter(input);
        else {
            result.setText("!!!ERROR!!!! Layout error");
            result.setColor(Color.red);
        }
        boolean wait = true;
        while(wait) {
            if(view.keyPressed('c')){
                StringSelection stringSelection = new StringSelection(output);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                title.setText("Morse Converter    0 to exit   result copyed!");
            }
            if(view.keyPressed('0')) wait = false;
            else view.wait(10);
        }
        end();
    }

    private void setup(){
        view.setSize(600,150);
        title = new Text(10,10,"Morse Converter    0 to exit c to copy result");
        inputText = new Text(10,40, "Input: ");
        result = new Text(10,70,"result");
    }
    private void startConverter(String pInput){
        inputText.setText("Input: " + pInput);
        String input = pInput;
        if (input.charAt(0) == '.' || input.charAt(0) == '-' || input.charAt(0) == '/') {
            BinaryTree<String> morseTree = fillTree();
            StringBuilder out = new StringBuilder();
            while(input.length() > 0) {
                if (input.charAt(0) == ' ') input = input.substring(1);
                StringBuilder in = new StringBuilder();
                while (input.length() > 0 && input.charAt(0) != ' ') {
                    in.append(input.charAt(0));
                    input = input.substring(1);
                }
                out.append(morseToString(morseTree, in.toString()));
            }
            result.setText(out.toString());
            output = out.toString();
        }
        else {
            String out = stringToMorse(input);
            result.setText(out);
            output = out;
        }
    }

    private String morseToString(BinaryTree<String> morseTree, String morse) {
        if(morse.length() == 0) return morseTree.getContent();
        else{
            if(morse.charAt(0) == '.') return morseToString(morseTree.getLeftTree(), morse.substring(1));
            else if(morse.charAt(0) == '-') return morseToString(morseTree.getRightTree(), morse.substring(1));
            else if(morse.charAt(0) == '/') return " ";
            else if(morse.charAt(0) == ' ') return morseToString(morseTree, morse.substring(1));
            else {
                return "  !!ERROR!!  ";
            }
        }
    }

    private String stringToMorse(String input){
        String out = "";
        while (input.length() > 0) {
            out = out + switchFunction(input);
            input = input.substring(1);
        }
        return out.substring(0,out.length() -1);
    }
    
    private String switchFunction(String input){
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
                case "ä" : return ".-.- ";
                case "ö" : return "---. ";
                case "ü" : return "..-- ";
                case "ß" : return "---- ";
                case "+" : return ".-.-. ";
                case "." : return ".-.-.- ";
                case "6" : return "-.... ";
                case "-" : return "-....- ";
                case "=" : return "-...- ";
                case "/" : return "-..-. ";
                case ":" : return "---... ";
                case "8" : return "---.. ";
                case "Ż" : return "--..- ";
                case "," : return "--..-- ";
                case " " : return "/ ";
                default : return input + " ";
            }
    }

    private BinaryTree<String> fillTree(){
        BinaryTree<String> treeRLLLL = new BinaryTree<>("6");
        treeRLLLL.setRightTree(new BinaryTree<>("-"));
        BinaryTree<String> treeLRLRL = new BinaryTree<>("+");
        treeLRLRL.setRightTree(new BinaryTree<>("."));
        BinaryTree<String> treeRRLLR = new BinaryTree<>("Ż");
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
        BinaryTree<String> treeLRLR = new BinaryTree<>("Ä");
        treeLRLR.setLeftTree(treeLRLRL);
        BinaryTree<String> treeRRRL = new BinaryTree<>("Ö");
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
        treeLLR.setRightTree(new BinaryTree<>("Ü"));
        BinaryTree<String> treeLRR = new BinaryTree<>("W");
        treeLRR.setLeftTree(new BinaryTree<>("P"));
        treeLRR.setRightTree(new BinaryTree<>("J"));
        BinaryTree<String> treeRLR = new BinaryTree<>("K");
        treeRLR.setLeftTree(new BinaryTree<>("C"));
        treeRLR.setRightTree(new BinaryTree<>("Y"));
        BinaryTree<String> treeRRR = new BinaryTree<>("O");
        treeRRR.setLeftTree(treeRRRL);
        treeRRR.setRightTree(new BinaryTree<>("ß"));

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

        BinaryTree<String> tree = new BinaryTree<>("-");
        tree.setLeftTree(treeL);
        tree.setRightTree(treeR);
        return tree;
    }

    private void end(){
        view.remove(title);
        view.remove(inputText);
        view.remove(result);
        view.setSize(0,0);
    }
}
