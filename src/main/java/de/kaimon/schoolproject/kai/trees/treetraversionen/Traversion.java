package de.kaimon.schoolproject.kai.trees.treetraversionen;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;
import sas.Text;
import sas.View;

public class Traversion {

    View view;
    Text tree;
    Text tree1;
    Text tree2;
    Text tree3;
    Text tree4;
    Text lrwPOST;
    Text wlrPRE;
    Text lwrIN;

    private BinaryTree<Integer> nummberTree;
    private String post = "LRW: ";
    private String pre = "WLR: ";
    private String in = "LWR: ";

    public Traversion(View view, int[] input){
        this.view = view;
        setup();
        fillTree(input);
        System.out.println("");
        lrwPOST = new Text(10,160," Postorder " + outputPostorderLRW(nummberTree));
        wlrPRE = new Text(10,190," Preorder " + outputPreorderWLR(nummberTree));
        lwrIN = new Text(10,220," Inorder " + outputInorderLWR(nummberTree));
        boolean wait = true;
        while(wait) {
            if(view.keyPressed('0')) wait = false;
            else view.wait(10);
        }
        end();
    }

    private void setup(){
        view.setSize(430,260);
        tree = new Text(10,10,"Binary Tree:          '0' to exit");
        tree1 = new Text(10,40, "");
        tree2 = new Text(10,70, "");
        tree3 = new Text(10,100, "");
        tree4 = new Text(10,130, "");
    }
    private String outputPostorderLRW(BinaryTree<Integer> tree){
        if(tree.isEmpty()) return post;
        if(!tree.getLeftTree().isEmpty()) outputPostorderLRW(tree.getLeftTree());
        if(!tree.getRightTree().isEmpty()) outputPostorderLRW(tree.getRightTree());
        post = post + " " + tree.getContent();
        return post;
    }

    private String outputPreorderWLR(BinaryTree<Integer> tree){
        if(tree.isEmpty()) return pre;
        pre = pre + " " + tree.getContent();
        if(!tree.getLeftTree().isEmpty()) outputPreorderWLR(tree.getLeftTree());
        if(!tree.getRightTree().isEmpty()) outputPreorderWLR(tree.getRightTree());
        return pre;
    }

    private String outputInorderLWR(BinaryTree<Integer> tree){
        if(tree.isEmpty()) return in;
        if(!tree.getLeftTree().isEmpty()) outputInorderLWR(tree.getLeftTree());
        in = in + " " + tree.getContent();
        if(!tree.getRightTree().isEmpty()) outputInorderLWR(tree.getRightTree());
        return in;
    }

    private void fillTree(int[] post){
        BinaryTree<Integer> treeL;
        BinaryTree<Integer> treeR;
        if(post[14] == 9898) return;
        nummberTree = new BinaryTree<>(post[14]);
        if(post[7] != 9898){
            treeL = new BinaryTree<>(post[6]);
            if(post[2] != 9898){
                BinaryTree<Integer> treeLL = new BinaryTree<>(post[2]);
                if(post[0] != 9898) treeLL.setLeftTree(new BinaryTree<>(post[0]));
                if(post[1] != 9898) treeLL.setRightTree(new BinaryTree<>(post[1]));
                treeL.setLeftTree(treeLL);
            }
            if(post[5] != 9898){
                BinaryTree<Integer> treeLR = new BinaryTree<>(post[5]);
                if(post[3] != 9898) treeLR.setLeftTree(new BinaryTree<>(post[3]));
                if(post[4] != 9898) treeLR.setRightTree(new BinaryTree<>(post[4]));
                treeL.setRightTree(treeLR);
            }
            nummberTree.setLeftTree(treeL);
        }
        if(post[13] != 9898){
            treeR = new BinaryTree<>(post[13]);
            if(post[10] != 9898){
                BinaryTree<Integer> treeRL = new BinaryTree<>(post[9]);
                if(post[8] != 9898) treeRL.setLeftTree(new BinaryTree<>(post[7]));
                if(post[9] != 9898) treeRL.setRightTree(new BinaryTree<>(post[8]));
                treeR.setLeftTree(treeRL);
            }
            if(post[12] != 9898) {
                BinaryTree<Integer> treeRR = new BinaryTree<>(post[12]);
                if(post[11] != 9898) treeRR.setLeftTree(new BinaryTree<>(post[10]));
                if(post[12] != 9898) treeRR.setRightTree(new BinaryTree<>(post[11]));
                treeR.setRightTree(treeRR);
            }
            nummberTree.setRightTree(treeR);
        }

        tree1.setText(
                "                                    " +
                nummberTree.getContent());
        tree2.setText(
                "                    "+
                nummberTree.getLeftTree().getContent() +"                                " + nummberTree.getRightTree().getContent());
        tree3.setText("          "+
                nummberTree.getLeftTree().getLeftTree().getContent() +"                "+
                nummberTree.getLeftTree().getRightTree().getContent() +"                "+
                nummberTree.getRightTree().getLeftTree().getContent() +"                " +
                nummberTree.getRightTree().getRightTree().getContent());
        tree4.setText(
                nummberTree.getLeftTree().getLeftTree().getLeftTree().getContent() + "        " +
                nummberTree.getLeftTree().getLeftTree().getRightTree().getContent() + "        " +
                nummberTree.getLeftTree().getRightTree().getLeftTree().getContent() + "        " +
                nummberTree.getLeftTree().getRightTree().getRightTree().getContent() + "        " +
                nummberTree.getRightTree().getLeftTree().getLeftTree().getContent() + "        " +
                nummberTree.getRightTree().getLeftTree().getRightTree().getContent() + "        " +
                nummberTree.getRightTree().getRightTree().getLeftTree().getContent() + "        " +
                nummberTree.getRightTree().getRightTree().getRightTree().getContent());

    }

    private void end(){
        view.remove(tree);
        view.remove(tree1);
        view.remove(tree2);
        view.remove(tree3);
        view.remove(tree4);
        view.remove(lrwPOST);
        view.remove(wlrPRE);
        view.remove(lwrIN);
        view.setSize(0,0);
    }
}
