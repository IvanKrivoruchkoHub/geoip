package com.example.geoip.dto;

import lombok.Data;

@Data
public class IpInfoDto {
    private String canonicalIPv4Representation;
    private String countryCode;
    private String countryName;
    private String regionName;
    private String cityName;
    private Double latitude;
    private Double longitude;
}
