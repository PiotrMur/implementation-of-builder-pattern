package com.excercise.practice;

import com.excercise.practice.auxiliary.ConsoleReader;
import com.excercise.practice.builder.AddressBuilder;
import com.excercise.practice.builder.OccupationBuilder;
import com.excercise.practice.builder.PersonalDataBuilder;
import com.excercise.practice.entity.*;
import com.excercise.practice.implementation.MyMap;
import com.excercise.practice.implementation.Repository;

import java.io.*;
import java.util.*;


public class MainApp {

    public static void main(String[] args) throws FileNotFoundException {

        Repository<UUID, Employee> employees = new MyMap<>();

        saveEmployeesFromTextFile(employees);

        boolean keepWorking = true;
        while (keepWorking) {

            System.out.println("Insert a number assign to action you would like to perform: \n" +
                    "1 - Add Employee \n" +
                    "2 - Update Employee's data\n" +
                    "3 - Delete Employee\n" +
                    "4 - Delete ALL Employees\n" +
                    "5 - Show Employees\n" +
                    ">5 - Close application\n");


            ConsoleReader consoleReader = new ConsoleReader();

            int decision = consoleReader.readDecision();

            switch (decision) {
                case 1 -> addEmployee(employees);
                case 2 -> updateEmployee(employees);
                case 3 -> deleteEmployee(employees);
                case 4 -> deleteAllEmployees(employees);
                case 5 -> showEmployees(employees);
                default -> {
                    System.out.println("Application has been terminated");
                    keepWorking = false;
                }
            }
        }

        System.out.println("Application is closing...");

    }


    private static final ConsoleReader consoleReader = new ConsoleReader();

    private static void deleteAllEmployees(Repository<UUID, Employee> employees) {
        System.out.println("Are you sure you want to delete ALL Employees? (Y/N)");
        String decision = (consoleReader.fetchInput());
        if ("y".equalsIgnoreCase(decision)) {
            employees.removeAll();
            System.out.println("Deleting was successful");
        } else {
            System.out.println("Deleting procedure has been aborted");
        }

    }

    private static void addEmployee(Repository<UUID, Employee> employees) {
        String iteration = "y";
        while ("y".equalsIgnoreCase(iteration)) {
            System.out.println("Add new Employee.");

            String firstName = consoleReader.readRequiredProperty("Insert employee's name (required): ");
            String lastName = consoleReader.readRequiredProperty("Insert employee's last name (required): ");
            String age = consoleReader.readOptionalProperty("Insert employee's age (optional): ");
            PersonalData pData = new PersonalDataBuilder(firstName, lastName).age(age).build();

            String street = consoleReader.readRequiredProperty("Insert employee's street (required): ");
            String city = consoleReader.readRequiredProperty("Insert employee's city (required): ");
            String streetNumber = consoleReader.readOptionalProperty("Insert employee's street number (optional): ");
            String district = consoleReader.readOptionalProperty("Insert employee's district (optional): ");
            Address address = new AddressBuilder(street, city, streetNumber).district(district).build();

            String education = consoleReader.readOptionalProperty("Insert employee's education (required): ");
            String company = consoleReader.readOptionalProperty("Insert employee's company (optional): ");
            Occupation occupation = new OccupationBuilder(education).company(company).build();

            Employee employee = new Employee(pData, address, occupation);
            employees.save(employee.getId(), employee);
            System.out.println("Would you like to add another employee (Y/N)?");
            iteration = consoleReader.fetchInput();
        }
    }


    private static void deleteEmployee(Repository<UUID, Employee> employees) {
        String iteration = "y";
        while ("y".equalsIgnoreCase(iteration)) {
            displayEmployees(employees);
            System.out.println("Delete Employee\nInsert employee's id: ");
            UUID empId = UUID.fromString(consoleReader.fetchInput());
            employees.remove(empId);
            displayEmployees(employees);
            System.out.println("Would you like to delete another employee (Y/N)?");
            iteration = consoleReader.fetchInput();
        }
    }

    private static void updateEmployee(Repository<UUID, Employee> employees) {
        String iteration = "y";
        while ("y".equalsIgnoreCase(iteration)) {
            displayEmployees(employees);

            UUID empId = UUID.fromString(consoleReader.readRequiredProperty("Update Employee's Personal data\nInsert employee's id: "));
            if (!employees.exists(empId)) {
                System.out.println("Key " + empId + " does not exists!");
                break;
            }

            System.out.println("Update information and press enter");

            String firstName = (consoleReader.readRequiredProperty("First name (required):"));
            String lastName = (consoleReader.readRequiredProperty("Last name (required):"));
            String age = (consoleReader.readOptionalProperty("Age (optional):"));

            if (!"".equals(firstName)) {
                System.out.println("First name updated");
            }
            if (!"".equals(lastName)) {
                System.out.println("Last name updated");
            }
            if (!"".equals(age)) {
                System.out.println("Age updated");
            }

            Optional<Employee> employee = employees.findBy(empId);

            
            employee.ifPresent( emp -> {
                PersonalData personalData = new PersonalData(firstName, lastName, age);
                emp.setPersonalData(personalData);

                displayEmployees(employees);
            });




            System.out.println("Would you like to update another employee (Y/N)?");
            iteration = consoleReader.fetchInput();
        }
    }

    private static void saveEmployeesFromTextFile(Repository<UUID, Employee> employees) throws FileNotFoundException {
        System.out.println("Insert path to file you would like to use: ");
        String textFilePath = "C:\\Users\\piotr.murawski\\OneDrive - intive\\Desktop\\Employees.txt";
        File myFile = new File(textFilePath);
        Scanner scan = new Scanner(myFile);

        while (scan.hasNextLine()) {
            String line = scan.nextLine();

            String[] employeesData = line.split(",");


            String firstName = employeesData[0];
            String lastName = employeesData[1];
            String age = employeesData[2];
            PersonalData personalData = new PersonalData(firstName, lastName, age);

            String street = employeesData[3];
            String city = employeesData[4];
            String streetNumber = employeesData[5];
            String district = employeesData[6];
            Address address = new Address(street, city, streetNumber, district);

            String education = employeesData[7];
            String company = employeesData[8];
            Occupation occupation = new Occupation(education, company);

            Employee employee = (new Employee(personalData, address, occupation));
            employees.save(employee.getId(), employee);
        }

    }

    private static void displayEmployees(Repository<UUID, Employee> employeeRepository) {
        //zr??b tu pobranie z listy i wypisz
        employeeRepository.executeOnEach((key, value) -> System.out.println(key + ". " + value));
    }

    private static void showEmployees(Repository<UUID, Employee> employees) {
        String iteration = "n";
        while ("n".equalsIgnoreCase(iteration)) {
            employees.executeOnEach((key, value) -> System.out.println(key + ". " + value));
            System.out.println("Would you like to go back to main menu (Y/N)?");
            iteration = consoleReader.fetchInput();
        }
    }

}



