package com.pipocando.service.serie;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pipocando.domain.serie.Serie;
import com.pipocando.dto.request.SeriePostRequest;
import com.pipocando.dto.request.SeriePutRequest;
import com.pipocando.dto.response.SerieGetResponse;
import com.pipocando.mapper.SerieMapper;
import com.pipocando.repository.SerieRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SerieServiceImpl implements SerieService {

    private final SerieRepository serieRepository;
    private final SerieMapper serieMapper;

    @Override
    public List<SerieGetResponse> findAllSeries() {
        List<Serie> series = serieRepository.findAll();
        return serieMapper.toSerieGetResponseList(series);
    }

    @Override
    public SerieGetResponse findSerieById(Integer id) {
        Serie serie = serieRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Série não encontrada com o ID: " + id));
        return serieMapper.toSerieGetResponse(serie);
    }

    @Override
    public SerieGetResponse createSerie(SeriePostRequest seriePostRequest) {
        Serie serie = new Serie();
        serie.setName(seriePostRequest.name());
        serie.setStreaming(seriePostRequest.streaming());
        serie.setCompany(seriePostRequest.company());
        serie.setDirector(seriePostRequest.director());
        serie.setActors(seriePostRequest.actors());
        serie.setSeasons(seriePostRequest.seasons());
        
        Serie savedSerie = serieRepository.save(serie);
        return serieMapper.toSerieGetResponse(savedSerie);
    }

    @Override
    public SerieGetResponse updateSerie(Integer id, SeriePutRequest seriePutRequest) {
        Serie serie = serieRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Série não encontrada com o ID: " + id));
        
        serie.setName(seriePutRequest.name());
        serie.setStreaming(seriePutRequest.streaming());
        serie.setCompany(seriePutRequest.company());
        serie.setDirector(seriePutRequest.director());
        serie.setActors(seriePutRequest.actors());
        serie.setSeasons(seriePutRequest.seasons());
        
        Serie updatedSerie = serieRepository.save(serie);
        return serieMapper.toSerieGetResponse(updatedSerie);
    }

    @Override
    public void deleteSerie(Integer id) {
        Serie serie = serieRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Série não encontrada com o ID: " + id));
        
        serieRepository.delete(serie);
    }
}
