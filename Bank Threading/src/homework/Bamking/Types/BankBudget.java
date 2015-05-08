package homework.Bamking.Types;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Default
 * 06 May 2015
 * Description:
 * Bank budget class made for keeping a large amount of money with no problems occurring
 */

public class BankBudget {

    private List<Long> budget;

    private int currIndex;

    public BankBudget(){
        currIndex = 0;
        budget = new ArrayList<>();
    }

    public BankBudget(long initial){
        currIndex = 0;
        budget = new ArrayList<>();
        budget.add(currIndex, initial);
    }

    public synchronized boolean request(long requested){
        if (budget.get(currIndex) >= requested){
            long curr = budget.get(currIndex);
            budget.set(currIndex, curr - requested);
            return true;
        }else if (currIndex != 0){
            requested -= budget.get(currIndex);
            budget.set(currIndex, 0L);
            currIndex--;
            budget.set(currIndex, Long.MAX_VALUE - requested);
            return true;
        }
        return false;
    }

    public synchronized void put(long profit){
        if (Long.MAX_VALUE - budget.get(currIndex) >= budget.get(currIndex) + profit){
            long curr = budget.get(currIndex);
            budget.set(currIndex, curr + profit);
        }else{
            profit -= Long.MAX_VALUE - budget.get(currIndex);
            budget.set(currIndex, Long.MAX_VALUE);
            currIndex++;
            budget.set(currIndex, profit);
        }
    }

}
