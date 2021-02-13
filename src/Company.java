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
     * Helper method to check if an employee profile already exists in the container
     *
     * @param employee
     * @return
     */
    private boolean isDuplicate(Employee employee){
        for(int i = 0; i < emplist.length; i++){
            if(emplist[i].equals(employee.getProfile().equals(employee.getProfile()))){
                return true;
            }
        }
        return false;
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
        if(isDuplicate(employee)){
            return false;
        }
        emplist[numEmployee] = employee;
        numEmployee++;
        return true;
    }

    /**
     * Removes employee from container
     *
     * @param employee employee to be removed
     * @return true if successfully removed; false if employee does not exist
     */
    public boolean remove(Employee employee) {
        int index = find(employee);
        if(index == INVALID){
            return false;
        }
        emplist[index] = null;
        numEmployee--;
        for (int i = index; i < (emplist.length - 1); i++) {
            emplist[i] = emplist[i + 1];
        }
        return true;
    }

    /**
     * Sets number of hours for a parttime employee
     * @param employee employee's hours to be modified
     * @return true if successfully modified; false if employee does not exist
     */
    public boolean setHours(Employee employee) {
        int index = find(employee);
        if(index == INVALID){
            return false;
        }


        if(emplist[index] instanceof Parttime){
            Parttime temp = (Parttime) emplist[index];
            temp.setHoursWorked();
        }
    }

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
