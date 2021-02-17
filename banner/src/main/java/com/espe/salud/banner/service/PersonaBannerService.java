package com.espe.salud.banner.service;

import com.espe.salud.banner.model.PersonaBanner;

import java.util.Optional;

public interface PersonaBannerService {
    Optional<PersonaBanner> getPersonaBannerInfo(String cedula);
}
