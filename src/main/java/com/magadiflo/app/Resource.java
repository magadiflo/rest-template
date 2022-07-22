package com.magadiflo.app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Resource {

    private static final String URL_EXTERNA = "https://jsonplaceholder.typicode.com";

    private final RestTemplate restTemplate;

    public Resource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/ver/{id}")
    public DataEntity getViewData(@PathVariable Integer id) {
        String url = URL_EXTERNA.concat("/todos/{id}");
        return this.restTemplate.getForObject(url, DataEntity.class, id);
    }

    @GetMapping("/listar")
    public List<DataEntity> getLista() {
        String url = URL_EXTERNA.concat("/todos");
        DataEntity[] dataEntities = this.restTemplate.getForObject(url, DataEntity[].class);
        return Arrays.asList(dataEntities);
    }

    @PostMapping("/crear")
    public DataEntity crearData(@RequestBody  DataEntity data) {
        return this.restTemplate.postForObject(URL_EXTERNA.concat("/posts"), data, DataEntity.class);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizaData(@RequestBody  DataEntity data) {
        this.restTemplate.put(URL_EXTERNA.concat("/posts/{id}"), data, data.getId());
        Map<String, Object> response = new HashMap<>();
        response.put("state", "Actualización exitosa");
        response.put("data", data);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminaData(@PathVariable Integer id) {
        this.restTemplate.delete(URL_EXTERNA.concat("/posts/{id}"), id);

        Map<String, Object> response = new HashMap<>();
        response.put("state", "Registro eliminado!");
        return ResponseEntity.ok().body(response);
    }

}
