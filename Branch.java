import java.util.ArrayList;
/**
 * @author OGUZHAN SENTURK
 */
public class Branch {

    private String name;
    ArrayList<Branch_Employee> branch_employee_array = new ArrayList<Branch_Employee>();
    ArrayList<Transportation_Personnel> transportation_personnel_array = new ArrayList<Transportation_Personnel>();

    /**
     * Constructor
     * @param name This is initialize to Branch name
     */
    public Branch(String name) {
        this.name = name;
    }
    /**
     * @param id This is ID of branch employee
     * @return This returns index of branch employee otherwise returns -1
     */
    public int search_branch_employee_array (String id){
        for (int i = 0; i < branch_employee_array.size() ; i++) {
            if (id.equals(branch_employee_array.get(i).getUser_id()))  {
                return i;
            }
        }
        return -1;
    }
    public int search_branch_employee_array (String password,String id){
        for (int i = 0; i < branch_employee_array.size() ; i++) {
            if (password.equals(branch_employee_array.get(i).getPassword()) &&
                    id.equals(branch_employee_array.get(i).getUser_id()))  {
                return i;
            }
        }
        return -1;
    }
    /**
     * @param id This is ID of transportation personnel
     * @return This returns index of transportation personnel otherwise returns -1
     */
    public int search_transportation_personnel_array (String id){
        for (int i = 0; i < transportation_personnel_array.size() ; i++) {
            if (id.equals(transportation_personnel_array.get(i).getUser_id())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @param password This is password of transportation personnel
     * @param id This is ID of transportation personnel
     * @return This returns index of transportation personnel otherwise returns -1
     */
    public int search_transportation_personnel_array (String password,String id){
        for (int i = 0; i < transportation_personnel_array.size() ; i++) {
            if (password.equals(transportation_personnel_array.get(i).getPassword()) &&
                    id.equals(transportation_personnel_array.get(i).getUser_id())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @return This return Branch name
     */
    public String getName() {
        return name;
    }
    /**
     * @param name This is new name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return This return branch_employee_array
     */
    public ArrayList<Branch_Employee> getBranch_employee_array() {
        return branch_employee_array;
    }
    /**
     * @param branch_employee_array This is new branch_employee_array
     */
    public void setBranch_employee_array(ArrayList<Branch_Employee> branch_employee_array) {
        this.branch_employee_array = branch_employee_array;
    }
    /**
     * @return This return transportation_personnel_array
     */
    public ArrayList<Transportation_Personnel> getTransportation_personnel_array() {
        return transportation_personnel_array;
    }
    /**
     * @param transportation_personnel_array This is new transportation_personnel_array
     */
    public void setTransportation_personnel_array(ArrayList<Transportation_Personnel> transportation_personnel_array) {
        this.transportation_personnel_array = transportation_personnel_array;
    }
    /**
     *  Function of print transportation branch_employee_array
     */
    public void print_branch_employee_array(){
        for (int i = 0; i < branch_employee_array.size(); i++) {
            System.out.println(i+1 + ") " + branch_employee_array.get(i).getName() + " " +
                    branch_employee_array.get(i).getSurname());
        }
    }
    /**
     * Function of print transportation_personnel_array
     */
    public void print_transportation_personnel_array(){
        for (int i = 0; i < transportation_personnel_array.size(); i++) {
            System.out.println(i+1 + ") " + transportation_personnel_array.get(i).getName() + " " +
                    transportation_personnel_array.get(i).getSurname());
        }
    }
}
