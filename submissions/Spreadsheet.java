// Question: https://leetcode.com/problems/design-spreadsheet/description/

class Spreadsheet {
    private Map<String, Integer> map;
    private boolean isTest;
    private int totalColumns;
    private int totalRows;

    public Spreadsheet(int rows) {
        isTest = false;
        map = new HashMap<>();
        totalColumns = 26;
        totalRows = rows;
    }

    public void setCell(String cell, int value) {
        int row = Integer.parseInt(cell.substring(1));
        char column = cell.charAt(0);

        if (isTest) {
            System.out.println("row: " + row + ", column: " + column);
            System.out.println("-----------------------");
        }
        if (row <= totalRows && column >= 'A' && column <= 'Z') {
            map.put(cell, value);
        }
    }

    public void resetCell(String cell) {
        if (map.containsKey(cell)) {
            map.put(cell, 0);
        }
    }

    public int getValue(String formula) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        char[] tokens = formula.toCharArray();
        int i = 1;
        int n = tokens.length;

        for (; i < n; i++) {
            if (tokens[i] == '+') {
                break;
            }
            first.append(tokens[i]);
        }

        // 1. Skip +.
        i++;
        for (; i < n; i++) {
            second.append(tokens[i]);
        }

        int firstValue = getValue(first.toString(), map);
        int secondValue = getValue(second.toString(), map);

        if (isTest) {
            System.out.println("formula: " + formula + "\nmap: " + map + "\nfirst: " + first + " -> firstValue: " + firstValue);
            System.out.println("second: " + second + " -> secondValue: " + secondValue + "\nresult: " + (firstValue + secondValue));
            System.out.println("------------------------------");
        }

        return firstValue + secondValue;
    }

    private int getValue(String key, Map<String, Integer> map) {
        char c = key.charAt(0);
        return c >= 'A' && c <= 'Z' ? map.getOrDefault(key, 0) : Integer.parseInt(key);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
