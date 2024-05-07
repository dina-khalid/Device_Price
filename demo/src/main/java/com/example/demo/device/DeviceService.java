package com.example.demo.device;

import org.springframework.stereotype.Component;
import java.util.List;

@Component // or @Service
public class DeviceService {

    public List<Device> getDevices() {
        return List.of(
            new Device(
                1, 
                2000,
                1,
                1,
                0, 
                1,
                1.0f,
                16.0f,
                0, 
                200.0f,
                4.0f,
                2.0f,
                800.0f,
                800.0f,
                2.0f,
                12.0f,
                7.0f,
                19,
                0,
                0,
                1,
                1
            )
        );
    }
}
