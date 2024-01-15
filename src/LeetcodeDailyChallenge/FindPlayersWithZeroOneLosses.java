package LeetcodeDailyChallenge;

//https://leetcode.com/problems/find-players-with-zero-or-one-losses/

import java.util.*;

public class FindPlayersWithZeroOneLosses {
    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> list = findWinners(matches);
        System.out.println(list);
    }

    private static List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        for (int[] match : matches) {
            int loser = match[1];
            map.put(loser, map.getOrDefault(loser, 0) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value == 0) list.get(0).add(key);

            if (value == 1) list.get(1).add(key);
        }

        Collections.sort(list.get(0));
        Collections.sort(list.get(1));


        return list;

    }
}
