// Question: https://leetcode.com/problems/employee-importance/description/

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        int maximumId = -1;
        for (Employee e: employees) {
            maximumId = Math.max(maximumId, e.id);
        }

        Employee[] employeeArray = new Employee[maximumId + 1];
        for (Employee e: employees) {
            employeeArray[e.id] = e;
        }

        return dfs(employeeArray[id], employeeArray);
    }

    private int dfs(Employee current, Employee[] employeeArray) {
        if (current == null) {
            return 0;
        }

        int importance = current.importance;
        for (int subordinateId: current.subordinates) {
            Employee subordinate = employeeArray[subordinateId];
            importance += dfs(subordinate, employeeArray);
        }

        return importance;
    }
}