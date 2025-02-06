# Vacuum World problem solution with Breadth-First Graph AI Search Algo!

- Uninformed search algorithm using First-In-First-Out queue as a frontier. 
- No additional knowledge (information) is given to the code. 
- Problem solution is found with the least movement (for this specific problem).

## Structure and features
- Each state has 2 sites A and B.
- Initial state has the vacuum on site A (if robot_A == 1; means vacuum exists on site A), and has dirt on both sides A and B (dirt_A = 1 && dirt_B = 1)
- States are recognized by variable state_ID which is based on the location of the vacuum and dirt, for example, the initial state state_ID would be 1101 because SITE A has a vacuum but SITE B does not so it is 1 and 0. Further, SITE A and SITE B both have dirt which makes it 1 and 1. Therefore, the state_ID is 1011.
- There are only 8 possible states and each state has its own state_ID.
- Since state_IDs are unique they are used in the expanded set to keep track.
- Keep in mind that only the initial state is given to the algorithm not all the states since it is an informed search
- The initial state is expanded generating new states in the frontier, if the generated state already exists in the frontier or the expanded set it will not be added to the frontier (queue).
- Generated states which have new (unseen) state_ID will be added to the frontier and will wait until its turn to be popped (POP) from the queue to be expanded and generate new states.

## Vacuum World States

  ![image](https://github.com/user-attachments/assets/49b79f1c-15c1-47de-9e54-490deea6a302)

Source: https://cs.stackexchange.com/questions/134581/ai-search-state-in-the-toy-vacuum-problem 

## Solution
- Solution is found when Sites A and B are clean.
- The algorithm found solution S -> R -> S 

## Search Tree

  ![Search_Tree](https://github.com/user-attachments/assets/e001df00-5dae-43db-b8af-1f6d41663144)

To run the code: 
1. Compilation: javac SearchTree.java VacuumProblem_BF_GS.java
2. Run executable: java VacuumProblem_BF_GS
