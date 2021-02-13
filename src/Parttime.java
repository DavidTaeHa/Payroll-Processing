import java.text.DecimalFormat;

/**
 * This class extends the employee class and contains data elements and operations specific to a part-time employee
 *
 * @author David Ha, Andrew McAvoy
 */
public class Parttime extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    /**
     * Constructor for Parttime class
     *
     * @param profile profile for the employee
     */
    public Parttime(Profile profile, double hourlyRate) {
        super(profile);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    @Override
    public String toString(){
        DecimalFormat formatter = new DecimalFormat("$###,###,##0.00");
        return super.toString() + "::PART TIME::" + "Hourly Rate " + formatter.format(hourlyRate);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Parttime){
            Parttime temp = (Parttime) obj;
            return (super.equals(temp)) && (hourlyRate == temp.hourlyRate) && (hoursWorked == temp.hoursWorked);
        }
        return false;
    }
}
