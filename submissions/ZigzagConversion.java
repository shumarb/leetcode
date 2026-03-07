// Question: https://leetcode.com/problems/zigzag-conversion/description/

class ZigzagConversion {
    public String convert(String s, int numRows) {
        // 1. Edge case: Only 1 row required, so all characters are in the same row.
        // Hence, the final result is the original string.
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        StringBuilder[] entries = new StringBuilder[numRows];
        StringBuilder result = new StringBuilder();
        boolean isAscending = true;
        boolean isTest = false;
        int index = 0;

        for (int i = 0; i < entries.length; i++) {
            entries[i] = new StringBuilder();
        }
        for (char c: s.toCharArray()) {
            if (index == 0) {
                isAscending = true;
            } else if (index == numRows - 1) {
                isAscending = false;
            }
            if (isTest) {
                System.out.println(" * c: " + c + " -> entry number: " + index);
            }

            entries[index].append(c);
            if (isAscending) {
                index++;
            } else {
                index--;
            }
        }
        for (StringBuilder current: entries) {
            result.append(current);
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------\nentries:");
            for (int i = 0; i < numRows; i++) {
                System.out.println(" * " + i + ": " + entries[i]);
            }
            System.out.println("-------------------------------------------------------\nresult: " + result);
        }

        return result.toString();
    }
}