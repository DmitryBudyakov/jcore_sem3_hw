package ru.gb.jcore.sem3.hw;

public class Chief extends Employee {
    public Chief(String fio, String position, String phone, float salary, int age) {
        super(fio, position, phone, salary, age);
    }

    static void increaseSalary(Employee[] employees, int upperAge, int addedSalary) {
        if (employees == null || upperAge < 0 || addedSalary < 0) {
            System.out.println("Неверные параметры");
            return;
        }
        for (Employee e : employees) {
            if (!(e instanceof Chief)) {
                if (e.getAge() > upperAge) {
                    e.setSalary(e.getSalary() + addedSalary);
                }
            }
        }
    }

    @Override
    public String toString() {
//        return super.toString();
        StringBuilder stringBuilder = new StringBuilder("Руководитель: [");
        stringBuilder.append(this.getFio());
        stringBuilder.append(", ");
        stringBuilder.append(this.getPosition());
        stringBuilder.append(", ");
        stringBuilder.append(this.getPhone());
        stringBuilder.append(", ");
        stringBuilder.append(this.getSalary());
        stringBuilder.append(", ");
        stringBuilder.append(this.getAge());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
