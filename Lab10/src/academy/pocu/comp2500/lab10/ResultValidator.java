package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.NotFoundResult;
import academy.pocu.comp2500.lab10.pocuflix.OkResult;
import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase resultBase;

    public ResultValidator(ResultBase resultBase) {
        this.resultBase = resultBase;
    }

    public boolean isValid(ResultCode resultCode) {
        // 생성자에 전달한 결과 개체가 ResultCode 인자로 특정된 올바른 유효한 결과라면 true, 아니라면 false
        if (this.resultBase.getCode() != resultCode) {
            return false;
        }

        switch (resultCode) {
            case OK:
                return this.resultBase instanceof OkResult;
            case NOT_MODIFIED:
                return this.resultBase instanceof CachedResult;
            case SERVICE_UNAVAILABLE:
                return this.resultBase instanceof ServiceUnavailableResult;
            case UNAUTHORIZED:
                return this.resultBase instanceof UnauthorizedResult;
            case NOT_FOUND:
                return this.resultBase instanceof NotFoundResult;
            default:
                assert (false) : "Unknown type";
        }

        return false;
    }
}
