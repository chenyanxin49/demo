package com.example.tree;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/8/1
 * Time     :       17:56
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * ThreadTree
 *   给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 树中的结点包含前后中序遍历顺序的上或下结点。
 */
public class ThreadTree {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 大小
     */
    private int size;

    /**
     * 线索化的时候保存前驱
     */
    private Node pre;

    public ThreadTree() {
        this.root = null;
        this.size = 0;
        this.pre = null;
    }

    ThreadTree(int[] data) {
        this.pre = null;
        this.size = data.length;
        // 创建二叉树
        this.root = createTree(data, 1);
    }

    /**
     * 创建二叉树
     */
    private Node createTree(int[] data, int index) {
        if (index > data.length) {
            return null;
        }
        Node node = new Node(data[index - 1]);
        Node left = createTree(data, 2 * index);
        Node right = createTree(data, 2 * index + 1);
        node.setLeft(left);
        node.setRight(right);
        return node;
    }

    /**
     * 将以root为根节点的二叉树线索化
     */
    void inThread(Node root) {
        if (root != null) {
            // 线索化左孩子
            inThread(root.getLeft());
            // 左孩子为空
            if (null == root.getLeft()) {
                // 将左孩子设置为线索
                root.setLeftIsThread();
                root.setLeft(pre);
            }
            // 右孩子为空
            if (pre != null && null == pre.getRight()) {
                pre.setRightIsThread();
                pre.setRight(root);
            }
            pre = root;
            // 线索化右孩子
            inThread(root.getRight());
        }
    }

    /**
     * 中序遍历线索二叉树
     */
    void inThreadList(Node root) {
        if (root != null) {
            // 如果左孩子不是线索
            while (root != null && root.isLeftIsThread()) {
                root = root.getLeft();
            }
            do {
                if (root != null) {
                    System.out.print(root.getData() + ",");
                    // 如果右孩子是线索
                    if (root.isRightIsThread()) {
                        root = root.getRight();
                    } else {
                        // 有右孩子
                        root = root.getRight();
                        while (root != null && root.isLeftIsThread()) {
                            root = root.getLeft();
                        }
                    }
                }
            } while (root != null);
        }
    }

    /**
     * 前序遍历递归算法
     */
    private void preList(Node root) {
        if (root != null) {
            System.out.print(root.getData() + ",");
            preList(root.getLeft());
            preList(root.getRight());
        }
    }

    /**
     * 中序遍历
     */
    void inList(Node root) {
        if (root != null) {
            inList(root.getLeft());
            System.out.print(root.getData() + ",");
            inList(root.getRight());
        }
    }

    Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
