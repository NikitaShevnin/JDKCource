package Less4.HW;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        Employee employee1 = new Employee();
        employee1.setEmployeeId(1);
        employee1.setPhoneNumber("+123456789");
        employee1.setName("John");
        employee1.setExperience(5);
        directory.addEmployee(employee1);

        List<Employee> employeesWithExperience5 = directory.findEmployeesByExperience(5);
        for (Employee employee : employeesWithExperience5) {
            System.out.println(employee.getName());
        }

        String phoneNumber = directory.findPhoneNumberByName("John");
        System.out.println(phoneNumber);
    }
}