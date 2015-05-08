package homework.Bamking.Exceptions;

/**
 * Created by Default
 * 05 May 2015
 * Description:
 * Exception, which may occur while trying to get money from bank
 */

public class TransactionFailException extends Exception {

    private String message;

    public TransactionFailException(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
