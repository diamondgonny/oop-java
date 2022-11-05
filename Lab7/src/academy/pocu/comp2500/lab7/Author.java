package academy.pocu.comp2500.lab7;

public class Author {
    private final String firstName;
    private final String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", firstName, lastName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Author)) {
            return false;
        }
        Author author = (Author) obj;
        return this.firstName.equals(author.firstName) && this.lastName.equals(author.lastName);
    }

    @Override
    public int hashCode() {
        return this.firstName.hashCode() ^ this.lastName.hashCode() << 16;
    }
}
