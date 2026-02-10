package com.sorokin_hibernate_dz.client;

import com.sorokin_hibernate_dz.coupon.CouponDomain;
import com.sorokin_hibernate_dz.entities.Order;
import com.sorokin_hibernate_dz.entities.Profile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientDomain {
    private Long id;

    private String name;
    private String email;

    private LocalDateTime registrationDate;

    private Profile profile;

    private final List<Order> orders = new ArrayList<>();
    private final List<CouponDomain> coupons = new ArrayList<>();


    static ClientDomain create(String name, String email){
        return new ClientDomain(name, email);
    }

    private ClientDomain(String name, String email) {
        setName(name);
        setEmail(email);

        this.registrationDate = LocalDateTime.now();
    }

//    public void addOrder(Order newOrder) {
//        if (newOrder == null) {
//            throw new IllegalArgumentException("Order cannot be null");
//        }
//
//        if (newOrder.getClient() != null && !this.equals(newOrder.getClient())) {
//            throw new IllegalStateException(
//                    String.format("Order already belongs to another client (ID: %d)",
//                            newOrder.getClient().getId())
//            );
//        }
//
//        if (!orders.contains(newOrder)) {
//            orders.add(newOrder);
//        }
//    }

    public void addCoupon(CouponDomain coupon) {
        if (coupon == null) {
            throw new IllegalArgumentException("CouponDomain cannot be null");
        }

        if (!coupons.contains(coupon)) {
            coupons.add(coupon);
            if(!coupon.getClients().contains(this)){
                coupon.addClient(this);
            }
        }
    }
    public void removeCoupon(CouponDomain coupon) {
        if (coupon == null) {
            throw new IllegalArgumentException("CouponDomain cannot be null");
        }

        coupons.remove(coupon);
        coupon.removeClient(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ClientDomain that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    private void setProfile(Profile profile) {
        if (profile == null) {
            throw new IllegalArgumentException("Profile cannot be null");
        }

        if (profile.getClient() != null && !this.equals(profile.getClient())) {
            long clientId = profile.getClient().getId();

            throw new IllegalStateException(
                    "Profile already belongs to another client (ID: %d)"
                            .formatted(clientId)
            );
        }

        this.profile = profile;
    }

    private void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(
                    "Client name cannot be null or blank (NAME: %s)"
                            .formatted(name)
            );
        }

        this.name = name;
    }

    private void setEmail(String email) {
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException(
                    "Email cannot be null or blank (EMAIL: %s)"
                            .formatted(email)
            );
        }

        this.email = email;
    }
}
