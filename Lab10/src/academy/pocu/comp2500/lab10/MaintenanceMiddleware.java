package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;

public class MaintenanceMiddleware {
    private IRequestHandler store;
    private OffsetDateTime startDateTime;
    gggg

    public MaintenanceMiddleware(IRequestHandler store, OffsetDateTime startDateTime) {
        this.store = store;
        this.startDateTime = startDateTime;
    }

    public ResultBase handle(Request request) {
        // Pocuflix가 점검 중이라면 ServiceUnavailableResult 개체를 반환합니다. 아니라면 다음 핸들러에 요청을 넘깁니다.
        //점검 기간은 언제나 1시간이라는 사실을 잊지 마세요!
    }
}
