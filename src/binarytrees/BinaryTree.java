package binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree<E> {

    protected Node<E> root;

    protected void setRoot(Node<E> root) {
        this.root = root;
    }

    public void clear() {
        root = null;
    }

    public int height() {
        return height(root);
    }

    protected int height(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int leaves() {
        return leaves(root);
    }

    protected int leaves(Node<E> node) {
        if (node == null) {
            return 0;
        } else if (node.hasNoChildren()) {
            return 1;
        } else {
            return leaves(node.getLeft()) + leaves(node.getRight());
        }
    }

    public int size() {
        return size(root);
    }

    protected int size(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.getLeft()) + size(node.getRight());
        }
    }

    public List<E> preorder() {
        ArrayList<E> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    protected void preorder(Node<E> node, List<E> list) {
        if (node != null) {
            list.add(node.getValue());
            preorder(node.getLeft(), list);
            preorder(node.getRight(), list);
        }
    }

    public List<E> inorder() {
        ArrayList<E> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    protected void inorder(Node<E> node, List<E> list) {
        if (node != null) {
            inorder(node.getLeft(), list);
            list.add(node.getValue());
            inorder(node.getRight(), list);
        }
    }

    public List<E> postorder() {
        ArrayList<E> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    protected void postorder(Node<E> node, List<E> list) {
        if (node != null) {
            postorder(node.getLeft(), list);
            postorder(node.getRight(), list);
            list.add(node.getValue());
        }
    }

    public List<E> levelOrder() {
        ArrayList<E> list = new ArrayList<>();
        LinkedList<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (node != null) {
                list.add(node.getValue());
                queue.offer(node.getLeft());
                queue.offer(node.getRight());
            }
        }
        return list;
    }

    private static int _i;

    public static <E> BinaryTree<E> fromPreorder(List<E> preorder, List<E> inorder) {
        _i = 0;
        BinaryTree<E> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(nodeFromPreorder(preorder, inorder));
        return binaryTree;
    }

    protected static <E> Node<E> nodeFromPreorder(List<E> preorder, List<E> inorder) {
        if (inorder.isEmpty()) {
            return null;
        } else {
            Node<E> node = new Node<>(preorder.get(_i++));
            int i = inorder.indexOf(node.getValue());
            node.setLeft(nodeFromPreorder(preorder, inorder.subList(0, i)));
            node.setRight(nodeFromPreorder(preorder, inorder.subList(i + 1, inorder.size())));
            return node;
        }
    }

    public static <E> BinaryTree<E> fromPostorder(List<E> postorder, List<E> inorder) {
        _i = postorder.size() - 1;
        BinaryTree<E> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(nodeFromPostorder(postorder, inorder));
        return binaryTree;
    }

    protected static <E> Node<E> nodeFromPostorder(List<E> postorder, List<E> inorder) {
        if (inorder.isEmpty()) {
            return null;
        } else {
            Node<E> node = new Node<>(postorder.get(_i--));
            int i = inorder.indexOf(node.getValue());
            node.setRight(nodeFromPostorder(postorder, inorder.subList(i + 1, inorder.size())));
            node.setLeft(nodeFromPostorder(postorder, inorder.subList(0, i)));
            return node;
        }
    }
}
