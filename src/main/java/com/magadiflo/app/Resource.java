package com.magadiflo.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class Resource {

    private static final String URL_EXTERNA = "https://jsonplaceholder.typicode.com";

    private final RestTemplate restTemplate;

    public Resource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/ver")
    public DataEntity getApi() {
        String url = URL_EXTERNA.concat("/todos/1");
        return this.restTemplate.getForObject(url, DataEntity.class);
    }

    @GetMapping("/listar")
    public List<DataEntity> getLista() {
        String url = URL_EXTERNA.concat("/todos");
        DataEntity[] dataEntities = this.restTemplate.getForObject(url, DataEntity[].class);
        return Arrays.asList(dataEntities);
    }

}
