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

import com.pipocando.dto.request.AvaliationPostRequest;
import com.pipocando.dto.request.AvaliationPutRequest;
import com.pipocando.dto.response.AvaliationGetResponse;
import com.pipocando.service.avaliation.AvaliationService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1/avaliation")
@RequiredArgsConstructor
public class AvaliationController {

    private final AvaliationService avaliationService;

    @GetMapping
    public ResponseEntity<List<AvaliationGetResponse>> getAllAvaliations() {
        return ResponseEntity.ok(avaliationService.findAllAvaliations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliationGetResponse> getAvaliationById(@PathVariable Integer id) {
        return ResponseEntity.ok(avaliationService.findAvaliationById(id));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AvaliationGetResponse>> getAvaliationsByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(avaliationService.findAvaliationsByUserId(userId));
    }
    
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<AvaliationGetResponse>> getAvaliationsByMovieId(@PathVariable Integer movieId) {
        return ResponseEntity.ok(avaliationService.findAvaliationsByMovieId(movieId));
    }

    @PostMapping
    public ResponseEntity<AvaliationGetResponse> createAvaliation(@RequestBody @Valid AvaliationPostRequest avaliationPostRequest) {
        AvaliationGetResponse createdAvaliation = avaliationService.createAvaliation(avaliationPostRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAvaliation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliationGetResponse> updateAvaliation(
            @PathVariable Integer id,
            @RequestBody @Valid AvaliationPutRequest avaliationPutRequest) {
        AvaliationGetResponse updatedAvaliation = avaliationService.updateAvaliation(id, avaliationPutRequest);
        return ResponseEntity.ok(updatedAvaliation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvaliation(@PathVariable Integer id) {
        avaliationService.deleteAvaliation(id);
        return ResponseEntity.noContent().build();
    }
}
