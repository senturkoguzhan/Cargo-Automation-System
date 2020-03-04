import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author OGUZHAN SENTURK
 */
public class Automation_System {

    ArrayList<Admin> admin_array = new ArrayList<Admin>();
    ArrayList<Branch> branch_array = new ArrayList<Branch>();
    ArrayList<Customer> customer_array = new ArrayList<Customer>();
    ArrayList<Cargo> cargo_array = new ArrayList<Cargo>();

    /**
     * Print cargo info
     * @param index This is cargo index
     */
    public void print_cargo_info(int index){
        System.out.println("Sender : " + cargo_array.get(index).getSender_info().getName()
                + " " + cargo_array.get(index).getSender_info().getSurname()
                + " , Receiver : " + cargo_array.get(index).getReceiver_info().getName()
                + " " + cargo_array.get(index).getReceiver_info().getSurname()
                + " , Cargo Status : " + cargo_array.get(index).getCargo_status());
    }
    /**
     * @param id This is Tracking ID  of cargo
     * @return This returns index of cargo otherwise returns -1
     */
    public int search_cargo_array (String id){
        for (int i = 0; i < cargo_array.size() ; i++) {
            if (id.equals(cargo_array.get(i).getTrack_num())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @param password This is password of customer
     * @param id This is ID of customer
     * @return This returns index of customer otherwise returns -1
     */
    public int search_customer_array ( String password,String id){
        for (int i = 0; i < customer_array.size() ; i++) {
            if (password.equals(customer_array.get(i).getPassword()) &&
                    id.equals(customer_array.get(i).getUser_id())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @param id This is ID of customer
     * @return This returns index of customer otherwise returns -1
     */
    public int search_customer_array (String id){
        for (int i = 0; i < customer_array.size() ; i++) {
            if (id.equals(customer_array.get(i).getUser_id())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @param id This is ID of customer
     * @return This returns index of admin otherwise returns -1
     */
    public int search_admin_array (String id){
        for (int i = 0; i < admin_array.size() ; i++) {
            if (id.equals(admin_array.get(i).getUser_id())) {
                return i;
            }
        }
        return -1;
    }
    public int search_admin_array (String id,String password){
        for (int i = 0; i < admin_array.size() ; i++) {
            if (id.equals(admin_array.get(i).getUser_id())
            && password.equals(admin_array.get(i).getPassword())) {
                return i;
            }
        }
        return -1;
    }
    /**
     * @param name This is name of branch
     * @return This returns index of branch otherwise returns -1
     */
    public int search_branch_array (String name){
        for (int i = 0; i < branch_array.size() ; i++) {
            if (name.equals(branch_array.get(i).getName())){
                return i;
            }
        }
        return -1;
    }
    /**
     * @return This returns customer_array
     */
    public ArrayList<Customer> getCustomer_array() {
        return customer_array;
    }
    /**
     * @param customer_array This is new customer_array
     */
    public void setCustomer_array(ArrayList<Customer> customer_array) {
        this.customer_array = customer_array;
    }
    /**
     * @return This returns cargo_array
     */
    public ArrayList<Cargo> getCargo_array() {
        return cargo_array;
    }
    /**
     * @param cargo_array This is new cargo_array
     */
    public void setCargo_array(ArrayList<Cargo> cargo_array) {
        this.cargo_array = cargo_array;
    }
    /**
     * @param branch_array This is new branch_array
     */
    public void setBranch_array(ArrayList<Branch> branch_array) {
        this.branch_array = branch_array;
    }
    /**
     * @return This returns branch_array
     */
    public ArrayList<Branch> getBranch_array() {
        return branch_array;
    }
    /**
     * @return This returns admin_array
     */
    public ArrayList<Admin> getAdmin_array() {
        return admin_array;
    }
    /**
     * @param admin_array This is new admin_array
     */
    public void setAdmin_array(ArrayList<Admin> admin_array) {
        this.admin_array = admin_array;
    }
    /**
     * This function shows Main menu
     * @exception java.util.InputMismatchException if user enter input that not expected like a string
     */
    public void ShowMenu() {
        int input = 0;
        do {
            try {
                System.out.println("---- CARGO AUTOMATION SYSTEM ----");
                System.out.println(" 1) Admin Menu");
                System.out.println(" 2) Branch Employee Menu");
                System.out.println(" 3) Transportation Personnel Menu");
                System.out.println(" 4) Customer Menu");
                System.out.println(" 5) Test");
                System.out.println(" 6) Exit");
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
                switch (input){
                    case 1 :
                        Admin admin = new Admin();
                        admin.ShowMenu(this);
                        break;
                    case 2 :
                        Branch_Employee branch_employee = new Branch_Employee();
                        branch_employee.ShowMenu(this);
                        break;
                    case 3 :
                        Transportation_Personnel transportation_personnel = new Transportation_Personnel();
                        transportation_personnel.ShowMenu(this);
                        break;
                    case 4 :
                        Customer customer = new Customer();
                        customer.ShowMenu(this);
                        break;
                    case 5 :
                        Test test = new Test();
                        test.test_case();
                    default :
                        break;
                }
            }
            catch (java.util.InputMismatchException ignored) {
            }
        }while( input != 6 );
    }
    /**
     * Print admin array
     */
    public void print_admin_array(){
        for (int i = 0; i < admin_array.size(); i++) {
            System.out.println(i+1 + ") " + admin_array.get(i).getName() + " " + admin_array.get(i).getSurname());
        }
    }
    /**
     * Print branch array
     */
    public void print_branch_array(){
        for (int i = 0; i < branch_array.size(); i++) {
            System.out.println(i+1 + ") " + branch_array.get(i).getName());
        }
    }
    /**
     * Print customer array
     */
    public void print_customer_array(){
        for (int i = 0; i < customer_array.size(); i++) {
            System.out.println(i+1 + ") " + customer_array.get(i).getName() + " " +  customer_array.get(i).getSurname());
        }
    }
    /**
     * Print cargo array
     */
    public void print_cargo_array(){
        for (int i = 0; i < cargo_array.size(); i++) {
            System.out.println(i+1 + ") " + "Sender : "+ cargo_array.get(i).getSender_info().getName() + " "+
                    cargo_array.get(i).getSender_info().getSurname() + " , Receiver : " +
                    cargo_array.get(i).getReceiver_info().getName() +  " " +
                    cargo_array.get(i).getReceiver_info().getSurname());
        }
    }
    /**
     * @param obj This is admin object that want to add
     */
    public void add_admin(Admin obj)
    {
        admin_array.add(obj);
    }
}
