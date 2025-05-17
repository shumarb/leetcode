// Question: https://leetcode.com/problems/points-that-intersect-with-cars/description/

class PointsThatIntersectWithCars {
    public int numberOfPoints(List<List<Integer>> nums) {
        Stack<List<Integer>> stack = new Stack<>();
        boolean isTest = false;
        int numberOfPoints = 0;

        nums.sort((a, b) -> Integer.compare(a.get(0), b.get(0)));
        if (isTest) {
            System.out.println("sorted nums: ");
            for (List<Integer> entry: nums) {
                System.out.println(" * entry: " + entry);
            }
        }

        stack.push(nums.get(0));
        for (int i = 1; i < nums.size(); i++) {
            List<Integer> incoming = nums.get(i);
            if (incoming.get(0) <= stack.peek().get(1)) {
                stack.peek().set(1, Math.max(stack.peek().get(1), incoming.get(1)));
            } else {
                stack.push(incoming);
            }
        }
        if (isTest) {
            System.out.println("---------------------------------------------------");
            System.out.println("stack: ");
            for (List<Integer> entry: stack) {
                System.out.println(" * entry: " + entry);
            }
        }

        while (!stack.isEmpty()) {
            List<Integer> top = stack.pop();
            numberOfPoints += (top.get(1) - top.get(0) + 1);
        }
        if (isTest) {
            System.out.println("---------------------------------------------------");
            System.out.println("numberOfPoints: " + numberOfPoints);
        }

        return numberOfPoints;
    }
}