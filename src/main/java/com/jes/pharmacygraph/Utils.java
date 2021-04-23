package com.jes.pharmacygraph;

import com.jes.pharmacygraph.entities.Node;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    public static String convertMapWithStream(Map<Node, Integer> data){
        String mapAsString = data.keySet().stream()
                .map(key -> key.getName() + "=" + data.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
        return mapAsString;
    }

    public static String convertListWithStream(List<Node> data) {
        String listAsString = data.stream()
                .map(node -> node.getName() + "=" + node.getDistance())
                .collect(Collectors.joining(", ", "{", "}"));
        return listAsString;
    }
}
