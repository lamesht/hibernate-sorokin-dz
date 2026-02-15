package sorokin_hibernate_dz.infrastructure.persestence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profiles")
public class ProfileJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @OneToOne
    @JoinColumn(
            name = "client_id",
            nullable = false, unique = true
    )
    private ClientJpaEntity client;


    public static ProfileJpaEntity of(
            Long id,
            String address,
            String phoneNumber,
            ClientJpaEntity client
    ) {
        return new ProfileJpaEntity(id, address, phoneNumber, client);
    }

    private ProfileJpaEntity(
            Long id,
            String address,
            String phoneNumber,
            ClientJpaEntity client) {
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.client = client;
    }

    private ProfileJpaEntity() {}


    public Long getId() { return id; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public Long getClientId() { return client != null ? client.getId() : null; }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
