import java.util.Scanner;

public class EmailSystem{
    public static void main(String[] args) {
        //user Interface
        Scanner sc = new Scanner(System.in);
        User user = new User("Ayesha Javed");
        System.out.println("------------------------------------");
        System.out.println("Welcome to the Email Managing System!!");
        System.out.println("------------------------------------");
        while(true){    
        System.out.println("""
                Enter your choice..
                (1) Sign up
                (0) Exit                            
                        """);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    user.signUp(sc);
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
