package com.pipocando.service.avaliation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pipocando.domain.avaliation.Avaliation;
import com.pipocando.domain.movie.Movie;
import com.pipocando.domain.user.User;
import com.pipocando.dto.request.AvaliationPostRequest;
import com.pipocando.dto.request.AvaliationPutRequest;
import com.pipocando.dto.response.AvaliationGetResponse;
import com.pipocando.mapper.AvaliationMapper;
import com.pipocando.repository.AvaliationRepository;
import com.pipocando.repository.MovieRepository;
import com.pipocando.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliationServiceImpl implements AvaliationService {

    private final AvaliationRepository avaliationRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final AvaliationMapper avaliationMapper;

    @Override
    public List<AvaliationGetResponse> findAllAvaliations() {
        List<Avaliation> avaliations = avaliationRepository.findAll();
        return avaliationMapper.toAvaliationGetResponseList(avaliations);
    }

    @Override
    public AvaliationGetResponse findAvaliationById(Integer id) {
        Avaliation avaliation = avaliationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada com o ID: " + id));
        return avaliationMapper.toAvaliationGetResponse(avaliation);
    }

    @Override
    public List<AvaliationGetResponse> findAvaliationsByUserId(Integer userId) {
        User user = userRepository.findByIdAndDeletedAtIsNull(userId)
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + userId));
        List<Avaliation> avaliations = avaliationRepository.findByUser(user);
        return avaliationMapper.toAvaliationGetResponseList(avaliations);
    }

    @Override
    public List<AvaliationGetResponse> findAvaliationsByMovieId(Integer movieId) {
        Movie movie = movieRepository.findById(movieId)
            .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com o ID: " + movieId));
        List<Avaliation> avaliations = avaliationRepository.findByMovie(movie);
        return avaliationMapper.toAvaliationGetResponseList(avaliations);
    }

    @Override
    public AvaliationGetResponse createAvaliation(AvaliationPostRequest avaliationPostRequest) {
        User user = userRepository.findByIdAndDeletedAtIsNull(avaliationPostRequest.userId())
            .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + avaliationPostRequest.userId()));
        
        Movie movie = movieRepository.findById(avaliationPostRequest.movieId())
            .orElseThrow(() -> new EntityNotFoundException("Filme não encontrado com o ID: " + avaliationPostRequest.movieId()));
        
        // Check if user already evaluated this movie
        avaliationRepository.findByUserAndMovie(user, movie)
            .ifPresent(a -> {
                throw new IllegalStateException("Usuário já avaliou este filme");
            });
        
        Avaliation avaliation = new Avaliation();
        avaliation.setRating(avaliationPostRequest.rating());
        avaliation.setComment(avaliationPostRequest.comment());
        avaliation.setUser(user);
        avaliation.setMovie(movie);
        
        Avaliation savedAvaliation = avaliationRepository.save(avaliation);
        return avaliationMapper.toAvaliationGetResponse(savedAvaliation);
    }

    @Override
    public AvaliationGetResponse updateAvaliation(Integer id, AvaliationPutRequest avaliationPutRequest) {
        Avaliation avaliation = avaliationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada com o ID: " + id));
        
        avaliation.setRating(avaliationPutRequest.rating());
        avaliation.setComment(avaliationPutRequest.comment());
        
        Avaliation updatedAvaliation = avaliationRepository.save(avaliation);
        return avaliationMapper.toAvaliationGetResponse(updatedAvaliation);
    }

    @Override
    public void deleteAvaliation(Integer id) {
        Avaliation avaliation = avaliationRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrada com o ID: " + id));
        
        avaliationRepository.delete(avaliation);
    }
}
