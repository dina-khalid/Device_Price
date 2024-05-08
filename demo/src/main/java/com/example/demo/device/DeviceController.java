package com.example.demo.device;

import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("api/v1/devices")
public class DeviceController {

    private final DeviceService deviceService;
    private final PredictionService predictionService;

    @Autowired
    public DeviceController(DeviceService deviceService, PredictionService predictionService) {
        this.deviceService = deviceService;
        this.predictionService = predictionService;
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

    @PostMapping("/predict/{deviceId}")
    public Mono<Device> predictPrice(@PathVariable int deviceId) {
        return deviceService.getDeviceById(deviceId)
                .flatMap(device -> {
                    // Convert Device to DeviceDTO
                    DeviceDTO deviceDTO = mapToDeviceDTO(device);
                    // Call prediction service with DeviceDTO
                    return predictionService.predictPriceRange(deviceDTO)
                            .map(priceRange -> {
                                // Set the predicted price range to the device
                                device.setPrice_range(priceRange);
                                return device;
                            });
                });
    }

    // Helper method to map Device to DeviceDTO
    private DeviceDTO mapToDeviceDTO(Device device) {
        DeviceDTO deviceDTO = new DeviceDTO();
        // Set device info to DTO
        deviceDTO.setBattery_power(device.getBattery_power());
        deviceDTO.setBlue(device.getBlue());
        deviceDTO.setClock_speed(device.getClock_speed());
        deviceDTO.setDual_sim(device.getDual_sim());
        deviceDTO.setFc(device.getFc());
        deviceDTO.setFour_g(device.getFour_g());
        deviceDTO.setInt_memory(device.getInt_memory());
        deviceDTO.setM_dep(device.getM_dep());
        deviceDTO.setMobile_wt(device.getMobile_wt());
        deviceDTO.setN_cores(device.getN_cores());
        deviceDTO.setPc(device.getPc());
        deviceDTO.setPx_height(device.getPx_height());
        deviceDTO.setPx_width(device.getPx_width());
        deviceDTO.setRam(device.getRam());
        deviceDTO.setSc_h(device.getSc_h());
        deviceDTO.setSc_w(device.getSc_w());
        deviceDTO.setTalk_time(device.getTalk_time());
        deviceDTO.setThree_g(device.getThree_g());
        deviceDTO.setTouch_screen(device.getTouch_screen());
        deviceDTO.setWifi(device.getWifi());
        return deviceDTO;
    }


}
