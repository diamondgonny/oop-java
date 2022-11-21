package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private int expiryDuration;
    private int remainedExpiryCount;
    // store

    public CacheMiddleware(IRequestHandler requestHandler, int expiryDuration) {
        this.requestHandler = requestHandler;
        this.expiryDuration = expiryDuration;
        this.remainedExpiryCount = 0;
    }

    @Override
    public ResultBase handle(Request request) {
        // 요청이 캐시에 저장되어 있었다면 CachedResult 개체를 반환합니다. [-1]
        // 그게 아니라면 다음 핸들러에 요청을 보냅니다. (이 미들웨어는 결과가 OkResult인 요청만 캐시에 저장합니다.) [추가/삭제]
/*
        if (0 < this.remainedExpiryCount && this.remainedExpiryCount <= expiryDuration) {
            --expiryDuration;
            return new CachedResult(this.remainedExpiryCount);
        } else if (this.remainedExpiryCount == 0) {

        }
*/
    }
}
