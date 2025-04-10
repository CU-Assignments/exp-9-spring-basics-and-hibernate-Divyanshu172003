@Entity
public class Transaction {
    @Id @GeneratedValue
    private int id;
    private int fromAcc;
    private int toAcc;
    private double amount;
    private Date date;

    // Getters and setters
}
