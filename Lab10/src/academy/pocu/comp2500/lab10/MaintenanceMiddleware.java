package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class MaintenanceMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private OffsetDateTime startDateTime;
    private OffsetDateTime endDateTime;

    public MaintenanceMiddleware(IRequestHandler requestHandler, OffsetDateTime startDateTime) {
        this.requestHandler = requestHandler;
        this.startDateTime = startDateTime;
        this.endDateTime = startDateTime.plusHours(1);
    }

    @Override
    public ResultBase handle(Request request) {
        // Pocuflix가 점검 중이라면 ServiceUnavailableResult 개체를 반환합니다. 아니라면 다음 핸들러에 요청을 넘깁니다.
        // 점검 기간은 언제나 1시간이라는 사실을 잊지 마세요!
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        if (now.isAfter(this.startDateTime) && now.isBefore(this.endDateTime)) {
            return new ServiceUnavailableResult(this.startDateTime, this.endDateTime);
        }
        return this.requestHandler.handle(request);
    }
}
