// Question: https://leetcode.com/problems/maximum-population-year/description/

class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        boolean isTest = false;
        int maximumPopulation = 0;
        int maximumPopulationYear = 0;
        int[] population = new int[2051];

        for (int[] log: logs) {
            for (int i = log[0]; i <= log[1] - 1; i++) {
                population[i]++;
                if (population[i] > maximumPopulation) {
                    maximumPopulation = population[i];
                    maximumPopulationYear = i;
                } else if (population[i] == maximumPopulation && i < maximumPopulationYear) {
                    maximumPopulationYear = i;
                }
            }
        }

        if (isTest) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("maximum population year: " + maximumPopulationYear);
            System.out.println("maximum population: " + maximumPopulation);
            System.out.println("population:");
            for (int i = 1950; i < 2051; i++) {
                System.out.println(i + " --> " + population[i]);
            }
        }

        return maximumPopulationYear;
    }
}