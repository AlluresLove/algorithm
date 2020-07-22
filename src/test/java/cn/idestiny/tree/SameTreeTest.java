package cn.idestiny.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SameTreeTest {

    @Test
    public void isSameTree() {
        SameTree sameTree = new SameTree();
        SameTree.TreeNode treeNode = new SameTree.TreeNode(1);
        SameTree.TreeNode treeNode2 = new SameTree.TreeNode(1);
        SameTree.TreeNode treeNode3 = new SameTree.TreeNode(2);
        SameTree.TreeNode treeNode4 = new SameTree.TreeNode(1);
        SameTree.TreeNode treeNode5 = new SameTree.TreeNode(1);
        SameTree.TreeNode treeNode6 = new SameTree.TreeNode(2);

        treeNode.right = treeNode2;
        boolean sameTree1 = sameTree.isSameTree(treeNode, treeNode);
        System.out.println(sameTree1);

    }

    @Test
    public void preorderTraversal() {
    }
}