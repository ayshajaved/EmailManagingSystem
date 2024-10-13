import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Email {
    private String subject;
    private String messageBody;
    private Person sender;
    private Person recepient;
    private LocalDateTime timeStamp;
    private EmailStatus status;
    {
        this.timeStamp = LocalDateTime.now().plusMinutes(5);
    }
    //constructor chaining
    Email(String subject, String body, Person sender, Person recepient,int choice){
        this.subject = subject;
        this.messageBody = body;
        this.sender = sender;
        this.recepient = recepient;
        setStatus(choice);
    }
    Email(String subject, String body, Person sender, Person recepient){
        this(subject,body,sender,recepient,1);
    }
    Email(String subject, String body){
        this(subject, body,new Person("Unnamed","No Contact", "No Email"), new Person("Unnamed","No Contact", "No Email"), 1);
    }
    Email(String subject){
        this(subject,"No body", new Person("Unnamed","No Contact", "No Email"), new Person("Unnamed","No Contact", "No Email"), 1);
    }
    Email(){
        this("No Subject","No Body",new Person("Unnamed","No Contact", "No Email"),new Person("Unnamed","No Contact", "No Email"), 1);
    }
    //deep copy constructor
    Email(Email email){
        this.subject = new String(email.subject);
        this.messageBody = new String(email.messageBody);// using new string is completely fine, and we can remove it also, we only use to explicity creating a new String
        this.sender = email.getSender().deepCopy();
        this.recepient = email.getRecepient().deepCopy();
        this.status = email.getStatus();
    }
    public void setStatus(int a){
        switch(a){
            case 1:
                this.status = EmailStatus.DRAFT;
                break;
            case 2:
                this.status = EmailStatus.SENT;
                break;
            case 3:
                this.status = EmailStatus.UNSEEN;
                break;
            case 4:
                this.status = EmailStatus.SEEN;
                break;
            case 5:
                this.status = EmailStatus.UNREAD;
                break;
            case 6:
                this.status = EmailStatus.READ;
                break;
            default:
                break;
        }
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getMessageBody() {
        return messageBody;
    }
    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
    public Person getSender() {
        return sender;
    }
    public void setSender(Person sender) {
        this.sender = sender;
    }
    public Person getRecepient() {
        return recepient;
    }
    public void setRecepient(Person recepient) {
        this.recepient = recepient;
    }
    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
    public EmailStatus getStatus() {
        return status;
    }
    public String format(LocalDateTime time){
        if(time ==null){
            return "Default time";
        }
        else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            return time.format(formatter);
        }
    }
    @Override
    public String toString(){
        return "Subject      :"+getSubject()+
             "\nMessage Body :"+getMessageBody()+
             "\nRecepient    :"+getRecepient()+
             "\nStatus       :"+getStatus()+
             "\nSender       :"+getSender()+
             "\nSent Time    :"+format(getTimeStamp())+
             "\n********************************\n";
    }
    @Override
    public boolean equals(Object o){
        if(this ==o){
            return true;
        }
        if(o.getClass()!=this.getClass() || o ==null){
            return false;
        }
        Email email =(Email)o;
        return 
        this.sender.equals(email.sender) && 
        this.recepient.equals(email.recepient)&& 
        this.messageBody.equals(email.messageBody);
    }
}

