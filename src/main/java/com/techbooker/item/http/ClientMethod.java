package com.techbooker.item.http;

import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClientMethod {

    <T> T getForEntity(Class<T> classType, String url, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers);

    <T> List<T> getForList(Class<T> classType, String url, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers);

    <T, R> T postForEntity(Class<T> classType, String url, R body, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers);

    <T, R> T putForEntity(Class<T> classType, String url, R body, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers);

    <T, R> T delete(Class<T> classType, String url, Map<String, ?> uriVariables, Optional<MultiValueMap<String, String>> headers);

}
