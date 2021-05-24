import java.util.Date;

public abstract class Staff implements Comparable<Staff>{
    private String id;
    private String name;
    private int age;
    private float salaryRatio;
    private Date joinDate;
    private Department department;
    private int dayOff;

    public Staff(String id, String name, int age, float salaryRatio, Date joinDate, Department department, int dayOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryRatio = salaryRatio;
        this.joinDate = joinDate;
        this.department = department;
        this.dayOff = dayOff;
    }

    public Staff() {
    }

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

    public float getSalaryRatio() {
        return salaryRatio;
    }

    public void setSalaryRatio(float salaryRatio) {
        this.salaryRatio = salaryRatio;
    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public float calculateSalary(){
        return ICalculator.caculateSalary(this);
    }


    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-20s%-20s%-20s%-20s",id,name,age,joinDate,department,dayOff,this.calculateSalary());
    }
}
