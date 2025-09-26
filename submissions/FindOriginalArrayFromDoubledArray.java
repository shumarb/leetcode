// Question: https://leetcode.com/problems/find-original-array-from-doubled-array/description/

class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = false;
        int i = 0;
        int n = changed.length;
        int[] result = new int[n / 2];

        if (n % 2 == 1) {
            return new int[0];
        }

        Arrays.fill(result, -1);
        Arrays.sort(changed);
        if (isTest) {
            System.out.println("start, queue: " + queue);
        }
        for (int number: changed) {
            if (isTest) {
                System.out.println("--------------------------------------------------------------");
                System.out.println("number: " + number);
                System.out.println(" * before, queue: " + queue + " | result: " + Arrays.toString(result));
            }
            if (!queue.isEmpty() && queue.peek() == number) {
                result[i++] = queue.poll() / 2;
            } else {
                queue.offer(number * 2);
            }
            if (isTest) {
                System.out.println(" * after, queue: " + queue + " | result: " + Arrays.toString(result));
            }
        }
        if (isTest) {
            System.out.println("final, queue: " + queue);
            System.out.println("--------------------------------------------------------------\nresult: " + Arrays.toString(result));
        }

        return queue.isEmpty() ? result : new int[0];
    }
}