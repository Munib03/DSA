class Solution {
private class UnWeightedGraph {
  private class Node {
    private final int label;

    private Node(int label) {
      this.label = label;
    }

    @Override
    public String toString() {
      return label + "";
    }
  }

  private final Map<Integer, Node> nodesMap = new HashMap<>();
  private final Map<Node, List<Node>> adjacencyList = new HashMap<>();


  public void addNode(int val) {
    var newNode = new Node(val);

    nodesMap.putIfAbsent(val, newNode);
    adjacencyList.putIfAbsent(newNode, new ArrayList<>());
  }

  public void addEdge(int from, int to) {
    var fromNode = nodesMap.get(from);
    var toNode = nodesMap.get(to);

    if (fromNode == null || toNode == null)
      return;

    adjacencyList.get(fromNode).add(toNode);
  }

  public int[] topoSort() {
    var stack = new Stack<Node>();
    var set = new HashSet<Node>();

    for (var node : nodesMap.values()) {
      if (!set.contains(node))
        topoSort(node, set, stack);
    }

    var n = stack.size();
    int[] ans = new int[n];
    var index = 0;

    while (!stack.isEmpty())
      ans[index++] = stack.pop().label;

    return ans;
  }

  private boolean hasCycle() {
    var visiting = new HashSet<Node>();
    var visited = new HashSet<Node>();
    
    for (var node: nodesMap.values())
      if (hasCycle(node, visiting, visited))
        return true;
    
    return false;
  }
  
  // Inner Details of the class
  private boolean hasCycle(Node node, Set<Node> visiting, Set<Node> visited) {
    visiting.add(node);
    
    for (var neighbor: adjacencyList.get(node)) {
      if (visited.contains(neighbor))
        continue;
      
      if (visiting.contains(neighbor) || hasCycle(neighbor, visiting, visited))
        return true;
    }
    
    visiting.remove(node);
    visited.add(node);
    
    return false;
  }
  
  private void topoSort(Node node, Set<Node> set, Stack<Node> stack) {
    if (node == null || set.contains(node))
      return;

    set.add(node);

    for (var neighbor : adjacencyList.get(node))
      if (!set.contains(neighbor))
        topoSort(neighbor, set, stack);

    stack.push(node);
  }
}

public int[] findOrder(int numCourses, int[][] prerequisites) {
  var graph = new UnWeightedGraph();

  for (var i = 0; i < numCourses; i++)
    graph.addNode(i);

  for (var edge : prerequisites)
    graph.addEdge(edge[1], edge[0]);

  if (graph.hasCycle())
    return new int[] {  };
  
  return graph.topoSort();
}

}