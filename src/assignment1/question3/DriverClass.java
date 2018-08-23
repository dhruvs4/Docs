package assignment1.question3;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DriverClass {
    private static EmployeeDataOperations eds = EmployeeDataOperations.getInstance() ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;

        while(true) {
//            try {
            System.out.println("1. To add a employee\n 2. To remove a specific employee\n 3. Details of an employee\n 4. Total number of employees\n 5. Data of all employees\n 6. Delete data of all employees\n 7. To exit");
            System.out.println("enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            boolean success;
            switch (choice) {
                case 1:
                    success = eds.add(getEmployeeDataFromUser());
                    if (success) {
                        System.out.println("Employee added successfully");
                    } else {
                        System.out.println("Employee already exists");
                    }
                    break;
                case 2:
                    System.out.println("Enter id of employee to be removed: ");
                    int id = Integer.parseInt(sc.nextLine());
                    boolean b = eds.remove(id);
                    if (b) {
                        System.out.println("Employee removed successfully");
                    } else {
                        System.out.println("ID not found");
                    }
                    break;
                case 3:
                    System.out.println("enter id of the employee:");
                    int id1 = Integer.parseInt(sc.nextLine());
                    Employee required_employee = eds.findById(id1);
                    if (required_employee != null)
                        System.out.println("id: " + required_employee.getId() + "\n name: " + required_employee.getName() + "\n salary " + required_employee.getSalary());
                    else System.out.println("employee id not present");
                    break ;
                case 4:
                    int count = eds.getCount();
                    System.out.println("Employee count:" + count);
                    break;
                case 5:
                    List<Employee> employeeList = eds.findAll(eds.hm);
                    Iterator var4 = employeeList.iterator();
                    while(true) {
                        if (!var4.hasNext()) {
                            break;
                        }
                        Employee E = (Employee)var4.next();
                        System.out.println("id: "+E.getId()+" name: "+E.getName()+" salary: "+E.getSalary());
                    }
                    break;
                case 6:
                    eds.deleteAll();
                    System.out.println("all data cleared");
                    break;
                case 7:
                    System.exit(0);
                default:
                    continue;
            }
//        }
//                System.out.println("present number of employees:" + eds.hm.size());
//            catch(Exception e){
//                System.out.println("incorrect data inserted. Try again!");
//                continue;
//            }
            System.out.println("present number of employees:" + eds.hm.size());
        }
    }

    private static Employee getEmployeeDataFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Id, Name and Salary: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        String name = scanner.nextLine();
        float salary = Float.parseFloat(scanner.nextLine());
        return new Employee(id, name, (int) salary);
    }
}