import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DepartmentManagement {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Department> listDepartment;

    public ArrayList<Department> listAllDepartment() {
        Collections.sort(listDepartment);
        return listDepartment;
    }

    public DepartmentManagement() {
        listDepartment = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        listDepartment.add(department);
    }

    public Department createNewDepartment(Department d) {

        boolean validate;

        // Set ID
        validate = true;
        System.out.print("Department ID: ");
        while (validate) {
            if (scan.hasNext()) {
                d.setId(scan.next());
                validate = false;
            } else {
                System.err.print("ID - Please Input Department ID number: ");
            }
            scan.nextLine();
        }

        // Set name
        validate = true;
        System.out.print("Name: ");
        while (validate) {
            String name = scan.nextLine();
            if (name.trim().isEmpty()) {
                System.err.print("NAME - Please input Department Name: ");
            } else {
                d.setName(name);
                validate = false;
            }
        }
        return d;
    }

    /**
     * Display All Information of All Department
     * @param listD - List Of All Department
     * */
    public void display(ArrayList<Department> listD) {
        System.out.println("Name");
        for (Department d : listD) {
            System.out.println(d.toString());
        }
    }
}
