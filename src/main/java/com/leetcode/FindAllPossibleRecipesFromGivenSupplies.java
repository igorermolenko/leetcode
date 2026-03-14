package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static java.util.List.of;

public class FindAllPossibleRecipesFromGivenSupplies {

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> ingredients2recipes = new HashMap<>();
        Map<String, Integer> recipes2ingredientsCount = new HashMap<>();

        for (int i = 0; i < recipes.length; i++) {
            List<String> recipeIngredients = ingredients.get(i);
            for (String ingredient : recipeIngredients) {
                ingredients2recipes.computeIfAbsent(ingredient, k -> new HashSet<>()).add(recipes[i]);
            }
            recipes2ingredientsCount.put(recipes[i], recipeIngredients.size());
        }

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (String supply : supplies) {
            queue.offer(supply);
        }

        while (!queue.isEmpty()) {
            String ingredient = queue.poll();
            if (ingredients2recipes.containsKey(ingredient)) {
                for (String recipe : ingredients2recipes.get(ingredient)) {
                    int count = recipes2ingredientsCount.compute(recipe, (k, v) -> v == null ? 0 : v - 1);
                    if (count == 0) {
                        queue.offer(recipe);
                        result.add(recipe);
                    }
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        FindAllPossibleRecipesFromGivenSupplies task = new FindAllPossibleRecipesFromGivenSupplies();
        System.out.println(task.findAllRecipes(new String[]{"bread"}, of(of("yeast", "flour")), new String[]{"yeast", "flour", "corn"}));
        System.out.println(task.findAllRecipes(new String[]{"bread", "sandwich"}, of(of("yeast", "flour"), of("bread", "meat")), new String[]{"yeast", "flour", "meat"}));
        System.out.println(task.findAllRecipes(new String[]{"bread", "sandwich", "burger"}, of(of("yeast", "flour"), of("bread", "meat"), of("sandwich", "meat", "bread")), new String[]{"yeast", "flour", "meat"}));
    }

}