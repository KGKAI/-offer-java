package next_node_of_binary_tree;

/**
 * 题目描述 给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 *
 * 思路：1、如果当前节点有右节点，那么他的下一个节点就是它的右子树中的最左节点
 *      2、如果当前节点没有右节点，则分一下两种情况：
 *         a、如果节点是他父节点的左子节点，那么他的下一个节点就是他的父节点
 *         b、如果一个节点既没有右子树，并且还是他父节点的右子节点，我们可以
 *         沿着他指向父节点的指针一直向上遍历，直到找到一个是他父节点的左子节
 *         点的节点，如果这样的节点存在，那么这个节点的父节点就是我们要找的下一个节点
 */
public class NextNodeOfBinaryTree {
    public static BinaryTreeNode getNext(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }

        BinaryTreeNode next = null;
        if (node.getRight() != null) {
            BinaryTreeNode right = node.getRight();
            while (right.getLeft() != null) {
                right = right.getLeft();
            }

            next = right;
        } else if (node.getParent() != null) {
            BinaryTreeNode current = node;
            BinaryTreeNode parent = node.getParent();

            while (parent != null && current == parent.getRight()) {
                    current = parent;
                    parent = parent.getParent();
            }

            next = parent;
        }

        return next;
    }
}

class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private BinaryTreeNode parent;

    public BinaryTreeNode() {
    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public BinaryTreeNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode parent) {
        this.parent = parent;
    }
}