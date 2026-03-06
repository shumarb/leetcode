// Question: https://leetcode.com/problems/zigzag-conversion/description/

class ZigzagConversion {
    public String convert(String s, int numRows) {
        // 1. Edge case: Only 1 row required, so all characters are in the same row.
        // Hence, the final result is the original string.
        if (numRows == 1) {
            return s;
        }

        List<List<Character>> list = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        boolean isAscending = true;
        boolean isTest = false;
        int index = 0;

        for (int i = 0; i < numRows; i++) {
            List<Character> newRow = new ArrayList<>();
            list.add(newRow);
        }
        for (char c: s.toCharArray()) {
            if (index == 0) {
                isAscending = true;
            } else if (index == numRows - 1) {
                isAscending = false;
            }
            if (isTest) {
                System.out.println(" * c: " + c + " -> list number: " + index);
            }

            list.get(index).add(c);
            if (isAscending) {
                index++;
            } else {
                index--;
            }
        }
        for (List<Character> row: list) {
            for (char c: row) {
                result.append(c);
            }
        }
        if (isTest) {
            System.out.println("-------------------------------------------------------\nlist:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(" * " + i + " -> " + list.get(i));
            }
            System.out.println("-------------------------------------------------------\nresult: " + result);
        }

        return result.toString();
    }
}