package LeetcodeDailyChallenge;

//https://leetcode.com/problems/assign-cookies/

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] s = {1, 1};
        int[] g = {1, 2, 3};
        System.out.println(findContentChildren(g, s));

    }

    private static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length) {
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }
}
