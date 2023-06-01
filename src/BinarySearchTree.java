
// 바이너리 서치 트리는 기존의 이진트리와 링크드 리스트의 장점을 갖고 나온 자료구조다
// 이진트리의 장점은 한 노드에 두개의 자식들로 연결되어있어 탐색에서 OlogN 을 보여주지만
// 단점으로 노드를 삭제 추가 는 없다.
// 링크드 리스트의 장점은 노드들끼리 연결되어있기때문에 데이터를 추가하거나 삭제하는데 o(1) 으로 빠르다
// 하지만 단점으로는 데이터가 다 연결되어있는 선형자료구조 이기때문에 데이터를 탐색하는데는 오래걸린다.
// 이러한 장점들을모아 데이터를 추가하는데 빠르면서, 탐색에도 효율적인 자료구조를 만들기 위해 나왔다.

// 바이너리 서치 트리에는 규칙이있는데 루트를 기준으로 왼쪽 자식은 루트보다 작은값 오른쪽은 큰값이 배치된다.


public class BinarySearchTree {

    static public class BST{

        NodeInfo currRootNode = null;

        static public class NodeInfo {
            int data = 0;
            NodeInfo left;
            NodeInfo right;
            NodeInfo(int data){
                this.data = data;
                left = null;
                right = null;
            }

        }


        public void inorder(NodeInfo currRootNode){

            if(currRootNode == null) return;

            inorder(currRootNode.left);
            System.out.println(currRootNode.data);
            inorder(currRootNode.right);
        }


        public void search(NodeInfo currNode, int data){




        }

        public NodeInfo insert(NodeInfo currRootNode, int data){



            if( currRootNode == null){
                currRootNode = new NodeInfo(data);
            } else if( data <= currRootNode.data){
                currRootNode.left = insert(currRootNode.left,data);
            } else {
                currRootNode.right = insert(currRootNode.right,data);
            }


            return currRootNode;
        }

        public void delete(){






        }





    }


    public static void main(String[] args) {

        BST linkedList = new BST();


        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,50);
        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,30);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,20);
        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,20);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,70);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,60);

        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,80);


        linkedList.currRootNode = linkedList.insert(linkedList.currRootNode ,80);


        linkedList.inorder(linkedList.currRootNode);

    }


}
