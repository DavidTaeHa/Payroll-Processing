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
    final static int DEPARTMENT_HEAD = 2;
    final static int DIRECTOR = 3;
    final static int PARTTIME = 4;
    final static int FULLTIME = 5;

    /**
     * Constants used for getting parameters from the array of inputs
     */
    final static int FIRST_PARAMETER = 0;
    final static int SECOND_PARAMETER = 1;
    final static int THIRD_PARAMETER = 2;
    final static int FOURTH_PARAMETER = 3;
    final static int FIFTH_PARAMETER = 4;
    final static int SIXTH_PARAMETER = 5;
    final static int LENGTH_REQUIREMENT_FIVE = 5;
    final static int LENGTH_REQUIREMENT_SIX = 6;

    /**
     * Constructor for PayrollProcessing class
     */
    public PayrollProcessing(){
        payrollProcessingSession = true;
    }

    /**
     * Private method to check if the length of the array of parameters is correct
     */
    private void checkLength(int expectedLength, int actualLength){
        if(actualLength != expectedLength){
            throw new InputMismatchException("Invalid Command!");
        }
    }

    /**
     * Private method to aid in adding a new fulltime or parttime to the company container
     */
    private void addCommand(String name, String department, String dateHired, String pay, int role, Company company){
        Date date = new Date(dateHired);
        if(!date.isValid()){
            throw new InputMismatchException(dateHired + " is not a valid date!");
        }
        if(!department.equals("CS") && !department.equals("ECE") && !department.equals("IT")){
            throw new InputMismatchException("Invalid department code!");
        }
        Profile profile = new Profile(name, department, date);
        if(role == PARTTIME){
            Parttime parttime = new Parttime (profile, Double.parseDouble(pay));
            company.add(parttime);
        }
        else if(role == FULLTIME){
            Fulltime fulltime = new Fulltime (profile, Double.parseDouble(pay));
            company.add(fulltime);
        }
        System.out.println("Employee added.");
    }

    /**
     * Private method to aid in adding new management to the company container
     */
    private void addCommand(String name, String department, String dateHired, String salary, String managementRole, Company company){
        Date date = new Date(dateHired);
        if(!date.isValid()){
            throw new InputMismatchException(dateHired + " is not a valid date!");
        }
        if(!department.equals("CS") && !department.equals("ECE") && !department.equals("IT")){
            throw new InputMismatchException("Invalid department code!");
        }
        if(Integer.parseInt(managementRole) > 3 || Integer.parseInt(managementRole) < 0){
            throw new InputMismatchException("Invalid management code!");
        }
        Profile profile = new Profile(name, department, date);
        Management management = new Management(profile, Double.parseDouble(salary), Integer.parseInt(managementRole));
        company.add(management);
        System.out.println("Employee added.");
    }

    /**
     * Handles all user input and output
     */
    public void run(){
        Company company = new Company();
        Scanner scan = new Scanner(System.in);
        System.out.println("Payroll Processing Session Running.");
        while(payrollProcessingSession){
            String input = scan.nextLine();
            String[] parameters = input.split(" ");
            String command = parameters[FIRST_PARAMETER];
            switch(command){
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
                    //remove
                case "C":
                    //calculate payment
                case "S":
                    //set hours
                case "PA":
                    //print all
                case "PH":
                    //print date hired
                case "PD":
                    //print department
                case "Q":
                    payrollProcessingSession = false;
                default:
                    
            }
        }
    }
}
