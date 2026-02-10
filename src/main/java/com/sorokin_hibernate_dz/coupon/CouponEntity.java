package com.sorokin_hibernate_dz.coupon;

import com.sorokin_hibernate_dz.client.ClientEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coupon")
public class CouponEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "discount", nullable = false)
    private Double discount;

    @ManyToMany(mappedBy = "coupons")
    private Set<ClientEntity> clients = new HashSet<>();


    static CouponEntity create(String code, Double discount) {
        return new CouponEntity(code, discount);
    }

    static CouponEntity of(Long id, String code, Double discount) {
        return new CouponEntity(id, code, discount);
    }

    private CouponEntity(Long id, String code, Double discount) {
        this.id = id;
        this.code = code;
        this.discount = discount;
    }

    private CouponEntity(String code, Double discount) {
        this.code = code;
        this.discount = discount;
    }

    Long getId() {
        return id;
    }

    Double getDiscount() {
        return discount;
    }

    String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }

    void setDiscount(Double discount) {
        this.discount = discount;
    }

    private CouponEntity() {
    }
}
