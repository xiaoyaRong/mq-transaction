package com.rxy;

import com.rxy.parking.service.ParkingServiceLocal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ProviderApplicationTests {
    @Autowired
    private ParkingServiceLocal parkingServiceLocal;

    @Test
    void contextLoads() {
        parkingServiceLocal.testProviderTransaction("123",new Date());
    }

}
