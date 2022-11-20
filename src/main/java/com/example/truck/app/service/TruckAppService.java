package com.example.truck.app.service;

import com.example.truck.app.model.LocationDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class TruckAppService implements CommandLineRunner {

    public List<LocationDetails> locationDetailsList;

    @Override
    public void run(String... args) throws Exception {

        Gson gson = new Gson();
        String url_path = "https://data.sfgov.org/resource/rqzj-sfat.json";

        try {
            URL url = new URL(url_path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            locationDetailsList = gson.fromJson(reader, new TypeToken<List<LocationDetails>>() {}.getType());

//			searchByApplicantName(locationDetailsList, "Ziaurehman Amini");
//			searchByExpirationDate(locationDetailsList, "2022-11-15T00:00");
//			searchByStreetName(locationDetailsList, "MARKET ST: DRUMM ST intersection");
//			searchByLeasetDistance(locationDetailsList, 37.786856111883054, -122.40689189299718);


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
