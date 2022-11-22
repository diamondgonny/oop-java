package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.ResultCode;

import java.util.HashMap;

public class CacheMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private int expiryDuration;
    private HashMap<Request, Integer> caches = new HashMap<>();

    public CacheMiddleware(IRequestHandler requestHandler, int expiryDuration) {
        this.requestHandler = requestHandler;
        this.expiryDuration = expiryDuration;
    }

    @Override
    public ResultBase handle(Request request) {
        if (caches.containsKey(request) && caches.get(request) > 1) {
            caches.replace(request, caches.get(request) - 1);
            return new CachedResult(caches.get(request));
        }
        if (this.requestHandler.handle(request).getCode().equals(ResultCode.OK)) {
            this.caches.put(request, expiryDuration);
        }
        return this.requestHandler.handle(request);
    }
}
