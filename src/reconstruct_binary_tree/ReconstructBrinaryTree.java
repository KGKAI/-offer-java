package reconstruct_binary_tree;

// 重建二叉树
// 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 思路：
public class ReconstructBrinaryTree {
    public static BinaryTreeNode reconstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            return null;
        }

        return reconstruct(pre, 0, pre.length - 1, in, 0, in.length);
    }

    /**
     * @param preOrder      前序遍历数组
     * @param startPreIndex 前序遍历数组开始下标
     * @param endPreIndex   前序遍历结束下标
     * @param inOrder       中序遍历数组
     * @param startInIndex  中序遍历开始下标
     * @param endInIndex    中序遍历结束下标
     * @return
     */
    private static BinaryTreeNode reconstruct(int[] preOrder, int startPreIndex, int endPreIndex, int[] inOrder, int startInIndex, int endInIndex) {
        int rootValue = preOrder[startPreIndex];
        System.out.println("根结点的值为：" + rootValue);
        BinaryTreeNode root = new BinaryTreeNode(rootValue);

        if (startPreIndex == endPreIndex && startInIndex == endInIndex && preOrder[startPreIndex] == inOrder[startInIndex]) {
            System.out.println("only one element");
            return root;
        }

        int rootInIndex = startInIndex;
        // 在中序遍历里找到根结点
        while (rootInIndex <= endInIndex && inOrder[rootInIndex] != rootValue) {
            rootInIndex++;
        }

        int leftLength = rootInIndex - startInIndex;
        int leftPreEndIndex = startPreIndex + leftLength;

        if (leftLength > 0) {
            root.setLeft(reconstruct(preOrder, startPreIndex + 1, leftPreEndIndex, inOrder, startInIndex, rootInIndex - 1));
        }

        if (endPreIndex - startPreIndex > leftLength) {
            root.setRight(reconstruct(preOrder, leftPreEndIndex + 1, endPreIndex, inOrder, rootInIndex + 1, endInIndex));
        }

        return root;
    }

    public static void printPreOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.getLeft() != null) {
            printPreOrder(root.getLeft());
        }
        System.out.print(root.getValue() + " ");

        if (root.getRight() != null) {
            printPreOrder(root.getRight());
        }

    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        printPreOrder(reconstructBinaryTree(preOrder, inOrder));
    }
}

class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
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
}
