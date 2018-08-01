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
class TreeNode {

    /**
     * 节点数据值
     */
    private int val = 0;
    /**
     * 左孩子
     */
    private TreeNode right = null;
    /**
     * 右孩子
     */
    private TreeNode left = null;

    TreeNode() {
    }

    private TreeNode(int val) {
        this.val = val;
    }

    /**
     * 建树
     */
    void createBinTree(int[] array, List<TreeNode> nodeList) {
        // 遍历数据放入树节点
        for (int anArray : array) {
            // 树节点放入树集合
            nodeList.add(new TreeNode(anArray));
        }
        // 依次为节点添加孩子，循环上限需-1，否则可能数组下标越界
        for (int parentIndex = 0; parentIndex < (array.length >> 1) - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList.get((parentIndex << 1) + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList.get((parentIndex << 1) + 2);
        }
        // 最后个父节点位置
        int lastParentIndex = (array.length >> 1) - 1;
        nodeList.get(lastParentIndex).left = nodeList.get((lastParentIndex << 1) + 1);
        // 如果为奇数才有右叶子，否则没有，不判断会下标越界
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList.get((lastParentIndex << 1) + 2);
        }
    }

    /**
     * 先序遍历输出-递归 先序遇到节点就操作
     */
    void preOrder(TreeNode node) {
        if (node != null) {
            // 先序遍历先操作父再左右，或先父再右左
            System.out.print(node.val + "\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 先序遍历输出-非递归 先序遇到节点就操作
     */
    void preOrder2(TreeNode node) {
        // 创建一个栈存储遍历到的根
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                // 节点不为空，操作当前数据，（节点不为空时一路左树遍历到底，直到左树为空，）
                // 然后把本层节点压入栈存储，用以当本层节点的子树遍历完回到这里遍历本层节点的兄弟右树
                // 同时把左子树记录为节点，进入下一层
                System.out.print(node.val + "\t");
                stack.push(node);
                node = node.left;
            } else {
                // 节点为空时，左树遍历到尽头叶子，弹出栈里的上一节点，记录上一节点的右子树，即当前节点的兄弟右树；
                // 或者上次记录的右子树也为空时，说明这个节点左右遍历完成，弹出栈里的上一节点，记录上一节点的右子树，
                // 此时一路右子树判断直到回到根节点，进入根节点的右树，再次遍历左树一路到底，循环直到栈弹空。
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历输出-递归 先把节点记录下来，操作下一个子，再操作节点，再操作另一个子
     */
    void inOrder(TreeNode node) {
        if (node != null) {
            // 中序遍历先操作左再父再右，或先右再父再左
            inOrder(node.left);
            System.out.print(node.val + "\t");
            inOrder(node.right);
        }
    }

    /**
     * 中序遍历输出-非递归 先把节点记录下来，操作下一个子，再操作节点，再操作另一个子
     */
    void inOrder2(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                // 先把节点记录下来
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                // 相比先序只是把数据放在操作右子树分支前
                System.out.print(node.val + "\t");
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历输出-递归 先把节点记录下来，操作完两个子，再操作节点
     */
    void postOrder(TreeNode node) {
        if (node != null) {
            // 后序先左右再父，或先右左再父
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + "\t");
        }
    }

    /**
     * 后序遍历输出-非递归 先把节点记录下来，操作完两个子，再操作节点
     */
    void postOrder2(TreeNode root) {
        // 后序先左右再父
        Stack<TreeNode> stack = new Stack<>();
        // 循环退出条件，记录右节点已经访问过，否则会死循环，无限遍历第一个右节点
        TreeNode lastVisit = root;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                // 第一次root根入栈
                // 之后此子树的左节点依次入栈，当前节点记录下来
                stack.push(root);
                root = root.left;
            }
            // 左节点入栈完毕，查看当前栈顶元素
            root = stack.peek();
            if (root.right == null || lastVisit == root.right) {
                // 如果其右子树也为空，或者右子树已经访问
                // 则可以直接输出当前节点的值
                System.out.print(root.val + "\t");
                stack.pop();
                lastVisit = root;
                root = null;
            } else {
                // 否则，继续遍历右子树
                root = root.right;
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
        Queue<TreeNode> queue = new LinkedList<>();
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
            return left.val == right.val
                    && lrSym(left.left, right.right)
                    && lrSym(left.right, right.left);
        }
        return false;
    }
}
