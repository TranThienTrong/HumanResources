import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources {

    static Scanner scanMain = new Scanner(System.in);
    static StaffManagement staffControl = new StaffManagement();
    static DepartmentManagement departmentManagement = new DepartmentManagement();

    static void createNewStaff(ArrayList<Department> dpm) {
        System.out.print("Which you want to create Employee or Manager ('e' = Employee, otherwise for Manager): ");
        scanMain = new Scanner(System.in);
        String choice = scanMain.nextLine();
        if (choice.equalsIgnoreCase("e")) {
            Employee e = new Employee();
            e = staffControl.createNewEmployee(e, dpm);
            staffControl.addStaff(e);
        } else {
            Manager m = new Manager();
            try {
                m = staffControl.createNewManager(m, dpm);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            staffControl.addStaff(m);
        }
    }

    static void createNewDepartment() {
        Department d = new Department();
        d = departmentManagement.createNewDepartment(d);
        departmentManagement.addDepartment(d);
    }


    public static void main(String[] args) {

        Department d1 = new Department("Coding");
        Department d2 = new Department("Tester");
        departmentManagement.addDepartment(d1);
        departmentManagement.addDepartment(d2);

        System.out.println("Welcome to the Human Resources Application");
        while (true) {
            System.out.println("------------------------------------------");
            System.out.println("1.Display Current Staffs Of Company");
            System.out.println("2.Display Departments Of Company");
            System.out.println("3.Display Staffs Of Department");
            System.out.println("4.Add New Staff");
            System.out.println("5.Search Staff By Name / ID");
            System.out.println("6.Display Staffs Salary Table");
            System.out.println("7.Display Staffs Salary In Ascending Order");
            System.out.println("8.Add New Department");
            System.out.println("9.Exit");
            System.out.print("Your choice: ");
            int choice = scanMain.nextInt();

            switch (choice) {
                case 1:
                    ArrayList<Staff> listStaff = staffControl.listAll();
                    staffControl.display(listStaff);
                    break;
                case 2:
                    ArrayList<Department> listD = departmentManagement.listAllDepartment();
                    departmentManagement.display(listD);
                    break;
                case 3:
                    System.out.print("Enter dept to search: ");
                    scanMain = new Scanner(System.in);
                    String dept = scanMain.nextLine();
                    ArrayList<Staff> foundByDept = staffControl.searchByDepartment(dept);
                    staffControl.display(foundByDept);

                    int staffQuantityOfThisDepartment = 0;
                    Department d = new  Department();
                    staffQuantityOfThisDepartment = d.getStaffQuantity(foundByDept, dept);
                    System.out.println("Number Of Staff in This Department: " + staffQuantityOfThisDepartment);



                    break;
                case 4:
                    ArrayList<Department> listDpm = departmentManagement.listAllDepartment();
                    createNewStaff(listDpm);
                    break;
                case 5:
                    ArrayList<Staff> foundByNameOrId = staffControl.searchByName();
                    staffControl.display(foundByNameOrId);
                    break;
                case 6:
                    staffControl.listAllSalary();
                    break;
                case 7:
                    staffControl.listAllSalaryAsc();
                    break;
                case 8:
                    createNewDepartment();
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        }
    } // End Main Function
} // End Client
