import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author OGUZHAN SENTURK
 */
public class Transportation_Personnel extends User {
    /**
     * Default Constructor
     */
    public Transportation_Personnel() {
    }
    /**
     * Constructor of Transportation_Personnel Class calls super class's constructor
     * @param name This is name of transportation personnel
     * @param surname This is surname of transportation personnel
     * @param password This is password of transportation personnel
     * @param user_id This is ID of branch transportation personnel
     */
    public Transportation_Personnel(String name, String surname, String password, String user_id) {
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
            int cargo_index;
            int branch_index;
            int transportation_personnel_index;
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Please Enter Transportation Personnel ID");
            String input_id = scanner2.nextLine();
            System.out.println("Please Enter Transportation Personnel Branch Name");
            String input_branch = scanner2.nextLine();
            System.out.println("Please Enter Transportation Personnel Password");
            String input_password = scanner2.nextLine();
            branch_index = obj.search_branch_array(input_branch);
            transportation_personnel_index = obj.getBranch_array().get(branch_index).search_transportation_personnel_array
                    (input_password, input_id);
            if (branch_index != -1 && transportation_personnel_index != -1) {
                Scanner scanner;
                int input2 = 0;
                do {
                    try {
                        System.out.println("---- TRANSPORTATION PERSONNEL " + obj.getBranch_array().get(branch_index)
                                .getTransportation_personnel_array().get(transportation_personnel_index).getName()
                                + " " + obj.getBranch_array().get(branch_index).getTransportation_personnel_array()
                                .get(transportation_personnel_index).getSurname()  + " ----");
                        System.out.println(" 1) Update Cargo Status");
                        System.out.println(" 2) Check Cargo Status");
                        System.out.println(" 3) Change Password");
                        System.out.println(" 4) Exit");
                        scanner = new Scanner(System.in);
                        input2 = scanner.nextInt();
                        switch (input2) {
                            case 1:
                                System.out.println("Please Enter Tracking Number");
                                String input_trackid = scanner2.nextLine();
                                cargo_index = obj.search_cargo_array(input_trackid);
                                if (cargo_index != -1) {
                                    update_cargo(obj.getCargo_array(),cargo_index);
                                    System.out.println("CARGO STATUS UPDATED");
                                } else {
                                    System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                                }
                                break;
                            case 2:
                                System.out.println("Please Enter Tracking Number");
                                input_trackid = scanner2.nextLine();
                                cargo_index = obj.search_cargo_array(input_trackid);
                                if (cargo_index != -1) {
                                    obj.print_cargo_info(cargo_index);
                                } else {
                                    System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                                }
                                break;
                            case 3:
                                System.out.println("Please Enter New Password");
                                String input_password3 = scanner2.nextLine();
                                obj.getBranch_array().get(branch_index).getTransportation_personnel_array()
                                        .get(transportation_personnel_index).setPassword(input_password3);
                                System.out.println("PASSWORD CHANGED");
                                break;
                            default:
                                break;
                        }
                    }
                    catch (java.util.InputMismatchException ignored) {
                    }
                } while (input2 != 4);
            }
            else {
                System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
        }
    }
    /**
     * @param arr This is cargo_array
     * @param index This is cargo index that want to delete
     * @exception NullPointerException if reference is null
     */
    public void update_cargo(ArrayList<Cargo> arr, int index) {
        try {
            arr.get(index).setCargo_status("DELIVERED");
        }
        catch (java.lang.NullPointerException e) {
            System.out.println("NULL POINTER");
        }
    }
}
