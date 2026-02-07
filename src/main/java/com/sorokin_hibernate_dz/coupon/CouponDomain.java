package com.sorokin_hibernate_dz.coupon;

import com.sorokin_hibernate_dz.client.Client;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CouponDomain {
    private Long id;
    private String code;
    private Double discount;
    private Set<Client> clients = new HashSet<>();

    public CouponDomain(String code, Double discount) {
        changeCode(code);
        changeDiscount(discount);
    }

    CouponDomain(Long id, String code, Double discount, Set<Client> clients) {
        setId(id);
        changeCode(code);
        changeDiscount(discount);
        this.clients = clients != null ? new HashSet<>(clients) : new HashSet<>();
    }

    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }
    public void removeClient(Client client) {
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

    public Set<Client> getClients() {
        return clients;
    }

    Long getId() {
        return id;
    }
    void setId(Long id){
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
