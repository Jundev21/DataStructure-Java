



public class BinaryTree {


    static public class Node{
        int data = 0;

        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;

        }

    }

    static public class makeBinaryTree{

        static void preorder(Node root){

            if(root == null) return;

            System.out.println("start pre order "+ root.data);

            preorder(root.left);

            preorder(root.right);


        }

        static void inorder(Node root){


            if(root == null) return;


            inorder(root.left);

            System.out.println("inorder" + root.data);

            inorder(root.right);


        }

        static void postOrder(Node root){


            if(root == null) return;

            postOrder(root.left);

            postOrder(root.right);

            System.out.println("Post order" + root.data);
        }

    }

    public static void main(String[] args) {

        BinaryTree.Node rootNode = new Node(1);


        rootNode.left = new Node(2);

        rootNode.right = new Node(3);

        rootNode.left.left = new Node(4);

        rootNode.left.right = new Node(5);

        rootNode.right.left = new Node(6);

        rootNode.right.right = new Node(7);


//        makeBinaryTree.preorder(rootNode);


//          makeBinaryTree.preorder(rootNode);

          makeBinaryTree.postOrder(rootNode);



    }





}
