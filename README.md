# Algorithms, data structures and design patterns implemented in Java.


# Algorithms
The implemented algorithms are of several types: 
- recursion - Factorial, Fibonacci (with Memoization technique and without it)
- search - Breadth-first search, Depth-first search (plus Inorder, Preorder, Postorder Traversal) 
- sorting - BubbleSort, HeapSort, InsertionSort, MergeSort, QuickSort, SelectionSort
  
Also implemented Sliding Puzzle/N-Puzzle game.
This game is a popular puzzle that consists of N tiles where N can be 8, 15, 24 and so on. The puzzle is divided into √(N+1) rows and √(N+1) columns eg. 15-Puzzle will have 4 rows and 4 columns, an 8-Puzzle will have 3 rows and 3 columns and so on. The puzzle consists of one empty space where the tiles can be moved and thus the puzzle is solved when a particular goal pattern is formed.

I use A* search algorithm to describe the solution to the problem. Define a search node of the game to be a board, the number of moves made to reach the board, and the previous search node. First, insert the initial search node (the initial board, 0 moves, and a null previous search node) into a priority queue. Then, delete from the priority queue the search node with the minimum priority, and insert into the priority queue all neighboring search nodes (those that can be reached in one move from the dequeued search node). Repeat this procedure until the search node dequeued corresponds to a goal board. The success of this approach hinges on the choice of priority calculation for a search node. We consider Manhattan priority - the sum of the Manhattan distances (approximation heuristics / sum of the vertical and horizontal distance) from the blocks to their goal positions, plus the number of moves made so far to get to the search node..

Links:
- Memoization - https://www.interviewcake.com/concept/java/memoization
- Breadth-First Search - https://www.baeldung.com/java-breadth-first-search
- Depth-First Search - https://www.baeldung.com/java-depth-first-search
- Bubble Sort - https://www.geeksforgeeks.org/bubble-sort/
- Heap Sort - https://www.geeksforgeeks.org/heap-sort/
- Insertion Sort - https://www.geeksforgeeks.org/insertion-sort/
- Merge Sort - https://www.geeksforgeeks.org/merge-sort/
- Quick Sort - https://www.geeksforgeeks.org/quick-sort/ , https://www.geeksforgeeks.org/can-quicksort-implemented-onlogn-worst-case-time-complexity/
- Selection Sort - https://www.geeksforgeeks.org/selection-sort/
- Sliding Puzzle Game - https://algorithmsinsight.wordpress.com/graph-theory-2/a-star-in-general/implementing-a-star-to-solve-n-puzzle/ , https://www.cs.princeton.edu/courses/archive/fall15/cos226/assignments/8puzzle.html
- A* Search Algorithm - https://www.geeksforgeeks.org/a-search-algorithm/ , https://algorithmsinsight.wordpress.com/graph-theory-2/a-star-in-general/ 

# Data Structures
The implemented data structures are: ArrayList, DoubleLinkedList, LinkedList, HashMap, LinkedHashMap, HashSet, Heap, PriorityQueue, Queue, Stack, TreeMap, TreeSet, BinaryTree, BinarySearchTree, RedBlackTree.

Links:
- Array List - https://beginnersbook.com/2013/12/java-arraylist/
- Linked List - https://www.geeksforgeeks.org/linked-list-set-1-introduction/
- Hash Map - https://medium.com/@mr.anmolsehgal/java-hashmap-internal-implementation-21597e1efec3
- Hash Set - https://www.geeksforgeeks.org/internal-working-of-sethashset-in-java/
- Heap - https://www.geeksforgeeks.org/binary-heap/
- Priority Queue - https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
- Queue - https://www.geeksforgeeks.org/queue-interface-java/
- Stack - https://www.geeksforgeeks.org/stack-class-in-java/
- Tree Map - https://www.baeldung.com/java-treemap
- Tree Set - https://www.baeldung.com/java-tree-set
- Binary Tree - https://www.baeldung.com/java-binary-tree
- Binary Search Tree - https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
- Red-Black Tree - https://algorithmtutor.com/Data-Structures/Tree/Red-Black-Trees/

# Design Patterns
The implemented design patterns are: 
* Creational - Builder, Factory Method, Singleton
* Structural - Adapter, Bridge, Composite, Decorator, Facade, Proxy
* Behavioral - Observer, Command, Strategy, Template Method, Interpreter

Links:
- Creational Design Patterns - https://refactoring.guru/design-patterns/creational-patterns
- Structural Design Patterns - https://refactoring.guru/design-patterns/structural-patterns
- Behavioral Design Patterns - https://refactoring.guru/design-patterns/behavioral-patterns
- Design Patterns with Java - https://www.journaldev.com/1827/java-design-patterns-example-tutorial
