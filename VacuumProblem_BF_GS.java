import java.util.*;

public class VacuumProblem_BF_GS
{
	//ACTIONS
	public static Node action_Left(Node node)
	{
		Node new_node = new Node(node);
		if (node.robot_B == 1)
		{
			new_node.robot_B = 0;
			new_node.robot_A = 1;
		}
		new_node.state_ID = new_node.robot_A << 3 | new_node.robot_B << 2 | new_node.dirt_A << 1 | new_node.dirt_B << 0;
		System.out.print("Result from ACTION LEFT: ");
		System.out.println(new_node.robot_A + " " + new_node.robot_B + " " + new_node.dirt_A + " " + new_node.dirt_B);
		new_node.parent = node;
		new_node.action = "LEFT";
		new_node.pathCost = node.pathCost + 1;
		return (new_node);
	}
	public static Node action_Right(Node node)
	{
		Node new_node = new Node(node);
		if (node.robot_A == 1)
		{
			new_node.robot_A = 0;
			new_node.robot_B = 1;
		}
		new_node.state_ID = new_node.robot_A << 3 | new_node.robot_B << 2 | new_node.dirt_A << 1 | new_node.dirt_B << 0;
		System.out.print("Result from ACTION RIGHT: ");
		System.out.println(new_node.robot_A + " " + new_node.robot_B + " " + new_node.dirt_A + " " + new_node.dirt_B);
		new_node.parent = node;
		new_node.action = "RIGHT";
		new_node.pathCost = node.pathCost + 1;
		return (new_node);
	}
	public static Node action_S(Node node)
	{
		Node new_node = new Node(node);
		if (node.robot_A == 1 && node.dirt_A == 1)
			new_node.dirt_A = 0;
		else if (node.robot_B == 1 && node.dirt_B == 1)
			new_node.dirt_B = 0;
		new_node.state_ID = new_node.robot_A << 3 | new_node.robot_B << 2 | new_node.dirt_A << 1 | new_node.dirt_B << 0;
		System.out.print("Result from ACTION SUCK: ");
		System.out.println(new_node.robot_A + " " + new_node.robot_B + " " + new_node.dirt_A + " " + new_node.dirt_B);
		new_node.parent = node;
		new_node.action = "SUCK";
		new_node.pathCost = node.pathCost + 1;
		return (new_node);
	}
	//GOAL TEST
	public static boolean goal_test(Node node)
	{
		boolean solutionFound = false;
		if (node.dirt_A == 0 && node.dirt_B == 0)
			solutionFound = true;
		return (solutionFound);
	}
	//SOLUTION
	public static void solution(Node node)
	{
		Node ptr = node;
		System.out.println();
		System.out.println("GOAL STATE REACHED");
		while (true)
		{
			if (ptr == null)
				break ;
			System.out.print(Integer.toBinaryString(ptr.state_ID));
			if (ptr.action == null)
				break ;
			System.out.print("<--");
			System.out.print(ptr.action);
			System.out.print("--");
			ptr = ptr.parent;
		}
	}
	//Check state_ID in queue nodes
	public static boolean state_ID_checkQ(Queue<Node> queue, int targetValue)
	{
		for (Node node : queue)
		{
			if (node.state_ID == targetValue)
				return (true);
		}
		return (false);
	}
    public static void main(String[] args)
    {
		Node root = new Node(1, 0, 1, 1);
		Node node;
		Queue<Node> queue = new LinkedList<>();
		if (goal_test(root) == true)
		{
			solution(root);
			return ;
		}
		queue.add(root);//Frontier
		int a = 0;
		ArrayList<Integer> expandedSet = new ArrayList<>();
		while (true)
		{
			System.out.println("Loop " + a);
			if (queue.isEmpty())
				return ;
			for (Node element : queue)
				System.out.println("Frontier: " + Integer.toBinaryString(element.state_ID));
			node = queue.poll();
			System.out.println("Node state: ");
			System.out.println(Integer.toBinaryString(node.state_ID));
			expandedSet.add(node.state_ID);
			for (Integer num : expandedSet)
			{
				System.out.print("Expanded sets: ");
				System.out.println(Integer.toBinaryString(num));
			}
			for (int i = 3; i > 0; i--)
			{
				Node new_node = new Node(node);
				if (i % 3 == 0)
				{
					new_node = action_Left(new_node);
					if (!expandedSet.contains(new_node.state_ID) && !state_ID_checkQ(queue, new_node.state_ID))
					{
						if (goal_test(new_node))
						{
							solution(new_node);
							return ;
						}
						queue.add(new_node);//addition of the new node
						System.out.println("Action LEFT added node to the queue");
					}
				}
				else if (i % 2 == 0)
				{
					new_node = action_Right(new_node);
					if (!expandedSet.contains(new_node.state_ID) && !state_ID_checkQ(queue, new_node.state_ID))
					{
						if (goal_test(new_node))
						{
							solution(new_node);
							return ;
						}
						System.out.println("Action RIGHT added node to the queue");
						queue.add(new_node);//addition of the new node
					}
				}
				else 
				{
					new_node = action_S(new_node);
					if (!expandedSet.contains(new_node.state_ID) && !state_ID_checkQ(queue, new_node.state_ID))
					{

						if (goal_test(new_node))
						{
							solution(new_node);
							return ;
						}
						System.out.println("Action SUCK added node to the queue");
						queue.add(new_node);//addition of the new node
					}
				}
			}
			a++;
			System.out.println();
		}
    }
}