package academy.pocu.comp2500.lab10;

import academy.pocu.comp2500.lab10.pocuflix.User;

import java.util.Objects;

public class Request {
    private String title;
    private User user;

    public Request(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Request request = (Request) obj;
        return Objects.equals(title, request.title) && Objects.equals(user, request.user);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
