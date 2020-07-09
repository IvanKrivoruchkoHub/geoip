package com.example.geoip.controller;

import com.example.geoip.dto.IpInfoDto;
import com.example.geoip.entity.IpInfo;
import com.example.geoip.service.IpInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/geoip")
public class IpInfoController {

    @Autowired
    private IpInfoService ipInfoService;

    @GetMapping("/{ipv4}")
    public IpInfoDto getIpInfo(@PathVariable("ipv4") String ipv4) {
        if (!ipv4.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Bad input data");
        }
        IpInfo ipInfo = ipInfoService.findIpInfoByIp(ipv4);
        return convertIpInfoToDto(ipInfo, ipv4);
    }

    private IpInfoDto convertIpInfoToDto(IpInfo ipInfo, String ipv4) {
        IpInfoDto ipInfoDto = new IpInfoDto();
        ipInfoDto.setCanonicalIPv4Representation(ipv4);
        ipInfoDto.setCityName(ipInfo.getCityName());
        ipInfoDto.setCountryCode(ipInfo.getCountryCode());
        ipInfoDto.setCountryName(ipInfo.getCountryName());
        ipInfoDto.setRegionName(ipInfo.getRegionName());
        ipInfoDto.setLatitude(ipInfo.getLatitude());
        ipInfoDto.setLongitude(ipInfo.getLongitude());
        return ipInfoDto;
    }
}
