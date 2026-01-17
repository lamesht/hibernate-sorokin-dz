package com.sorokin_hibernate_dz.entities;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter
    private String name;
    @Getter
    private String email;

    @Getter
    private LocalDateTime registrationDate;

    @OneToOne(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    @Getter
    private Profile profile;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

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
    private List<Coupon> coupons = new ArrayList<>();

    public Client(String name, String email) {
        setName(name);
        setEmail(email);

        this.registrationDate = LocalDateTime.now();
    }

    public void addOrder(Order newOrder) {
        if (newOrder == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        if (newOrder.getClient() != null && !this.equals(newOrder.getClient())) {
            throw new IllegalStateException(
                    String.format("Order already belongs to another client (ID: %d)",
                            newOrder.getClient().getId())
            );
        }

        if (!orders.contains(newOrder)) {
            orders.add(newOrder);
        }
    }

    public void addCoupon(Coupon coupon) {
        if (coupon == null) {
            throw new IllegalArgumentException("Coupon cannot be null");
        }

        if (!coupons.contains(coupon)) {
            coupons.add(coupon);
        }
    }
    public void removeCoupon(Coupon coupon) {
        if (coupon == null) {
            throw new IllegalArgumentException("Coupon cannot be null");
        }

        coupons.remove(coupon);
    }

    public void setProfile(Profile profile) {
        if (profile == null) {
            throw new IllegalArgumentException("Profile cannot be null");
        }

        if (profile.getClient() != null && !this.equals(profile.getClient())) {
            throw new IllegalStateException(
                    String.format("Profile already belongs to another client (ID: %d)",
                            profile.getClient().getId())
            );
        }

        this.profile = profile;
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public List<Coupon> getCoupons() {
        return Collections.unmodifiableList(coupons);
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Invalid client name: " + name);
        }

        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }

        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
