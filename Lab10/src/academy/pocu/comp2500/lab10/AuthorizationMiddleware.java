package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware implements IRequestHandler {
    private IRequestHandler requestHandler;
    private HashSet<User> users;

    public AuthorizationMiddleware(IRequestHandler requestHandler, HashSet<User> users) {
        this.requestHandler = requestHandler;
        this.users = users;
    }

    @Override
    public ResultBase handle(Request request) {
        // 만약 요청을 보낸 사용자가 허용된 사용자 목록에 들어있지 않다면 UnauthorizedResult 개체를 반환합니다.
        // 그렇지 않다면 다음 핸들러에 요청을 넘깁니다.
        for (User user : users) {
            // null pointer exception
            if (request.getUser() != null && request.getUser().equals(user)) {
                return this.requestHandler.handle(request);
            }
        }
        return new UnauthorizedResult();
    }
}
