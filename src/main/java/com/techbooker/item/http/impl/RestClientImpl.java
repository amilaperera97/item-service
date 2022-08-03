package com.techbooker.item.http.impl;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.techbooker.item.http.ClientMethod;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Slf4j
@AllArgsConstructor
public class RestClientImpl implements ClientMethod {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public <T> T getForEntity(Class<T> classType, String url, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers) {
        AtomicReference<HttpEntity<String>> requestEntity = new AtomicReference<>();
        headers.ifPresent(value -> requestEntity.set(new HttpEntity<>(null, value)));
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity.get(), String.class, uriVariables);
            JavaType javaType = objectMapper.getTypeFactory().constructType(classType);
            return readValue(response, javaType);
        } catch (HttpClientErrorException exception) {
            if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                log.info("No data found {}", url);
            } else {
                log.info("rest client exception", exception.getMessage());
            }
        }
        return null;
    }

    @Override
    public <T> List<T> getForList(Class<T> classType, String url, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers) {
        AtomicReference<HttpEntity<String>> requestEntity = new AtomicReference<>();
        headers.ifPresent(value -> requestEntity.set(new HttpEntity<>(null, value)));
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity.get(), String.class, uriVariables);
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, classType);
            return readValue(response, collectionType);
        } catch (HttpClientErrorException exception) {
            if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                log.info("No data found {}", url);
            } else {
                log.info("rest client exception", exception.getMessage());
            }
        }
        return new ArrayList<>();
    }

    @Override
    public <T, R> T postForEntity(Class<T> classType, String url, R body, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers) {
        HttpEntity<R> requestEntity = headers.map(httpHeaders -> new HttpEntity<>(body, httpHeaders)).orElseGet(() -> new HttpEntity<>(body));
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class, uriVariables);
        JavaType javaType = objectMapper.getTypeFactory().constructType(classType);
        return readValue(response, javaType);
    }

    @Override
    public <T, R> T putForEntity(Class<T> classType, String url, R body, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers) {
        HttpEntity<R> requestEntity = headers.map(httpHeaders -> new HttpEntity<>(body, httpHeaders)).orElseGet(() -> new HttpEntity<>(body));
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class, uriVariables);
        JavaType javaType = objectMapper.getTypeFactory().constructType(classType);
        return readValue(response, javaType);
    }

    @Override
    public <T, R> T delete(Class<T> classType, String url, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers) {
        AtomicReference<HttpEntity<String>> requestEntity = new AtomicReference<>();
        headers.ifPresent(value -> requestEntity.set(new HttpEntity<>(null, value)));

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity.get(), String.class, uriVariables);
        JavaType javaType = objectMapper.getTypeFactory().constructType(classType);
        return readValue(response, javaType);
    }

    private <T> T readValue(ResponseEntity<String> response, JavaType javaType) {
        T result = null;
        if (response.getStatusCode() == HttpStatus.OK ||
                response.getStatusCode() == HttpStatus.CREATED) {
            try {
                result = objectMapper.readValue(response.getBody(), javaType);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        } else {
            log.info("No data found {}", response.getStatusCode());
        }
        return result;
    }

    private void headers(Optional<MultiValueMap<String, String>> headers) {

    }
}
