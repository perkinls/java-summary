package lipan.top.notes.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author li.pan
 * @title 二叉搜索树
 */
public class BinarySearchTree<E extends Comparable<E>> {
    class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * 二叉搜索树中的元素个数
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断二叉搜索树是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 二叉搜索树中添加元素e
     *
     * @param e 元素
     */
    public void addV1(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            addV1(root, e);
        }
    }

    private void addV1(Node node, E e) {
        if (node.e.equals(e)) {
            throw new RuntimeException("当前二叉搜索树不支持重复元素!");
        }
        /*
         * 根据判断,递归到最深层终止
         */
        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
        } else if (e.compareTo(node.e) < 0 && node.left != null) {
            addV1(node.left, e);
        } else if (e.compareTo(node.e) > 0 && node.right != null) {
            addV1(node.right, e);
        }
    }

    /**
     * 二叉搜索树中添加元素e,对V1版本优化 处理逻辑统一
     *
     * @param e 元素
     */
    public void addV2(E e) {
        root = addV2(root, e);
    }

    private Node addV2(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = addV2(node.left, e);

        } else if (e.compareTo(node.e) > 0) {
            node.right = addV2(node.right, e);
        } else {
            throw new RuntimeException("当前二叉搜索树不支持重复元素!");
        }
        return node;
    }


    /**
     * 判断二叉搜索树中是否包含元素e
     *
     * @param e 元素e
     * @return
     */
    public boolean contains(E e) {

        return contains(root, e);

    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.equals(node.e)) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {// e.compareTo(node.e) > 0
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     *
     * @return
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历非递归实现
     *
     * @return
     */
    public void preOrderNR() {
        // 使用 java.util.Stack 来模拟系统栈
        Stack<Node> stack = new Stack<>();
        // 前序遍历所以先将根节点压入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 将当前要访问的节点出栈
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                // 由于栈的特性是后入先出，所以这里是右子树先入栈
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    /**
     * 中序遍历
     *
     * @return
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     *
     * @return
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历
     *
     * @return
     */
    public void levelOrder() {
        levelOrder(root);
    }

    private void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<>();
        // 根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            // 将当前要访问的节点出队
            Node cur = queue.remove();
            System.out.println(cur.e);

            // 左右节点入队
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 获取二分搜索树的最小元素
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }

        return minimum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最小元素所在节点
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }
    /**
     * 获取二分搜索树的最大元素
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty!");
        }
        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大元素所在节点
     */
    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 删除二分搜索树中的最大元素所在节点，并返回该元素
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            // 如果有左子树，需要将其挂到被删除的节点上
            Node leftNode = node.left;
            node.left = null;
            size--;

            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除二分搜索树中的最小元素所在节点，并返回该元素
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 删除以node为根的二分搜索树中的最小节点
     * 返回删除节点后新的二分搜索树的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            // 如果有右子树，需要将其挂到被删除的节点上
            Node rightNode = node.right;
            node.right = null;
            size--;

            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    /**
     * 从二分搜索树中删除元素为e的节点
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中值为e的节点，递归实现
     * 返回删除节点后新的二分搜索树的根
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            // 要删除的节点在左子树中
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            // 要删除的节点在右子树中
            node.right = remove(node.right, e);
            return node;
        }

        // 找到了要删除的节点
        // 待删除的节点左子树为空的情况
        if (node.left == null) {
            // 如果有右子树，需要将其挂到被删除的节点上
            Node rightNode = node.right;
            node.right = null;
            size--;

            return rightNode;
        }

        // 待删除的节点右子树为空的情况
        if (node.right == null) {
            // 如果有左子树，需要将其挂到被删除的节点上
            Node leftNode = node.left;
            node.left = null;
            size--;

            return leftNode;
        }

        // 待删除的节点左右子树均不为空的情况
        // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
        Node successor = minimum(node.right);
        // 用这个节点替换待删除节点的位置
        // 由于removeMin里已经维护过一次size了，所以这里就不需要维护一次了
        successor.right = removeMin(node.right);
        successor.left = node.left;
        return successor;
    }

}
