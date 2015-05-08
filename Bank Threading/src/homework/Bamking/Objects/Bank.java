package homework.Bamking.Objects;

import homework.Bamking.Types.BankBudget;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Default
 * 05 May 2015
 * Description:
 * Yet another typical class - representation of a Bank
 */

public class Bank {

    public String name;
    public int foundationYear;
    private BankBudget budget;
    private List<Client> clients;
    private int currIndex;

    public Bank(String name, int foundationYear, long budget){
        this.foundationYear = foundationYear;
        this.name = name;

        this.budget = new BankBudget(budget);
        clients = new ArrayList<>();
    }

    public Bank(String name, int foundationYear){
        this.foundationYear = foundationYear;
        this.name = name;

        this.budget = new BankBudget();
        clients = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public boolean checkClient(Client client){
        return clients.contains(client);
    }

    public void put(long amount){
        budget.put(amount);
    }

    public boolean refill(long requested){
        return budget.request(requested);
    }

}
