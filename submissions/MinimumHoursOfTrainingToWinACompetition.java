// Question: https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/description/

class MinimumHoursOfTrainingToWinACompetition class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        boolean isTest = false;
        int n = energy.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (isTest) {
                System.out.println("i: " + i + "\n * before, initialEnergy: " + initialEnergy + ", initialExperience: " + initialExperience + ", result: " + result);
            }

            int currentEnergy = energy[i];
            int currentExperience = experience[i];
            int difference = 0;

            if (initialEnergy <= currentEnergy) {
                difference = Math.abs(initialEnergy - currentEnergy) + 1;
                initialEnergy += difference;
                result += difference;
            }

            if (initialExperience <= currentExperience) {
                difference = Math.abs(initialExperience - currentExperience) + 1;
                initialExperience += difference;
                result += difference;
            }

            initialEnergy -= currentEnergy;
            initialExperience += currentExperience;

            if (isTest) {
                System.out.println("\n * after, initialEnergy: " + initialEnergy + ", initialExperience: " + initialExperience + ", result: " + result);
                System.out.println("-----------------------------------------------------------------");
            }
        }

        return result;
    }
}
