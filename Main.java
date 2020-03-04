/**
 * @author OGUZHAN SENTURK
 */
public class Main {
    /**
     * @param args to main
     */
    public static void main(String[] args) {
        Automation_System system = new Automation_System();
        //Default admin must be entered system to use admin menu
        Admin obj = new Admin("OĞUZHAN", "ŞENTÜRK", "123", "1");
        system.getAdmin_array().add(obj);
        system.ShowMenu();
    }
}