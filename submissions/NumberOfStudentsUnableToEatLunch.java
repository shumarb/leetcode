// Question: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> sandwichesQueue = new LinkedList<>();
        Queue<Integer> studentsQueue = new LinkedList<>();
        boolean isTest = false;
        int countSandwich0 = 0;
        int countSandwich1 = 0;
        int countStudent0 = 0;
        int countStudent1 = 0;

        for (int student: students) {
            studentsQueue.offer(student);
            if (student == 0) {
                countStudent0++;
            } else {
                countStudent1++;
            }
        }
        for (int sandwich: sandwiches) {
            sandwichesQueue.offer(sandwich);
            if (sandwich == 0) {
                countSandwich0++;
            } else {
                countSandwich1++;
            }
        }

        while (!studentsQueue.isEmpty() && !sandwichesQueue.isEmpty()) {
            int sandwich = sandwichesQueue.peek();
            int student = studentsQueue.peek();
            if (isTest) {
                System.out.println("----------------------------------------------------------------------------------");
                System.out.println("studentsQueue: " + studentsQueue + ", sandwichesQueue: " + sandwichesQueue);
                System.out.println(" * sandwich: " + sandwich + ", student: " + student);
            }

            if (sandwich == student) {
                if (sandwich == 0) {
                    countSandwich0--;
                    countStudent0--;
                }
                if (sandwich == 1) {
                    countSandwich1--;
                    countStudent1--;
                }

                studentsQueue.poll();
                sandwichesQueue.poll();

            } else {
                // 1. Edge cases: No correct student available to collect correct sandwich.
                if ((sandwich == 0 && countStudent0 == 0) || (sandwich == 1 && countStudent1 == 0)) {
                    break;
                }
                studentsQueue.offer(studentsQueue.poll());
            }
        }

        return studentsQueue.size();
    }
}