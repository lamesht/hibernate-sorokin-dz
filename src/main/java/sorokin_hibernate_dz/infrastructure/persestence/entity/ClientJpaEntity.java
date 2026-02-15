package sorokin_hibernate_dz.infrastructure.persestence.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class ClientJpaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "registrationDate", nullable = false)
    private LocalDateTime registrationDate;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "profileId")
    private ProfileJpaEntity profile;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private final List<OrderJpaEntity> orders = new ArrayList<>();

    @ManyToMany(mappedBy = "clients")
    private final List<CouponJpaEntity> coupons = new ArrayList<>();

    public static ClientJpaEntity of(
            Long id,
            String name,
            String email,
            LocalDateTime registrationDate) {
        return new ClientJpaEntity(id, name, email, registrationDate);
    }

    private ClientJpaEntity(
            Long id,
            String name,
            String email,
            LocalDateTime registrationDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    private ClientJpaEntity() {}
}
