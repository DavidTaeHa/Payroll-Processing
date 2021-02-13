/**
 * This class represents a company container that will contain instances of employees
 *
 * @author David Ha, Andrew McAvoy
 */
public class Company {
    private Employee[] emplist;
    private int numEmployee;

    final static int LIST_INCREMENT_VALUE = 4;
    final static int INVALID = -1;

    public Company(){
        emplist = new Employee[LIST_INCREMENT_VALUE];
        numEmployee = 0;
    }

    /**
     * Helper method to help find an employee in the employee container
     * @param employee Employee to be found
     * @return index of the employee in the container; -1 if not found
     */
    private int find(Employee employee) {
        for (int index = 0; index < emplist.length; index++) {
            if ((emplist[index] != null) && emplist[index].equals(employee)) {
                return index;
            }
        }
        return INVALID;
    }

    /**
     * Helper method to increase capacity of array if the container if full
     */
    private void grow() {
        Employee[] temp = new Employee[emplist.length + LIST_INCREMENT_VALUE];
        for (int i = 0; i < emplist.length; i++) {
            temp[i] = emplist[i];
        }
        emplist = temp;
    }

    /**
     * Adds a new employee to the container
     * @param employee employee to be added
     * @return true if successfully added; false if already exists
     */
    public boolean add(Employee employee) {
        if(numEmployee == emplist.length){
            grow();
        }

    } //check the profile before adding

    /**
     * Removes employee from container
     * @param employee employee to be removed
     * @return true if successfully removed; false if employee does not exist
     */
    public boolean remove(Employee employee) {
        return true;
    } //maintain the original sequence

    /**
     * Sets number of hours for an employee
     * @param employee employee's hours to be modified
     * @return true if successfully modified; false if employee does not exist
     */
    public boolean setHours(Employee employee) {
        return true;
    } //set working hours for a part time

    /**
     * Calculates payments for all employees in the container
     */
    public void processPayments() {

    } //process payments for all employees

    /**
     * Prints earning statements for all employees
     */
    public void print() {

    } //print earning statements for all employees

    /**
     * Prints earning statements by department
     */
    public void printByDepartment() {

    } //print earning statements by department

    /**
     * Prints earning statements by date hired
     */
    public void printByDate() {

    } //print earning statements by date hired
}
