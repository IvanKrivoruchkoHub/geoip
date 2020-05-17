package com.example.geoip.service;

import com.example.geoip.entity.IpInfo;

public interface IpInfoService {
    IpInfo findIpInfoByIp(String ipv4);
}
