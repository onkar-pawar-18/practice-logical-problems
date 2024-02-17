public class BinaryTree {

    TreeNode root;

    public void insertNode(int data) {
        TreeNode node = new TreeNode(data, null, null);
        if (this.root == null) {
            this.root = node;
        } else {
            TreeNode p = null;
            TreeNode q = this.root;
            while (q != null) {
                p = q;
                if (data < q.data) {
                    q = q.left;
                } else {
                    q = q.right;
                }
            }
            if (data < p.data) {
                p.left = node;
            } else {
                p.right = node;
            }
        }
    }

    public void traverseInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.printf("%d->", node.data);
        traverseInOrder(node.left);
        traverseInOrder(node.right);
    }

    public void traversePreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        traversePreOrder(node.left);
        System.out.printf("%d->", node.data);
        traversePreOrder(node.right);
    }
    public void traversePostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        System.out.printf("%d->", node.data);
    }
}

class TreeNode {
    public TreeNode() {}

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    int data;
    TreeNode left;
    TreeNode right;
}