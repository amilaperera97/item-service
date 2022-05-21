package com.techbooker.item.http;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Component
public class RestClient {
    private final RestTemplate restTemplate;

    public static void get() {

    }
}
