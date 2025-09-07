// Question: https://leetcode.com/problems/pascals-triangle-ii/description/

class PascalsTriangleTwo {
    private boolean isTest;
    private int rowIndex;

    public List<Integer> getRow(int rowIndex) {
        List<Integer> currentRow = new ArrayList<>();
        currentRow.add(1);
        isTest = false;
        this.rowIndex = rowIndex;

        if (isTest) {
            System.out.println("rowIndex: " + rowIndex);
            System.out.println("------------------------------------------");
        }

        return helper(currentRow, 0);
    }

    private List<Integer> helper(List<Integer> currentRow, int currentIndex) {
        if (isTest) {
            System.out.println("currentIndex: " + currentIndex + " -> currentRow: " + currentRow);
        }

        if (rowIndex == currentIndex) {
            return currentRow;
        }

        if (rowIndex < 2) {
            currentRow.add(1);
            return helper(currentRow, currentIndex + 1);
        }

        List<Integer> newRow = new ArrayList<>();
        newRow.add(1);
        for (int i = 0; i < currentRow.size() - 1; i++) {
            newRow.add(currentRow.get(i) + currentRow.get(i + 1));
        }
        newRow.add(1);

        return helper(newRow, currentIndex + 1);
    }
}