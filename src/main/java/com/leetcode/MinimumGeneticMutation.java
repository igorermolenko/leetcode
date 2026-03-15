package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Set<String>> graph = new HashMap<>();
        graph.put(startGene, getNeighbours(startGene, bank));
        for (String s : bank) {
            graph.put(s, getNeighbours(s, bank));
        }

        int mutationCounter = 0;
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String nextGene = queue.poll();
                if (endGene.equals(nextGene)) {
                    return mutationCounter;
                }
                for (String neighbour : graph.get(nextGene)) {
                    if (!visited.contains(neighbour)) {
                        queue.offer(neighbour);
                        visited.add(neighbour);
                    }
                }
            }
            mutationCounter++;
        }

        return -1;
    }


    private Set<String> getNeighbours(String gene, String[] bank) {
        Set<String> neighbours = new HashSet<>();
        for (String s : bank) {
            if (isNeighbor(s, gene)) neighbours.add(s);
        }
        return neighbours;
    }

    private boolean isNeighbor(String gene1, String gene2) {
        int diffCount = 0;
        for (int i = 0; i < gene1.length(); i++) {
            if (gene1.charAt(i) != gene2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }


    public static void main(String[] args) {
        MinimumGeneticMutation task = new MinimumGeneticMutation();
        System.out.println(task.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(task.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(task.minMutation("AAAAAAAA", "CCCCCCCC", new String[]{"AAAAAAAA", "AAAAAAAC", "AAAAAACC", "AAAAACCC", "AAAACCCC", "AACACCCC", "ACCACCCC", "ACCCCCCC", "CCCCCCCA"}));
    }

}