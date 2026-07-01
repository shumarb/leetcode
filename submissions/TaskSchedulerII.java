// Question: https://leetcode.com/problems/task-scheduler-ii/description/

class TaskSchedulerII {
    public long taskSchedulerII(int[] tasks, int space) {
        Map<Integer, Long> taskCompletionDay = new HashMap<>();
        boolean isTest = false;
        long result = 0;

        for (int task: tasks) {
            if (isTest) {
                System.out.println("day: " + result + "\ntask: " + task + "\n\n * before, taskCompletionDay: " + taskCompletionDay);
            }

            if (!taskCompletionDay.containsKey(task)) {
                result++;
            } else {
                result = Math.max(result + 1, taskCompletionDay.get(task) + space + 1);
            }

            taskCompletionDay.put(task, result);
            if (isTest) {
                System.out.println(" * after, taskCompletionDay: " + taskCompletionDay + "\n\ntask " + task + " completed on day " + result);
                System.out.println("----------------------------------------");
            }
        }
        if (isTest) {
            System.out.println("result: " + result);
        }

        return result;
    }
}
