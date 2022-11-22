package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private int expiryDuration;
    private HashMap<Request, Integer> caches;

    public CacheMiddleware(IRequestHandler requestHandler, int expiryDuration) {
        this.requestHandler = requestHandler;
        this.expiryDuration = expiryDuration;
        this.caches = new HashMap<>();
    }

    @Override
    public ResultBase handle(Request request) {
        // 요청이 캐시에 저장되어 있었다면 CachedResult 개체를 반환합니다. [-1]
        // 그게 아니라면 다음 핸들러에 요청을 보냅니다. (이 미들웨어는 결과가 OkResult인 요청만 캐시에 저장합니다.) [추가/삭제]

        // 캐시에 저장된 요청 (참고 : 1회 남은 걸 사용 == 만료)
        if (caches.containsKey(request) && caches.get(request) > 1) {
            caches.replace(request, caches.get(request) - 1);
            return new CachedResult(caches.get(request));
        }

        // 캐시에 저장 안된 요청 (신규 / 만료)
        if (this.requestHandler.handle(request).getCode().equals(ResultCode.OK)) {
            this.caches.put(request, expiryDuration);
        }
        return this.requestHandler.handle(request);
    }
}
