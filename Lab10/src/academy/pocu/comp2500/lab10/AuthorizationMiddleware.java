package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.ResultBase;
import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.HashSet;

public class AuthorizationMiddleware {
    private IRequestHandler store;
    private HashSet<User> users = new HashSet<>();

    public AuthorizationMiddleware(IRequestHandler store, HashSet<User> users) {
        this.store = store;
        this.users = users;
    }

    public ResultBase handle(Request request) {
        // 만약 요청을 보낸 사용자가 허용된 사용자 목록에 들어있지 않다면 UnauthorizedResult 개체를 반환합니다.
        // 그렇지 않다면 다음 핸들러에 요청을 넘깁니다.
    }
}
