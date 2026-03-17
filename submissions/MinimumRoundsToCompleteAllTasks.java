// Question: https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/

class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean isTest = false;
        int totalRounds = 0;

        for (int e: tasks) {
            map.put(e, 1 + map.getOrDefault(e, 0));
        }
        if (isTest) {
            System.out.println("tasks: " + Arrays.toString(tasks) + "\nmap: " + map);
            System.out.println("----------------------------------------------");
        }

        for (Map.Entry<Integer, Integer> e: map.entrySet()) {
            int difficulty = e.getKey();
            int value = e.getValue();

            if (value == 1) {
                return -1;
            }

            int completedRounds = (value + 2) / 3;
            totalRounds += completedRounds;

            if (isTest) {
                System.out.println(" * completed difficulty " + difficulty + " in " + completedRounds + " rounds");
            }
        }
        if (isTest) {
            System.out.println("----------------------------------------------\ntotal rounds: " + totalRounds);
        }

        return totalRounds;
    }
}
