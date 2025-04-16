package com.pipocando.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pipocando.dto.request.SeriePostRequest;
import com.pipocando.dto.request.SeriePutRequest;
import com.pipocando.dto.response.SerieGetResponse;
import com.pipocando.service.serie.SerieService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/serie")
@RequiredArgsConstructor
public class SerieController {

    private final SerieService serieService;

    @GetMapping
    public ResponseEntity<List<SerieGetResponse>> getAllSeries() {
        return ResponseEntity.ok(serieService.findAllSeries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieGetResponse> getSerieById(@PathVariable Integer id) {
        return ResponseEntity.ok(serieService.findSerieById(id));
    }

    @PostMapping
    public ResponseEntity<SerieGetResponse> createSerie(@RequestBody @Valid SeriePostRequest seriePostRequest) {
        SerieGetResponse createdSerie = serieService.createSerie(seriePostRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSerie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SerieGetResponse> updateSerie(
            @PathVariable Integer id,
            @RequestBody @Valid SeriePutRequest seriePutRequest) {
        SerieGetResponse updatedSerie = serieService.updateSerie(id, seriePutRequest);
        return ResponseEntity.ok(updatedSerie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSerie(@PathVariable Integer id) {
        serieService.deleteSerie(id);
        return ResponseEntity.noContent().build();
    }
}
