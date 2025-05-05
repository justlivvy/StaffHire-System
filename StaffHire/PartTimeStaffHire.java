
public class PartTimeStaffHire extends StaffHire
{
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate, String qualification, String appointedBy, boolean joined, int workingHour, double wagesPerHour, String shifts)
    {
        super(vacancyNumber, designation, jobType);
        setStaffName(staffName);
        setJoiningDate(joiningDate);
        setQualification(qualification);
        setAppointedBy(appointedBy);
        setJoined(joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    public int getWorkingHour() { return workingHour; }
    public double getWagesPerHour() { return wagesPerHour; }
    public String getShifts() { return shifts; }
    public boolean getTerminated() { return terminated; }

    public void setShifts(String shifts)
    {
        if (getJoined()) {
            this.shifts = shifts;
        } else {
            System.out.println("Cannot set shift if not joined.");
        }
    }

    public void terminate()
    {
        if (terminated) {
            System.out.println("Staff already terminated.");
        } else {
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            terminated = true;
        }
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("Working Hours: " + workingHour);
        System.out.println("Wages Per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
        System.out.println("Income per day: " + (workingHour * wagesPerHour));
    }
}
