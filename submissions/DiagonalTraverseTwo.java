// Question: https://leetcode.com/problems/diagonal-traverse-ii/description/

class DiagonalTraverseTwo {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> lists = new ArrayList<>();
        boolean isTest = false;
        int count = 0;
        int index = 0;
        int[] result = null;

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);

            for (int j = 0; j < row.size(); j++) {
                index = i + j;
                if (lists.size() < index + 1) {
                    lists.add(new ArrayList<>());
                }
                lists.get(index).add(row.get(j));
                count++;
            }
        }

        result = new int[count];
        index = 0;
        for (List<Integer> list: lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                result[index++] = list.get(i);
            }
        }
        if (isTest) {
            display("nums:", nums);
            display("lists:", lists);
            System.out.println("result: " + Arrays.toString(result));
        }

        return result;
    }

    private void display(String sentence, List<List<Integer>> list) {
        System.out.println(sentence);
        for (List<Integer> e: list) {
            System.out.println(" * " + e);
        }
        System.out.println("------------------------------------------------------------");
    }
}