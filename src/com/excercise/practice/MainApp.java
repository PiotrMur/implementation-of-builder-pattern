package com.excercise.practice;

import com.excercise.practice.auxiliary.ConsoleReader;
import com.excercise.practice.entity.*;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        //PersonalData pData = new PersonalDataBuilder("Tomasz", "Poszytek").build();
        //Address address = new AddressBuilder("Nowa", 13, "Warszawa").district("Wola").build();
        //Occupation occupation = new OccupationBuilder("Computer Science").company("Google").build();

        Map<Integer, Employee> dbMap = new HashMap<>();

        boolean keepWorking = true;
        while(keepWorking) {

                System.out.println("Insert a number assign to action you would like to perform: \n" +
                        "1 - Add Employees from text file\n" +
                        "2 - Add Employee -> THIS WORKS\n" +
                        "3 - Update Employee's data\n" +
                        "4 - Delete Employee\n" +
                        "5 - Delete ALL Employees\n" +
                        "6 - Show Employees -> THIS WORKS\n" +
                        ">6 - Close application\n");


                    ConsoleReader consoleReader = new ConsoleReader();

                    int decision = consoleReader.readDecision();

                    switch (decision) {
                        //case 1 -> saveEmployeesFromTextFile();
                        case 2 -> addEmployee(dbMap);
                        //case 3 -> updateEmployee();
                        //case 4 -> deleteEmployee();
                        //case 5 -> deleteAllEmployees();
                        case 6 -> showEmployees(dbMap);
                        default -> {
                            System.out.println("Application has been terminated");
                            keepWorking = false;
                        }
                    }
                }

        System.out.println("Application is closing...");

    }



        private static ConsoleReader consoleReader = new ConsoleReader();

        /*private static void deleteAllEmployees() {
            System.out.println("Are you sure you want to delete ALL Employees? (Y/N)");
            String decision = (consoleReader.fetchInput());
            if(decision.equals("y")){
                System.out.println("Deleting was successful");
            } else{
                System.out.println("Deleting procedure has been aborted");
            }


        }*/

        private static void addEmployee(Map dbMap) {
            String iteration = "y";
            while("y".equalsIgnoreCase(iteration)) {
                System.out.println("Add new Employee.");

                String firstName = consoleReader.readProperty("Insert employee's name (required): ");
                String lastName = consoleReader.readProperty("Insert employee's last name (required): ");
                int age = Integer.parseInt(consoleReader.readProperty("Insert employee's company (optional): "));
                PersonalData pData = new PersonalDataBuilder(firstName, lastName).age(age).build();
                Employee employee = new Employee(pData);
                dbMap.put(dbMap.size()+1, employee);
                System.out.println("Would you like to add another employee (Y/N)?");
                iteration = consoleReader.fetchInput();
            }
        }



        /*private static void deleteEmployee() {
            String iteration = "y";
            while("y".equalsIgnoreCase(iteration)) {
                displayEmployees();
                System.out.println("Delete Employee\nInsert employee's id: ");
                int empId = Integer.parseInt(consoleReader.fetchInput());

                System.out.println("Would you like to delete another employee (Y/N)?");
                iteration = consoleReader.fetchInput();
            }
        }*/

        /*private static void updateEmployee() {
            String iteration = "y";
            while("y".equalsIgnoreCase(iteration)) {
                displayEmployees(session);
                System.out.println("Update Employee's data\nInsert employee's id: ");
                int empId = Integer.parseInt(consoleReader.fetchInput());
                System.out.println("Update information of your choice. If an update is not necessary, press enter and leave field empty");
                System.out.println("First name:");
                String firstName = (consoleReader.fetchInput());
                System.out.println("Last name:");
                String lastName = (consoleReader.fetchInput());
                System.out.println("Company:");
                String company = (consoleReader.fetchInput());

                if (!"".equals(firstName)) {
                    employee.setFirstName(firstName);
                    System.out.println("First name updated");
                }
                if (!"".equals(lastName)) {
                    employee.setLastName(lastName);
                    System.out.println("Last name updated");
                }
                if (!"".equals(company)) {
                    employee.setCompany(company);
                    System.out.println("Company name updated");
                }
                displayEmployees();
                System.out.println("Would you like to update another employee (Y/N)?");
                iteration = consoleReader.fetchInput();
            }
        }*/

        /*private static void saveEmployeesToDB(List<Employee> employees) {
            for(Employee emp : employees){
                ;
            }
        }*/
        /*private static void saveEmployeesFromTextFile() throws FileNotFoundException {
            System.out.println("Insert path to file you would like to use: ");
            String textFilePath = consoleReader.fetchInput();
            File myFile = new File(textFilePath);
            Scanner scan = new Scanner(myFile);
            List<Employee> employees = new ArrayList<>();

            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String firstName = (line.split(" "))[0];
                String lastName = (line.split(" "))[1];
                String company = (line.split(" "))[2];
                employees.add(new Employee(firstName, lastName, company));
            }

            saveEmployeesToDB(employees);
        }*/

        /*private static void displayEmployees(){
            for(Object emp : employees) {
                System.out.println(emp);
            }
        }*/

        private static void showEmployees(Map map){
            String iteration = "n";
            while("n".equalsIgnoreCase(iteration)) {
                map.forEach((key, value) ->System.out.println(key + ". " + value));
                System.out.println("Would you like to go back to main menu (Y/N)?");
                iteration = consoleReader.fetchInput();
            }
        }
}



