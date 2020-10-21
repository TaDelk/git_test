class BinarySearchTree {

    class Node {
        int key;
        Node left, right;

        public Node( int item) {
            key = item;
            left = right = null;
        }
    }
    // root of BST
    Node root;

    // constructor
    BinarySearchTree() {
        root = null;
    }

    public Node search(Node root, int key) {

        if (root==null || root.key==key)
            return root;

        if (root.key > key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node ( key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        }else if ( key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // return the unchanged pointer
        return root;
    }

     /* Given a binary tree, print its nodes according to the 
      "bottom-up" postorder traversal. */
      void printPostorder(Node node) 
      { 
          if (node == null) 
              return; 
    
          // first recur on left subtree 
          printPostorder(node.left); 
    
          // then recur on right subtree 
          printPostorder(node.right); 
    
          // now deal with the node 
          System.out.print(node.key + " "); 
      } 
    
      /* Given a binary tree, print its nodes in inorder*/
      void printInorder(Node node) 
      { 
          if (node == null) 
              return; 
    
          /* first recur on left child */
          printInorder(node.left); 
    
          /* then print the data of node */
          System.out.print(node.key + " "); 
    
          /* now recur on right child */
          printInorder(node.right); 
      } 
    
      /* Given a binary tree, print its nodes in preorder*/
      void printPreorder(Node node) 
      { 
          if (node == null) 
              return; 
    
          /* first print data of node */
          System.out.print(node.key + " "); 
    
          /* then recur on left sutree */
          printPreorder(node.left); 
    
          /* now recur on right subtree */
          printPreorder(node.right); 
      } 
    
      // Wrappers over above recursive functions 
      void printPostorder()  {     printPostorder(root);  } 
      void printInorder()    {     printInorder(root);   } 
      void printPreorder()   {     printPreorder(root);  } 
    
    void delete (int key) {
        deleteRec(root, key);
    }

    Node deleteRec(Node root, int key) {
        if (root == null ) return root;

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        }else if (key < root.key) {
            root.right = deleteRec(root.right, key);
        }else {
            if (root.left ==null ) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            }

            root.key = minValue (root.right);

            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(100);
        tree.insert(50);
        tree.insert(3);
        tree.insert(1);
        tree.insert(80);
        tree.insert(52);
        tree.insert(90);
        tree.insert(83);
        tree.insert(99);
        tree.insert(20);
        tree.insert(150);
        tree.insert(125);
        tree.insert(152);

        System.out.println("Inorder");
        tree.printInorder();
        System.out.println("Postorder");
        tree.printPostorder();
        System.out.println("Preorder");
        tree.printPreorder();

    }

}