
// 바이너리 서치 트리는 기존의 이진트리와 링크드 리스트의 장점을 갖고 나온 자료구조다
// 이진트리의 장점은 한 노드에 두개의 자식들로 연결되어있어 탐색에서 OlogN 을 보여주지만
// 단점으로 노드를 삭제 추가 는 없다.
// 링크드 리스트의 장점은 노드들끼리 연결되어있기때문에 데이터를 추가하거나 삭제하는데 o(1) 으로 빠르다
// 하지만 단점으로는 데이터가 다 연결되어있는 선형자료구조 이기때문에 데이터를 탐색하는데는 오래걸린다.
// 이러한 장점들을모아 데이터를 추가하는데 빠르면서, 탐색에도 효율적인 자료구조를 만들기 위해 나왔다.

// 바이너리 서치 트리에는 규칙이있는데 루트를 기준으로 왼쪽 자식은 루트보다 작은값 오른쪽은 큰값이 배치된다.


import java.util.Optional;

public class BinarySearchTree {

    static public class BST {

        NodeInfo currRootNode = null;

        static public class NodeInfo {
            int data = 0;
            NodeInfo left;
            NodeInfo right;

            NodeInfo(int data) {
                this.data = data;
                left = null;
                right = null;
            }

        }


        public void inorder(NodeInfo currRootNode) {

            if (currRootNode == null) return;

            inorder(currRootNode.left);
            System.out.println(currRootNode.data);
            inorder(currRootNode.right);
        }


        public void search(NodeInfo currNode, int data) {


        }

        public NodeInfo insert(NodeInfo currRootNode, int data) {

            if (currRootNode == null) {
                currRootNode = new NodeInfo(data);
            } else if (data <= currRootNode.data) {
                currRootNode.left = insert(currRootNode.left, data);
            } else {
                currRootNode.right = insert(currRootNode.right, data);
            }


            return currRootNode;
        }


        //해당 노드가 있는지 없는지 탐색하기
        public NodeInfo searchingNode(NodeInfo targetNode, int data) {

            if (targetNode.data < data) {
                return searchingNode(targetNode.right, data);
            } else if (targetNode.data > data) {
                return searchingNode(targetNode.left, data);
            } else {
                return targetNode;
            }

        }
        // 바이너리 트리에서 삭제는 크게 두가지 종류가있다.
        // 자식 노드가 없는 부모노드가 삭제 될때,
        // 자식 노드가 있는 부모가 삭제될때 가있다.
        // 첫번째로 자식노드가 없는 부모노드가 삭제되면 연결을 그냥 끊으면된다.
        // 둘째로 자식노드가 있는 부모노드가 삭제되는건데,
        // 부모 노드가 삭제되면 자식노드중 하나가 부모노드로 교체되어야한다.
        // 바이너리 서치트리는 부모노드 기준에서 왼쪽이 작은수 오른쪽이 큰수이기때문에
        // 왼쪽에서 가장 큰 노드거나 또는 오른쪽에서 가장 작은 노드가 대체되어야한다.

        public NodeInfo deletion(NodeInfo currNode, int data) {


            System.out.println("CurrNode Data" + currNode.data);


            if (currNode.data < data) {

                System.out.println("Right Node " + currNode.right.data);
                currNode.right = deletion(currNode.right, data);

            } else if (currNode.data > data) {

                currNode.left =  deletion(currNode.left, data);
               System.out.println("Left Node" + currNode.left.data);

            } else {

                //  한쪽 자식이 없거나 양쪽 자식 둘다 없는경우
                if(currNode.left == null){
                    System.out.println("Find Right Node" + currNode.left.data);
                    return currNode.right;

                } else if( currNode.right == null){
                    System.out.println("Find left Node" + currNode.left.data);
                    return currNode.left;
                }

                // 양쪽 자식이 둘다 있을경우 왼쪽노드의 최대값 / 오른쪽 노드의 최솟값
                // 보통 왼쪽 최대값으로 찾음


                int minData = 0;

               while(currNode.left.right != null){
                   minData = currNode.left.right.data;
                   currNode = currNode.left;
               }

               currNode.data = minData;

               currNode.left = deletion(currNode.left,data);


            }

            System.out.println(currNode.data);

            return currNode;

        }




    }




    public static void main(String[] args) {

        BST linkedList = new BST();


        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,50);
        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,30);
        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,40);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,20);
        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,25);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,10);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,5);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,6);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,4);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,70);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,60);


        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,80);

//        linkedList.inorder(linkedList.currRootNode);

//        BST.NodeInfo isFind = linkedList.searchingNode(linkedList.currRootNode, 100);


        linkedList.currRootNode = linkedList.deletion(linkedList.currRootNode, 20);


        System.out.println("after delete node");
        linkedList.inorder(linkedList.currRootNode);



    }


}
