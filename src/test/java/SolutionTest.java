import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void kthSmallestExample1() {
    assertEquals(1, sol.kthSmallest(sol.createBinaryTree(new String[]{
        "3","1","4", "null", "2"
    }), 1));
  }
  @Test
  void kthSmallestExample2() {
    assertEquals(3, sol.kthSmallest(sol.createBinaryTree(new String[]{
        "5","3","6", "2", "4", "null", "null", "1"
    }), 3));
  }

  @Test
  void kthSmallestV1Example1() {
    assertEquals(1, sol.kthSmallestV1(sol.createBinaryTree(new String[]{
        "3","1","4", "null", "2"
    }), 1));
  }
  @Test
  void kthSmallestV1Example2() {
    assertEquals(3, sol.kthSmallestV1(sol.createBinaryTree(new String[]{
        "5","3","6", "2", "4", "null", "null", "1"
    }), 3));
  }
}