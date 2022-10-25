public class MyBST {
    private BSTNode root;

    private class BSTNode {
        Integer val;
        BSTNode left, right;

        public BSTNode(Integer val) {
            this.val = val;
            left = right = null;
        }

        @Override
        public String toString() {return "" + this.val;}
    }

    public int size() {
        return sizeHelper(root);
    }
    public int sizeHelper(BSTNode node) {
        if (node == null)
            return 0;
        else
            return(sizeHelper(node.left) + 1 + sizeHelper(node.right));
    }

    public void insert(Integer n) {
        if (root == null) {
            root = new BSTNode(n);
        }
        insert(root, n);
    }


    public void insert(BSTNode reference, Integer n) {
        BSTNode ref = reference;

        if (ref.val == 0) {
            ref.val = n;
        }

        if (n > ref.val) {
            if (ref.right == null) {
                ref.right = new BSTNode(n);
                return;
            }
            insert(ref.right, n);

        } else {
            if (ref.left == null) {
                ref.left = new BSTNode(n);
                return;
            }
            insert(ref.left, n);
        }
    }

    public boolean contains (Integer n) {
        if (root == null) {
            return false;
        }
        return contains(root, n);
    }

    public boolean contains (BSTNode reference, Integer n) {
        BSTNode ref = reference;

        if (n == ref.val) {
            return true;
        }
        else if (n > ref.val) {
            contains(ref.right, n);

        } else {
            contains(ref.left, n);
        }
        return false;

    }

    public Integer getMax() {
        return getMax(root);
    }

    public Integer getMax(BSTNode node) {
        if (node.right == null) {
            return node.val;
        } else {
            return getMax(node.right);
        }
    }

    public Integer getMin() {
        return getMin(root);
    }

    public Integer getMin(BSTNode node) {
        if (node.left == null) {
            return node.val;
        } else {
            return getMin(node.left);
        }
    }

    public void delete (Integer n, BSTNode node) {
        BSTNode ref = node;

        if (n == ref.val) {
            ref.val = null;
        }
        else if (n > ref.val) {
            delete(n, ref.right);

        } else {
            delete(n, ref.left);
        }
    }


    public void delete (Integer n) {
        delete(n, root);
    }



    public void print(BSTNode node) {
        BSTNode ref = node;
        if (ref == null) {
            return;
        }

        System.out.println(ref.val);

        print(ref.left);
        print(ref.right);

    }
    public void print() {
        print(root);
    }


}


