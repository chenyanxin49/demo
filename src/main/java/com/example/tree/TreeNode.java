package com.example.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/8/1
 * Time     :       11:14
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * TreeNode
 */
public class TreeNode {

    private int val = 0;
    private TreeNode left = null;
    private TreeNode right = null;

    public int getVal() {
        return val;
    }

    TreeNode() {
    }

    private TreeNode(int val) {
        this.val = val;
    }

    /**
     * 建树
     */
    void createBinTree(int[] array, List<TreeNode> nodeList) {
        for (int anArray : array) {
            nodeList.add(new TreeNode(anArray));
        }
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
            nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
        }
        int lastparentIndex = array.length / 2 - 1;
        nodeList.get(lastparentIndex).left = nodeList
                .get(lastparentIndex * 2 + 1);
        if (array.length % 2 == 1) {
            nodeList.get(lastparentIndex).right = nodeList
                    .get(lastparentIndex * 2 + 2);
        }

    }

    /**
     * 先序遍历输出-递归
     */
    void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + "\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 先序遍历输出-非递归
     */
    void preOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (node != null) {
            TreeNode p = node;
            while (p != null || !stack.isEmpty()) {
                if (p != null) {
                    System.out.print(p.val + "\t");
                    stack.push(p);
                    p = p.left;
                } else {//在刚才那个p的左子树为空，或者p为叶子节点时执行。
                    p = stack.pop();
                    p = p.right;
                }
            }
        }
    }

    /**
     * 中序遍历输出
     */
    void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + "\t");
            inOrder(node.right);
        }
    }

    /**
     * 中序遍历-非递归
     */
    void inOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (node != null) {
            TreeNode p = node;
            while (p != null || !stack.isEmpty()) {
                if (p != null) {
                    stack.push(p);
                    p = p.left;
                } else {
                    p = stack.pop();
                    System.out.print(p.val + "\t");
                    p = p.right;
                }
            }
        }
    }

    /**
     * 后序递归遍历输出
     */
    void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + "\t");
        }
    }

    /**
     * 非递归后序遍历
     */
    void postOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 查看当前栈顶元素
            node = stack.peek();
            // 如果其右子树也为空，或者右子树已经访问
            // 则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + "\t");
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                // 否则，继续遍历右子树
                node = node.right;
            }
        }
    }

    /**
     * 根据先序序列和中序序列唯一建造一棵二叉树，返回二叉树的根
     */
    private TreeNode preAndinCreateTree(char[] pre, char[] in, int i, int j, int m, int n) {
        //数组pre存储先序序列，i,j分别表示pre的上标和下标
        //in：中序序列，m，n分别表示in的上标和下标
        //函数返回先序序列和中序序列构成的树的根
        int k;
        TreeNode p = null;
        if (n < 0) {
            return null;
        }
        p = new TreeNode(pre[i]);
        k = m;
        //在中序中找根
        while ((k <= n) && in[k] != pre[i]) {
            k++;
        }
        p.left = preAndinCreateTree(pre, in, i + 1, i + k - m, m, k - 1);
        p.right = preAndinCreateTree(pre, in, i + k - m + 1, j, k + 1, n);
        return p;
    }

    /**
     * 层次遍历
     */
    void levelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (node != null) {
            queue.add(node);
            while (!queue.isEmpty()) {
                TreeNode nnode = queue.poll();
                if (nnode != null) {
                    System.out.print(nnode.val + "\t");
                    if (nnode.left != null) {
                        queue.add(nnode.left);
                    }
                    if (nnode.right != null) {
                        queue.add(nnode.right);
                    }
                }
            }
        }
    }

    /**
     * 求二叉树的高度
     */
    int height(TreeNode node) {
        int lh, rh;
        if (node == null) {
            return 0;
        } else {
            lh = height(node.left);
            rh = height(node.right);
            return 1 + (lh > rh ? lh : rh);
        }
    }

    /**
     * 操作给定的二叉树，将其变换为原二叉树的镜像。
     */
    void mirror(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirror(root.left);
            mirror(root.right);
        }
    }

    /**
     * 二叉树的下一个结点 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * 对称的二叉树
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return lrSym(pRoot.left, pRoot.right);
    }

    private boolean lrSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && lrSym(left.left, right.right)
                    && lrSym(left.right, right.left);
        }
        return false;
    }
}
