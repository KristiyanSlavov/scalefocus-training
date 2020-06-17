# Algorithms, data structures and design patterns implemented in Java.


# Algorithms
The implemented algorithms are of several types: recursion, search, sorting.
  
Also implemented Sliding Puzzle/N-Puzzle game.
This game is a popular puzzle that consists of N tiles where N can be 8, 15, 24 and so on. The puzzle is divided into √(N+1) rows and √(N+1) columns eg. 15-Puzzle will have 4 rows and 4 columns, an 8-Puzzle will have 3 rows and 3 columns and so on. The puzzle consists of one empty space where the tiles can be moved and thus the puzzle is solved when a particular goal pattern is formed.

I use A* search algorithm to describe the solution to the problem. Define a search node of the game to be a board, the number of moves made to reach the board, and the previous search node. First, insert the initial search node (the initial board, 0 moves, and a null previous search node) into a priority queue. Then, delete from the priority queue the search node with the minimum priority, and insert into the priority queue all neighboring search nodes (those that can be reached in one move from the dequeued search node). Repeat this procedure until the search node dequeued corresponds to a goal board. The success of this approach hinges on the choice of priority calculation for a search node. We consider Manhattan priority - the sum of the Manhattan distances (sum of the vertical and horizontal distance) from the blocks to their goal positions, plus the number of moves made so far to get to the search node..

# Data Structures
The implemented data structures are: ArrayList, DoubleLinkedList, LinkedList, HashMap, LinkedHashMap, HashSet, Heap, PriorityQueue, Queue, Stack, TreeMap, TreeSet, BinaryTree, BinarySearchTree, RedBlackTree.

# Design Patterns
The implemented design patterns are: 
* Creational - Builder, Factory Method, Singleton
* Structural - Adapter, Bridge, Composite, Decorator, Facade, Proxy
* Behavioral - Observer, Command, Strategy, Template Method, Interpreter
