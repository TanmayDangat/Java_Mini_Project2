import java.util.*;

class User {                 // Storing the user information
    private String name;
    private String email;
    private String location;
    private String reporting_manager;
    private double contact_number;
    private String project;
    private String department;
    private String role;

    public User(String name, String email, String location, String reporting_manager, double contact_number, String project, String department, String role) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.reporting_manager = reporting_manager;
        this.contact_number = contact_number;
        this.project = project;
        this.department = department;
        this.role = role;
    }
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getLocation(){
        return location;
    }
    
    public String getReporting_manager(){
        return reporting_manager;
    }
    
    public double getContact_number(){
        return contact_number;
    }
    
    public String getProject(){
        return project;
    }
    
    public String getDepartment(){
        return department;
    }
    
    public String getRole(){
        return role;
    }
}

class SendEmail{             // Class containing the email details
    public void sendEmail(User user) {
        String subject = "Welcome on board";
        String body = "Hi " + user.getName() + "\n" + "Thank you for registering with us. \nWe're excited to have you on board. " + "\n\n" + "Best regards, \nThe team.\n";

        System.out.println("Email sent to : " + user.getEmail());
        System.out.println("Name : " + user.getName());
        System.out.println("Location : " + user.getLocation());
        System.out.println("Reporting Manager : " + user.getReporting_manager());
        System.out.println("Contact Number : " + user.getContact_number());
        System.out.println("Project : " + user.getProject());
        System.out.println("Department : " + user.getDepartment());
        System.out.println("Role : " + user.getRole());
        System.out.println("Subject : " + subject);
        System.out.println("Body : ");
        System.out.println(body);
        System.out.println();
    }
}

class InputDetails{          // Class containing the input details
    ArrayList<User> userList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    public void inputDetails(){
        System.out.print("Enter name : ");
        String name = sc.nextLine();

        System.out.print("Enter email : ");
        String email = sc.nextLine();

        System.out.print("Enter location : ");
        String location = sc.nextLine();

        System.out.print("Enter reporting manager name : ");
        String reporting_manager = sc.nextLine();

        System.out.print("Enter contact number  : ");
        double contact_number = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter project name : ");
        String project = sc.nextLine();

        System.out.print("Enter department name : ");
        String department = sc.nextLine();

        System.out.print("Enter role : ");
        String role = sc.nextLine();
        System.out.println();
            
        User user = new User(name, email, location,reporting_manager, contact_number, project, department, role);
            
        userList.add(user);
    } 
    
    public ArrayList<User> getUserList(){
        return userList;
    }
}
public class SendEmailMain {      // Main class containing the logic of the code
    public static void main(String args[]) {
        SendEmail sm = new SendEmail();
        InputDetails id = new InputDetails();
        Scanner sc = new Scanner(System.in);
        String moreUser;
        do{
            id.inputDetails();
            System.out.print("Do you want to enter more users? (yes/no): ");
            moreUser = sc.nextLine();
            System.out.println();

        }while (moreUser.equalsIgnoreCase("yes"));

        System.out.println("No, then terminated");
        System.out.println("-----------------------");
        
        for (User user : id.getUserList()) {
            sm.sendEmail(user);
            System.out.println("-----------------------");
        }
    }
}