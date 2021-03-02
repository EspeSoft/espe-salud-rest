package com.espe.salud.banner.service;

import com.espe.salud.banner.model.PersonaBanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PersonaBannerServiceImpl implements PersonaBannerService {
    private final RestTemplate restTemplate;

    @Value("${banner-api-url}")
    private String API_URL;

    @Autowired
    public PersonaBannerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<PersonaBanner> getPersonaBannerInfo(String cedula) {
        String url = API_URL + cedula;
        PersonaBanner[] response = restTemplate.getForObject(url, PersonaBanner[].class);
        assert response != null;
        if (response.length > 0) {
            return Optional.of(response[0]);
        } else {
            return Optional.empty();
        }
    }
}
