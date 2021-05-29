package lesson4;

import lesson3.queue.DequeImpl;

import java.util.ArrayList;
import java.util.List;


public class TestMain4 {

    public static void main(String[] args) {
//        testLinkedList();
        //testForEach();
        testDeque();
    }

    private static void testDeque() {
        LinkedDequeImpl<Integer> dq = new LinkedDequeImpl<>();

        dq.insertRight(1);
        dq.insertRight(2);
        dq.insertRight(3);
        dq.insertRight(4);
        System.out.println(dq);
        System.out.println(dq.removeRight());
        System.out.println(dq);
        dq.insertLeft(4);
        System.out.println(dq);
        System.out.println(dq.peekLeft());
        System.out.println(dq.peekRight());
        System.out.println(dq.removeLeft());
        System.out.println(dq);
    }

    private static void testLinkedList() {
//        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertLast(5);
//
        linkedList.display();
//
        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));
//
        linkedList.removeFirst();
        linkedList.remove(2);

        linkedList.display();
    }

    private static void testForEach() {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        for (int i = 0; i < arrayList.size(); i++) {
            int value = arrayList.get(i);
        }

//        LinkedList<Integer> linkedListJava = new LinkedList<>();
//        linkedListJava.addFirst(1);
//        linkedListJava.addFirst(2);
//        linkedListJava.addLast(3);
//        linkedListJava.addLast(4);

//        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();
//        linkedList.insertFirst(1);
//        linkedList.insertFirst(2);
//        linkedList.insertFirst(3);
//        linkedList.insertFirst(4);
//
//        LinkedList.Node<Integer> currentNode = linkedList.firstElement;
//        while (currentNode != null) {
//            int value = currentNode.item;
//            currentNode = currentNode.next;
//        }


        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
//
//        System.out.println("----");
//
            /*
            Iterator<Integer> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                Integer value = iterator.next();
                System.out.println(value);
            }

             */
//


        LinkedList<Integer> linkedList = new SimpleLinkedListImpl<>();
        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);

        linkedList.display();

        for (Integer value : linkedList) {
            System.out.println(value);
        }
    }
}

