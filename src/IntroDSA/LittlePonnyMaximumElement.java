package IntroDSA;

public class LittlePonnyMaximumElement {
    public static void main(String[] args) {
        int[] A = {1,4,2};
        int B = 3;
        System.out.println(getTheMinElementRequiredToCompleteOperation(A, B));
    }

    private static int getTheMinElementRequiredToCompleteOperation(int[] A, int B) {
        boolean isBPresent = isBPresentInTheArray(A, B);
        if (!isBPresent) return -1;
        return minElementRequired(A, B);
    }

    private static int minElementRequired(int[] A, int B) {
        int cnt = 0;
        for (int i : A) {
            if (i > B) cnt++;
        }
        return cnt == 0 ? -1 : cnt;
    }

    private static boolean isBPresentInTheArray(int[] A, int B) {
        for (int i : A) if (i == B) return true;
        return false;
    }
}
