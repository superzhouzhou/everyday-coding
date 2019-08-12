package com.zxh.algorithm.mycollection.linkedlist;

/**
 * @author zhouxiaohui
 */
public class MyTwoWayLinkedList<T> {

  private int size;
  private Node headNode;
  private Node tailNode;
  private int capacity;

  public MyTwoWayLinkedList(int capacity) {
    this.capacity = capacity;
  }

  public MyTwoWayLinkedList() {
  }

  public static void main(String[] args) {
    MyTwoWayLinkedList<Integer> linkedList = new MyTwoWayLinkedList<Integer>();
    linkedList.add(1);
    linkedList.add(2);
    linkedList.add(3);
    linkedList.print();

  }

  public boolean add(T t) {
    if (size <= capacity && capacity > 0) {
      if (size > 0) {
        Node<T> newNode = new Node<T>(t, tailNode, null);
        tailNode.next = newNode;
        tailNode = newNode;
      } else {
        headNode = tailNode;
        headNode = new Node(t, null, null);
      }
      ++size;
      return true;
    }
    return false;
  }

  public int size() {
    return size;
  }

  public String print() {
    StringBuffer sb = new StringBuffer();
    int count = size;
    Node temp = headNode;
    while (count > 0) {
      sb.append(temp.t);
      temp = temp.next;
      count--;
    }
    System.out.println(sb.toString());
    return sb.toString();
  }

  class Node<T> {

    T t;
    Node prev;
    Node next;

    public Node(T t, Node prev, Node next) {
      this.t = t;
      this.prev = prev;
      this.next = next;
    }

  }


}
