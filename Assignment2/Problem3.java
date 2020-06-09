/**************************************************************
 Purpose/Description: Simple operations on binary search trees
 Author’s Panther ID: 3022407
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person. I used stackoverflow, class Textbook for help.
 **************************************************************/


public class Problem3 {

    public static void main(String[] args) {

        // create new tree
        BinarySearchTree bt = new BinarySearchTree();

        // add number
        bt.insert(1);
        bt.insert(2);
        bt.insert(3);
        bt.insert(4);
        bt.insert(5);


        // print the tree
        System.out.println("\nTree: ");
        bt.printTree();

        // get the total sum of tree
        int sum = bt.keySum();
        System.out.println("\n\nSum is: " + sum);

        // delete the smallest number node
        System.out.println("\nDelete smallest");
        bt.deleteMin();
        bt.printTree();

        // print the tree in postOrder
        System.out.println("\n\nPostOrder");
        bt.printPostOrder();

    }


    public static class BinarySearchTree
    {
        // inner class
        public class BinarySearchTreeNode
        {
            public int key;
            public BinarySearchTreeNode left;
            public BinarySearchTreeNode right;

            BinarySearchTreeNode(int key) {
                this.key = key;
                this.left = null;
                this.right = null;
            }

        }

        // root node
        public BinarySearchTreeNode root;

        // add nodes to the tree
        public void insert(int key) {
            // call helper method
            root = addRecursive(root, key);
        }

        // helper method
        private BinarySearchTreeNode addRecursive(BinarySearchTreeNode current, int key) {
            if (current == null) {
                return new BinarySearchTreeNode(key);
            }
            //if the new node's value is lower than the current node's, we go to the left child
            if (key < current.key) {
                current.left = addRecursive(current.left, key);
            } else if (key > current.key) {
                //if the new node's value is greater than the current node's, we go to the right child
                current.right = addRecursive(current.right, key);
            } else {
                // value already exists
                return current;
            }

            return current;
        }

        // a) returns the sum of all the keys in the tree
        public int keySum() {
            // call helper method
            return keySumHelper(root);

        }

        int sum = 0;
        public int keySumHelper(BinarySearchTreeNode node) {
            if (node != null) {
                // recursive calls
                keySumHelper(node.left);
                // add key value to our sum variable
                sum += node.key;
                keySumHelper(node.right);
            }
            return sum;
        }

        // b) deletes the minimum element in the tree
        public void deleteMin() {

            // get the value of smallest node
            int min = findMin(root);
            // start at the root pass in the smallest value
            root = deleteRecursive(root, min);
        }

        // find the smallest number node
        public int findMin(BinarySearchTreeNode root) {
            return root.left == null ? root.key : findMin(root.left);
        }

        public BinarySearchTreeNode deleteRecursive(BinarySearchTreeNode node, int key) {
            if (node == null) {
                return null;
            }

            if (key == node.key) {
                // Node to delete found
                // if node is a leaf
                if (node.left == null && node.right == null) {
                    return null;
                }
                // node has one child
                if (node.right == null) {
                    return node.left;
                }

                if (node.left == null) {
                    return node.right;
                }
                // node has two children
                int smallestValue = findMin(node.right);
                node.key = smallestValue;
                node.right = deleteRecursive(node.right, smallestValue);
                return node;
            }
            if (key < node.key) {
                node.left = deleteRecursive(node.left, key);
                return node;
            }
            node.right = deleteRecursive(node.right, key);
            return node;
        }

        // c) print tree
        public void printTree() {
            // start at root node
            traverseInOrder(root);
        }

        public void traverseInOrder(BinarySearchTreeNode node) {
            if (node != null) {
                traverseInOrder(node.left);
                System.out.print(" " + node.key);
                traverseInOrder(node.right);
            }
        }

        // d) print tree in postOrder
        public void printPostOrder() {

            traversePostOrder(getMin(root));
        }

        // find the smallest number node
        public BinarySearchTreeNode getMin(BinarySearchTreeNode root) {
            return root.left == null ? root : getMin(root.left);
        }

        public void traversePostOrder(BinarySearchTreeNode node) {
            if (node != null) {
                traversePostOrder(node.left);
                traversePostOrder(node.right);
                System.out.print(" " + node.key);
            }
        }









    }
}
