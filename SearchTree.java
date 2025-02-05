
class Node
{
    int state_ID;
    Node parent;
    String action;
    int pathCost;
    
    int robot_A;
    int robot_B;
    int dirt_A;
    int dirt_B;

    public Node(int rA, int rB, int dA, int dB)
    {
        this.robot_A = rA;
        this.robot_B = rB;
        this.dirt_A = dA;
        this.dirt_B = dB;

        state_ID = (robot_A << 3) | (robot_B << 2) | (dirt_A << 1) | (dirt_B << 0);
        parent = null;
        action = null;
        pathCost = 0;
    }

    public Node(Node other)
    {
        this.state_ID = other.state_ID;
        this.parent = other.parent;  // Reference copy (shallow)
        this.action = other.action;  // Reference copy (shallow)
        this.pathCost = other.pathCost;
        this.robot_A = other.robot_A;
        this.robot_B = other.robot_B;
        this.dirt_A = other.dirt_A;
        this.dirt_B = other.dirt_B;
    }
}
