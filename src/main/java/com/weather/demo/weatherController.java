package com.weather.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class weatherController {

    @GetMapping("/city")
    public Weather weather(@RequestParam(value = "city", defaultValue = "Batangas City") String city) {
        return new Weather(city, "642f7f0eeced185b420232e05ee03ab6");
    }

    @GetMapping(value = "/test")
    public String getCityName() {
        String uri = "http://localhost:8080/city";
        RestTemplate weatherTemp = new RestTemplate();
        String result = weatherTemp.getForObject(uri, String.class);
        return result;
    }
    
}
