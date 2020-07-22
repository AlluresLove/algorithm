package cn.idestiny.tree;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 * 输出: true
 *
 * 示例 2:
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 * 输出: false
 *
 * 示例 3:
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 * 输出: false
 *
 * @author: Lv Fan
 * @description: 相同的树
 * @date: Create in 2020/7/22 6:55
 */
public class SameTree {

    static class TreeNode{

        /**
         * 默认设置Value构造函数
         * @param value 节点值
         */
        public TreeNode(int value) {
            this.val = value;
        }

        /**
         * 左节点
         */
        public TreeNode left;

        /**
         * 右节点
         */
        public TreeNode right;

        /**
         * 节点值
         */
        public int val;
    }

    /**
     * 第二种使用递归方式判断
     * @param p 第一个树
     * @param q 第二个树
     * @return 是否完全一致
     */
    public boolean isSameTree(TreeNode p,TreeNode q){
        // 两个节点都null，相同
        if (p == null && q == null ){
            return true;
        }
        // 一个节点不为空，一个节点为空，不相同
        if (p == null || q == null){
            return false;
        }
        // 两个节点的值不相同
        if (p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }


    /**
     * 第一中方式
     * @param p 第一个树
     * @param q 第二个树
     * @return 是否完全一致
     */
    public boolean isSameTree2(TreeNode p,TreeNode q){
        // 存放第一个树所有值
        List<Integer> plist = new LinkedList<>();
        // 存放第二个树所有值
        List<Integer> qlist = new LinkedList<>();
        // 前序遍历第一个树
        preorderTraversal(p,plist);
        // 前序遍历第二个树
        preorderTraversal(q,qlist);
        // 判断元素是否相同
        if (qlist.size() != plist.size()){
            return false;
        }

        for (int i = 0; i < qlist.size(); i++) {
            if (qlist.get(i) == null && plist.get(i) == null){
                continue;
            }
            if (!qlist.get(i).equals(plist.get(i))){
                return false;
            }
        }

        return true;
    }

    /**
     * 前序递归遍历
     * @param treeNode 树节点
     * @param list list
     */
    public void preorderTraversal(TreeNode treeNode,List<Integer> list){
        if (treeNode != null){
            list.add(treeNode.val);
            // 左为空，右键点有值，插入null
            if (treeNode.left == null && treeNode.right != null){
                list.add(null);
            }
            preorderTraversal(treeNode.left,list);
            preorderTraversal(treeNode.right,list);
        }
    }

}























