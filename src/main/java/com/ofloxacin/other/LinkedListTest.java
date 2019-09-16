package com.ofloxacin.other;

/**
 * @author chens
 * @date 2019/5/10 16:02
 */
public class LinkedListTest {

    private static Node head;

    private static Node tail;

    public static void main(String[] args) {
        LinkedListTest listTest = new LinkedListTest();
        listTest.add(new Node("S1"));
        listTest.add(new Node("S2"));
        listTest.add(new Node("S3"));
        listTest.print();
        listTest.count();
        listTest.insert(0, new Node("S0"));
    }

    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.getValue());
            cur = cur.getNext();
        }
    }

    public void count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
    }

    public void add(Node node) {
        if (head == null) {
            head = node;
        } else {

        }
    }

    public void insert(Node current, Node node) {

    }

    public void insert(int current, Node node) {
        Node n = get(current);
        if (n == head) {
            head = node;
            node.setNext(n);
            n.setPre(node);
            return;
        }
        n.getPre().setNext(node);
        node.setNext(n);
        n.setPre(node);
    }

    public void remove(int index) {
        Node n = get(index);
    }

    public void remove(Node node) {

    }

    public Node get(int i) {
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node current = head;
        while (current != null && count != i) {
            count++;
            current = current.getNext();
        }
        return current;
    }
}
