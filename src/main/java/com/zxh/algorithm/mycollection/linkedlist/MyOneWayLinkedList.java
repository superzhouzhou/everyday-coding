package com.zxh.algorithm.mycollection.linkedlist;

import java.util.Arrays;

/**
 * @author zhouxiaohui
 */
public class MyOneWayLinkedList <T>{

  int size;
  Node headNode;
  Node tailNode;
  int capactity;

  public MyOneWayLinkedList() {

  }

  public MyOneWayLinkedList(int capactity) {

    this.capactity = capactity;
  }

  public static void main(String[] args) {
    MyOneWayLinkedList myOneWayLinkedList = new MyOneWayLinkedList();
    myOneWayLinkedList.add(1);
    myOneWayLinkedList.add(2);
    myOneWayLinkedList.add(3);
    myOneWayLinkedList.add(4);
    System.out.println(myOneWayLinkedList.size);
    myOneWayLinkedList.print();
    System.out.println(myOneWayLinkedList.find(3));
    System.out.println(myOneWayLinkedList.find(5));
    System.out.println(myOneWayLinkedList.remove(10));
    System.out.println(myOneWayLinkedList.find(3));
    myOneWayLinkedList.print();
    myOneWayLinkedList.reverse();
    myOneWayLinkedList.print();
  }

  public boolean add(Object object) {
    if (capactity != 0 && size == capactity) {
      return false;
    }
    Node node = new Node(object);
    if (headNode == null) {
      headNode = node;
    } else if (tailNode == null) {
      tailNode = node;
      headNode.next = tailNode;
    } else {
      tailNode.next = node;
      tailNode = node;
    }
    ++size;
    return true;
  }

  public Object remove(Object object) {
    int count = size;
    if (count > 0 && headNode.t == object) {
      --count;
      headNode = null;
      return true;
    }
    Node pre = headNode;
    Node currentNode = pre.next;
    while (currentNode != null) {
      if (currentNode.t == object) {
        pre.next = currentNode.next;
        currentNode = null;
        --size;
        return true;
      }
      currentNode = currentNode.next;
    }
    return false;
  }

  public Object find(Object object) {
    int count = size;
    Node firstNode = headNode;
    while (count > 0) {
      if (firstNode.t == object) {
        return firstNode;
      }
      firstNode = firstNode.next;
      --count;
    }
    return null;
  }

  public int size() {
    return size;
  }

  public void print() {
    int temp = size;
    Node currentNode = headNode;
    Object[] array = new Object[size];
    while (temp > 0) {
      array[size - temp] = currentNode.t;
      --temp;
      currentNode = currentNode.next;
    }
    System.out.println(Arrays.toString(array));
  }

  public void reverse() {
    Object[] array = new Object[size];
    int index = size;
    Node currentNode = headNode;
    while (index > 0) {
      array[size - index] = currentNode;
      --index;
      currentNode = currentNode.next;
    }
    for (int i = size; i >1 ; i--) {
      ((Node)array[i-1]).next=((Node)array[i-2]);
    }
    headNode = (Node) array[size-1];
  }

  class Node<T> {
    T t;
    Node next = null;
    public Node(T t) {
      this.t = t;
    }
  }
}


