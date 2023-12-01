# Prog08_max_heap-csc341f23

This programming assignment will be worked on during class. It is likely that you can complete the entire assignment during class time. However, if you do not complete during class, please complete it outside of class time. This will be graded at the same scale as other programming assignments (meaning it is worth 5 points).

## HEAPS

Create a **GENERIC** class MaxHeap that implements a **MAX HEAP**
Implement the methods:

- [x] `T pop()`
- [x] `void push(T value)`
- [x] `T peek()`
- [x] `boolean isEmpty()`

- [x] `sink(int i)`: sink the value at index i "down" into the "tree"
- [x] `floatUp(int i)`: float the value at index i "up" into the "tree"

- [x] `leftChildIndex(int index)`: return the index of the left child of "node" at index
- [x] `rightChildIndex(int index)`: return the index of the right child of "node" at index
- [x] `parentIndex(int index)`: return the index of the parent of "node" at index

- [x] Helper Methods: (name them whatever makes sense for you)

- [x] Create a Main class for testing.

Be sure to put things in different ordering to confirm the "tree" is being properly maintained
