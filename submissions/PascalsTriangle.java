// Question: https://leetcode.com/problems/pascals-triangle/description/

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;

        for (int i = 0; i < 2; i++) {
            if (i == numRows) {
                break;
            }
            List<Integer> e = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                e.add(1);
            }
            result.add(e);
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> e = new ArrayList<>();
            List<Integer> previous = result.get(i - 1);
            e.add(1);
            for (int j = 0; j < previous.size() - 1; j++) {
                int incoming = previous.get(j) + previous.get(j + 1);
                e.add(incoming);
            }
            e.add(1);
            result.add(e);
        }
        if (isTest) {
            System.out.println("result:");
            for (List<Integer> e: result) {
                System.out.println(e);
            }
            System.out.println("-------------------------------------");
        }

        return result;
    }
}