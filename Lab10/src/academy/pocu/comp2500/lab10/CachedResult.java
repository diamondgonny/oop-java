package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

public class CachedResult extends ResultBase {
    private int remainedExpiryCount;

    public CachedResult(int remainedExpiryCount) {
        super(ResultCode.NOT_MODIFIED);
        this.remainedExpiryCount = remainedExpiryCount;
    }

    public int getExpiryCount() {
        return remainedExpiryCount;
    }
}
