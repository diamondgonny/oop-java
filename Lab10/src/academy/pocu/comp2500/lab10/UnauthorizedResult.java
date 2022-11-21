package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class UnauthorizedResult {
    private ResultCode code;

    public UnauthorizedResult() {
        this.code = ResultCode.UNAUTHORIZED;
    }

    public String getErrorMessage() {
        return "Unauthorized access";
    }
}
