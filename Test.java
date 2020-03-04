/**
 * @author OGUZHAN SENTURK
 */
public class Test {

    public void test_case() {
        System.out.println("----- TEST -----");
        Automation_System system = new Automation_System();

        System.out.println("Creating Admin...");
        Admin admin = new Admin("Oğuzhan", "Şentürk", "1","1");
        system.add_admin(admin);
        system.print_admin_array();

        System.out.println("Creating Admin...");
        Admin admin2 = new Admin("Başak", "Karakaş", "2","2");
        system.add_admin(admin2);
        system.print_admin_array();

        System.out.println("Admin Adding Branch...");
        Branch branch1 = new Branch("Kadikoy");
        admin.add_branch(system.getBranch_array(), branch1);
        system.print_branch_array();

        System.out.println("Admin Adding Branch...");
        Branch branch2 = new Branch("Maltepe");
        admin.add_branch(system.getBranch_array(), branch2);
        system.print_branch_array();

        System.out.println("Admin Deleting Branch " + branch1.getName() + "...");
        admin.delete_branch(system.getBranch_array(), 0);
        system.print_branch_array();

        System.out.println("Admin Adding Branch Employee at " + branch2.getName() + "...");
        Branch_Employee employee1 = new Branch_Employee("Muhammed", "Özkan", "3","3");
        admin.add_branch_employee(branch2.getBranch_employee_array(), employee1);
        branch2.print_branch_employee_array();

        System.out.println("Admin Adding Branch Employee at " + branch2.getName() + "...");
        Branch_Employee employee2 = new Branch_Employee("Cem", "Doğan", "4","4");
        admin.add_branch_employee(branch2.getBranch_employee_array(), employee2);
        branch2.print_branch_employee_array();

        System.out.println("Admin Deleting Branch Employee from " + branch2.getName() + "...");
        admin.delete_branch_employee(branch2.getBranch_employee_array(), 1);
        branch2.print_branch_employee_array();

        System.out.println("Admin Adding Transportation Personnel " + branch2.getName() + "...");
        Transportation_Personnel employee3 = new Transportation_Personnel("Beyza", "Aydogmuş", "5","5");
        admin.add_transportation_personnel(branch2.getTransportation_personnel_array(), employee3);
        branch2.print_transportation_personnel_array();

        System.out.println("Admin Adding Transportation Personnel " + branch2.getName() + "...");
        Transportation_Personnel employee4 = new Transportation_Personnel("Burak", "Tekdamar", "6","6");
        admin.add_transportation_personnel(branch2.getTransportation_personnel_array(), employee4);
        branch2.print_transportation_personnel_array();

        System.out.println("Admin Deleting Transportation Personnel from " + branch2.getName() + "...");
        admin.delete_transportation_personnel(branch2.getTransportation_personnel_array(), 1);
        branch2.print_transportation_personnel_array();

        System.out.println("Branch Employee Adding Customer...");
        Customer customer1 = new Customer("Ali", "Biçim", "7","7");
        employee1.add_customer(system.getCustomer_array(),customer1);
        system.print_customer_array();

        System.out.println("Branch Employee Adding Customer...");
        Customer customer2 = new Customer("MesutCan", "Tomay", "8","8");
        employee1.add_customer(system.getCustomer_array(),customer2);
        system.print_customer_array();

        System.out.println("Branch Employee Adding Customer...");
        Customer customer3 = new Customer("Demet", "Akalın", "9","9");
        employee1.add_customer(system.getCustomer_array(),customer3);
        system.print_customer_array();

        System.out.println("Branch Employee Deleting Customer...");
        employee1.delete_customer(system.getCustomer_array(),1);
        system.print_customer_array();

        System.out.println("Creating cargo and adding system by Branch Eployee...");
        Cargo cargo1 = new Cargo(customer1,customer3 ,"1111", "On Branch");
        employee1.add_info(system.getCargo_array(),cargo1);
        system.print_cargo_array();

        System.out.println("Creating cargo and adding system by Branch Eployee...");
        Cargo cargo2 = new Cargo(customer3,customer1 ,"2222", "On Branch");
        employee1.add_info(system.getCargo_array(),cargo2);
        system.print_cargo_array();

        System.out.println("Cargo removing system by Branch Employee...");
        employee1.delete_info(system.getCargo_array(),0);
        system.print_cargo_array();

        System.out.println("Customer Checking Cargo with tracking number...");
        system.print_cargo_info(0);
        System.out.println("Cargo Delivering by transportation personnel...");
        employee3.update_cargo(system.getCargo_array(),0);
        System.out.println("Checking Cargo with tracking number...");
        system.print_cargo_info(0);

    }
}

