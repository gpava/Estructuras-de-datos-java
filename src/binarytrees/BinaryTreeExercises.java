package binarytrees;

public class BinaryTreeExercises<E> extends BinaryTree<E> {

    public int nodesBelowLevel(int level) {
        return nodesBelowLevel(level, root);
    }

    protected int nodesBelowLevel(int level, Node<E> node) {
        if (node == null) {
            return 0;
        } else if (level == 0) {
            return size(node.getLeft()) + size(node.getRight());
        } else {
            return nodesBelowLevel(level - 1, node.getLeft()) + nodesBelowLevel(level - 1, node.getRight());
        }
    }

    protected class Branch {

        Node<Integer> leaf;
        int sum;

        Branch(Node<Integer> leaf, int sum) {
            this.leaf = leaf;
            this.sum = sum;
        }
    }

    public int leastBranchLeafValue() {
        return leastBranchLeafValue((Node<Integer>) root, 0).leaf.getValue();
    }

    protected Branch leastBranchLeafValue(Node<Integer> node, int sum) {
        if (node.hasNoChildren()) {
            return new Branch(node, sum + node.getValue());
        } else {
            Branch leftBranch = leastBranchLeafValue(node.getLeft(), sum + node.getValue());
            Branch rightBranch = leastBranchLeafValue(node.getRight(), sum + node.getValue());
            return (rightBranch == null || (leftBranch != null && leftBranch.sum < rightBranch.sum)) ? leftBranch : rightBranch;
        }
    }
}
