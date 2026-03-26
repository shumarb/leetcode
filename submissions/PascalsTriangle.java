// Question: https://leetcode.com/problems/pascals-triangle/description/

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        boolean isTest = false;

        result.add(List.of(1));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> incoming = new ArrayList<>();
            List<Integer> previous = result.get(result.size() - 1);

            incoming.add(1);
            for (int j = 0; j < previous.size() - 1; j++) {
                incoming.add(previous.get(j) + previous.get(j + 1));
            }
            incoming.add(1);

            result.add(incoming);
        }
        if (isTest) {
            System.out.println("result:");
            for (List<Integer> row: result) {
                System.out.println(row);
            }
        }

        return result;
    }
}
