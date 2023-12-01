# Programming Assignment 9 Breadth First (BFS) and Depth First Search (DFS) of Graphs

## Due Thursday, December 7 end-of-day. Moodle link open until Friday end-of-day. No late assignments accepted. No exceptions

Zip all files and submit via Moodle

In this assignment, you will use the ADT Queue and the ADT Stack that you previously implemented. Both will be implementing the QueueInterface.

The Queue should be implemented using a **Circular Array**, which uses indices to mark the "head" and "tail" of the queue that is stored in the array. You should also use a **dummy space** in this implementation, meaning an extra space that is a buffer between the end of the array and the head (it is always 1 space "before" the head).

> If the indices used for the head and tail of the Queue are equal, then the Queue is empty. If the tail index + 1 would be equal to the head index of the Queue, then the Queue is full.

The Stack implementation is your choice. For the implementation, both push and pop operate at the same "end" of the data structure.

There are 3 text files provided that represent a maze. Each node is a decision point. Nodes without any children are deadends. One node in the maze is an exit node (there is a boolean _isExit_ set to true for the exit). You will determine the path through the maze from "start" to "exit" using either a Breadth-First Search or a Depth-First Search. The only distinction between these two traversal methods is the type of queue that is used. As part of the assignment, you will keep track of how many nodes are placed on the queue before the exit is found.

> The word "queue" is used both as a general concept and as a specific ADT. The ADTs Stack and Queue are technically both queues in that they only operate on the ends of the structure, not in the middle. There is also a Priority Queue and a Deque (not to be confused with the operation dequeue, which is synonymous with remove). Typically, when someone just says "queue," they mean an FIFO Queue, but if there is any ambiguity be sure to ask.

### Implementation of interface QueueInterface

- [x] `public void push(T value)` : add a value to the end of the Queue.
- [x] `public T pop()` : remove the first element of the Queue.
- [x] `public T peek()` : return the first element of the Queue, but do not remove it.
- [x] `public boolean isEmpty()` : true if Queue is empty.

This class has been implemented.

### Implementation of class Queue

The methods for `public class Queue<T> implements QueueInterface<T>` are specified by the QueueInterface. Additionally:

- [] `public String toString()` : override Object toString, which might be useful for debugging.

Your class Queue should have the following private member variables. You may include more than these.

- [x] `private int head` : index of the first element in the Queue
- [x] `private int tail` : index of the location to place the next added value

>Note: you might find it useful to have a helper function that returns the "next" index.

You have already created a Queue. You will need to modify it so that it implements the QueueInterface.

### Implementation of class Stack

The methods for `public class Stack<T> implements QueueInterface<T>` are specified by the QueueInterface. Additionally,

- [] `public String toString()` : override Object toString

Your class Stack should have the following private member variable. You may include more than these.

- [] `private int count` : number of elements currently in the stack. All operations occur at the end.

You have already created a Stack. You will need to modify it so that it implements the QueueInterface.

### Implementation of class Maze

The method descriptions for `public class Maze` are:

- [] `public load(String fname)` : create a graph/maze based on the file
- [] `public LinkedList<MazeNode> solve(algorithm)` : find the exit using the specified algorithm (either "bfs" or "dfs").
- [] `public void print()` : prints all nodes in the graph with their children.
- [] `public int total_count()` : total number of nodes placed on the queue throughout the solving of the maze
- [] `public int max_count()` : max number of nodes ever on the queue throughout the solving of the maze

The Breadth-First Search (bfs) and Depth-First Seach (dfs) algorithms are identical except that bfs uses an FIFO Queue and dfs uses an LIFO Queue. Here is the algorithm taking this into account:

```Java
// Create the queue, appropriate for the type of traversal

// push the start onto the queue
// while the queue is not empty
    // pop from the queue
    // for each child of that popped node
        // if child is exit node
            // set previous
            // return the path from root to this node (using previouses)
        // if not yet visited (previous will be null)
            // push onto the queue
            // set previous
            // increment count
```

Note that the code for this algorithm only appears 1 time in `solve()`. Declare a QueueInterface object and assign it to either Queue or Stack. Since they have a shared interface, you can use the same methods of push and pop.

You also need to implement the `print()` method. Print each node in the graph and all its children on 1 line.

### Solve (main) Class

The `Solve` class contains `main(String[] args)`. To run the application, you have to use the command line and enter command-line arguments. The parameter of main is a list of strings that are read in from the command-line (anything that comes after "Solve".)

To run the code to solve the first maze using BFS, at the command prompt, you type:

``` txt
java Solve maze1.txt bfs 
```

To run the code to solve the first maze using DFS, at the command prompt, you type:

``` txt
java Solve maze1.txt dfs 
```
