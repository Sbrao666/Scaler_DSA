package LeetcodeDailyChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;


//https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/?envType=daily-question&envId=2023-11-19

public class MakeArrayElementsEqual {

    public static void main(String[] args) {
        int[] A = {5, 1, 3};
        System.out.println(reductionOperations_I(A));
        System.out.println(reductionOperations_II(A));

    }

//    More optimized
    private static int reductionOperations_II(int[] A) {
        Arrays.sort(A);
        int operations = 0;
        int up = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                up++;
            }

            operations += up;
        }

        return operations;
    }

    private static int reductionOperations_I(int[] A) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>((Pair p1, Pair p2) -> p2.key - p1.key);
        HashMap<Integer, Integer> map = getFreqMap(A);
        map.forEach((key, value) -> {
            maxHeap.add(new Pair(key, value));
        });
        int operations = 0;
        while (maxHeap.size() != 1) {
            Pair largest = maxHeap.poll();
            int freq = largest.frequency;
            Pair nextLargest = maxHeap.poll();
            nextLargest.frequency += freq;
            maxHeap.add(nextLargest);
            operations += freq;
        }

        return operations;
    }

    private static HashMap<Integer, Integer> getFreqMap(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) map.put(a, map.getOrDefault(a, 0) + 1);
        return map;
    }

    static class Pair {
        int key;
        int frequency;

        public Pair(int key, int frequency) {
            this.key = key;
            this.frequency = frequency;
        }
    }
}
