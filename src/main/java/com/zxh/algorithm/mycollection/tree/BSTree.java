package com.zxh.algorithm.mycollection.tree;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;

/**
 * @author zhouxiaohui
 */
public class BSTree<T extends Comparable<T>> {

  private BSTreeNode<T> root;

  /**
   * 新增节点
   */
  public void insert(T key) {
    BSTreeNode<T> tbsTreeNode = new BSTreeNode<>(key, null, null, null);
    if (tbsTreeNode != null) {
      this.insert(this, tbsTreeNode);
    }
  }

  private void insert(BSTree<T> tbsTree, BSTreeNode<T> z) {
    //BSTreeNode<T> root = tbsTree.root;
    BSTreeNode a = tbsTree.root;
    BSTreeNode b = null;
    while (a != null) {
      b = a;
      int cmp = z.key.compareTo((T) a.key);
      if (cmp < 0) {
        a = a.left;
      } else {
        a = a.right;
      }
    }
    z.parent = b;
    if (b == null) {
      tbsTree.root = z;
    } else {
      int cmp = z.key.compareTo((T) b.key);
      if (cmp < 0) {
        b.left = z;
      } else {
        b.right = z;
      }
    }

  }

  private BSTreeNode find(T t) {
    BSTreeNode<T> tmp = root;
    while (tmp != null) {
      int cmp = t.compareTo(tmp.key);
      if (cmp < 0) {
        tmp = tmp.left;
      } else if (cmp > 0) {
        tmp = tmp.right;
      } else {
        return tmp;
      }
    }
    return null;
  }

  public void delete(T t) {
    BSTreeNode<T> delNode = this.root;
    BSTreeNode<T> parentDelNode = null;


    while (delNode != null && delNode.key != t) {
      parentDelNode = delNode;
      if (delNode.left!=null && t.compareTo(delNode.left.key) < 0) {
        delNode = delNode.left;
      } else {
        delNode = delNode.right;
      }
    }
    if (delNode == null) return;

    if (delNode.left !=null && delNode.right != null) {
      BSTreeNode<T> minChild = delNode.left;
      BSTreeNode<T> minChildParent = delNode;
      while (delNode.left != null) {
        minChild = delNode.left;
        minChildParent = delNode;
      }
      delNode.key = minChild.key;
      delNode = minChild;
      parentDelNode = minChildParent;
    }
    //BSTreeNode<T> delNode;
    BSTreeNode child;
    if (delNode.left != null) {
      child = delNode.left;
    } else if (delNode.right != null) {
      child = delNode.right;
    } else {
      child = null;
    }

    if (parentDelNode == null) {
      root = child;
    } else if (parentDelNode.left == delNode) {
      parentDelNode.left = child;
    } else {
      parentDelNode.right = child;
    }


  }

  public void preOrder(BSTree bsTree) {
    preOrder(bsTree.root);
  }

  public void preOrder(BSTreeNode bsTreeNode) {
    if (bsTreeNode != null) {
      System.out.print(bsTreeNode.key + ",");
      preOrder(bsTreeNode.left);
      preOrder(bsTreeNode.right);
    }
  }

  public void inOrder(BSTree bsTree) {
    inOrder(bsTree.root);
  }

  public void inOrder(BSTreeNode bsTreeNode) {
    if (bsTreeNode != null) {
      inOrder(bsTreeNode.left);
      System.out.print(bsTreeNode.key + ",");
      inOrder(bsTreeNode.right);
    }
  }

  public void postOrder(BSTree bsTree) {
    postOrder(bsTree.root);
  }

  public void postOrder(BSTreeNode bsTreeNode) {
    if (bsTreeNode != null) {
      inOrder(bsTreeNode.left);
      System.out.print(bsTreeNode.key + ",");
      inOrder(bsTreeNode.right);
    }
  }


  @Test
  public void testInsert() {
    BSTree<Integer> integerBSTree = new BSTree<>();
    Set<Integer> set = new LinkedHashSet<>(10);
   /* for (int i = 0; i < 10; i++) {

    }*/
    while (true) {
      int v = (int) (Math.random() * 10);
      set.add(v);
      if (set.size() == 10) {
        break;
      }
      System.out.println(v);
    }
    System.out.println(Arrays.toString(set.toArray()));
    for (Integer o : set) {
      integerBSTree.insert(o);
    }
    System.out.println("preOrder:");
    integerBSTree.preOrder(integerBSTree);
    System.out.println();
    System.out.println("inOrder");
    integerBSTree.inOrder(integerBSTree);
    //integerBSTree.insert(i);
    BSTree<Integer> bsTree = new BSTree<>();
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    for (Integer i : list) {
      bsTree.insert(i);
    }
    System.out.println("inOrder 2:");
    bsTree.inOrder(bsTree);
    System.out.println();
    System.out.println("find 3");
    BSTreeNode bsTreeNode = bsTree.find(3);

    System.out.println(bsTreeNode.key + " rigth:" + bsTreeNode.right.key);
  }

  public class BSTreeNode<T extends Comparable<T>> {

    private T key;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;
    private BSTreeNode<T> parent;

    public BSTreeNode(T key, BSTreeNode<T> left,
        BSTreeNode<T> right, BSTreeNode<T> parent) {
      this.key = key;
      this.left = left;
      this.right = right;
      this.parent = parent;
    }
  }
}
