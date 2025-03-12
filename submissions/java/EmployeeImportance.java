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
        int importance = 0;
        Employee[] employeeArray = populate(employees);

        Employee target = findEmployee(id, employeeArray);
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(target);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Employee current = queue.poll();
                importance += current.importance;
                if (current.subordinates.size() > 0) {
                    for (int subordinateId: current.subordinates) {
                        Employee subordinate = findEmployee(subordinateId, employeeArray);
                        queue.offer(subordinate);
                    }
                }
            }
        }

        return importance;
    }

    private Employee findEmployee(int id, Employee[] employeeArray) {
        return (employeeArray[id] == null) ? null : employeeArray[id];
    }

    private Employee[] populate(List<Employee> employees) {
        int maximumId = -1;
        for (Employee e: employees) {
            maximumId = Math.max(maximumId, e.id);
        }
        Employee[] employeeArray = new Employee[maximumId + 1];
        for (Employee e: employees) {
            employeeArray[e.id] = e;
        }
        return employeeArray;
    }
}