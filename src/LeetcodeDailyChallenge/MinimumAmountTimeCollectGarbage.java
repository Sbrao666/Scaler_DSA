package LeetcodeDailyChallenge;


import java.util.HashMap;

//https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/?envType=daily-question&envId=2023-11-20
public class MinimumAmountTimeCollectGarbage {
    public static void main(String[] args) {
        String[] garbage = {"G", "M", "P"};
        int[] travel = {1, 3};
        System.out.println(garbageCollection(garbage, travel));
    }

    private static int garbageCollection(String[] garbage, int[] travel) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> highestIndexMap = getHighestIndexMap(garbage);
        map.put('M', 0);
        map.put('P', 0);
        map.put('G', 0);
        for (int i = 0; i < garbage.length; i++) {
            boolean isMDone = false;
            boolean isPDone = false;
            boolean isGDone = false;
            for (int j = 0; j < garbage[i].length(); j++) {
                char currentChar = garbage[i].charAt(j);
                map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

                if (i > 0) {
                    if (highestIndexMap.get('M') >= i && !isMDone) {
                        map.put('M', map.get('M') + travel[i - 1]);
                        isMDone = true;
                    }
                    if (highestIndexMap.get('P') >= i && !isPDone) {
                        map.put('P', map.get('P') + travel[i - 1]);
                        isPDone = true;
                    }
                    if (highestIndexMap.get('G') >= i && !isGDone) {
                        map.put('G', map.get('G') + travel[i - 1]);
                        isGDone = true;
                    }
                }
            }


        }

        return map.get('M') +
                map.get('G') +
                map.get('P');
    }

    private static HashMap<Character, Integer> getHighestIndexMap(String[] garbage) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 0);
        map.put('P', 0);
        map.put('G', 0);

        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                char currentChar = garbage[i].charAt(j);
                map.put(currentChar, i);
            }
        }
        return map;
    }
}
