package com.sorokin_hibernate_dz.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter @Getter
public class CouponPatchRequest {
    private String code;
    private Double discount;
    private List<Client> addClients;
    private List<Client> removeClients;

    public boolean hasUpdates() {
        return code != null
                || discount != null
                || addClients != null
                || removeClients != null;
    }
}
