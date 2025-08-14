// Question: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int student0 = 0;
        int student1 = 0;

        for (int student: students) {
            if (student == 0) {
                student0++;
            } else {
                student1++;
            }
        }
        for (int sandwich: sandwiches) {
            if (sandwich == 0) {
                if (student0 == 0) {
                    break;
                } else {
                    student0--;
                }

            } else {
                if (student1 == 0) {
                    break;
                } else {
                    student1--;
                }
            }
        }

        return student0 + student1;
    }
}