package Less4.HW;

import java.util.ArrayList;
import java.util.List;


public class EmployeeDirectory {
    private List<Employee> employees;

    /**
     *   Конструктор EmployeeDirectory():
     * - Создает новый экземпляр класса EmployeeDirectory;
     * - Инициализирует пустой список employees.
     */
    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    /**
    Метод addEmployee(Employee employee):
    - Добавляет объект сотрудника в список employees.
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Метод findEmployeesByExperience(int experience):
     * @param experience - Принимает на вход значение стажа;
     * @return - Возвращает список сотрудников, у которых стаж равен переданному значению.
     */
    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == experience) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * Метод findPhoneNumberByName(String name) - Ищет сотрудника по имени в списке employees;
     * @param name - Принимает на вход имя сотрудника;
     * @return - Возвращает номер телефона найденного сотрудника или null,
     * если сотрудник не найден.
     */
    public String findPhoneNumberByName(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee.getPhoneNumber();
            }
        }
        return null;
    }

    /**
     * Метод findEmployeeByEmployeeId(int employeeId) - Ищет сотрудника по табельному номеру
     * в списке employees;
     * @param employeeId - Принимает на вход табельный номер сотрудника;
     * @return - Возвращает найденного сотрудника или null, если сотрудник не найден.
     */
    public Employee findEmployeeByEmployeeId(int employeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        return null;
    }
}
