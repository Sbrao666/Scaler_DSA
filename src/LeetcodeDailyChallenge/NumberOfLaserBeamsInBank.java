package LeetcodeDailyChallenge;

public class NumberOfLaserBeamsInBank {
    public static void main(String[] args) {
        String[] bank = {"00000", "00101", "10100", "11110", "11100", "01001", "00100", "11010"};
        System.out.println(numberOfBeams(bank));
    }

    private static int numberOfBeams(String[] bank) {
        int totalBeams = 0;

        int currentLesser = 0;
        for (int i = 0; i < bank[0].length(); i++) {
            if (bank[0].charAt(i) == '1') currentLesser++;
        }
        int prevLesser = currentLesser;

        for (int i = 1; i < bank.length; i++) {
            currentLesser = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') currentLesser++;
            }

            if (currentLesser == 0) continue;

            if (prevLesser > 0) {
                totalBeams += (currentLesser * prevLesser);
                prevLesser = currentLesser;
            }
        }

        return totalBeams;
    }
}
