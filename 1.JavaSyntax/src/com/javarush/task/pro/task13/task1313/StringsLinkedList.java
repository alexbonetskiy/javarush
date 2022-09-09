package com.javarush.task.pro.task13.task1313;

import java.util.ArrayList;

public class StringsLinkedList {
    private Node first = new Node(null, null, null);
    private Node last = new Node(null, null, null);
    private ArrayList<Node> arr = new ArrayList<>();
    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        //напишите тут ваш код
        if (arr.size() == 0){
        Node newNode = new Node(first, value, last);
        arr.add(newNode);
        first.next = newNode;
        last.prev = newNode;}
        else {
         Node lastNode = arr.get(arr.size()-1);
         Node newNode = new Node(arr.get(arr.size()-1), value, last);
         arr.add(newNode);
         last.prev = newNode;
         lastNode.next = newNode;
        }


    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;

        public Node(Node prev, String value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;

        }
    }
}
