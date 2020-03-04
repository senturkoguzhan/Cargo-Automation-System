import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author OGUZHAN SENTURK
 */
public class Admin extends User {
    /**
     * Default constructor
     */
    public Admin() {
    }
    /**
     * Constructor of Admin Class calls super class's constructor
     * @param name This is name of admin
     * @param surname This is surname of admin
     * @param password This is password of admin
     * @param user_id This is ID of admin
     */
    public Admin(String name, String surname, String password, String user_id) {
        super(name, surname, password, user_id);
    }
    /**
     * @param obj This is Automation_System object to access data in system
     * @exception java.util.InputMismatchException if user enter input that not expected like a string
     */
    @Override
    public void ShowMenu(Automation_System obj) {
        int admin_index;
        int branch_index;
        int check_valid;
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Please Enter Admin ID");
        String input_id = scanner3.nextLine();
        System.out.println("Please Enter Admin Password");
        String input_password = scanner3.nextLine();
        admin_index = obj.search_admin_array(input_id,input_password);
        if (admin_index !=- 1) {
            Scanner scanner ;
            int input2 = 0;
            do {
                try {
                    System.out.println("---- ADMIN " + obj.getAdmin_array().get(admin_index).getName()
                            + " " + obj.getAdmin_array().get(admin_index).getSurname() + " ----");
                    System.out.println(" 1) Add Branch");
                    System.out.println(" 2) Remove Branch");
                    System.out.println(" 3) Add Branch Employee");
                    System.out.println(" 4) Remove Branch Employee");
                    System.out.println(" 5) Add Transportation Personnel");
                    System.out.println(" 6) Remove Transportation Personnel");
                    System.out.println(" 7) Add Admin");
                    System.out.println(" 8) Check Cargo Status");
                    System.out.println(" 9) Change Password");
                    System.out.println(" 10) Exit");
                    scanner = new Scanner(System.in);
                    input2 = scanner.nextInt();
                    switch (input2){
                        case 1 :
                            System.out.println("Please Enter Branch Name");
                            String input_name2 = scanner3.nextLine();
                            check_valid = obj.search_branch_array(input_name2);
                            if(check_valid == -1){
                                Branch branch = new Branch(input_name2);
                                add_branch(obj.getBranch_array(),branch);
                                System.out.println("BRANCH ADDED ON THE SYSTEM" );
                            }
                            else{
                                System.out.println("THIS NAME ALREADY TAKEN");
                            }
                            break;
                        case 2 :
                            System.out.println("Please Enter Branch Name");
                            input_name2 = scanner3.nextLine();
                            branch_index = obj.search_branch_array(input_name2);
                            if (branch_index != -1){
                                delete_branch(obj.getBranch_array(),branch_index);
                                System.out.println("BRANCH REMOVED ON THE SYSTEM");
                            }
                            else{
                                System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                            }
                            break;
                        case 3 :
                            System.out.println("Please Enter Branch Employee Name");
                            String input_name3 = scanner3.nextLine();
                            System.out.println("Please Enter Branch Employee Surname");
                            String input_surname3 = scanner3.nextLine();
                            System.out.println("Please Enter Branch Employee ID");
                            String input_id3 = scanner3.nextLine();
                            System.out.println("Please Enter Branch Employee Password");
                            String input_password3 = scanner3.nextLine();
                            System.out.println("Please Enter Branch Name:");
                            String input_branch3 = scanner3.nextLine();
                            branch_index = obj.search_branch_array(input_branch3);
                            if (branch_index != -1){
                                check_valid = obj.getBranch_array().get(branch_index).search_branch_employee_array(input_id3);
                                if(check_valid == -1){
                                    Branch_Employee branch_employee = new
                                            Branch_Employee(input_name3,input_surname3,input_password3,input_id3);
                                    add_branch_employee(obj.getBranch_array().get(branch_index)
                                            .getBranch_employee_array(), branch_employee);
                                    System.out.println("BRANCH EMPLOYEE ADDED ON THE SYSTEM");
                                }
                                else{
                                    System.out.println("THIS ID ALREADY TAKEN");
                                }
                            }
                            else {
                                System.out.println("BRANCH NOT FOUND ON THE SYSTEM");
                            }
                            break;
                        case 4 :
                            System.out.println("Please Enter Branch Employee ID");
                            input_id3 = scanner3.nextLine();
                            System.out.println("Please Enter Branch Name:");
                            input_branch3 = scanner3.nextLine();
                            branch_index = obj.search_branch_array(input_branch3);
                            if (branch_index != -1) {
                                int index = obj.getBranch_array().get(branch_index).search_branch_employee_array
                                        (input_id3);
                                if (index != -1) {
                                    delete_branch_employee(obj.getBranch_array().get(branch_index)
                                            .getBranch_employee_array(),index);
                                    System.out.println("BRANCH EMPLOYEE REMOVED ON THE SYSTEM");
                                }
                                else {
                                    System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                                }
                            }
                            else {
                                System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                            }
                            break;
                        case 5 :
                            System.out.println("Please Enter Transportation Personnel Name");
                            input_name3 = scanner3.nextLine();
                            System.out.println("Please Enter Transportation Personnel Surname");
                            input_surname3 = scanner3.nextLine();
                            System.out.println("Please Enter Transportation Personnel ID");
                            input_id3 = scanner3.nextLine();
                            System.out.println("Please Enter Transportation Personnel Password");
                            input_password3 = scanner3.nextLine();
                            System.out.println("Please Enter Branch Name:");
                            input_branch3 = scanner3.nextLine();
                            branch_index = obj.search_branch_array(input_branch3);
                            if (branch_index != -1){
                                check_valid = obj.getBranch_array().get(branch_index).search_transportation_personnel_array(input_id3);
                                if(check_valid == -1){
                                    Transportation_Personnel transportation_personnel = new
                                            Transportation_Personnel(input_name3,input_surname3,input_password3,input_id3);
                                    add_transportation_personnel(obj.getBranch_array().get(branch_index)
                                            .getTransportation_personnel_array(), transportation_personnel);
                                    System.out.println("TRANSPORTATION PERSONNEL ADDED ON THE SYSTEM");
                                }
                                else{
                                    System.out.println("THIS ID ALREADY TAKEN");
                                }

                            }
                            else {
                                System.out.println("BRANCH NOT FOUND ON THE SYSTEM");
                            }
                            break;
                        case 6 :
                            System.out.println("Please Enter Transportation Personnel ID");
                            input_id3 = scanner3.nextLine();
                            System.out.println("Please Enter Branch Name:");
                            input_branch3 = scanner3.nextLine();
                            branch_index = obj.search_branch_array(input_branch3);
                            if (branch_index != -1) {
                                int index = obj.getBranch_array().get(branch_index)
                                        .search_transportation_personnel_array
                                                ( input_id3);
                                if (index != -1) {
                                    delete_transportation_personnel(obj.getBranch_array().get(branch_index)
                                            .getTransportation_personnel_array(),index);
                                    System.out.println("TRANSPORTATION PERSONNEL REMOVED ON THE SYSTEM");
                                }
                                else {
                                    System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                                }
                            }
                            else {
                                System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                            }
                            break;
                        case 7:
                            System.out.println("Please Enter Admin Name");
                            input_name3 = scanner3.nextLine();
                            System.out.println("Please Enter Admin Surname");
                            input_surname3 = scanner3.nextLine();
                            System.out.println("Please Enter Admin ID");
                            input_id3 = scanner3.nextLine();
                            System.out.println("Please Enter Admin Password");
                            input_password3 = scanner3.nextLine();
                            check_valid = obj.search_admin_array(input_id3);
                            if(check_valid == -1){
                                Admin admin = new Admin(input_name3,input_surname3,input_password3,input_id3);
                                obj.add_admin(admin);
                                System.out.println("ADMIN ADDED ON THE SYSTEM");
                            }
                            else{
                                System.out.println("THIS ID ALREADY TAKEN");
                            }
                            break;
                        case 8 :
                            System.out.println("Please Enter Tracking Number");
                            String input_trackid = scanner3.nextLine();
                            int cargo_index = obj.search_cargo_array(input_trackid);
                            if (cargo_index != -1){
                                obj.print_cargo_info(cargo_index);
                            }
                            else {
                                System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                            }
                            break;
                        case 9 :
                            System.out.println("Please Enter New Password");
                            input_password3 = scanner3.nextLine();
                            obj.getAdmin_array().get(admin_index).setPassword(input_password3);
                            System.out.println("PASSWORD CHANGED");
                            break;
                        default :
                            break;
                    }
                }
                catch (java.util.InputMismatchException ignored) {
                }
            }while( input2 != 10);
        }
        else {
            System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
        }
    }
    /**
     * @param arr This is branch_array
     * @param branch This is new branch object that want to add
     * @exception NullPointerException if reference is null
     */
    public void add_branch(ArrayList<Branch> arr, Branch branch) {
        try {
            arr.add(branch);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
    /**
     * @param arr This is branch_array
     * @param index This is branch index that want to delete
     * @exception NullPointerException if reference is null
     */
    public void delete_branch(ArrayList<Branch> arr, int index) {
        try {
            arr.remove(index);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
    /**
     * @param arr This is cargo_array
     * @param employee This is new cargo object that want to add
     * @exception NullPointerException if reference is null
     */
    public void add_branch_employee(ArrayList<Branch_Employee> arr, Branch_Employee employee) {
        try {
            arr.add(employee);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
    /**
     * @param arr This is cargo_array
     * @param index This is branch employee index employee that want to delete
     * @exception NullPointerException if reference is null
     */
    public void delete_branch_employee(ArrayList<Branch_Employee> arr, int index) {
        try {
            arr.remove(index);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
    /**
     * @param arr This is cargo_array
     * @param personnel This is new cargo object that want to add
     * @exception NullPointerException if reference is null
     */
    public void add_transportation_personnel(ArrayList<Transportation_Personnel> arr,Transportation_Personnel personnel) {
        try {
            arr.add(personnel);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
    /**
     * @param arr This is cargo_array
     * @param index This is transportation personnel index that want to delete
     * @exception NullPointerException if reference is null
     */
    public void delete_transportation_personnel(ArrayList<Transportation_Personnel> arr, int index) {
        try {
            arr.remove(index);
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
}

