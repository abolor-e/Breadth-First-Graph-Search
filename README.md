## Vacuum World problem solution with Breadth-First Graph Search!

- Uninformed search algorithm using First-In-First-Out queue as a frontier. 
- No additional knowledge (information) is given to the code. 
- Problem solution is found with the least move (for this specific problem).

# Structure and features of states
- Each state has 2 sites A and B.
- Initial state has the vacuum on site A (if robot_A == 1; means vacuum exists on site A), and has dirt on both sides A and B (dirt_A = 1 && dirt_B = 1)
- States are recognized by variable state_ID which is based on the location of the vacuum and dirt, for example, initial state state_ID would be 1101 because SITE A has vacuum but SITE B does not so it is 1 and 0. Further, SITE A and SITE B both has dirts which makes it 1 and 1. Therefore, the state_ID is 1011.
- There only 8 possible states and each state has its own state_ID.
- Since state_IDs are unique they are used in the expanded set to keep track.

![image](https://github.com/user-attachments/assets/49b79f1c-15c1-47de-9e54-490deea6a302)

To run the code: 
1. Compilation: javac SearchTree.java VacuumProblem_BF_GS.java
2. Run executable: java VacuumProblem_BF_GS
