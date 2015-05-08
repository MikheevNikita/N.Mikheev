package homework.Bamking.Objects;

/**
 * Created by Default
 * 05 May 2015
 * Description:
 * Describes every bank client
 */

public class Client {

    private static int count = 0;

    private String name;
    private String surname;
    private int ID;
    private long balance;

    public Client(String surname, String name, long balance){
        this.name = name;
        this.surname = surname;

        count++;
        ID = count;
        this.balance = balance;
    }

    public void income(long amount){
        balance += amount;
    }

    public boolean request(long amount){
        if (balance > amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}
