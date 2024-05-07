package com.example.demo.device;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DeviceConfig {
    @Bean
    CommandLineRunner commandLineRunner( DeviceRepository repository) {
        return args -> {
            Device dev1 =  new Device(
            1,	1043,	1,	1.8f,	1,	14f,	0,	5f,	0.1f,	193f,	3f,	16f,	226f,	1412f,	3476f,	12f,	7,	2,	0,	1,	0,2		
            );

            Device dev2 =  new Device(
            2,	841,	1,	0.5f,	1,	4f,	1,	61f,	0.8f,	191f,	5f,	12f,	746f,	857f,	3895f,	6f,	0,	7,	1,	0,	0, 2				
            );

            repository.saveAll( List.of(dev1, dev2));

                  };
    }
}