// Question: https://leetcode.com/problems/k-items-with-the-maximum-sum/description/

class KItemsWithTheMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        List<Integer> elements = new ArrayList<>();
        boolean isTest = false;
        int maximumSum = 0;

        populate(elements, -1, numNegOnes);
        populate(elements, 0, numZeros);
        populate(elements, 1, numOnes);
        if (isTest) {
            System.out.println("numNegOnes: " + numNegOnes + ", numZeros: " + numZeros + ", numOnes: " + numOnes + ", k: " + k);
            System.out.println("elements: " + elements);
        }

        int j = elements.size() - 1;
        for (int i = 0; i < k; i++) {
            maximumSum += elements.get(j--);
        }

        return maximumSum;
    }

    private void populate(List<Integer> elements, int number, int count) {
        for (int i = 0; i < count; i++) {
            elements.add(number);
        }
    }
}