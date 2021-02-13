/**
 * This class defines the profile of an employee
 *
 * @author David Ha, Andrew McAvoy
 */
public class Profile {
    private String name; //Lastname, firstname
    private String department;
    private Date dateHired;

    /**
     * Prints instance of this class in the following format
     * name::department::dateHired
     * @return textual representation of profile
     */
    @Override
    public String toString(){
        return name + "::" + department + "::" + dateHired;
    }

    /**
     * Compares two profiles to see if they are equal
     * @param obj represents another profile to compare
     * @return boolean value true if they are equal false if otherwise
     */
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Profile){
            Profile temp = (Profile) obj;
            return ((name == temp.name) && (department == temp.department) && (dateHired == temp.dateHired));
        }
        return false;
    }
}
