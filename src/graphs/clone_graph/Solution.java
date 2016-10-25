package graphs.clone_graph;

import java.util.*;

/**
 * Created by ugurdonmez on 11/09/16.
 */
public class Solution {

    public static void main(String [] args) {

        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null) {
            return null;
        }

        Map<Integer, UndirectedGraphNode> map = new HashMap<>();

        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();

            if (!map.containsKey(n.label)) {
                map.put(n.label, new UndirectedGraphNode(n.label));

                for (UndirectedGraphNode u : n.neighbors) {
                    queue.add(u);
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();

            if (!visited.contains(n.label)) {

                UndirectedGraphNode clone = map.get(n.label);

                for (UndirectedGraphNode u : n.neighbors) {
                    clone.neighbors.add(map.get(u.label));
                    queue.add(u);
                }
                visited.add(n.label);
            }
        }

        return map.get(node.label);
    }

}

class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}