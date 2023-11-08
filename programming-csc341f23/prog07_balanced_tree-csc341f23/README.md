# Programming Assignment 7 Balanced Binary Search Trees

## Implementation due Thursday, November 16 end-of-day

### Zip all files and submit via Moodle

In this project, you will be building on the previous lab to create a List class that is implemented with a Binary Search Tree (BST). The primary focus will be on maintaining a balanced tree (but not with rotations).

Start with your BST lab, which should have the following:

- `void add(Simple value)`
- `String toString()`
- `Simple get(Simple simple)`
- `Simple find(Sting value)`
- `Simple find(Integer value)`
- `Simple min()`
- `Simple max()`
- `Simple[] toArray()`

**If you were not able to complete the BST or something wasn't working correctly, please come to office hours and I will fix it or provide you with code.**

## Requirements

### IMPLEMENTATION: Minor additions and modifications to the Node class

- Add `Node parent` to the Node class.
- Add `int height` to the Node class.

### IMPLEMENTATION: Additions and modifications of methods related to tree height and ordering

- Add `public int height()` that returns the height of the tree. _This should be private, but then I could not inspect it for testing._

- Modify `public void add(Simple simple)` to maintain the height. After the node is added to the tree, adjust its parent's height, as appropriate, which might require adjusting its parent, and so on. Also, if at any point it is determined that the left and right subtrees of any node have heights that differ by 10, then rebuild the tree to balance it.

- Add `public Simple[] toArray(Comparator<Simple> comp)`: Return an array in an order based on the specified comparator. Use your toArray() method and a sorting method to rearrange the array (NOT THE TREE!).

- Add `private void balance()`: Put everything into an ordered array and then reinsert into the tree. Think about which element you want as the root to make the left and right subtrees of equal height (or at most difference of 1). Then think about which nodes that you want as the left and right child of the root. This method needs to be recursive. Adding nodes back into the tree should automatically reset the height of each node because the add function is maintaining it. **Note, set the root to null before adding the nodes back in.**

- Add `public void reorder(Comparator<Simple> comp)`: Replace the ordering value with this comparator. Reorder the tree. Make sure it is **balanced**.

### IMPLEMENTATION: Additional methods related to search

- Add/Modify `public ArrayList<Simple> query(String value)`: Fill the ArrayList with all elements that are equal to the value that satisfy the query.

When removing nodes or rebalancing a tree, it can be useful to find the successor and predecessor of a given node. We are not using these methods in this implementation because we do not perform rotations or remove nodes, but it is a good exercise.

> Suggestion: draw a tree with various configurations and follow the below algorithms to make sure you understand how these algorithms find the successor and predecessor.

- Add `public Simple successor(Simple value)`.  _Normally, this would be private and probably return a Node, but then I couldn't test your code._ It might be useful to create a helper get method that returns the node corresponding to the given value. Then use the below algorithm to find its successor in the tree. If it has no successor, return null.

  If right subtree is not NULL, then successor is the minimum of the right subtree.
  If right subtree is NULL, then successor is one of the ancestors (if it exists -- notice that if the node is the rightmost node, there is no successor). Travel up using the parent pointer until you see a node which is a left child of its parent. The successor is that child's parent.

- Add `public Simple predecessor(Simple value)`. _Normally, this would be private, but then I couldn't test it._ Again, might be useful to have a helper function that returns the Node with the given value. Then use the below algorithm to find its predecesor in the tree. If it has no predecessor, return null.

  If left subtree is not NULL, then predecessor is maximum value of the left subtree.
  If left subtree is NULL, the predecessor is an ancestor (if it exists -- notice that if the node is the leftmost node, there is no predecessor). Travel up the tree using parent pointers until you see a node that is the right child of its parent. The predecessor is that child's parent.

## Documentation

- Javadocs are professional and complete. They do not describe implementation -- only input and output.
- Comment the code. Not too much, not too little.
- Style compliant.

## Testing

It is up to you to test your code and make sure it is meeting the requirements. I will not assess your tests.
