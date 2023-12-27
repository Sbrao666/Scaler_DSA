package LeetcodeDailyChallenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PathCrossing {
    public static void main(String[] args) {
        String path = "NES";
        System.out.println(isPathCrossing(path));
    }

    private static boolean isPathCrossing(String path) {
        Map<Character, Pair<Integer, Integer>> moves = new HashMap<>();
        moves.put('N', new Pair<>(0, 1));
        moves.put('S', new Pair<>(0, -1));
        moves.put('W', new Pair<>(-1, 0));
        moves.put('E', new Pair<>(1, 0));

        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair<>(0, 0));

        int x = 0;
        int y = 0;

        for (Character c : path.toCharArray()) {
            Pair<Integer, Integer> curr = moves.get(c);
            int dx = curr.getKey();
            int dy = curr.getValue();
            x += dx;
            y += dy;

            Pair<Integer, Integer> pair = new Pair<>(x, y);
            if (visited.contains(pair)) {
                return true;
            }

            visited.add(pair);
        }

        return false;

    }

    static class Pair<T1, T2> {
        T1 key;
        T2 value;

        public Pair(T1 key, T2 value) {
            this.key = key;
            this.value = value;
        }

        public T1 getKey() {
            return key;
        }

        public T2 getValue() {
            return value;
        }
    }

}
