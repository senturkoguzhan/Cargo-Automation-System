import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author OGUZHAN SENTURK
 */
public class Branch_Employee extends User {
    /**
     * Default constructor
     */
    public Branch_Employee() {
    }
    /**
     * Constructor of Branch_Employee Class calls super class's constructor
     * @param name This is name of branch employee
     * @param surname This is surname of branch employee
     * @param password This is password of branch employee
     * @param user_id This is ID of branch employee
     */
    public Branch_Employee(String name, String surname, String password, String user_id) {
        super(name, surname, password, user_id);
    }
    /**
     * @param obj This is Automation_System object to access data in system
     * @exception java.util.InputMismatchException if user enter input that not expected like a string
     * @exception java.lang.IndexOutOfBoundsException if user try log in the system with not exist account
     */
    @Override
    public void ShowMenu(Automation_System obj) {
        try {
            int customer_index;
            int branch_employee_index;
            int branch_index;
            int customer2_index;
            int cargo_index;
            int check_valid;
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Please Enter Branch Employee ID");
            String input_id = scanner2.nextLine();
            System.out.println("Please Enter Branch Employee Branch Name");
            String input_branch = scanner2.nextLine();
            System.out.println("Please Enter Branch Employee Password");
            String input_password = scanner2.nextLine();
            branch_index = obj.search_branch_array(input_branch);
            branch_employee_index = obj.getBranch_array().get(branch_index).search_branch_employee_array
                    ( input_password, input_id);
            if (branch_employee_index != -1 && branch_index != -1) {
                Scanner scanner;
                int input2 = 0;
                do {
                    try {
                        System.out.println("---- BRANCH EMPLOYEE " + obj.getBranch_array().get(branch_index)
                                .getBranch_employee_array().get(branch_employee_index).getName()+ " " +
                                obj.getBranch_array().get(branch_index)
                                        .getBranch_employee_array().get(branch_employee_index).getSurname()+ " ----");
                        System.out.println(" 1) Add Customer");
                        System.out.println(" 2) Remove Customer");
                        System.out.println(" 3) Add Cargo");
                        System.out.println(" 4) Remove Cargo");
                        System.out.println(" 5) Check Cargo Status");
                        System.out.println(" 6) Change Password");
                        System.out.println(" 7) Exit");
                        scanner = new Scanner(System.in);
                        input2 = scanner.nextInt();
                        switch (input2) {
                            case 1:
                                System.out.println("Please Enter Customer Name");
                                String input_name2 = scanner2.nextLine();
                                System.out.println("Please Enter Customer Surname");
                                String input_surname2 = scanner2.nextLine();
                                System.out.println("Please Enter Customer ID");
                                String input_id2 = scanner2.nextLine();
                                System.out.println("Please Enter Customer Password");
                                String input_password2 = scanner2.nextLine();
                                check_valid = obj.search_customer_array(input_id2);
                                if(check_valid == -1){
                                    Customer customer = new Customer(input_name2, input_surname2, input_password2, input_id2);
                                    add_customer(obj.getCustomer_array(), customer);
                                    System.out.println("CUSTOMER ADDED ON THE SYSTEM");
                                }
                                else{
                                    System.out.println("THIS ID ALREADY TAKEN");
                                }

                                break;
                            case 2:
                                System.out.println("Please Enter Customer ID");
                                input_id2 = scanner2.nextLine();
                                customer_index = obj.search_customer_array(input_id2);
                                if (customer_index != -1) {
                                    delete_customer(obj.getCustomer_array(),customer_index);
                                    System.out.println("CUSTOMER REMOVED ON THE SYSTEM");
                                } else {
                                    System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                                }
                                break;
                            case 3:
                                System.out.println("Please Enter Sender ID");
                                input_id2 = scanner2.nextLine();
                                System.out.println("Please Enter Receiver ID");
                                String input_id3 = scanner2.nextLine();
                                System.out.println("Please Enter Tracking Number");
                                String input_trackid = scanner2.nextLine();
                                customer_index = obj.search_customer_array( input_id2);
                                customer2_index = obj.search_customer_array( input_id3);
                                if (customer_index != -1 && customer2_index != -1 ) {
                                    check_valid = obj.search_cargo_array(input_trackid);
                                    if(check_valid == -1){
                                        System.out.println("CARGO ADDED ON THE SYSTEM");
                                        Cargo cargo = new Cargo(obj.getCustomer_array().get(customer_index),
                                                obj.getCustomer_array().get(customer2_index),input_trackid,
                                                "ON THE BRANCH");
                                        add_info(obj.getCargo_array(),cargo);
                                    }
                                    else{
                                        System.out.println("THIS TRACKING NUMBER ALREADY TAKEN");
                                    }

                                } else {
                                    System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                                }
                                break;
                            case 4:
                                System.out.println("Please Enter Tracking Number");
                                input_trackid = scanner2.nextLine();
                                cargo_index = obj.search_cargo_array(input_trackid);
                                if (cargo_index != -1) {
                                    delete_info(obj.getCargo_array(),cargo_index);
                                    System.out.println("CARGO REMOVED ON THE SYSTEM");
                                } else {
                                    System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                                }
                                break;
                            case 5:
                                System.out.println("Please Enter Tracking Number");
                                input_trackid = scanner2.nextLine();
                                cargo_index = obj.search_cargo_array(input_trackid);
                                if (cargo_index != -1) {
                                    obj.print_cargo_info(cargo_index);
                                } else {
                                    System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                                }
                                break;
                            case 6:
                                System.out.println("Please Enter New Password");
                                String input_password3 = scanner2.nextLine();
                                obj.getBranch_array().get(branch_index).getBranch_employee_array()
                                        .get(branch_employee_index).setPassword(input_password3);
                                System.out.println("PASSWORD CHANGED");
                                break;
                            default:
                                break;
                        }
                    }
                    catch (java.util.InputMismatchException ignored) {
                    }
                } while (input2 != 7);
            }
            else {
                System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
            }
        }
        catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
        }
    }
    /**
     * @param arr This is customer_array
     * @param customer This is new customer object that want to add
     * @exception NullPointerException if reference is null
     */
    public void add_customer(ArrayList<Customer> arr, Customer customer) {
        try {
            arr.add(customer);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
    /**
     * @param arr This is customer_array
     * @param index This is cargo index that want to delete
     * @exception NullPointerException if reference is null
     */
    public void delete_customer(ArrayList<Customer> arr, int index) {
        try {
            arr.remove(index);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
    /**
     * @param arr This is cargo_array
     * @param cargo This is new cargo object that want to add
     * @exception NullPointerException if reference is null
     */
    public void add_info(ArrayList<Cargo> arr, Cargo cargo) {
        try {
            arr.add(cargo);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
    /**
     * @param arr This is cargo_array
     * @param index This is cargo index that want to delete
     * @exception NullPointerException if reference is null
     */
    public void delete_info(ArrayList<Cargo> arr, int index) {
        try {
            arr.remove(index);
        } catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
}
