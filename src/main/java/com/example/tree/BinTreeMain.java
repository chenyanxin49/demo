package com.example.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/8/1
 * Time     :       11:24
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * BinTreeMain
 */
public class BinTreeMain {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        List<TreeNode> nodeList = new LinkedList<>();
        TreeNode treeNode = new TreeNode();
        treeNode.createBinTree(array, nodeList);
        TreeNode root = nodeList.get(0);
        System.out.println("递归先序：");
        treeNode.preOrder(root);
        System.out.println();
        System.out.println("非递归先序：");
        treeNode.preOrder2(root);
        System.out.println();
        System.out.println("递归中序：");
        treeNode.inOrder(root);
        System.out.println();
        System.out.println("非递归中序：");
        treeNode.inOrder2(root);
        System.out.println();
        System.out.println("递归后序：");
        treeNode.postOrder(root);
        System.out.println();
        System.out.println("非递归后序：");
        treeNode.postOrder2(root);
        System.out.println();
        System.out.println("层级遍历：");
        treeNode.levelOrder(root);
        System.out.println();
        System.out.println("树高：");
        System.out.println(treeNode.height(root));
        System.out.println("镜像翻转：");
        treeNode.mirror(root);
        treeNode.levelOrder(root);
        System.out.println();
        System.out.println("是否对称的二叉树：");
        System.out.println(treeNode.isSymmetrical(root));
//        HeapSortTest.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
