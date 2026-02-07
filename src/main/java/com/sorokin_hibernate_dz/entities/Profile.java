package com.sorokin_hibernate_dz.entities;

import com.sorokin_hibernate_dz.client.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter
    private String address;
    @Getter
    private String phoneNumber;

    @OneToOne
    @JoinColumn(
            name = "client_id",
            unique = true,
            nullable = false
    )
    @Getter
    private Client client;

    public Profile(String address, String phoneNumber, Client client) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.client = client;
    }

    public void setAddress(String address){
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Invalid address: " + address);
        }

        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber){
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Invalid phoneNumber: " + phoneNumber);
        }

        this.address = phoneNumber;
    }



    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
