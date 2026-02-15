package sorokin_hibernate_dz.domain.model;

public class ProfileDomain {
    private Long id;
    private String address;
    private String phoneNumber;
    private Long clientId;

    public static ProfileDomain create(
            String address,
            String phoneNumber,
            Long clientId) {
        return new ProfileDomain(address, phoneNumber, clientId);
    }

    public static ProfileDomain of(
            Long id,
            String address,
            String phoneNumber,
            Long clientId) {
        return new ProfileDomain(id, address, phoneNumber, clientId);
    }

    private ProfileDomain(
            String address,
            String phoneNumber,
            Long clientId) {
        updateAddress(address);
        updatePhoneNumber(phoneNumber);
        setClientId(clientId);
    }

    private ProfileDomain(
            Long id,
            String address,
            String phoneNumber,
            Long clientId
    ) {
        setId(id);
        updateAddress(address);
        updatePhoneNumber(phoneNumber);
        setClientId(clientId);
    }

    public Long getClientId() {
        return clientId;
    }

    private void setClientId(Long clientId) {
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException(
                    "ClientId cannot be null, zero or negative (ID: %d)"
                            .formatted(clientId)
            );
        }

        this.clientId = clientId;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(
                    "Id cannot be null, zero or negative (ID: %d)"
                            .formatted(id));
        }

        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void updateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }

        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void updatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Invalid phoneNumber: " + phoneNumber);
        }

        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "ProfileDomain{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", clientId=" + clientId +
                '}';
    }
}
