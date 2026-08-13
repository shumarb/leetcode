// Question: https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/description/

class MinimumHoursOfTrainingToWinACompetition {
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

            if (initialEnergy > currentEnergy && initialExperience > currentExperience) {
                initialEnergy -= currentEnergy;
                initialExperience += currentExperience;

            } else {
                while (initialEnergy <= currentEnergy) {
                    initialEnergy++;
                    result++;
                }

                while (initialExperience <= currentExperience) {
                    initialExperience++;
                    result++;
                }

                initialEnergy -= currentEnergy;
                initialExperience += currentExperience;
            }

            if (isTest) {
                System.out.println("\n * after, initialEnergy: " + initialEnergy + ", initialExperience: " + initialExperience + ", result: " + result);
                System.out.println("-----------------------------------------------------------------");
            }
        }

        return result;
    }
}
