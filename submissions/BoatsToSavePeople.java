// Question: https://leetcode.com/problems/boats-to-save-people/description/

class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        boolean isTest = false;
        int boats = 0;
        int left = 0;
        int right = people.length - 1;

        people = sort(people);
        if (isTest) {
            System.out.println("people: " + Arrays.toString(people) + "\nboats: " + boats);
            System.out.println("-------------------------------------------------------");
        }

        while (left <= right) {
            int sum = people[left] + people[right];
            if (isTest) {
                System.out.println(" * left:  " + left + " -> e: " + people[left]);
                System.out.println(" * right: " + right + " -> e: " + people[right] + "\n * sum: " + sum);
                System.out.println("-------------------------------------------------------");
            }
            if (sum <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        if (isTest) {
            System.out.println("boats: " + boats);
        }

        return boats;
    }

    private int[] sort(int[] arr) {
        int[] count;
        int j = 0;
        int largest = 0;

        for (int e: arr) {
            largest = Math.max(e, largest);
        }
        count = new int[largest + 1];
        for (int e: arr) {
            count[e]++;
        }

        for (int i = 1; i <= largest; i++) {
            while (count[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }
}