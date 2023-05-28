// 노드에는 각 데이터를 저장할 수 있는 정보와 다음 데이터를 가리킬수있는 넥스트가 필요하다.

import org.w3c.dom.NodeList;
import org.w3c.dom.ls.LSOutput;

public class LinkedList {

    static public class LinkedListClass{

//        list 클래스에는 노드 정보를 담고있어야한다.
//        노드 정보에는 현재 데이터 그리고 어디를 가리키고 있는지에 대한 정보와 다음 어디를 가르키고
//        있는지 head 에 대한 정보 필요

        private NodeInfo head =null;
        private NodeInfo tail =null;
        private int size =0;

        private class NodeInfo{

            private int data =0;
            private NodeInfo nextNode;

            private int ss = 10;
            //생성자 함수

            public NodeInfo(int data){
                this.data = data;
                this.nextNode = null;
            }

            @Override
            public String toString() {
                return String.valueOf(this.data);
            }
        }


        public void insertToFirstNode(int data){

          NodeInfo newNode = new NodeInfo(data);

          if(head == null) {
              head = newNode;
              tail = newNode;

          } else{

              newNode.nextNode = head;
              head = newNode;
          }

          size+=1;

        }

        public void insertToLastNode(int data){
            NodeInfo newNode = new NodeInfo(data);


            if(head == null){
                insertToFirstNode(data);
            }


            tail.nextNode = newNode;
            tail = newNode;

            size+=1;

        }


        public void insertToMiddle(int data, int index){

            NodeInfo newNode = new NodeInfo(data);

            NodeInfo searchingHead = head;


            if(head == null){
                insertToFirstNode(data);
            }

            while(index-1 > 0){

                searchingHead = searchingHead.nextNode;

                index--;

            }

            System.out.println("find index" +  searchingHead);


            NodeInfo temp2 = searchingHead.nextNode;

            searchingHead.nextNode = newNode;

            newNode.nextNode = temp2;



            if(newNode.nextNode == null) {
                tail = newNode;
            }
            size++;


        }

        public void findNode(int index){

            NodeInfo currHead = head;

            while(index != 0){

                currHead  = currHead.nextNode;

                index--;
            }

            System.out.println(currHead.data);


        }



        public void printList(){



            while(head != null){

                System.out.println(head.data);

                head = head.nextNode;
            }

        }




    }
    public static void main(String[] args) {

        //노드를 생성하고 생성한 노드를 하나씩 추가하여 연결한다.

        LinkedListClass linked = new LinkedListClass();

        linked.insertToFirstNode(10);
        linked.insertToFirstNode(20);
        linked.insertToFirstNode(30);
        linked.insertToLastNode(100);
        linked.insertToLastNode(1000);


//        linked.findNode(4);


        linked.insertToMiddle(5000,1);
        linked.insertToMiddle(50000,1);
        linked.insertToMiddle(500,2);

        linked.insertToMiddle(1000000,5);



        linked.printList();



    }


}
