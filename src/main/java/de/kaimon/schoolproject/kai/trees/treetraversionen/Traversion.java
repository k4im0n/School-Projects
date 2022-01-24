package de.kaimon.schoolproject.kai.trees.treetraversionen;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;

public class Traversion {

    private BinaryTree<Integer> nummberTree;
    private String post = "LRW: ";
    private String pre = "WLR: ";
    private String in = "LWR: ";

    public Traversion(){
        fillTree(new int[]{5, 13, 10, 18, 30, 20, 15, 36, 39, 38, 49, 55, 51, 47, 33});
        System.out.println("");
        System.out.println(outputPostorderLRW(nummberTree) + " Postorder");
        System.out.println(outputPreorderWLR(nummberTree) + " Preorder");
        System.out.println(outputInorderLWR(nummberTree) + " Inorder");
        new TreeViewGUI(nummberTree);
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
        /*
        System.out.println(
                "\t\t\t\t\t\t\t" +
                nummberTree.getContent());
        System.out.println(
                "\t\t\t"+
                nummberTree.getLeftTree().getContent() +"\t\t\t\t\t\t\t\t" + nummberTree.getRightTree().getContent());
        System.out.println("\t"+
                nummberTree.getLeftTree().getLeftTree().getContent() +"\t\t\t\t"+
                nummberTree.getLeftTree().getRightTree().getContent() +"\t\t\t\t"+
                nummberTree.getRightTree().getLeftTree().getContent() +"\t\t\t\t" +
                nummberTree.getRightTree().getRightTree().getContent());
        System.out.println(
                nummberTree.getLeftTree().getLeftTree().getLeftTree().getContent() + "\t\t" +
                nummberTree.getLeftTree().getLeftTree().getRightTree().getContent() + "\t\t" +
                nummberTree.getLeftTree().getRightTree().getLeftTree().getContent() + "\t\t" +
                nummberTree.getLeftTree().getRightTree().getRightTree().getContent() + "\t\t" +
                nummberTree.getRightTree().getLeftTree().getLeftTree().getContent() + "\t\t" +
                nummberTree.getRightTree().getLeftTree().getRightTree().getContent() + "\t\t" +
                nummberTree.getRightTree().getRightTree().getLeftTree().getContent() + "\t\t" +
                nummberTree.getRightTree().getRightTree().getRightTree().getContent());
         */
    }
}
