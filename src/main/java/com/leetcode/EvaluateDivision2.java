package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.List.of;

public class EvaluateDivision2 {


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>(); // source <-> map of target to weight
        for (int i = 0; i < equations.size(); i++) {
            String operand1 = equations.get(i).get(0);
            String operand2 = equations.get(i).get(1);
            double result = values[i];
            graph.computeIfAbsent(operand1, k -> new HashMap<>()).put(operand2, result);
            graph.computeIfAbsent(operand2, k -> new HashMap<>()).put(operand1, 1 / result);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(graph, new HashSet<>(), queries.get(i).get(0), queries.get(i).get(1));
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String start, String finish) {
        if (visited.contains(start) || !graph.containsKey(start) || !graph.containsKey(finish)) {
            return -1;
        }
        visited.add(start);
        Map<String, Double> node = graph.get(start);
        if (node.containsKey(finish)) {
            return node.get(finish);
        }
        for (Map.Entry<String, Double> entry : node.entrySet()) {
            double result = dfs(graph, visited, entry.getKey(), finish);
            if (result != -1) {
                return result * entry.getValue();
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        EvaluateDivision2 task = new EvaluateDivision2();
        System.out.println(Arrays.toString(task.calcEquation(of(of("a", "b"), of("b", "c")), new double[]{2.0, 3.0}, of(of("a", "c"), of("b", "a"), of("a", "e"), of("a", "a"), of("x", "x")))));
        System.out.println(Arrays.toString(task.calcEquation(of(of("a", "b"), of("b", "c"), of("bc", "cd")), new double[]{1.5, 2.5, 5.0}, of(of("a", "c"), of("c", "b"), of("bc", "cd"), of("cd", "bc")))));
        System.out.println(Arrays.toString(task.calcEquation(of(of("a", "b")), new double[]{0.5}, of(of("a", "b"), of("b", "a"), of("a", "c"), of("x", "y"), of("a", "a")))));
    }
}
