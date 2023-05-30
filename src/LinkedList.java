// 노드에는 각 데이터를 저장할 수 있는 정보와 다음 데이터를 가리킬수있는 넥스트가 필요하다.
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.LSOutput;




// 링크드 리스트 와 어레이 리스트의 차이점.

// 링크드 리스트와 어레이 리스트의 공통점 부터 보자면 선형주조로 되어있는 자료구조이며 배열 과는 다르게 데이터를 중간에 추가하거나 삭제가 가능하다.

// 차이점을보자면 링크드 리스트는 각 데이터의 주소들로 연결되어있어 데이터를 추가 삭제할때 빠르고 편리하다는 장점이있다

// 반면에 링크드 리스트는 데이터 추가 삭제가 가능은 하지만 배열을 기반으로 만들어져있어 링크드 리스트에 비해서는 비효율적이지만

// 데이터를 찾을때는 인덱스를 통해서 찾을 수 있기 때문에 이부분에서는 링크드 리스트 에 비해 빠르다.


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
