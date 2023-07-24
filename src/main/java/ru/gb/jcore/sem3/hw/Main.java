package ru.gb.jcore.sem3.hw;

public class Main {
    public static void main(String[] args) {
        // создание массива из 5 сотрудников
        Employee[] employees = new Employee[]{
                new Employee("Иванов Иван Иванович", "инженер", "89161234567", 52000, 25),
                new Employee("Петров Петр Петрович", "оператор", "89104321567", 55000, 46),
                new Employee("Сидоров Матвей Иванович", "тестировщик", "89067654321", 45000, 24),
                new Employee("Гаврилов Игорь Михайлович", "инженер", "89857654123", 53000, 52),
                new Employee("Михайлов Андрей Олегович", "разработчик", "89194567321", 65000, 29)
        };

        System.out.println("Список сотрудников:");
        printOutAllEmployees(employees);
        // Средняя зарплата сотрудников:
        System.out.println("Средняя зарплата сотрудников: " + countAverageSalary(employees));

        int upperAge = 45;
        int addedSalary = 5000;

        // Повышение зарплаты через метод в Employee
        increaserSalary(employees, upperAge, addedSalary);

        System.out.println();
        System.out.printf("Список сотрудников после повышения зарплаты на %d для тех, кто старше %d через метод в классе Employee:" +
                System.lineSeparator(), addedSalary, upperAge);
        printOutAllEmployees(employees);

        // Средняя зарплата сотрудников:
        System.out.println("Средняя зарплата сотрудников: " + countAverageSalary(employees));

        // Повышение зарплаты через static метод в Employee
        Employee.increaseSalary(employees, upperAge, addedSalary);

        System.out.println();
        System.out.printf("Список сотрудников после повышения зарплаты на %d для тех, кто старше %d через static метод в классе Employee:" +
                System.lineSeparator(), addedSalary, upperAge);
        printOutAllEmployees(employees);

        // Средняя зарплата сотрудников:
        System.out.println("Средняя зарплата сотрудников: " + countAverageSalary(employees));

        // Добавление руководителя к общему списку сотрудников:
        Employee[] employeesExt = new Employee[employees.length + 1];
        System.arraycopy(employees, 0, employeesExt, 0, employees.length);
        employeesExt[employeesExt.length - 1] = new Chief("Степанов Степан Степанович", "менеджер", "89857654321", 45000, 48);

        // Список сотрудников с руководителем:
        System.out.println();
        System.out.println("Список сотрудников после добавления руководителя:");
        printOutAllEmployees(employeesExt);

        // Средняя зарплата сотрудников:
        System.out.println("Средняя зарплата сотрудников: " + countAverageSalary(employeesExt));

        // Повышение зарплаты через static метод в Chief
        Chief.increaseSalary(employeesExt, upperAge, addedSalary);

        System.out.println();
        System.out.printf("Список сотрудников после повышения зарплаты на %d для тех, кто старше %d через static метод в классе Chief:" +
                System.lineSeparator(), addedSalary, upperAge);
        printOutAllEmployees(employeesExt);

        // Средний возраст сотрудников:
        System.out.println();
        System.out.println("Средний возраст сотрудников: " + countAverageAge(employeesExt));

        // Средняя зарплата сотрудников:
        System.out.println("Средняя зарплата сотрудников: " + countAverageSalary(employeesExt));

    }

    public static void increaserSalary(Employee[] emp, int upperAge, int addedSalary) {
        if (emp == null || upperAge < 0 || addedSalary < 0) {
            System.out.println("Неверные параметры");
            return;
        }
        for (Employee e : emp) {
            if (e.getAge() > upperAge) {
                e.setSalary(e.getSalary() + addedSalary);
            }
        }
    }

    public static float countAverageAge(Employee[] emp) {
        if (emp == null) {
            System.out.println("Список пустой");
            return 0;
        }
        float totalAge = 0;
        for (Employee e : emp) {
            totalAge += e.getAge();

        }
        return totalAge / emp.length;
    }

    public static float countAverageSalary(Employee[] emp) {
        if (emp == null) {
            System.out.println("Список пустой");
            return 0;
        }
        float totalSalary = 0;
        for (Employee e : emp) {
            totalSalary += e.getSalary();
        }
        return totalSalary / emp.length;
    }


    public static void printOutAllEmployees(Employee[] emp) {
        if (emp == null) {
            System.out.println("Список сотрудников пустой");
            return;
        }
        for (Employee e : emp) {
            System.out.println(e.toString());
        }
    }
}
