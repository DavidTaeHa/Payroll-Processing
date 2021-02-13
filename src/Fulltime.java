import java.text.DecimalFormat;

/**
 * This class extends the employee class and contains data elements and operations specific to a full-time employee
 *
 * @author David Ha, Andrew McAvoy
 */
public class Fulltime extends Employee{
    private double annualSalary;

    /**
     * Constructor for Fulltime class
     *
     * @param profile profile for the employee
     */
    public Fulltime(Profile profile, double annualSalary) {
        super(profile);
        this.annualSalary = annualSalary;
    }

    @Override
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("$###,###,##0.00");
        return super.toString() + "::FULL TIME::" + "Annual Salary " + formatter.format(annualSalary);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Fulltime){
            Fulltime temp = (Fulltime) obj;
            return (super.equals(temp)) && (annualSalary == temp.annualSalary);
        }
        return false;
    }
}
