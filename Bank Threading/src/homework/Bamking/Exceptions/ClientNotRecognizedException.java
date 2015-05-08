package homework.Bamking.Exceptions;

/**
 * Created by Default
 * 08 May 2015
 * Description:
 * Occurs when unknown client tries to transact with bank
 */

public class ClientNotRecognizedException extends TransactionFailException {

    public ClientNotRecognizedException(String message) {
        super(message);
    }

}
