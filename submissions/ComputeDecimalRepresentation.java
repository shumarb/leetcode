// Question: https://leetcode.com/problems/compute-decimal-representation/description/

class ComputeDecimalRepresentation {
    public int[] decimalRepresentation(int n) {
        List<Integer> list = new ArrayList<>();
        boolean isTest = false;
        int power = 0;
        int[] result;

        while (n > 0) {
            int digit = n % 10;
            int number = digit * (int) Math.pow(10.0, power++);
            if (isTest) {
                System.out.println("digit: " + digit + " -> number: " + number);
            }
            if (number > 0) {
                list.add(0, number);
            }
            n /= 10;
        }
        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        if (isTest) {
            System.out.println("list: " + list + "\nresult: " + Arrays.toString(result));
        }

        return result;
    }
}