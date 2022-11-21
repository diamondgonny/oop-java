package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class UnauthorizedResult extends ResultBase {
    private String errorMessage;

    public UnauthorizedResult() {
        super(ResultCode.UNAUTHORIZED);
        this.errorMessage = "Unauthorized access";
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
