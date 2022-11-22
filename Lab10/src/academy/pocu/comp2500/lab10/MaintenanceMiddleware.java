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
        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
        if (now.isAfter(this.startDateTime) && now.isBefore(this.endDateTime)) {
            return new ServiceUnavailableResult(this.startDateTime, this.endDateTime);
        }
        return this.requestHandler.handle(request);
    }
}
