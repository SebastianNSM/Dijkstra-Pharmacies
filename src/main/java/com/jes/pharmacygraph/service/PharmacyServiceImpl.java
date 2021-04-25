package com.jes.pharmacygraph.service;
import com.jes.pharmacygraph.api.PharmacyRepository;
import com.jes.pharmacygraph.entities.Dijkstra;
import com.jes.pharmacygraph.entities.Graph;
import com.jes.pharmacygraph.entities.HashNode;
import com.jes.pharmacygraph.entities.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PharmacyServiceImpl implements PharmacyService{

    PharmacyRepository pharmaRepo = new PharmacyRepository();

    public Set<Node> getAllNodes(){
        return pharmaRepo.getGraph().getNodes();
    }

    public int findNodeinHash(String name){
        int res = 0;
        HashNode n = pharmaRepo.getHash().find(name);
        if(n != null){
            res = 1;
        }
        return res;
    }

    public Node getNodeInGraph(String name){
        if(findNodeinHash(name)==1){
            for(Node n : pharmaRepo.getGraph().getNodes()){
                if(n.getName().equals(name)){
                    return n;
                }
            }
        }
        return null;
    }

    public String findShortestPath(String origin, String destination){
        Node orNode = getNodeInGraph(origin);
        Node destNode = getNodeInGraph(destination);
        return getShortestPath(orNode, destNode, pharmaRepo.getGraph());

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