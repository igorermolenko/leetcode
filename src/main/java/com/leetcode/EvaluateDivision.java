package com.leetcode;

import java.util.*;

import static java.util.List.of;

public class EvaluateDivision {


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String operand1 = equation.get(0);
            String operand2 = equation.get(1);
            double result = values[i];

            List<Edge> edges1 = graph.compute(operand1, (k, v) -> v == null ? new ArrayList<>() : v);
            List<Edge> edges2 = graph.compute(operand2, (k, v) -> v == null ? new ArrayList<>() : v);
            edges1.add(new Edge(operand2, result));
            edges2.add(new Edge(operand1, 1 / result));
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            result[i] = dfs(graph, query.get(0), query.get(1), new HashSet<>());
        }

        return result;
    }

    double dfs(Map<String, List<Edge>> graph, String from, String to, Set<String> visited) {
        if (!graph.containsKey(from) || !graph.containsKey(to) || visited.contains(from)) {
            return -1;
        }
        visited.add(from);
        List<Edge> edges = graph.get(from);
        for (Edge edge : edges) {
            if (edge.target.equals(to)) {
                return edge.weight;
            }
            double temp = dfs(graph, edge.target, to, visited);
            if (temp != -1) {
                return edge.weight * temp;
            }
        }
        return -1;
    }


    private record Edge(String target, double weight) {}


    public static void main(String[] args) {
        EvaluateDivision task = new EvaluateDivision();
        System.out.println(Arrays.toString(task.calcEquation(of(of("a", "b"), of("b", "c")), new double[]{2.0, 3.0}, of(of("a", "c"), of("b", "a"), of("a", "e"), of("a", "a"), of("x", "x")))));
        System.out.println(Arrays.toString(task.calcEquation(of(of("a", "b"), of("b", "c"), of("bc", "cd")), new double[]{1.5, 2.5, 5.0}, of(of("a", "c"), of("c", "b"), of("bc", "cd"), of("cd", "bc")))));
        System.out.println(Arrays.toString(task.calcEquation(of(of("a", "b")), new double[]{0.5}, of(of("a", "b"), of("b", "a"), of("a", "c"), of("x", "y"), of("a", "a")))));
    }
}
