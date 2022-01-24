package de.kaimon.schoolproject.kai.trees;

import de.kaimon.schoolproject.implementations.datenstrukturklassen.baum.BinaryTree;

public class TreeCreate {

    private static BinaryTree<Integer> nummberTree;

    public static BinaryTree fillTree(int[] post){
        BinaryTree<Integer> treeL;
        BinaryTree<Integer> treeR;
        if(post[14] == 9898) return null;
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
        return nummberTree;
    }
}
