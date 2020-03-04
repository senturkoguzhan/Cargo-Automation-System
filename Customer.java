import java.util.Scanner;
/**
 * @author OGUZHAN SENTURK
 *
 */
public class Customer extends User {
    /**
     * Default constructor
     */
    public Customer() {
    }
    /**
     * Constructor of Customer Class calls super class's constructor
     * @param name This is name of customer
     * @param surname This is surname of customer
     * @param password This is password of customer
     * @param user_id This is ID of branch customer
     */
    public Customer(String name, String surname, String password, String user_id) {
        super(name, surname, password, user_id);
    }
    /**
     * @param obj This is Automation_System object to access data in system
     * @exception java.util.InputMismatchException if user enter input that not expected like a string
     */
    @Override
    public void ShowMenu(Automation_System obj) {
        int customer_index;
        int cargo_index;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please Enter Customer ID");
        String input_id = scanner2.nextLine();
        System.out.println("Please Enter Customer Password");
        String input_password = scanner2.nextLine();
        customer_index = obj.search_customer_array(input_password,input_id);
        if (customer_index != -1) {
            Scanner scanner;
            int input2 = 0;
            do {
                try {
                    System.out.println("---- CUSTOMER " + obj.getCustomer_array().get(customer_index).getName()
                            + " " + obj.getCustomer_array().get(customer_index).getSurname()  + " ----");
                    System.out.println(" 1) Check Cargo Status");
                    System.out.println(" 2) Change Password");
                    System.out.println(" 3) Exit");
                    scanner = new Scanner(System.in);
                    input2 = scanner.nextInt();
                    switch (input2) {
                        case 1:
                            System.out.println("Please Enter Tracking Number");
                            String input_trackid = scanner2.nextLine();
                            cargo_index = obj.search_cargo_array(input_trackid);
                            if (cargo_index != -1){
                                obj.print_cargo_info(cargo_index);
                            }
                            else {
                                System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
                            }
                            break;
                        case 2 :
                            System.out.println("Please Enter New Password");
                            String input_password3 = scanner2.nextLine();
                            obj.getCustomer_array().get(customer_index).setPassword(input_password3);
                            System.out.println("PASSWORD CHANGED");
                            break;
                        default:
                            break;
                    }
                }
                catch (java.util.InputMismatchException ignored) {
                }
            } while (input2 != 3);
        }
        else {
            System.out.println("YOUR ENTRY NOT FOUND ON THE SYSTEM");
        }
    }
}
