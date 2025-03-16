// Question: https://leetcode.com/problems/find-k-closest-elements/description/

class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;

        for (int number: arr) {
            list.add(number);
        }
        list.sort((a, b) -> Integer.compare(Math.abs(a - x), Math.abs(b - x)) == 0
                ? Integer.compare(a, b)
                : Integer.compare(Math.abs(a - x), Math.abs(b - x))
        );
        if (isTest) {
            System.out.println("arr: " + Arrays.toString(arr) + "\nk: " + k + "\nx: " + x + "\nlist: " + list);
        }

        for (int i = 0; i < k; i++) {
            result.add(list.get(i));
        }
        countingSort(result);
        if (isTest) {
            System.out.println("sorted result: " + result);
        }

        return result;
    }

    private void countingSort(List<Integer> result) {
        int[] numberFrequency = new int[20001];
        for(int number: result) {
            numberFrequency[number + 10000]++;
        }

        int j = 0;
        for (int i = 0; i < numberFrequency.length; i++) {
            while (numberFrequency[i] > 0) {
                result.set(j++, i - 10000);
                numberFrequency[i]--;
            }
        }
    }
}