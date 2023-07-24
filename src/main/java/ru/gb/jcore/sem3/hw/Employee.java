package ru.gb.jcore.sem3.hw;


public class Employee {
    private String fio;
    private String position;
    private String phone;
    private float salary;
    private int age;

    public Employee(String fio, String position, String phone, float salary, int age) {
        this.fio = fio;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    static void increaseSalary(Employee[] employees, int upperAge, int addedSalary) {
        if (employees == null || upperAge < 0 || addedSalary < 0) {
            System.out.println("Неверные параметры");
            return;
        }
        for (Employee e : employees) {
            if (e.age > upperAge) e.salary += addedSalary;
        }
    }

    public void increaseSalary(int addedSalary) {
        if (addedSalary < 0) {
            System.out.println("Неверные параметры");
            return;
        }
            this.salary += addedSalary;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
//        return super.toString();
        StringBuilder stringBuilder = new StringBuilder("Сотрудник: [");
        stringBuilder.append(this.fio);
        stringBuilder.append(", ");
        stringBuilder.append(this.position);
        stringBuilder.append(", ");
        stringBuilder.append(this.phone);
        stringBuilder.append(", ");
        stringBuilder.append(this.salary);
        stringBuilder.append(", ");
        stringBuilder.append(this.age);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
