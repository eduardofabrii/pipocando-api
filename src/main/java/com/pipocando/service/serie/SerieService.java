package com.pipocando.service.serie;

import java.util.List;

import com.pipocando.dto.request.SeriePostRequest;
import com.pipocando.dto.request.SeriePutRequest;
import com.pipocando.dto.response.SerieGetResponse;

public interface SerieService {
    List<SerieGetResponse> findAllSeries();
    SerieGetResponse findSerieById(Integer id);
    SerieGetResponse createSerie(SeriePostRequest seriePostRequest);
    SerieGetResponse updateSerie(Integer id, SeriePutRequest seriePutRequest);
    void deleteSerie(Integer id);
}
