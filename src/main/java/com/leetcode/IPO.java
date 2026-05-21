package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // Создаем массив индексов от 0 до n-1
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Сортируем индексы по возрастанию требуемого капитала
        Arrays.sort(indices, (a, b) -> Integer.compare(capital[a], capital[b]));

        // Куча хранит ТОЛЬКО чистую прибыль (Integer) по убыванию
        PriorityQueue<Integer> profitMaxHeap = new PriorityQueue<>((a, b) -> b - a);

        int idx = 0;
        int finalCapital = w;

        while (k-- > 0) {
            // Добавляем в кучу прибыль ВСЕХ проектов, которые стали доступны
            while (idx < n && capital[indices[idx]] <= finalCapital) {
                profitMaxHeap.offer(profits[indices[idx]]);
                idx++; // Конвейер идет только вперед, назад возвращаться не нужно!
            }

            // Если доступных проектов нет, то и капитал увеличить нельзя
            if (profitMaxHeap.isEmpty()) {
                break;
            }

            // Забираем самый прибыльный проект
            finalCapital += profitMaxHeap.poll();
        }

        return finalCapital;
    }


    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> profitMaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < profits.length; i++) {
            capitalMinHeap.offer(new int[]{profits[i], capital[i]});
        }

        int finalCapital = w;

        while (k-- > 0) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[1] <= finalCapital) {
                profitMaxHeap.offer(capitalMinHeap.poll());
            }
            if (profitMaxHeap.isEmpty()) {
                break;
            }
            finalCapital += profitMaxHeap.poll()[0];
        }

        return finalCapital;
    }


    public static void main(String[] args) {
        IPO task = new IPO();
        System.out.println(task.findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
        System.out.println(task.findMaximizedCapital(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}));
    }

}
