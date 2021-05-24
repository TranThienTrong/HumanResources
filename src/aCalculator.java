public abstract class aCalculator {
    static float caculateSalary(Staff staff) {
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
}
