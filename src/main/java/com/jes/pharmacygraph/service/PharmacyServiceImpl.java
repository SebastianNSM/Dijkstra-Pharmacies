package com.jes.pharmacygraph.service;

import com.jes.pharmacygraph.api.PharmacyRepository;
import com.jes.pharmacygraph.entities.Dijkstra;
import com.jes.pharmacygraph.entities.Graph;
import com.jes.pharmacygraph.entities.HashNode;
import com.jes.pharmacygraph.entities.Node;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    PharmacyRepository pharmaRepo = new PharmacyRepository();

    public Set<Node> getAllNodes() {
        return pharmaRepo.getGraph().getNodes();
    }

    public int findNodeinHash(String name) {
        int res = 0;
        HashNode n = pharmaRepo.getHash().find(name);
        if (n != null) {
            res = 1;
        }
        return res;
    }

    public Node getNodeInGraph(String name) {
        if (findNodeinHash(name) == 1) {
            for (Node n : pharmaRepo.getGraph().getNodes()) {
                if (n.getName().equals(name)) {
                    return n;
                }
            }
        }
        return null;
    }

    public String findAdjacencyList(String name) {
        return getNodeInGraph(name).getAdjacentNodes().keySet().stream().map(Node::getName).collect(Collectors.joining(", "));
    }

    public String findShortestPath(String origin, String destination) {
        Node orNode = getNodeInGraph(origin);
        Node destNode = getNodeInGraph(destination);
        return getShortestPath(orNode, destNode, pharmaRepo.getGraph());

    }

    public String getShortestPath(Node origin, Node destination, Graph graph) {
        Graph dGraph = Dijkstra.calculateShortestPathFromSource(graph, origin);
        Node res = dGraph.getNodes().stream().filter(node -> node.equals(destination)).findFirst().orElse(null);
        if (res != null && res.getDistance() != Integer.MAX_VALUE) {
            StringBuilder sb = new StringBuilder();
            String shortestPath = res.getShortestPath().stream()
                    .map(node -> node.getName() + " -> " + node.getDistance())
                    .collect(Collectors.joining(", ")) + ", " + res.getName() + " -> " + res.getDistance();
            sb.append("Distance traveled: ").append(res.getDistance()).append("\nShortest Path\t").append(shortestPath);
            this.pharmaRepo.resetGraph();
            return sb.toString();
        }
        this.pharmaRepo.resetGraph();
        return "No path found";
    }
}
