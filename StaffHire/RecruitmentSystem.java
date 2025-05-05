import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RecruitmentSystem extends JFrame implements ActionListener
{
    private ArrayList<StaffHire> staffList = new ArrayList<>();

    private JTextField vacancyField, designationField, jobTypeField, staffNameField, joiningDateField, qualificationField, appointedByField, salaryField, weeklyHoursField, workingHourField, wagesPerHourField, shiftsField, displayIndexField;
    private JButton addFullTimeButton, addPartTimeButton, setSalaryButton, setShiftButton, terminateButton, displayButton, clearButton;

    public RecruitmentSystem()
    {
        setTitle("Recruitment System");
        setSize(900, 750);
        setLayout(new BorderLayout(10,10));

        Font labelFont = new Font("SansSerif", Font.PLAIN, 16);
        Font titleFont = new Font("SansSerif", Font.BOLD, 22);
        Dimension fieldSize = new Dimension(350, 40);

        // Title
        JLabel titleLabel = new JLabel("Recruitment System", SwingConstants.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(new Color(0, 102, 204));
        add(titleLabel, BorderLayout.NORTH);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Staff Details"));
        inputPanel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fields
        vacancyField = new JTextField();         vacancyField.setPreferredSize(fieldSize);
        designationField = new JTextField();     designationField.setPreferredSize(fieldSize);
        jobTypeField = new JTextField();         jobTypeField.setPreferredSize(fieldSize);
        staffNameField = new JTextField();       staffNameField.setPreferredSize(fieldSize);
        joiningDateField = new JTextField();     joiningDateField.setPreferredSize(fieldSize);
        qualificationField = new JTextField();   qualificationField.setPreferredSize(fieldSize);
        appointedByField = new JTextField();     appointedByField.setPreferredSize(fieldSize);
        salaryField = new JTextField();          salaryField.setPreferredSize(fieldSize);
        weeklyHoursField = new JTextField();     weeklyHoursField.setPreferredSize(fieldSize);
        workingHourField = new JTextField();     workingHourField.setPreferredSize(fieldSize);
        wagesPerHourField = new JTextField();    wagesPerHourField.setPreferredSize(fieldSize);
        shiftsField = new JTextField();          shiftsField.setPreferredSize(fieldSize);
        displayIndexField = new JTextField();    displayIndexField.setPreferredSize(fieldSize);

        // Add fields
        addLabelAndField(inputPanel, gbc, "Vacancy Number:", vacancyField, 0, labelFont);
        addLabelAndField(inputPanel, gbc, "Designation:", designationField, 1, labelFont);
        addLabelAndField(inputPanel, gbc, "Job Type:", jobTypeField, 2, labelFont);
        addLabelAndField(inputPanel, gbc, "Staff Name:", staffNameField, 3, labelFont);
        addLabelAndField(inputPanel, gbc, "Joining Date:", joiningDateField, 4, labelFont);
        addLabelAndField(inputPanel, gbc, "Qualification:", qualificationField, 5, labelFont);
        addLabelAndField(inputPanel, gbc, "Appointed By:", appointedByField, 6, labelFont);
        addLabelAndField(inputPanel, gbc, "Salary (Full-Time):", salaryField, 7, labelFont);
        addLabelAndField(inputPanel, gbc, "Weekly Hours (Full-Time):", weeklyHoursField, 8, labelFont);
        addLabelAndField(inputPanel, gbc, "Working Hours (Part-Time):", workingHourField, 9, labelFont);
        addLabelAndField(inputPanel, gbc, "Wages Per Hour (Part-Time):", wagesPerHourField, 10, labelFont);
        addLabelAndField(inputPanel, gbc, "Shifts (Part-Time):", shiftsField, 11, labelFont);
        addLabelAndField(inputPanel, gbc, "Display/Terminate Index:", displayIndexField, 12, labelFont);

        add(inputPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel(new GridLayout(4,2,10,10));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        buttonPanel.setBackground(new Color(235, 235, 250));

        addFullTimeButton = new JButton("Add Full Time Staff");
        addPartTimeButton = new JButton("Add Part Time Staff");
        setSalaryButton = new JButton("Set Salary");
        setShiftButton = new JButton("Set Shift");
        terminateButton = new JButton("Terminate Part-Time");
        displayButton = new JButton("Display Staff");
        clearButton = new JButton("Clear Fields");

        buttonPanel.add(addFullTimeButton);
        buttonPanel.add(addPartTimeButton);
        buttonPanel.add(setSalaryButton);
        buttonPanel.add(setShiftButton);
        buttonPanel.add(terminateButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Listeners
        addFullTimeButton.addActionListener(this);
        addPartTimeButton.addActionListener(this);
        setSalaryButton.addActionListener(this);
        setShiftButton.addActionListener(this);
        terminateButton.addActionListener(this);
        displayButton.addActionListener(this);
        clearButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addLabelAndField(JPanel panel, GridBagConstraints gbc, String labelText, JTextField textField, int y, Font font)
    {
        JLabel label = new JLabel(labelText);
        label.setFont(font);
        textField.setFont(font);

        gbc.gridx = 0;
        gbc.gridy = y;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = y;
        panel.add(textField, gbc);
    }

    // Button logic (same as before)
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == addFullTimeButton) {
            addFullTimeStaff();
        } else if (e.getSource() == addPartTimeButton) {
            addPartTimeStaff();
        } else if (e.getSource() == setSalaryButton) {
            setSalary();
        } else if (e.getSource() == setShiftButton) {
            setShift();
        } else if (e.getSource() == terminateButton) {
            terminateStaff();
        } else if (e.getSource() == displayButton) {
            displayStaff();
        } else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    // Logic methods (same as earlier)
    private void addFullTimeStaff() {
        try {
            int vacancy = Integer.parseInt(vacancyField.getText());
            double salary = Double.parseDouble(salaryField.getText());
            int weeklyHours = Integer.parseInt(weeklyHoursField.getText());

            FullTimeStaffHire fullTime = new FullTimeStaffHire(
                vacancy, designationField.getText(), jobTypeField.getText(), staffNameField.getText(),
                joiningDateField.getText(), qualificationField.getText(), appointedByField.getText(), true,
                salary, weeklyHours
            );
            staffList.add(fullTime);
            JOptionPane.showMessageDialog(this, "Full-time staff added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding Full Time Staff: " + ex.getMessage());
        }
    }

    private void addPartTimeStaff() {
        try {
            int vacancy = Integer.parseInt(vacancyField.getText());
            int workingHour = Integer.parseInt(workingHourField.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());

            PartTimeStaffHire partTime = new PartTimeStaffHire(
                vacancy, designationField.getText(), jobTypeField.getText(), staffNameField.getText(),
                joiningDateField.getText(), qualificationField.getText(), appointedByField.getText(), true,
                workingHour, wagesPerHour, shiftsField.getText()
            );
            staffList.add(partTime);
            JOptionPane.showMessageDialog(this, "Part-time staff added successfully!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error adding Part Time Staff: " + ex.getMessage());
        }
    }

    private void setSalary() {
        try {
            int index = Integer.parseInt(displayIndexField.getText());
            if (index >= 0 && index < staffList.size()) {
                StaffHire staff = staffList.get(index);
                if (staff instanceof FullTimeStaffHire) {
                    double newSalary = Double.parseDouble(salaryField.getText());
                    ((FullTimeStaffHire) staff).setSalary(newSalary);
                    JOptionPane.showMessageDialog(this, "Salary updated!");
                } else {
                    JOptionPane.showMessageDialog(this, "Selected staff is not Full-Time!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid index!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error setting salary: " + ex.getMessage());
        }
    }

    private void setShift() {
        try {
            int index = Integer.parseInt(displayIndexField.getText());
            if (index >= 0 && index < staffList.size()) {
                StaffHire staff = staffList.get(index);
                if (staff instanceof PartTimeStaffHire) {
                    ((PartTimeStaffHire) staff).setShifts(shiftsField.getText());
                    JOptionPane.showMessageDialog(this, "Shift updated!");
                } else {
                    JOptionPane.showMessageDialog(this, "Selected staff is not Part-Time!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid index!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error setting shift: " + ex.getMessage());
        }
    }

    private void terminateStaff() {
        try {
            int index = Integer.parseInt(displayIndexField.getText());
            if (index >= 0 && index < staffList.size()) {
                StaffHire staff = staffList.get(index);
                if (staff instanceof PartTimeStaffHire) {
                    ((PartTimeStaffHire) staff).terminate();
                    JOptionPane.showMessageDialog(this, "Part-time staff terminated!");
                } else {
                    JOptionPane.showMessageDialog(this, "Selected staff is not Part-Time!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid index!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error terminating staff: " + ex.getMessage());
        }
    }

    private void displayStaff() {
        try {
            int index = Integer.parseInt(displayIndexField.getText());
            if (index >= 0 && index < staffList.size()) {
                StaffHire staff = staffList.get(index);
                staff.display(); // Output to terminal
            } else {
                JOptionPane.showMessageDialog(this, "Invalid index!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error displaying staff: " + ex.getMessage());
        }
    }

    private void clearFields() {
        vacancyField.setText("");
        designationField.setText("");
        jobTypeField.setText("");
        staffNameField.setText("");
        joiningDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        salaryField.setText("");
        weeklyHoursField.setText("");
        workingHourField.setText("");
        wagesPerHourField.setText("");
        shiftsField.setText("");
        displayIndexField.setText("");
    }

    public static void main(String[] args)
    {
        new RecruitmentSystem();
    }
}


