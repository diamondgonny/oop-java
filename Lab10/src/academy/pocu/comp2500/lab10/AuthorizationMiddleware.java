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
        for (User user : users) {
            if (request.getUser() != null && request.getUser().equals(user)) {
                return this.requestHandler.handle(request);
            }
        }
        return new UnauthorizedResult();
    }
}
