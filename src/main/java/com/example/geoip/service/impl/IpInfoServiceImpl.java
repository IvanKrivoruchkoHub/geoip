package com.example.geoip.service.impl;

import com.example.geoip.entity.IpInfo;
import com.example.geoip.repository.IpInfoRepository;
import com.example.geoip.service.IpInfoService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IpInfoServiceImpl implements IpInfoService {
    @Autowired
    private IpInfoRepository ipInfoRepository;

    @Override
    public IpInfo findIpInfoByIp(String ipv4) {
        Optional<IpInfo> ipInfo = ipInfoRepository.findIpInfoByIp(covertFromIpv4ToDecimal(ipv4));
        if (ipInfo.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Can not find information for ipv4 = " + ipv4
                    + ". Check input data");
        }
        return ipInfo.get();
    }

    private Long covertFromIpv4ToDecimal(String ipv4) {
        String[] ipAddressInArray = ipv4.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            if (ip > 255) {
                throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Bad ip data (ipv4 = " + ipv4 + ")");
            }
            result += ip * Math.pow(256, power);
        }
        return result;
    }
}
