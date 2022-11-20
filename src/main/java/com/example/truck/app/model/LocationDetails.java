package com.example.truck.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class LocationDetails {

    public String objectid;
    public String applicant;
    public String facilitytype;
    public String cnn;
    public String locationdescription;
    public String address;
    public String blocklot;
    public String block;
    public String lot;
    public String permit;
    public String status;
    public String x;
    public String y;
    public String latitude;
    public String longitude;
    public String schedule;
    public String received;
    public String priorpermit;
    public String expirationdate;
    public Location location;
//    public String computed_region_yftq_j783;
//    public String computed_region_p5aj_wyqh;
//    public String computed_region_rxqg_mtj9;
//    public String computed_region_bh8s_q3mv;
//    public String computed_region_fyvs_ahh9;
}
