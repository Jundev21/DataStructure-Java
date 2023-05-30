public class QueueList {


    Node head;
    Node tail;

    int size =0;


    static public class Node{

        int data =0;
        Node nextNode = null;

        Node(int data){
            this.data = data;
            this.nextNode = null;
        }


    }


    public void enqueue(int data){

        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
            tail = newNode;
        }else{

            tail.nextNode = newNode;
            tail = newNode;

        }




        size+=1;


    }


    public void dequeue(){

        Node tempNode = head.nextNode;

        head = null;

        head = tempNode;




    }

    public void display(){

        while(head != null){

            System.out.println(head.data);

            head = head.nextNode;

        }

    }






    public static void main(String[] args) {

        QueueList queue = new QueueList();

        queue.enqueue(1);

        queue.enqueue(2);

        queue.enqueue(3);

        queue.enqueue(4);

        queue.enqueue(5);

        queue.dequeue();

        queue.enqueue(6);

        queue.dequeue();


        queue.display();



    }
}
