package com.jes.pharmacygraph;

import com.jes.pharmacygraph.entities.Dijkstra;
import com.jes.pharmacygraph.entities.Graph;
import com.jes.pharmacygraph.entities.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class PharmacyCommandlineRunner implements CommandLineRunner {

    private final Logger LOGGER = LoggerFactory.getLogger(PharmacyCommandlineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        initializeData();
    }

    public void initializeData() {
        LOGGER.info("Initialize nodes");
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        LOGGER.info("Initialize destinations");
        nodeA.addDestination(nodeB, 5);
        nodeA.addDestination(nodeC, 10);

        nodeB.addDestination(nodeD, 18);

        nodeC.addDestination(nodeD, 5);
        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);

        Graph graph = new Graph();
        LOGGER.info("Initialize graph");
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        LOGGER.info("Dijkstra from nodeA");
        String pathBC = getShortestPath(nodeA, nodeD, graph);
        LOGGER.info(pathBC);
    }

    public String getShortestPath(Node origin, Node destination, Graph graph) {
        Graph dGraph = Dijkstra.calculateShortestPathFromSource(graph,origin);
        Node res = dGraph.getNodes().stream().filter(node -> node.equals(destination)).findFirst().orElse(null);
        if (res != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Distance traveled: ").append(res.getDistance()).append("\tShortest Path").append(res.getShortestPath());
            return sb.toString();
        }
        return "No path found";
    }
}
