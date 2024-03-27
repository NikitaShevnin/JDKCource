package Less4.HW;

/**
 * Обьявил поля и методы
 */

public class Employee {
    private int employeeId;
    private String phoneNumber;
    private String name;
    private int experience;

    //Табельный номер
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Номер телефона
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Имя
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Стаж
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}