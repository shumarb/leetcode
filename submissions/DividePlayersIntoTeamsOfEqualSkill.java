// Question: https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/

class DividePlayersIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        boolean isTest = false;
        int left = 0;
        int right = skill.length - 1;
        long chemistry;
        long sumChemistry = 0;

        skill = sort(skill);
        chemistry = skill[0] + skill[skill.length - 1];
        if (isTest) {
            System.out.println("sorted skill: " + Arrays.toString(skill) + "\nchemistry: " + chemistry);
            System.out.println("-------------------------------------");
        }

        while (left < right) {
            long leftPlayer = (long) skill[left++];
            long rightPlayer = (long) skill[right--];
            if (isTest) {
                System.out.println(" * leftPlayer: " + leftPlayer + "\n * rightPlayer: " + rightPlayer);
                System.out.println(" ** team chemistry: " + (leftPlayer + rightPlayer));
                System.out.println("-------------------------------------");
            }
            if (leftPlayer + rightPlayer != chemistry) {
                return -1;
            }

            sumChemistry += (leftPlayer * rightPlayer);
        }
        if (isTest) {
            System.out.println("sum chemistry: " + sumChemistry);
        }

        return sumChemistry;
    }

    private int[] sort(int[] arr) {
        int[] frequency;
        int j = 0;
        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            largest = Math.max(arr[i], largest);
        }
        frequency = new int[largest + 1];
        for (int number: arr) {
            frequency[number]++;
        }

        for (int i = 1; i <= largest; i++) {
            while (frequency[i]-- > 0) {
                arr[j++] = i;
            }
        }

        return arr;
    }
}