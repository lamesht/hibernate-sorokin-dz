package com.sorokin_hibernate_dz.coupon;

import com.sorokin_hibernate_dz.client.ClientDomain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CouponDomain {
    private Long id;
    private String code;
    private Double discount;
    private Set<ClientDomain> clients = new HashSet<>();


    static CouponDomain create(String code, Double discount){
        return new CouponDomain(code, discount);
    }

    static CouponDomain of(Long id, String code, Double discount) {
        return new CouponDomain(id, code, discount);
    }

    private CouponDomain(String code, Double discount) {
        changeCode(code);
        changeDiscount(discount);
    }

    private CouponDomain(Long id, String code, Double discount) {
        setId(id);
        changeCode(code);
        changeDiscount(discount);
    }

    public void addClient(ClientDomain client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }
    public void removeClient(ClientDomain client) {
        clients.remove(client);
    }

    public Double getDiscount() {
        return discount;
    }
    public void changeDiscount(Double discount) {
        if (discount == null || discount <= 0 || discount > 100) {
            throw new IllegalArgumentException(
                    "The discount should be between 1 and 100"
            );
        }

        this.discount = discount;
    }

    public String getCode() {
        return code;
    }
    public void changeCode(String code) {
        if (code == null || code.isBlank() || code.length() > 255) {
            throw new IllegalArgumentException(
                    "Code cannot be null or blank and must be less than 255 character"
            );
        }

        this.code = code;
    }

    public Set<ClientDomain> getClients() {
        return Collections.unmodifiableSet(clients);
    }

    public Long getId() {
        return id;
    }
    private void setId(Long id){
        if (id == null || id < 0) {
            throw new IllegalArgumentException(
                    "The id cannot be null and negative"
            );
        }

        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CouponDomain coupon)) return false;
        return Objects.equals(id, coupon.id) && Objects.equals(code, coupon.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }

    @Override
    public String toString() {
        return "CouponDomain{" +
                "discount=" + discount +
                ", code='" + code + '\'' +
                ", id=" + id +
                '}';
    }
}
