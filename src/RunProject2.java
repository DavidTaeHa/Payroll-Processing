/**
 *This class contains the main method that will run the project
 *
 * @author David Ha, Andrew McAvoy
 */
public class RunProject2 {
    public static void main(String[] args) {
        Date date = new Date();
        Date date2 = new Date("11/10/2019");
        Profile profile = new Profile("Bob","CS",date);
        Profile profile2 = new Profile("Bob","CS",date2);
        Employee employee = new Employee(profile);
        Employee employee2 = new Employee(profile2);
        System.out.println(employee.equals(employee2));
    }
}
