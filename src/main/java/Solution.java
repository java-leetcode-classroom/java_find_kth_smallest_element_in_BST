import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
  public TreeNode createBinaryTree(String[] inputs) {
    TreeNode result = null, cur;
    HashMap<Integer, TreeNode> hash = new HashMap<>();
    int size = inputs.length;
    for (int idx = 0; idx < size; idx++) {
      int num = 0;
      String val = inputs[idx];
      if (!val.equals("null")) {
        num = Integer.parseInt(val);
      }
      if (idx == 0) {
        result = new TreeNode(num);
        hash.put(num, result);
      }
      if (hash.containsKey(num)) {
        cur = hash.get(num);
      } else {
        cur = new TreeNode(num);
        hash.put(num, cur);
      }
      if (2*idx+1 < size) {
        if (!inputs[2*idx+1].equals("null")) {
          int leftVal = Integer.parseInt(inputs[2*idx+1]);
          if (hash.containsKey(leftVal)) {
            cur.left = hash.get(leftVal);
          } else {
            cur.left = new TreeNode(leftVal);
            hash.put(leftVal, cur.left);
          }
        }
      }
      if (2*idx+2 < size) {
        if (!inputs[2*idx+2].equals("null")) {
          int rightVal = Integer.parseInt(inputs[2*idx+2]);
          if (hash.containsKey(rightVal)) {
            cur.right = hash.get(rightVal);
          } else {
            cur.right = new TreeNode(rightVal);
            hash.put(rightVal, cur.right);
          }
        }
      }
    }
    return result;
  }
  public int kthSmallest(TreeNode root, int k) {
    ArrayList<Integer> result = inorder(root, new ArrayList<>(), k);
    return result.get(result.size()-1);
  }
  public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr, int k) {
    if (root == null) {
      return arr;
    }
    inorder(root.left, arr, k);
    if (arr.size() == k) {
      return arr;
    }
    arr.add(root.val);
    if (arr.size() == k) {
      return arr;
    }
    return inorder(root.right, arr, k);
  }
  public int kthSmallestV1(TreeNode root, int k) {
    LinkedList<TreeNode> stack = new LinkedList<>();
    while(true) {
      // 1. push left node first
      // if root not null
      while(root != null) {
        stack.push(root);
        root = root.left;
      }
      // if root == null
      // 2. pop and find right node
      root = stack.pop();
      k--;
      if (k == 0) {
        return root.val;
      }
      root = root.right;
    }
  }
}
