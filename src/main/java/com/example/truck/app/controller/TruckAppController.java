package com.example.truck.app.controller;

import com.example.truck.app.model.LocationDetails;
import com.example.truck.app.service.TruckAppService;
import com.example.truck.app.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "/truck-app")
public class TruckAppController {

    @Autowired
    private TruckAppService appService;

    @Autowired
    private Utils dateUtils;

    @GetMapping("/{name}")
    public ResponseEntity<LocationDetails> searchByApplicantName(@PathVariable String name) {
        Optional<LocationDetails> applicant = appService.locationDetailsList.stream()
                .filter(details -> details.getApplicant().equals(name))
                .findAny();

        if (applicant.isPresent()) {
            log.debug("Candidate Found: "+applicant.get());
            return ResponseEntity.ok(applicant.get());
        }
        else {
            log.debug("Not found!");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/date")
    public ResponseEntity<List<LocalDateTime>> searchByExpirationDate(@RequestParam String expDate) {
        LocalDateTime userDate = dateUtils.convertDate(expDate);

        List<LocalDateTime> localDateTimes = appService.locationDetailsList.stream()
                .filter(details -> details.getExpirationdate()!=null)
                .map(x -> dateUtils.convertDate(x.expirationdate))
                .filter(y -> y.isBefore(userDate))
                .collect(Collectors.toList());

        return ResponseEntity.ok(localDateTimes);
    }

    @GetMapping("/")
    public ResponseEntity<List<LocationDetails>> searchByStreetName(@RequestParam String streetName) {

        List<LocationDetails> locationDetailsByStreetName = appService.locationDetailsList.stream()
                .filter(details -> details.getLocationdescription() != null &&
                        details.getLocationdescription().equals(streetName))
                .collect(Collectors.toList());


        return ResponseEntity.ok(locationDetailsByStreetName);
    }

    @GetMapping("/distance")
    public ResponseEntity<LocationDetails> searchByLeastDistance(@RequestParam(name = "lat") double lat, @RequestParam(name = "lon") double lon) {

        double min_dist = Double.MAX_VALUE;
        LocationDetails minDistanceLocDetails = null;

        for (LocationDetails locationDetails : appService.locationDetailsList) {
            if (locationDetails.getLatitude() != null && locationDetails.getLongitude() != null) {
                double distance = Utils.distance(Double.valueOf(locationDetails.getLatitude()), Double.valueOf(locationDetails.getLongitude()), lat, lon);
                if(distance!=0.0) {
                    min_dist = Math.min(min_dist, distance);
                    minDistanceLocDetails = locationDetails;
                }

            }
        }
        return ResponseEntity.ok(minDistanceLocDetails);
    }

    @PostMapping("/addTruck")
    public ResponseEntity<Void> addDetail(@RequestBody LocationDetails entry) {
        appService.locationDetailsList.add(entry);

        log.info("Entry :"+entry.getObjectid()+ " is created.");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
