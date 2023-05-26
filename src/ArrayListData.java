
//import java.util.ArrayList;

// 비슷한 언어인 c / c++ 와는 다르게 Array List 라는 자료구조가있다.
// ArrayList 는 Array와 비슷하지만 데이터를 추가하거나 삭제할때 좀더 유용하다.
// Array 에서는 데이터를 중간에 넣을 수 없고 하나씩 차례대로 추가가된다. 인데스에 해당하는 데이터가 삭제가 되면 해당 자리는 공백이 된다.
// List 는 Array 에서 데이터를 추가하거나 삭제할때 불편한 사항들을 해결해준다.
// 데이터를 앞 / 뒤 / 또는 중간에 데이터를 삽입할 수 있고 데이터가 삭제되면 빈공백이 생기지않고 인덱스들이 하나씩 앞으로 당겨진다.


class ArrayList{

    private int[] originArr;
    private int arrSize = 0;
    private int listSize =0;

    ArrayList(int size){

        originArr = new int[size];

    }


    public void insert(int data){

        originArr[listSize]=data;

        listSize +=1;

    }

    public void addFirst (int data){

        add(0,data);
    }
    public void add(int whichIdx, int data){

                for(int j= listSize; j > whichIdx; j--){

                    originArr[j] = originArr[j-1];


                }

                originArr[whichIdx] = data;

        listSize+=1;



    }

    public void delete(){


    }

    public void print(){

        for(int curr : originArr){

            System.out.println(curr);
        }

    }

    public String toString(){

        return"Test";

    }

}


public class ArrayListData {

    public static void main(String[] args) {

        ArrayList list = new ArrayList(10);

//        list.add(0,10);
//        list.add(1,100);
//        list.add(1,1000);

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);


        list.add(1,100);

        list.add(3,300);

        list.addFirst(100000);

//        list.print();

    }
}
