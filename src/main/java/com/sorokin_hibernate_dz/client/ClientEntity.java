package com.sorokin_hibernate_dz.client;

import com.sorokin_hibernate_dz.coupon.CouponDomain;
import com.sorokin_hibernate_dz.entities.Order;
import com.sorokin_hibernate_dz.entities.Profile;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class ClientEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private LocalDateTime registrationDate;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private final List<Order> orders = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    @JoinTable(
            name = "client_coupons",
            joinColumns = @JoinColumn(
                    name = "client_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "coupon_id"
            )
    )
    private final List<CouponDomain> coupons = new ArrayList<>();

    static ClientEntity create(String name, String email){
        return new ClientEntity(name,email);
    }

    private ClientEntity(String name, String email) {
        setName(name);
        setEmail(email);
        this.registrationDate = LocalDateTime.now();
    }

    private void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(
                    "Client name cannot be null or blank: %s"
                            .formatted(name)
            );
        }

        this.name = name;
    }

    private void setEmail(String email) {
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException(
                    "Email cannot be null or blank: %s"
                            .formatted(email)
            );
        }

        this.email = email;
    }

    private ClientEntity() {
    }
}
