package DesignPatterns.ch1.Model;

public class UserDetails extends AbstractEntity {
    private String firstName;
    private String lastName;

    public UserDetails() {}

    public UserDetails(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserDetails(UserDetails userDetails) {
        this.firstName = userDetails.getFirstName();
        this.lastName = userDetails.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
