package homework.Bamking.Objects;

import homework.Bamking.Exceptions.ClientNotRecognizedException;
import homework.Bamking.Exceptions.TransactionFailException;
import homework.Bamking.Enumerations.Transactions;

/**
 * Created by Default
 * 05 May 2015
 * Description:
 * Functional class, which is used as an ATM machine for a bank
 */

public class Bankomat {

    private class Transact implements Runnable{

        private Transactions transaction;
        private long amount;

        public Transact(Transactions transaction, long amount){
            this.transaction = transaction;
            this.amount = amount;
        }

        @Override
        public void run() {
            try {
                transact(transaction, amount);
            } catch (TransactionFailException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public Bank bank;
    private long budget;
    private long balance;

    public Bankomat(Bank bank, long budget, long balance){
        this.bank = bank;
        this.budget = budget;
        this.balance = balance;
    }

    public Bankomat(Bank bank, long budget){
        this.budget = budget;
        this.bank = bank;
    }

    public void put(long amount, Client client) throws ClientNotRecognizedException {
        if (bank.checkClient(client)){
            client.income(amount);
            Thread putter = new Thread(new Transact(Transactions.PUT, amount));
            putter.start();
        }else{
            throw new ClientNotRecognizedException("Client could not be recognized.\n" +playUsOut());
        }
    }

    public void get(long amount, Client client) throws TransactionFailException{
        if (bank.checkClient(client)){
            if (client.request(amount)) {
                Thread getter = new Thread(new Transact(Transactions.GET, amount));
                getter.start();
            } else {
                throw new TransactionFailException("Not enough money.\n" + playUsOut());
            }
        }else{
            throw new ClientNotRecognizedException("Client could not be recognized.\n" +playUsOut());
        }
    }

    private boolean transact(Transactions transaction,long amount) throws TransactionFailException{
        switch (transaction) {
            case PUT:
                bank.put(amount);
                break;
            case GET:
                if (amount > budget){
                    throw new TransactionFailException("Requested amount cannot be handled by this particular bankomat" +
                            "please try another or visit nearest to you agency of " +bank.name +".\n" +playUsOut());
                }else{
                    if (balance > amount){
                        balance -= amount;
                        return true;
                    }else{
                        amount -= balance;
                        balance = 0;
                        try{
                            requestMoney(amount);
                        }catch (TransactionFailException e){
                            throw new TransactionFailException(e.getMessage());
                        }
                        return true;
                    }
                }
        }
        return false;
    }


    private void requestMoney(long requested) throws TransactionFailException{
        if (bank.refill(budget)){
            balance += budget;
        }else if (bank.refill(requested - balance)){
            balance += requested - balance;
        }else{
            throw new TransactionFailException("Could not process, please try again from another bankomat and," +
                    " in case of failure,connect our client server by dialing the phone number from your contract" +
                    " with our bank.\n" +playUsOut());
        }
    }


    private String playUsOut(){
        return "We are sorry for inconvenience.\n" +bank.name +" ® All rights reserved " +bank.foundationYear +" - 2015";
    }
}
