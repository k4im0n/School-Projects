package de.kaimon.schoolproject.kai.treetraversionen;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;

public class Traversion {

    private BinaryTree<Integer> nummberTree;

    public Traversion(){
        fillTree();
        new TreeViewGUI(nummberTree);
        System.out.println("----Postorder----");
        outputPostorderLRW(nummberTree);
        System.out.println("----Preorder----");
        outputPreorderWLR(nummberTree);
        System.out.println("----Inorder----");
        outputInorderLWR(nummberTree);
    }

    private void outputPostorderLRW(BinaryTree<Integer> tree){
        if(tree.isEmpty()) return;
        if(!tree.getLeftTree().isEmpty()) outputPostorderLRW(tree.getLeftTree());
        if(!tree.getRightTree().isEmpty()) outputPostorderLRW(tree.getRightTree());
        System.out.println(tree.getContent());
    }

    private void outputPreorderWLR(BinaryTree tree){
        if(tree.isEmpty()) return;
        System.out.println(tree.getContent());
        if(!tree.getLeftTree().isEmpty()) outputPreorderWLR(tree.getLeftTree());
        if(!tree.getRightTree().isEmpty()) outputPreorderWLR(tree.getRightTree());
    }

    private void outputInorderLWR(BinaryTree tree){
        if(tree.isEmpty()) return;
        if(!tree.getLeftTree().isEmpty()) outputInorderLWR(tree.getLeftTree());
        System.out.println(tree.getContent());
        if(!tree.getRightTree().isEmpty()) outputInorderLWR(tree.getRightTree());
    }

    private BinaryTree fillTree(){
        BinaryTree<Integer> binaryTr10 = new BinaryTree<>(10);
        binaryTr10.setLeftTree(new BinaryTree<>(5));
        BinaryTree<Integer> binaryTr18 = new BinaryTree<>(18);
        BinaryTree<Integer> binaryTr20 = new BinaryTree<>(20);
        binaryTr20.setLeftTree(binaryTr18);
        BinaryTree<Integer> binaryTr36 = new BinaryTree<>(36);
        BinaryTree<Integer> binaryTr39 = new BinaryTree<>(39);
        BinaryTree<Integer> binaryTr2 = new BinaryTree<>(38);
        binaryTr2.setLeftTree(binaryTr36);
        binaryTr2.setRightTree(binaryTr39);
        BinaryTree<Integer> binaryTr49 = new BinaryTree<>(49);
        BinaryTree<Integer> binaryTr51 = new BinaryTree<>(51);
        binaryTr51.setLeftTree(binaryTr49);
        BinaryTree<Integer> binaryTr15 = new BinaryTree<>(15);
        binaryTr15.setLeftTree(binaryTr10);
        binaryTr15.setRightTree(binaryTr20);
        BinaryTree<Integer> binaryTr47 = new BinaryTree<>(47);
        binaryTr47.setLeftTree(binaryTr2);
        binaryTr47.setRightTree(binaryTr51);
        nummberTree = new BinaryTree<>(33);
        nummberTree.setLeftTree(binaryTr15);
        nummberTree.setRightTree(binaryTr47);
        return nummberTree;
    }
}
