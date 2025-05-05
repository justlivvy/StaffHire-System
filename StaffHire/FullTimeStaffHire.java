
public class FullTimeStaffHire extends StaffHire
{
    private double salary;
    private int weeklyFractionalHours;

    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined, double salary, int weeklyFractionalHours)
    {
        super(vacancyNumber, designation, jobType);
        setStaffName(staffName);
        setJoiningDate(joiningDate);
        setQualification(qualification);
        setAppointedBy(appointedBy);
        setJoined(joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    public double getSalary() { return salary; }
    public int getWeeklyFractionalHours() { return weeklyFractionalHours; }

    public void setSalary(double salary) {
    this.salary = salary;
    }


    public void setWeeklyFractionalHours(int weeklyFractionalHours)
    {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}
