
//트리는 그래프의 한 종류로, 다음과 같은 특징을 가지고 있습니다:
//        사이클이 없는 연결 그래프: 트리는 사이클(cycle)이 존재하지 않는 연결 그래프입니다. 따라서 어떤 두 정점을 선택해도 정확히 하나의 경로만으로 연결되어 있습니다.
//        단일 연결성: 트리는 한 정점에서 다른 정점으로 가는 경로가 유일합니다. 즉, 어떤 두 정점을 선택하더라도 그들을 연결하는 경로는 유일합니다.
//        계층 구조: 트리는 계층 구조(hierarchical structure)를 가집니다. 트리의 최상위 정점을 루트(root)라고 하고, 루트에서 다른 정점들로 내려가는 경로를 따라 트리의 정점들은 계층적으로 구성됩니다.
//        트리는 이러한 특징으로 인해 그래프의 일종으로 분류됩니다. 그러나 일반적인 그래프와는 다르게 특별한 제약 조건을 가지고 있어 계층 구조를 표현하거나 계층적인 데이터를 표현하는 데 유용합니다. 트리는 컴퓨터 과학에서 다양한 분야에서 활발하게 활용되며, 예를 들어 파일 시스템, 데이터베이스 인덱스, 알고리즘 등에서 사용됩니다.

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
