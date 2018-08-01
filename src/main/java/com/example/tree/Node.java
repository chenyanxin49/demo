package com.example.tree;

/**
 * Created by       Intellij IDEA
 *
 * @author :       ChenYanxin
 * Date     :       2018/8/1
 * Time     :       17:54
 * Version  :       1.0
 * Company  :       北京太比雅科技(武汉研发中心)
 * Node  线索二叉树
 */
public class Node {

    private int data;
    private Node left;
    /**
     * 左孩子是否为线索
     */
    private boolean leftIsThread;
    private Node right;
    /**
     * 右孩子是否为线索
     */
    private boolean rightIsThread;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.leftIsThread = false;
        this.right = null;
        this.rightIsThread = false;
    }

    int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    Node getLeft() {
        return left;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    boolean isLeftIsThread() {
        return !leftIsThread;
    }

    void setLeftIsThread() {
        this.leftIsThread = true;
    }

    Node getRight() {
        return right;
    }

    void setRight(Node right) {
        this.right = right;
    }

    boolean isRightIsThread() {
        return rightIsThread;
    }

    void setRightIsThread() {
        this.rightIsThread = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            Node temp = (Node) obj;
            return temp.getData() == this.data;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + this.data;
    }
}
