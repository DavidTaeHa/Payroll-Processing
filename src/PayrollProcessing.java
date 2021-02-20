import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.Exception;

/**
 * This class will handle all user input and output
 *
 * @author David Ha, Andrew McAvoy
 */
public class PayrollProcessing {
    private boolean payrollProcessingSession;

    final static int MANAGER = 1;
    final static int DIRECTOR = 3;
    final static int PARTTIME = 4;
    final static int FULLTIME = 5;
    final static int PRINT_ALL = 1;
    final static int PRINT_DATE = 2;
    final static int PRINT_DEPARTMENT = 3;

    /**
     * Constants used for getting parameters from the array of inputs
     */
    final static int FIRST_PARAMETER = 0;
    final static int SECOND_PARAMETER = 1;
    final static int THIRD_PARAMETER = 2;
    final static int FOURTH_PARAMETER = 3;
    final static int FIFTH_PARAMETER = 4;
    final static int SIXTH_PARAMETER = 5;
    final static int LENGTH_REQUIREMENT_FOUR = 4;
    final static int LENGTH_REQUIREMENT_FIVE = 5;
    final static int LENGTH_REQUIREMENT_SIX = 6;

    /**
     * Constructor for PayrollProcessing class
     */
    public PayrollProcessing() {
        payrollProcessingSession = true;
    }

    /**
     * Helper method to check if the length of the array of parameters is correct
     *
     * @param expectedLength Expected length of the input command
     * @param actualLength   Actual length of the input command
     */
    private void checkLength(int expectedLength, int actualLength) {
        if (actualLength != expectedLength) {
            throw new ArrayIndexOutOfBoundsException("Invalid Command!");
        }
    }

    /**
     * Helper method to aid in adding a new fulltime or parttime to the company container
     *
     * @param name       Name of the employee
     * @param department Department associated with the employee
     * @param dateHired  Date that the employee is hired
     * @param pay        Annual salary or hourly rate of the employee
     * @param role       Number denoting Fulltime or Parttime status of the employee
     * @param company    Container full of employees
     */
    private void addCommand(String name, String department, String dateHired, String pay, int role, Company company) {
        Date date = new Date(dateHired);
        if (!date.isValid()) {
            throw new InputMismatchException(dateHired + " is not a valid date!");
        }
        if (!department.equals("CS") && !department.equals("ECE") && !department.equals("IT")) {
            throw new InputMismatchException("Invalid department code!");
        }
        Profile profile = new Profile(name, department, date);
        if (role == PARTTIME) {
            Parttime parttime = new Parttime(profile, Double.parseDouble(pay));
            if(!company.add(parttime)){
                System.out.println("Employee is already in the list");
                return;
            }
        } else if (role == FULLTIME) {
            Fulltime fulltime = new Fulltime(profile, Double.parseDouble(pay));
            if(!company.add(fulltime)){
                System.out.println("Employee is already in the list");
                return;
            }
        }
        System.out.println("Employee added.");
    }

    /**
     * Helper method to aid in adding new management to the company container
     *
     * @param name           Name of the employee
     * @param department     Department associated with the employee
     * @param dateHired      Date that the employee is hired
     * @param salary         Annual salary of the employee
     * @param managementRole Number denoting management role of the employee
     * @param company        Container full of employees
     */
    private void addCommand(String name, String department, String dateHired, String salary, String managementRole, Company company) {
        Date date = new Date(dateHired);
        if (!date.isValid()) {
            throw new InputMismatchException(dateHired + " is not a valid date!");
        }
        if (!department.equals("CS") && !department.equals("ECE") && !department.equals("IT")) {
            throw new InputMismatchException("Invalid department code!");
        }
        if (Integer.parseInt(managementRole) > DIRECTOR || Integer.parseInt(managementRole) < MANAGER) {
            throw new InputMismatchException("Invalid management code!");
        }
        Profile profile = new Profile(name, department, date);
        Management management = new Management(profile, Double.parseDouble(salary), Integer.parseInt(managementRole));
        if(!company.add(management)){
            System.out.println("Employee is already in the list");
        }
        else{
            System.out.println("Employee added.");
        }
    }

    /**
     * Helper method to aid in removing an employee from the container
     * @param name Name of the employee
     * @param department Department associated with the employee
     * @param dateHired Date that the employee is hired
     * @param company Container full of employees
     */
    private void removeCommand(String name, String department, String dateHired, Company company){
        Date date = new Date(dateHired);
        Profile profile = new Profile(name, department, date);
        Employee employee = new Employee(profile);
        if(!company.remove(employee)){
            System.out.println("Employee doesn’t exist.");
        }
        else{
            System.out.println("Employee removed.");
        }
    }

    /**
     * Helper method to aid in setting hours of parttime employees
     * @param name Name of the employee
     * @param department Department associated with the employee
     * @param dateHired Date tthat the employee is hired
     * @param hours Hours that the employee has worked
     * @param company Container full of employees
     */
    private void setHoursCommand(String name, String department, String dateHired, String hours, Company company){
        if(Integer.parseInt(hours) < 0){
            throw new InputMismatchException("Working hours cannot be negative.");
        }
        else if (Integer.parseInt(hours) > 100){
            throw new InputMismatchException("Invalid Hours: over 100");
        }
        Date date = new Date(dateHired);
        Profile profile = new Profile(name, department, date);
        Parttime parttime = new Parttime(profile, 0.0);
        parttime.setHoursWorked(Integer.parseInt(hours));
        if(!company.setHours(parttime)){
            System.out.println("Employee doesn’t exist.");
        }
        else{
            System.out.println("Working hours set.");
        }
    }

    /**
     * Helper method to aid in printing elements in the container
     *
     * @param printType Different ways to print the elements in the container
     */
    public void printCommand(int printType, Company company) {
        if (company.getNumEmployee() == 0) {
            System.out.println("Employee database is empty.");
        } else if (printType == PRINT_ALL) {
            System.out.println("--Printing earning statements for all employees--");
            company.print();
        } else if (printType == PRINT_DATE) {
            System.out.println("--Printing earning statements by date hired--");
            company.printByDate();
        } else if (printType == PRINT_DEPARTMENT) {
            System.out.println("--Printing earning statements by department--");
            company.printByDepartment();
        }
    }

    /**
     * Handles all user input and output
     */
    public void run() {
        Company company = new Company();
        Scanner scan = new Scanner(System.in);
        System.out.println("Payroll Processing Session Running.");
        while (payrollProcessingSession) {
            String input = scan.nextLine();
            String[] parameters = input.split(" ");
            String command = parameters[FIRST_PARAMETER];
            switch (command) {
                case "AP":
                    checkLength(LENGTH_REQUIREMENT_FIVE, parameters.length);
                    addCommand(parameters[SECOND_PARAMETER], parameters[THIRD_PARAMETER], parameters[FOURTH_PARAMETER],
                            parameters[FIFTH_PARAMETER], PARTTIME, company);
                    break;
                case "AF":
                    checkLength(LENGTH_REQUIREMENT_FIVE, parameters.length);
                    addCommand(parameters[SECOND_PARAMETER], parameters[THIRD_PARAMETER], parameters[FOURTH_PARAMETER],
                            parameters[FIFTH_PARAMETER], FULLTIME, company);
                    break;
                case "AM":
                    checkLength(LENGTH_REQUIREMENT_SIX, parameters.length);
                    addCommand(parameters[SECOND_PARAMETER], parameters[THIRD_PARAMETER], parameters[FOURTH_PARAMETER],
                            parameters[FIFTH_PARAMETER], parameters[SIXTH_PARAMETER], company);
                    break;
                case "R":
                    checkLength(LENGTH_REQUIREMENT_FOUR, parameters.length);
                    removeCommand(parameters[SECOND_PARAMETER], parameters[THIRD_PARAMETER],
                            parameters[FOURTH_PARAMETER], company);
                    break;
                case "C":
                    company.processPayments();
                    System.out.println("Calculation of employee payments is done.");
                    break;
                case "S":
                    checkLength(LENGTH_REQUIREMENT_FIVE, parameters.length);
                    setHoursCommand(parameters[SECOND_PARAMETER], parameters[THIRD_PARAMETER],
                            parameters[FOURTH_PARAMETER], parameters[FIFTH_PARAMETER], company);
                    break;
                case "PA":
                    printCommand(PRINT_ALL, company);
                    break;
                case "PH":
                    printCommand(PRINT_DATE, company);
                    break;
                case "PD":
                    printCommand(PRINT_DEPARTMENT, company);
                    break;
                case "Q":
                    payrollProcessingSession = false;
                default:

            }
        }
        System.out.println("Payroll Processing Session ended.");
        scan.close();
    }
}
