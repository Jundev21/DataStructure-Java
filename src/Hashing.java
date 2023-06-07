

// 해쉬 / 해싱 이란
// 어떠한 값을 해시 함수에 넣었을때 유일한 값으로 변형 시켜주는것을 해싱라고한다.
// 넣은 값을 키(key) 값 유일한 값으로 변경된 값(value)이 키에대한 값 이다.
// 해싱은 이렇게 키와 벨류값으로 생성된다.
// 해싱을 활용한 자료구조는 해시 테이블이있다.
// 해시 벨류는 유일한 값을 갖지만 같은 벨류값이 나오는 경우가 있다. 이를 "충돌" 이라고한다.
// 충돌난 값은 2가지 방법으로 해결 할 수있다.
// 1. 충돌난 버킷에 여러 데이터를 연결해서 저장하는방법 (체이닝).
//      링크드리스트, 트리(Red-Black Tree)로 해결
// 2. 다른 버킷으로 데이터를 저장하여 한 버킷에는 하나의 데이터만 저장하는 방법(개방 주소법).
//      Linear Probing, Quadratic Probing 으로 해결
// 충돌을 보완하여 나온 해시 맵과 해시 셋 이 있는데 해시맵, 해시셋 둘다 Java Collection FrameWork API 이다.
// 해시맵은 해시 테이블에 비해서 추가적으로 해시함수를 사용하기때문에 해시테이블에 비해 충돌이 덜 발생한다.
// 자바 해시맵은 체이닝을 사용하는 방식인데 그 이유는 링크드 리스트를 사용하여 데이터를 추가 또는 삭제를 쉽게하기 위함이다.



//Hash-Map 은 키와 벨류값으로 hash table 과 동일하게 데이터가 저장되는데
//Hash-set 같은 경우는 객체 그대로 저장한다.


// set - map 차이점
// set 은 중복값을 허용하지않고 map 은 중복되는 키값을 허용하지않는다.
// map 은 반복문을 실행하기위해서 set 으로 변환후에 반복문을 사용할 수 있다.
// set 은 중복 자체 등록이안되고
// map 은 가장 마지막에 들어온 값이 들어간다.


// 기본 개념 map , set 차이점 알아보기
// hash table, hash map, hash set 의 정확한 차이점과 언제 어떨때 사용하는지?



import java.util.*;
public class Hashing {

    static void hashSet(String str){
        HashSet<Character> hashSet = new HashSet<Character>();

        // Set add() 부분에서 이미 데이터가 있을 경우에는 false 를 반환한다.
        for(int i=0; i< str.length(); i++){

            Character extractChar = str.charAt(i);

            if(hashSet.add(extractChar)){

                hashSet.add(extractChar);

            }
            else{
                System.out.println("Already has data");
            }
        }


//        Iterator charA = hashSet.iterator();
//
//        while( charA.hasNext()){
//            System.out.println(charA.next());
//        }

        System.out.println(hashSet);

    }

    static void hashMap(String str){

        HashMap<Integer,Character> hashMap = new HashMap<Integer, Character>();



        // hash 맵 데이터 추가 테스트
        for(int i=0; i<str.length(); i++){

            hashMap.put(i,str.charAt(i));

        }

        hashMap.put(4,'u');

        for(Map.Entry<Integer,Character> entry : hashMap.entrySet()){

           System.out.println("key =" + entry.getKey() + "value = " + entry.getValue());

       }





    }

    static void hashTable(String str){

        Hashtable<Integer,String> hashTable = new Hashtable<Integer,String>();

        hashTable.put(1,"first");
        hashTable.put(2,"second");
        hashTable.put(3,"third");
        hashTable.put(4,"fouth");

//        System.out.println(hashTable);

        Hashtable<Integer,String> hashTable2 = new Hashtable<Integer,String>();



        // clone method - 객체를 복제할때 사용.
        hashTable2 = (Hashtable<Integer,String>)hashTable.clone();

        hashTable.clear();
        System.out.println("copy hash" + hashTable2);
    }



    public static void main(String[] args) {

        String str = "hello";
//        hashMap(str);
//        hashSet(str);
          hashTable(str);

    }

}
