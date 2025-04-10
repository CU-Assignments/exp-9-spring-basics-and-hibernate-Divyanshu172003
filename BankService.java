import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class BankService {
    private SessionFactory sessionFactory;

    public BankService(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Session session = sessionFactory.getCurrentSession();

        Account from = session.get(Account.class, fromId);
        Account to = session.get(Account.class, toId);

        if (from.getBalance() < amount)
            throw new RuntimeException("Insufficient funds");

        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);

        Transaction tx = new Transaction();
        tx.setFromAcc(fromId);
        tx.setToAcc(toId);
        tx.setAmount(amount);
        tx.setDate(new Date());
        session.save(tx);
    }
}
