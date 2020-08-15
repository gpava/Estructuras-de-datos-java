package binarytrees;

public class BST<E extends Comparable<E>> extends BinaryTree<E> {

    public void add(E e) {
        root = add(e, root);
    }

    protected Node<E> add(E e, Node<E> node) {
        if (node == null) {
            return new Node<>(e);
        }
        int cmp = e.compareTo(node.getValue());
        if (cmp < 0) {
            node.setLeft(add(e, node.getLeft()));
        } else if (cmp > 0) {
            node.setRight(add(e, node.getRight()));
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(e, root);
    }

    protected boolean contains(E e, Node<E> node) {
        if (node == null) {
            return false;
        }
        int cmp = e.compareTo(node.getValue());
        if (cmp == 0) {  // Assuming (x.compareTo(y)==0) == (x.equals(y)).
            return true;
        } else if (cmp < 0) {
            return contains(e, node.getLeft());
        } else {
            return contains(e, node.getRight());
        }
    }

    public void remove(E e) {
        root = remove(e, root);
    }

    protected Node<E> remove(E e, Node<E> node) {
        if (node == null) {
            return null;
        }
        int cmp = e.compareTo(node.getValue());
        if (cmp == 0) {  // Assuming (x.compareTo(y)==0) == (x.equals(y)).
            if (!node.hasLeft()) {
                return node.getRight();
            } else if (!node.hasRight()) {
                return node.getLeft();
            } else {
                node.setValue(max(node.getLeft()));
                node.setLeft(remove(node.getValue(), node.getLeft()));
            }
        } else if (cmp < 0) {
            node.setLeft(remove(e, node.getLeft()));
        } else {
            node.setRight(remove(e, node.getRight()));
        }
        return node;
    }

    protected E min(Node<E> node) {
        while (node.hasLeft()) {
            node = node.getLeft();
        }
        return node.getValue();
    }

    protected E max(Node<E> node) {
        while (node.hasRight()) {
            node = node.getRight();
        }
        return node.getValue();
    }
}
