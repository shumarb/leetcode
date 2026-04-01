// Question: https://leetcode.com/problems/course-schedule-iv/description/

class CourseScheduleFour {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] isAncestor = new boolean[numCourses][numCourses];
        boolean isTest = false;
        int[] inDegree = new int[numCourses];

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
            System.out.println("inDegree: " + Arrays.toString(inDegree) + "\n-----------------------------------------\ngraph: ");
            for (int i = 0; i < graph.length; i++) {
                System.out.println(" * " + i + ": " + graph[i]);
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int source = queue.poll();
            List<Integer> destinations = graph[source];

            for (int destination: destinations) {
                isAncestor[destination][source] = true;

                for (int i = 0; i < isAncestor.length; i++) {
                    if (isAncestor[source][i]) {
                        isAncestor[destination][i] = true;
                    }
                }
                if (--inDegree[destination] == 0) {
                    queue.offer(destination);
                }
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------\nisAncestor: ");
            for (int i = 0; i < isAncestor.length; i++) {
                boolean[] row = isAncestor[i];
                System.out.println(" * " + i + ": " + Arrays.toString(row));
            }
        }

        for (int[] edge: queries) {
            int destination = edge[1];
            int source = edge[0];
            if (isAncestor[destination][source]) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        if (isTest) {
            System.out.println("-----------------------------------------\nresult: " + result);
        }

        return result;
    }
}
