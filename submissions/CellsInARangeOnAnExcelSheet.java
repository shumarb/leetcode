// Question: https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/description/

class CellsInARangeOnAnExcelSheet {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        boolean isTest = false;
        char firstDigit = s.charAt(1);
        char firstLetter = s.charAt(0);
        char lastDigit = s.charAt(4);
        char lastLetter = s.charAt(3);

        for (char i = firstLetter; i <= lastLetter; i++) {
            StringBuilder current = new StringBuilder();
            current.append(i);
            for (char j = firstDigit; j <= lastDigit; j++) {
                current.append(j);
                if (isTest) {
                    System.out.println(" * add: " + current);
                }
                result.add(current.toString());
                current.setLength(1);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------\nresult: " + result);
        }

        return result;
    }
}