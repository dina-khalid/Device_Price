package com.example.demo.device;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("api/v1/devices")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/")
    public List<Device> getDevices() {
        return deviceService.getDevices();
    }

    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable("id") int id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping("/")
    public void addDevice(@RequestBody Device device) {
        deviceService.addNewDevice(device);
    }
}
