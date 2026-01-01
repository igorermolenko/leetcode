package com.leetcode;

public class GasStation {

    public int canCompleteCircuit2(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i] && canCompleteCircuit(gas, cost, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canCompleteCircuit(int[] gas, int[] cost, int start) {
        int gasBalance = 0;
        for (int i = start; i < gas.length; i++) {
            gasBalance = gasBalance + gas[i] - cost[i];
            if (gasBalance < 0) {
                return false;
            }
        }

        for (int i = 0; i < start; i++) {
            gasBalance = gasBalance + gas[i] - cost[i];
            if (gasBalance < 0) {
                return false;
            }
        }
        return true;
    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        int currentGas = 0;
        int idx = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            currentGas = currentGas + gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                idx = i + 1;
            }
        }
        return totalGas >= totalCost ? idx : -1;
    }


    public static void main(String[] args) {
        GasStation task = new GasStation();
        System.out.println(task.canCompleteCircuit(new int[]{2}, new int[]{2}));
        System.out.println(task.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(task.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
