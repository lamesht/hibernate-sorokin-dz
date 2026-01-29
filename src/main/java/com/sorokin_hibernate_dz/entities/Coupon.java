package com.sorokin_hibernate_dz.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Table(name = "coupons")
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String code;
    @Getter @Setter
    private Double discount;

    @ManyToMany(mappedBy = "coupons", fetch = FetchType.LAZY)
    private List<Client> clients = new ArrayList<>();


    public Coupon(String code, Double discount) {
        this.code = code;
        this.discount = discount;
    }

    void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        }
    }

    void removeClient(Client client) {
        clients.remove(client);
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coupon coupon)) return false;
        return Objects.equals(id, coupon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "code='" + code + '\'' +
                ", discount=" + discount +
                '}';
    }
}
