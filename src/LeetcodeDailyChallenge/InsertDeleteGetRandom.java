package LeetcodeDailyChallenge;

import java.util.HashSet;

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(10);
        boolean param_11 = obj.insert(100);
        boolean param_2 = obj.remove(100);
        int param_3 = obj.getRandom();
    }
}


class RandomizedSet {

    HashSet<Integer> set;

    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        if (!set.contains(val)) return false;
        set.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val)) return false;
        set.remove(val);
        return true;
    }

    public int getRandom() {
        int setSize = set.size();
        int randomize = (int) (Math.random() * setSize);

        int value = 0;
        for (int i : set) {
            if (randomize == 0) {
                value = i;
                break;
            }
            randomize--;
        }


        return value;
    }
}
