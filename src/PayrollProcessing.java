import java.util.Scanner;
import java.lang.Exception;

/**
 * This class will handle all user input and output
 *
 * @author David Ha, Andrew McAvoy
 */
public class PayrollProcessing {
    private boolean payrollProcessingSession;

    /**
     * Constructor for PayrollProcessing class
     */
    public PayrollProcessing(){
        payrollProcessingSession = true;
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
            switch(input){
                case "AP":
                    //add parttime
                case "AF":
                    //add fulltime
                case "AM":
                    //add manager
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
