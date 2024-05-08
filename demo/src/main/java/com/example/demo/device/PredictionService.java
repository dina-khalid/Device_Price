package com.example.demo.device;

import com.example.demo.device.dto.DeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PredictionService {

    private final WebClient webClient;

    @Autowired
    public PredictionService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:5000").build();
    }

    public Mono<Integer> predictPriceRange(DeviceDTO deviceDTO) {
        
        return webClient.post()
                .uri("/predict")
                .bodyValue(deviceDTO)
                .retrieve()
                .bodyToMono(PredictionResponse.class)
                .map(PredictionResponse::getPriceRange)
                .onErrorResume(throwable -> Mono.error(new RuntimeException("Failed to predict price: " + throwable.getMessage())));
    }

}
