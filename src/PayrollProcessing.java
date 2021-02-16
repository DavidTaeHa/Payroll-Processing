import java.util.Scanner;

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
    }
}
