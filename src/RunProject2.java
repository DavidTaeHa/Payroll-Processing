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
        Fulltime fulltime = new Fulltime(profile, 85000);
        Fulltime fulltime2 = new Fulltime(profile, 85000);
        Parttime parttime = new Parttime(profile,43.9);
        Parttime parttime2 = new Parttime(profile,43.9);
        System.out.println(parttime.equals(parttime2));
        System.out.println(parttime);
    }
}
