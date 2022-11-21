package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class ResultValidator {
    private ResultBase result;

    public ResultValidator(ResultBase result) {
        this.result = result;
    }

    public boolean isValid(ResultCode code) {
        // 생성자에 전달한 결과 개체가 ResultCode 인자로 특정된 올바른 유효한 결과라면 true, 아니라면 false
    }
}
