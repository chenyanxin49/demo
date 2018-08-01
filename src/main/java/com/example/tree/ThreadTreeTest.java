package com.example.tree;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/8/1
 * Time     :       17:56
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * ThreadTreeTest
 */
public class ThreadTreeTest {

    public static void main(String[] args) {

        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // 创建普通二叉树
        ThreadTree threadTree = new ThreadTree(data);

        // 中序递归遍历二叉树
        threadTree.inList(threadTree.getRoot());
        System.out.println();

        // 采用中序遍历将二叉树线索化
        threadTree.inThread(threadTree.getRoot());

        // 中序遍历线索化二叉树
        threadTree.inThreadList(threadTree.getRoot());
    }
}
