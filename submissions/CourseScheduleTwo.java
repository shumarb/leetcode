// Question: https://leetcode.com/problems/course-schedule-ii/description/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        boolean isTest = false;
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: prerequisites) {
            int destination = edge[0];
            int source = edge[1];
            graph[source].add(destination);
            inDegree[destination]++;
        }
        if (isTest) {
            System.out.println("inDegree: " + Arrays.toString(inDegree));
            System.out.println("------------------------------\ngraph:");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
            System.out.println("------------------------------");
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int source = queue.poll();
            result[index++] = source;

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
            System.out.println("------------------------------\nresult: " + Arrays.toString(result) + "\nindex: " + index);
        }

        return index == numCourses ? result : new int[0];
    }
}
