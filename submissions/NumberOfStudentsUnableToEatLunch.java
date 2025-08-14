// Question: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int countStudent0 = 0;
        int countStudent1 = 0;

        for (int student: students) {
            if (student == 0) {
                countStudent0++;
            } else {
                countStudent1++;
            }
        }
        for (int sandwich: sandwiches) {
            if (sandwich == 0) {
                if (countStudent0 == 0) {
                    break;
                } else {
                    countStudent0--;
                }

            } else {
                if (countStudent1 == 0) {
                    break;
                } else {
                    countStudent1--;
                }
            }
        }

        return countStudent0 + countStudent1;
    }
}