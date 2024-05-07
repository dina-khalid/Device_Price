package com.example.demo.device;

import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Component 
public class DeviceService {

    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }


    public List<Device> getDevices() {
        return deviceRepository.findAll();
    }

    public void addNewDevice(Device device) {
        deviceRepository.save(device);
    }

    public Device getDeviceById(int id) {
        return deviceRepository.findById(id).orElseThrow(() -> new IllegalStateException("Device with id " + id + " not found"));
    }
}
