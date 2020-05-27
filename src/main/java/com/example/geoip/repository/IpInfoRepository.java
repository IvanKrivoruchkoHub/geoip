package com.example.geoip.repository;

import com.example.geoip.entity.IpInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IpInfoRepository extends JpaRepository<IpInfo, Long> {
    @Query("select ip from IpInfo ip where :ip between ip.ipFrom and ip.ipTo")
    Optional<IpInfo> findIpInfoByIp(@Param("ip") Long ip);
}
