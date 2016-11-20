import serializable.Employee;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee("Ivan", 21);
        employee.speak();
        Employee employee1 = new Employee();
        int i = 10;

        List<Employee> employees = new ArrayList<>();
        employees.add(employee);

        Employee[] employeesarr = employees.toArray(new Employee[employees.size()]);
        Human h1 = new Human("Ivan", 23);
    }
}
