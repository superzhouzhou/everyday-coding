package com.zxh.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Given the root node of a binary search tree, return the sum of values of all nodes with value
 * between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 * Example 1:
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 Output: 32
 * Example 2:
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10 Output: 23
 *
 * Note:
 * The number of nodes in the tree is at most 10000. The final answer is guaranteed to be less than
 * 2^31.
 *
 * @author zhouxiaohui
 */
public class RangeSumofBST {

  public static void main(String[] args) {
    //List<Integer> elements = Arrays.asList();
    Integer[] elements = new Integer[]{10, 5, 15, 3, 7, null, 18};
    for (int i = 0; 2*i+2 < elements.length; i++) {
      Integer paraent = elements[i];
      if (paraent != null) {
        TreeNode pNode = new TreeNode(paraent);
        pNode.left = new TreeNode(elements[2 * i + 1]);
      }

    }
  }

}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
