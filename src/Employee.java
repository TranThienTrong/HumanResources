import java.util.Date;

public class Employee extends Staff implements ICalculator
{

    private int OT;

    public Employee() {
    }


    public int getOT() {
        return OT;
    }

    public void setOT(int OT) {
        this.OT = OT;
    }

    public Employee(String id, String name, int age, float salaryRatio, Date joinDate, Department department, int dayOff, int OT) {
        super(id, name, age, salaryRatio, joinDate, department, dayOff);
        this.OT = OT;
    }

    public float calculateSalary(Staff staff){
        float responsive_salary = 0;
        float salary = 0;

        if (staff instanceof Employee) {
            Employee employee = (Employee) staff;
            salary = employee.getSalaryRatio()*30000+employee.getOT()*2000;
        }
        else if (staff instanceof Manager) {
            Manager manager = (Manager) staff;
            if (manager.getPosition() == EPosition.BUSINESS_LEADER) {
                responsive_salary = 8000000;
            } else if (manager.getPosition() == EPosition.PROJECT_LEADER) {
                responsive_salary = 5000000;
            } else if (manager.getPosition() == EPosition.TECHNICAL_LEADER) {
                responsive_salary = 6000000;
            }
            salary = manager.getSalaryRatio() * 50000 + responsive_salary;
        }
        return salary;

    }


    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-20s%-20s",
                this.getId(),
                this.getName(),
                this.getAge(),
                this.getJoinDate(),
                this.getDepartment().getName(),
                this.getDayOff(),
                this.getOT(),
                this.calculateSalary());
    }


    @Override
    public int compareTo(Staff o) {
        return 0;
    }


}
