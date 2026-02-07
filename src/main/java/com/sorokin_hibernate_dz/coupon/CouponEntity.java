package com.sorokin_hibernate_dz.coupon;

import com.sorokin_hibernate_dz.client.Client;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class CouponEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "discount", nullable = false)
    private Double discount;

    @ManyToMany(mappedBy = "coupons")
    private Set<Client> clients = new HashSet<>();

    public CouponEntity() {
    }

    public CouponEntity(String code, Double discount) {
        this.code = code;
        this.discount = discount;
    }

    CouponEntity(Long id, String code, Double discount, Set<Client> clients) {
        this.id = id;
        this.code = code;
        this.discount = discount;
        this.clients = clients;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Double getDiscount() {
        return discount;
    }
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Set<Client> getClients() {
        return clients;
    }
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}
