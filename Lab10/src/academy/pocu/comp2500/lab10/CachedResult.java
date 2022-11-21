package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class CachedResult {
    private ResultCode code;
    private int expiryCount;

    public CachedResult(int expiryCount) {
        this.code = ResultCode.NOT_MODIFIED;
        this.expiryCount = expiryCount;
    }

    public int getExpiryCount() {
        return expiryCount;
    }
}
