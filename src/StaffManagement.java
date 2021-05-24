import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StaffManagement implements Comparable<Staff> {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Staff> listE;

    public ArrayList<Staff> listAll() {
        Collections.sort(listE);
        return listE;
    }


    public void listAllSalary() {
        System.out.println(String.format("%-10s%-20s%-20s", "ID", "Staff Name", "Salary"));
        for (Staff staff : listE) {
            System.out.println(String.format("%-10s%-20s%-20s", staff.getId(), staff.getName(), staff.calculateSalary()));
        }
    }


    public void listAllSalaryAsc() {
        listE.sort(Comparator.comparing(Staff::calculateSalary));
        System.out.println(String.format("%-10s%-20s%-20s", "ID", "Staff Name", "Salary"));
        for (Staff staff : listE) {
            System.out.println(String.format("%-10s%-20s%-20s", staff.getId(), staff.getName(), staff.calculateSalary()));
        }
    }


    public StaffManagement() {
        listE = new ArrayList<>();
    }


    public void addStaff(Staff staff) {
        listE.add(staff);
    }

    //Search by staff name
    public ArrayList<Staff> searchByName() {
        //store all matching staff or teacher
        ArrayList<Staff> empFound = new ArrayList<>();

        System.out.print("Enter the Name or ID of Staff to search: ");
        scan = new Scanner(System.in);
        String nameOrId = scan.nextLine();

        for (int i = 0; i < listE.size(); i++) {
            if (listE.get(i).getName().contains(nameOrId) || listE.get(i).getId().contains(nameOrId)) { // Check FullName in listE at i with name
                empFound.add(listE.get(i)); // If true, add listE at k to empFound
            }
        }
        return empFound;
    }

    public ArrayList<Staff> searchByDepartment(String dept) {

        ArrayList<Staff> empFound = new ArrayList<>();

        for (int i = 0; i < listE.size(); i++) {
            if (listE.get(i) instanceof Employee) {
                ArrayList<Employee> deptStaff = new ArrayList<>();
                deptStaff.add((Employee) listE.get(i));
                for (int k = 0; k < deptStaff.size(); k++) {
                    if (deptStaff.get(k).getDepartment().getName().equals(dept)) {
                        empFound.add(deptStaff.get(k));
                    }
                }
            }
            if (listE.get(i) instanceof Manager) {
                ArrayList<Manager> managerList = new ArrayList<>();
                managerList.add((Manager) listE.get(i));
                for (Manager managerStaff : managerList) {
                    if (managerStaff.getDepartment().getName().equals(dept)) {
                        empFound.add(managerStaff);
                    }
                }
            }
        }
        return empFound;
    }


    public Employee createNewEmployee(Employee emp, ArrayList<Department> dpm) {
        boolean validate;

        // Set ID
        validate = true;
        System.out.print("ID: ");
        while (validate) {
            String id = scan.nextLine();
            if (id.trim().isEmpty()) {
                System.err.print("ID - Please input staff ID: ");
            } else {
                emp.setId(id);
                validate = false;
            }
        }

        // Set name
        validate = true;
        System.out.print("Name: ");
        while (validate) {
            String name = scan.nextLine();
            if (name.trim().isEmpty()) {
                System.err.print("NAME - Please input employee name: ");
            } else {
                emp.setName(name);
                validate = false;
            }
        }

        // Set Age
        validate = true;
        System.out.print("Age: ");
        while (validate) {
            if (scan.hasNextInt()) {
                emp.setAge(scan.nextInt());
                validate = false;
            } else {
                System.err.print("Age - Please input staff Age number: ");
            }
            scan.nextLine();
        }

        // Set Join Date
        validate = true;
        while (validate) {
            System.out.print("Join Date (MM/dd/yyyy): ");
            String date = scan.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Date date2 = null;
            try {
                //Parsing the String
                date2 = dateFormat.parse(date);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            emp.setJoinDate(date2);
            validate = false;
        }

        // Set salary ratio
        validate = true;
        System.out.print("Salary ratio: ");
        while (validate) {
            if (scan.hasNextFloat()) {
                emp.setSalaryRatio(scan.nextFloat());
                validate = false;
            } else {
                System.err.print("SALARY RATIO - Please input number: ");
            }
            scan.nextLine();
        }

        // Set Department
        validate = true;
        System.out.print("Department: ");
        while (validate) {
            boolean exist = false;
            String name = scan.nextLine();
            for (int i = 0; i < dpm.size(); i++) {
                if (dpm.get(i).getName().equals(name)) {
                    emp.setDepartment(dpm.get(i));
                    exist = true;
                    validate = false;
                }
            }
            if (!exist) {
                System.err.println("Department Doesn't exist");
                validate = true;
                System.err.print("Please Input Exist Department Name Only: ");
            }
        }

        // Set Day Off
        validate = true;
        System.out.print("Day Off: ");
        while (validate) {
            if (scan.hasNextInt()) {
                emp.setDayOff(scan.nextInt());
                validate = false;
            } else {
                System.err.print("Day Off - Please input number: ");
            }
            scan.nextLine();
        }

        // Set OT
        validate = true;
        System.out.print("OT: ");
        while (validate) {
            if (scan.hasNextInt()) {
                emp.setOT(scan.nextInt());
                validate = false;
            } else {
                System.err.print("OT - Please input number: ");
            }
            scan.nextLine();
        }
        return emp;
    }


    public Manager createNewManager(Manager m, ArrayList<Department> dpm) throws ParseException {
        Scanner scan = new Scanner(System.in);
        boolean validate;

        // Set ID
        validate = true;
        System.out.print("ID: ");
        while (validate) {
            String id = scan.nextLine();
            if (id.trim().isEmpty()) {
                System.err.print("ID - Please input staff ID: ");
            } else {
                m.setId(id);
                validate = false;
            }
        }

        // Set name
        validate = true;
        System.out.print("Name: ");
        while (validate) {
            String name = scan.nextLine();
            if (name.trim().isEmpty()) {
                System.err.print("NAME - Please input Staff name: ");
            } else {
                m.setName(name);
                validate = false;
            }
        }


        // Set Age
        validate = true;
        System.out.print("Age: ");
        while (validate) {
            if (scan.hasNextInt()) {
                m.setAge(scan.nextInt());
                validate = false;
            } else {
                System.err.print("Age - Please input staff Age number: ");
            }
            scan.nextLine();
        }

        // Set Join Date
        validate = true;
        System.out.print("Join Date (MM/dd/yyyy): ");
        String date = scan.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date2 = null;
        try {
            //Parsing the String
            date2 = dateFormat.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        while (validate) {
            m.setJoinDate(date2);
            validate = false;
        }

        // Set salary ratio
        validate = true;
        System.out.print("Salary ratio: ");
        while (validate) {
            if (scan.hasNextFloat()) {
                m.setSalaryRatio(scan.nextFloat());
                validate = false;
            } else {
                System.err.print("SALARY RATIO - Please input number: ");
            }
            scan.nextLine();
        }

        // Set Department
        validate = true;
        System.out.print("Department: ");

        while (validate) {
            boolean exist = false;
            String name = scan.nextLine();
            for (int i = 0; i < dpm.size(); i++) {
                if (dpm.get(i).getName().equals(name)) {
                    m.setDepartment(dpm.get(i));
                    exist = true;
                    validate = false;
                }
            }
            if (!exist) {
                System.err.println("Department Doesn't exist");
                validate = true;
                System.err.print("Please Input Exist Department Name Only: ");
            }
        }


        // Set Day Off
        validate = true;
        System.out.print("Day Off: ");
        while (validate) {
            if (scan.hasNextInt()) {
                m.setDayOff(scan.nextInt());
                validate = false;
            } else {
                System.err.print("Day Off - Please input number: ");
            }
            scan.nextLine();
        }

        // Set position
        validate = true;
        System.out.print("Position (1=BUSINESS_LEADER; 2=PROJECT_LEADER; 3=TECHNICAL_LEADER): ");
        while (validate) {
            if (scan.hasNextByte()) {
                byte teacherDegree = scan.nextByte();
                switch (teacherDegree) {
                    case 1:
                        m.setPosition(EPosition.BUSINESS_LEADER);
                        validate = false;
                        break;
                    case 2:
                        m.setPosition(EPosition.PROJECT_LEADER);
                        validate = false;
                        break;
                    case 3:
                        m.setPosition(EPosition.TECHNICAL_LEADER);
                        validate = false;
                        break;
                    default:
                        System.err.print("POSITION - Please input from 1,2 or 3: ");
                        break;
                }
            } else {
                System.err.print("POSITION - Please input from 1,2 or 3: ");
            }
            scan.nextLine();
        }
        return m;
    }


    /**
     * Display All Information of All Staff
     *
     * @param listStaff - List Of All Staffs
     */
    public void display(ArrayList<Staff> listStaff) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-30s%-20s",
                "ID",
                "NAME",
                "AGE",
                "JOIN DATE",
                "DEPARTMENT",
                "DAY OFFS",
                "OVERTIMES / POSITION",
                "SALARY"));
        for (Staff staff : listStaff) {
            if (staff instanceof Employee) {
                Employee employee = (Employee) staff;
                String joinDate = formatter.format(employee.getJoinDate());
                System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-30s%-20s",
                        employee.getId(),
                        employee.getName(),
                        employee.getAge(),
                        joinDate,
                        employee.getDepartment().getName(),
                        employee.getDayOff(),
                        employee.getOT(),
                        "$ " + employee.calculateSalary()));
            } else if (staff instanceof Manager) {
                Manager manager = (Manager) staff;
                String joinDate = formatter.format(manager.getJoinDate());
                System.out.println(String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-30s%-20s",
                        manager.getId(),
                        manager.getName(),
                        manager.getAge(),
                        joinDate,
                        manager.getDepartment().getName(),
                        manager.getDayOff(),
                        manager.getPosition(),
                        "$ " + manager.calculateSalary()));
            }
        }
    }

    @Override
    public int compareTo(Staff o) {
        return 0;
    }
}
