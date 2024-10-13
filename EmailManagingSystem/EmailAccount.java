import java.util.Scanner;

public class EmailAccount {
    private String userEmail;    
    private String password;
    private Email[] emails;
    private int emailIndex =0, counter = 0;
    //constructor chaining
EmailAccount(String userEmail, String password){
    this.userEmail = userEmail;
    this.password = password;
    emails = new Email[10];
    for(int i = 0; i<emails.length; i++){
        emails[i] = new Email();
    }
    }
EmailAccount(String userEmail){
    this(userEmail, "Default Password");
}
EmailAccount(){
    this("Default User Email", "Default password");
}
public int getCounter() {
    return counter;
}
public void setCounter(int counter) {
    this.counter = counter;
}
public Email[] getEmails() {
    return emails;
}
public void setEmails(Email[] emails) {
    this.emails = emails;
}
public String getUserEmail() {
    return userEmail;
}
public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public Email sendEmail(Scanner sc){
    counter = 1;
    System.out.println("Enter Subject of the Email: ");
    String sub = sc.nextLine();
    System.out.println("Enter Message Body of the Email: ");
    String body = sc.nextLine();
    System.out.println("Enter sender name: ");
    String sender = sc.nextLine();
    System.out.println("Enter contact: ");
    String sender_contact = sc.nextLine();
    System.out.println("Enter Recepient name: ");
    String recepient = sc.nextLine();
    System.out.println("Enter Recepient contact: ");
    String recepient_contact = sc.nextLine();
    System.out.println("Enter Recepient Email: ");
    String recepient_email = sc.nextLine();
    int status = selectingStatus(sc);
    Email email = new Email(sub, body, new Person(sender, sender_contact,this.userEmail), new Person(recepient, recepient_contact, recepient_email), status);
    addEmail(email);
    return email;
}
public int selectingStatus(Scanner sc){
    System.out.println("Enter Email Status: ");
    int v = 1;
    for(EmailStatus value : EmailStatus.values()){
        System.out.println(v+" "+ value);
        v++;
    }   
    int s = sc.nextInt();
    sc.nextLine();
    return s;

}
public void addEmail(Email email){
    emails[emailIndex] = email;
    emailIndex++;
}
public void displayEmails(){
    if(counter ==1){
        System.out.println("Displaying Emails for the Current Account"+"\nUser Email: "+getUserEmail());
        for(int i = 0; i<emails.length; i++){
            if(emails[i].getSubject()!="No Subject"){
                System.out.println(emails[i]);
            }
        }
    }
    else{
        System.out.println("\nThere are no emails of this User Email to display!\nFirst Send Emails...\n");
    }
}
}