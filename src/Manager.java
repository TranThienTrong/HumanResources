import java.util.Date;

public class Manager extends Staff {

    private EPosition position; //Chức Danh

    public EPosition getPosition() {
        return position;
    }

    public void setPosition(EPosition position) {
        this.position = position;
    }

    public Manager(String id, String name, int age, float salaryRatio, Date joinDate, Department department, int dayOff, EPosition position) {
        super(id, name, age, salaryRatio, joinDate, department, dayOff);
        this.position = position;
    }

    public Manager(){}

    public float calculateSalary(){
        return ICalculator.caculateSalary(this);
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
                this.getPosition(),
                this.calculateSalary());
    }

    @Override
    public int compareTo(Staff o) {
        return 0;
    }
}
