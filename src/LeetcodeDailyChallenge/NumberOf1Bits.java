package LeetcodeDailyChallenge;

public class NumberOf1Bits {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(hammingWeight(n));
    }

    private static int hammingWeight(int n) {
        int cnt = 0;
        boolean negativeFlag = false;
        // if the number is negative then reverse the 2s complement
        if (n < 0) {
            n = n & ~(1 << 31);
            negativeFlag = true;
        }
        while (n > 0) {
            n = (n & (n - 1));
            ++cnt;
        }
        return negativeFlag ? cnt + 1 : cnt;
    }
}
