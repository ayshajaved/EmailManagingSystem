import java.util.Scanner;
public class User {
    private Email[][] accounts_Emails;
    private EmailAccount[] accounts;
    private String name;    
    private int accountIndex = 0, counter_=0, e=0, counter_a=0;
    User(String name){
        accounts_Emails = new Email[4][];
        accounts = new EmailAccount[4];
        this.name = name;
        //initializing all accounts with default email
        for(int i = 0; i< accounts_Emails.length;i++){
                accounts_Emails[i] = new Email[10];
                accounts[i] = new EmailAccount();
                for(int j = 0; j<accounts_Emails[i].length; j++){
                    accounts_Emails[i][j] = new Email();
                }
    }
    }
    public Email[][] getAccounts() {
        return accounts_Emails;
    }
    public void setAccounts(Email[][] accounts) {
        this.accounts_Emails = accounts;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
public void signUp(Scanner sc){
        System.out.println("Enter User Email: ");
        String useremail = sc.nextLine();
        System.out.println("Enter User Email password: ");
        String password = sc.nextLine();
        EmailAccount account = new EmailAccount(useremail, password);
        addAccount(account);
        if(login(sc,useremail ,password)){
        while(true){
            System.out.println("""
                    Enter your choice...
                    (1)Send Email
                    (2)Display Emails
                    (0) Exit
                            """);
            int x = sc.nextInt();
            sc.nextLine();
            switch (x) {
                case 1:
                Email email=account.sendEmail(sc);
                    accounts_Emails[(counter_-1)][e++] = new Email(email);
                    break;
                case 2:
                    System.err.println("Enter your choice!\n1 to display emails for this account\n2 to display all the emails of your 4 accounts: ");
                    int display_choice = sc.nextInt();
                    sc.nextLine();
                    if(display_choice==1){
                    account.displayEmails();
                    }
                    else if(display_choice ==2){
                        displayAllEmails(account, sc);
                    }
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
    else{
        System.out.println("Program Exited..");
    }
}
public boolean login(Scanner sc, String useremail, String password){
    while(true){
        System.out.println("""
            Enter your choice...
            (1)Login In
            (0) Exit
                    """);
    int x = sc.nextInt();
    sc.nextLine();
    switch (x) {
        case 1:
            System.out.println("Enter password for Email "+useremail+" : ");
            String entered_password = sc.nextLine();
            if(entered_password.equals(password)){
                return true;
            }
            else{
                System.out.println("Incorrect password..");
            }
            break;
        case 0:
            return false;
        default:
            break;
    }
    }
}
public void addAccount(EmailAccount account){
    counter_++;
    counter_a = 1;
    accounts[accountIndex] = account;
    accountIndex++;
}
public boolean checkUserValidity(Scanner sc){
    System.out.println("Enter Any of your passwords of Your accounts: ");
    String pass = sc.nextLine();
    for(int i = 0; i < accounts.length;i++){
        if(accounts[i].getUserEmail()!="Default User Email"){
            if(pass.equals(accounts[i].getPassword())){
                return true;
            }
        }
    }
    return false;
}

public void displayAllEmails(EmailAccount account, Scanner sc){
    if(checkUserValidity(sc)){
        if(counter_a !=0){
            if(account.getCounter()!=0){
                for(int i = 0; i< accounts.length; i++){
                    if(accounts[i].getUserEmail()!="Default User Email"){
                    System.out.println("Displaying Emails for Account User Email: "+accounts[i].getUserEmail());
                    for(int j = 0; j<accounts_Emails[i].length;j++){
                        if(accounts_Emails[i][j].getSubject()!="No Subject"){
                            System.out.println(accounts_Emails[i][j]);
                            System.out.println("\n");
                        }
                    }
                }
            }
        }
            else{
                System.out.println("\nNo Emails sent..\nFirst send Emails...\n");
            }
        }
        else{
            System.out.println("\nNo Sign Ups!Sign Up first...\n");
        }
    }
    else{
        System.out.println("Wrong password!User is not TrustWorthy...");
    }
}
}
