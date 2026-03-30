// Question: https://leetcode.com/problems/course-schedule/description/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = false;
        int[] inDegree = new int[numCourses];
        int countCompletedCourses = 0;

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: prerequisites) {
            int destination = edge[1];
            int source = edge[0];
            graph[source].add(destination);
            inDegree[destination]++;
        }
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree) + "\n-------------------------\ngraph:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
            System.out.println("-------------------------");
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int source = queue.poll();
            countCompletedCourses++;
            if (isTest) {
                System.out.println(" * completed: " + source);
            }

            for (int neighbour: graph[source]) {
                if (--inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        if (isTest) {
            System.out.println("-------------------------\ncompleted courses: " + countCompletedCourses);
        }

        return countCompletedCourses == numCourses;
    }
}
