package LeetcodeDailyChallenge;

public class DetermineStringHalvesAreAlike {
    public static void main(String[] args) {
        String s = "textbook";
        System.out.println(halvesAreAlike(s));
    }

    private static boolean halvesAreAlike(String s) {
        String vowels = "AEIOUaeiou";
        int i = 0;
        int j = s.length() - 1;
        int count = 0;
        while (i < j) {
            if (vowels.indexOf(s.charAt(i)) != -1) count++;
            if (vowels.indexOf(s.charAt(j)) != -1) count--;
            i++;
            j--;
        }

        return count == 0;
    }
}
