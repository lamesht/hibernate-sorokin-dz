package sorokin_hibernate_dz.domain.model;

import java.time.LocalDateTime;

public class ClientDomain {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime registrationDate;

    public static ClientDomain create(
            String name,
            String email) {
        return new ClientDomain(name, email);
    }

    public static ClientDomain of(
            Long id,
            String name,
            String email,
            LocalDateTime registrationDate) {
        return new ClientDomain(id, name, email, registrationDate);
    }

    private ClientDomain(String name, String email) {
        updateName(name);
        updateEmail(email);

        this.registrationDate = LocalDateTime.now();
    }

    private ClientDomain(
            Long id, String name,
            String email, LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }
    private void setId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(
                    "Id cannot be null, negative ot zero (ID: %d)"
                            .formatted(id)
            );
        }

        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void updateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Client name cannot be null or blank (NAME: %s)"
                            .formatted(name)
            );
        }

        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void updateEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException(
                    "Email cannot be null or blank (EMAIL: %s)"
                            .formatted(email)
            );
        }

        this.email = email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }
}
