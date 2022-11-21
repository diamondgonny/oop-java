package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

public class CacheMiddleware {
    private IRequestHandler store;
    private int expiryCount;

    public CacheMiddleware(IRequestHandler store, int expiryCount) {
        this.store = store;
        this.expiryCount = expiryCount;
    }

    public ResultBase handle(Request request) {
        // 요청이 캐시에 저장되어 있었다면 CachedResult 개체를 반환합니다. 그게 아니라면 다음 핸들러에 요청을 보냅니다.
        //이 미들웨어는 결과가 OkResult인 요청만 캐시에 저장합니다.
    }
}
