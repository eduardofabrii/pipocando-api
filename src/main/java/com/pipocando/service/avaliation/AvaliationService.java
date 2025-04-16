package com.pipocando.service.avaliation;

import java.util.List;

import com.pipocando.dto.request.AvaliationPostRequest;
import com.pipocando.dto.request.AvaliationPutRequest;
import com.pipocando.dto.response.AvaliationGetResponse;

public interface AvaliationService {
    List<AvaliationGetResponse> findAllAvaliations();
    AvaliationGetResponse findAvaliationById(Integer id);
    List<AvaliationGetResponse> findAvaliationsByUserId(Integer userId);
    List<AvaliationGetResponse> findAvaliationsByMovieId(Integer movieId);
    AvaliationGetResponse createAvaliation(AvaliationPostRequest avaliationPostRequest);
    AvaliationGetResponse updateAvaliation(Integer id, AvaliationPutRequest avaliationPutRequest);
    void deleteAvaliation(Integer id);
}
