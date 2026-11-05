/**
 * Superclass representing any person in the library system.
 * Demonstrates ENCAPSULATION (private fields + getters/setters)
 * and serves as the parent for INHERITANCE.
 */
public class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    /** Overridden by subclasses (POLYMORPHISM). */
    public String getRole() {
        return "Person";
    }

    public void displayInfo() {
        System.out.printf("Role  : %s%nName  : %s%nEmail : %s%n", getRole(), name, email);
    }
}