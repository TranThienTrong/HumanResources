import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department implements Comparable<Department> {

    private String id;
    private String name;
    private int count;
    private int staffQuantity = count ;

    public int findStaffQuantity(ArrayList<Staff> staffList,String DepartmentName) {
        count = 0;
        for (Staff staff : staffList) {
            if (staff.getDepartment().getName().equals(DepartmentName)) {
                count++;
            }
        }
        return count;
    }

    /* Constructors */
    public Department() {

    }

    public Department(String name) {
        this.name = name;
    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Accessor and Mutator of fields */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setStaffQuantity(ArrayList<Staff> staffList,String DepartmentName){
        this.staffQuantity = findStaffQuantity(staffList,DepartmentName);
    }


    public int getStaffQuantity(ArrayList<Staff> foundByDept, String dept){
        return staffQuantity;
    }


    /* Override Methods */

    @Override
    public String toString() {
        return String.format("%-10s", this.getName());
    }

    @Override
    public int compareTo(Department o) {
        return 0;
    }
}
