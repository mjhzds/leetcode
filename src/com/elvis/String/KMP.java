package com.elvis.String;

public class KMP {
    public static void main(String[] args) {
        String model = "abc";
        String str = "acdbabcdacb";
        System.out.println(kmp(str, model));
    }

    private static int kmp(String str, String model) {
        if (str == null || model == null) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int[] next = getNextArray(model.toCharArray());
        while (i < str.length() && j < model.length()) {
            if (str.charAt(i) == model.charAt(j)) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == model.length() ? i - j : -1;
    }

    private static int[] getNextArray(char[] arr) {
        int[] next = new int[arr.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < arr.length) {
            if (arr[pos - 1] == arr[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }
}
