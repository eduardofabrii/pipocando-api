package com.pipocando;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pipocando.domain.user.User;
import com.pipocando.domain.user.UserRole;
import com.pipocando.repository.UserRepository;
import com.pipocando.domain.serie.Serie;
import com.pipocando.domain.movie.Movie;
import com.pipocando.domain.avaliation.Avaliation;
import com.pipocando.domain.blog.Post;
import com.pipocando.domain.blog.Comment;
import com.pipocando.domain.blog.PostEvaluation;
import com.pipocando.repository.SerieRepository;
import com.pipocando.repository.MovieRepository;
import com.pipocando.repository.AvaliationRepository;
import com.pipocando.repository.PostRepository;
import com.pipocando.repository.CommentRepository;
import com.pipocando.repository.PostEvaluationRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class PipocandoApplication implements CommandLineRunner{

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final SerieRepository serieRepository;
	private final MovieRepository movieRepository;
	private final AvaliationRepository avaliationRepository;
	private final PostRepository postRepository;
	private final CommentRepository commentRepository;
	private final PostEvaluationRepository postEvaluationRepository;

	public static void main(String[] args) {
		SpringApplication.run(PipocandoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Users creation
		User usuario1 = new User();
		usuario1.setName("Cleverson Lima");
		usuario1.setEmail("clever@gmail.com");
		usuario1.setPassword(passwordEncoder.encode("webdev@123"));
		usuario1.setRole(UserRole.ADMIN);
		usuario1.setActive(true);

		// Adicione os outros usuários conforme o exemplo acima
		User usuario2 = new User(null, "João da Silva", "joao@email.com", passwordEncoder.encode("senha123"), null, null, UserRole.USER, null, true);
		User usuario3 = new User(null, "Maria Souza", "maria@email.com", passwordEncoder.encode("senha456"), null, null, UserRole.ADMIN, null, true);
		User usuario4 = new User(null, "Carlos Lima", "carlos@email.com", passwordEncoder.encode("senha789"), null, null, UserRole.USER, null, true);
		User usuario5 = new User(null, "Ana Paula", "ana@email.com", passwordEncoder.encode("senhaabc"), null, null, UserRole.USER, null, true);
		User usuario6 = new User(null, "Bruno Torres", "bruno@email.com", passwordEncoder.encode("senha321"), null, null, UserRole.USER, null, true);
		User usuario7 = new User(null, "Fernanda Dias", "fernanda@email.com", passwordEncoder.encode("senha654"), null, null, UserRole.ADMIN, null, true);
		User usuario8 = new User(null, "Lucas Mendes", "lucas@email.com", passwordEncoder.encode("senha987"), null, null, UserRole.USER, null, true);
		User usuario9 = new User(null, "Patricia Alves", "patricia@email.com", passwordEncoder.encode("senhaqwe"), null, null, UserRole.USER, null, true);
		User usuario10 = new User(null, "Rafael Costa", "rafael@email.com", passwordEncoder.encode("senhazxc"), null, null, UserRole.USER, null, true);
		User usuario11 = new User(null, "Juliana Ramos", "juliana@email.com", passwordEncoder.encode("senhaasd"), null, null, UserRole.USER, null, true);

		List<User> usuarios = Arrays.asList(
			usuario1, usuario2, usuario3, usuario4, usuario5, usuario6, usuario7, usuario8, usuario9, usuario10, usuario11
		);
		userRepository.saveAll(usuarios);

		// Séries
		Serie s1 = new Serie(null, "Stranger Things", "Netflix", "21 Laps", "The Duffer Brothers", "Millie Bobby Brown, Finn Wolfhard", 4);
		Serie s2 = new Serie(null, "Dark", "Netflix", "Wiedemann & Berg", "Baran bo Odar", "Louis Hofmann, Karoline Eichhorn", 3);
		Serie s3 = new Serie(null, "La Casa de Papel", "Netflix", "Vancouver Media", "Álex Pina", "Úrsula Corberó, Álvaro Morte", 5);
		Serie s4 = new Serie(null, "Breaking Bad", "AMC", "Sony Pictures", "Vince Gilligan", "Bryan Cranston, Aaron Paul", 5);
		Serie s5 = new Serie(null, "The Witcher", "Netflix", "Platige Image", "Lauren Schmidt", "Henry Cavill, Anya Chalotra", 2);
		Serie s6 = new Serie(null, "Friends", "NBC", "Warner Bros.", "David Crane", "Jennifer Aniston, Courteney Cox", 10);
		Serie s7 = new Serie(null, "The Office", "NBC", "Deedle-Dee Productions", "Greg Daniels", "Steve Carell, Rainn Wilson", 9);
		Serie s8 = new Serie(null, "Game of Thrones", "HBO", "HBO", "David Benioff", "Emilia Clarke, Kit Harington", 8);
		Serie s9 = new Serie(null, "The Mandalorian", "Disney+", "Lucasfilm", "Jon Favreau", "Pedro Pascal, Gina Carano", 3);
		Serie s10 = new Serie(null, "Lost", "ABC", "Bad Robot", "J.J. Abrams", "Matthew Fox, Evangeline Lilly", 6);
		serieRepository.saveAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10));

		// Filmes
		Movie m1 = new Movie(null, "Inception", null, "Warner Bros.", "Christopher Nolan", null, 148);
		Movie m2 = new Movie(null, "The Matrix", null, "Warner Bros.", "Lana Wachowski, Lilly Wachowski", null, 136);
		Movie m3 = new Movie(null, "Interstellar", null, "Paramount Pictures", "Christopher Nolan", null, 169);
		Movie m4 = new Movie(null, "Titanic", null, "20th Century Fox", "James Cameron", null, 195);
		Movie m5 = new Movie(null, "Avatar", null, "20th Century Fox", "James Cameron", null, 162);
		Movie m6 = new Movie(null, "Forrest Gump", null, "Paramount Pictures", "Robert Zemeckis", null, 142);
		Movie m7 = new Movie(null, "The Godfather", null, "Paramount Pictures", "Francis Ford Coppola", null, 175);
		Movie m8 = new Movie(null, "Pulp Fiction", null, "Miramax", "Quentin Tarantino", null, 154);
		Movie m9 = new Movie(null, "The Shawshank Redemption", null, "Columbia Pictures", "Frank Darabont", null, 142);
		Movie m10 = new Movie(null, "Jurassic Park", null, "Universal Pictures", "Steven Spielberg", null, 127);
		movieRepository.saveAll(Arrays.asList(m1,m2,m3,m4,m5,m6,m7,m8,m9,m10));

		// Avaliações
		Avaliation a1 = new Avaliation(null, 5, "Ótimo filme!", usuario2, m1);
		Avaliation a2 = new Avaliation(null, 4, "Muito bom!", usuario3, m2);
		Avaliation a3 = new Avaliation(null, 3, "Legal, mas poderia ser melhor.", usuario4, m3);
		Avaliation a4 = new Avaliation(null, 5, "Incrível!", usuario5, m4);
		Avaliation a5 = new Avaliation(null, 2, "Não gostei tanto.", usuario6, m5);
		Avaliation a6 = new Avaliation(null, 4, "Vale a pena assistir.", usuario7, m6);
		Avaliation a7 = new Avaliation(null, 5, "Um clássico!", usuario8, m7);
		Avaliation a8 = new Avaliation(null, 3, "Esperava mais.", usuario9, m8);
		Avaliation a9 = new Avaliation(null, 4, "Bom roteiro.", usuario10, m9);
		Avaliation a10 = new Avaliation(null, 5, "Sensacional!", usuario11, m10);
		avaliationRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10));

		// Posts
		Post p1 = new Post(); p1.setTitle("Primeira postagem"); p1.setContent("Conteúdo do post 1"); p1.setUserId(usuario2.getId()); p1.setMovieId(m1.getId()); p1.setCategory("Filmes");
		Post p2 = new Post(); p2.setTitle("Segunda postagem"); p2.setContent("Conteúdo do post 2"); p2.setUserId(usuario3.getId()); p2.setSerieId(s2.getId()); p2.setCategory("Séries");
		Post p3 = new Post(); p3.setTitle("Terceira postagem"); p3.setContent("Conteúdo do post 3"); p3.setUserId(usuario4.getId()); p3.setMovieId(m3.getId()); p3.setCategory("Filmes");
		Post p4 = new Post(); p4.setTitle("Quarta postagem"); p4.setContent("Conteúdo do post 4"); p4.setUserId(usuario5.getId()); p4.setSerieId(s4.getId()); p4.setCategory("Séries");
		Post p5 = new Post(); p5.setTitle("Quinta postagem"); p5.setContent("Conteúdo do post 5"); p5.setUserId(usuario6.getId()); p5.setMovieId(m5.getId()); p5.setCategory("Filmes");
		Post p6 = new Post(); p6.setTitle("Sexta postagem"); p6.setContent("Conteúdo do post 6"); p6.setUserId(usuario7.getId()); p6.setSerieId(s6.getId()); p6.setCategory("Séries");
		Post p7 = new Post(); p7.setTitle("Sétima postagem"); p7.setContent("Conteúdo do post 7"); p7.setUserId(usuario8.getId()); p7.setMovieId(m7.getId()); p7.setCategory("Filmes");
		Post p8 = new Post(); p8.setTitle("Oitava postagem"); p8.setContent("Conteúdo do post 8"); p8.setUserId(usuario9.getId()); p8.setSerieId(s8.getId()); p8.setCategory("Séries");
		Post p9 = new Post(); p9.setTitle("Nona postagem"); p9.setContent("Conteúdo do post 9"); p9.setUserId(usuario10.getId()); p9.setMovieId(m9.getId()); p9.setCategory("Filmes");
		Post p10 = new Post(); p10.setTitle("Décima postagem"); p10.setContent("Conteúdo do post 10"); p10.setUserId(usuario11.getId()); p10.setSerieId(s10.getId()); p10.setCategory("Séries");
		postRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));

		// Comments
		Comment c1 = new Comment(); c1.setContent("Muito bom!"); c1.setUserId(usuario2.getId()); c1.setPostId(p1.getId());
		Comment c2 = new Comment(); c2.setContent("Gostei do post!"); c2.setUserId(usuario3.getId()); c2.setPostId(p2.getId());
		Comment c3 = new Comment(); c3.setContent("Parabéns pelo conteúdo!"); c3.setUserId(usuario4.getId()); c3.setPostId(p3.getId());
		Comment c4 = new Comment(); c4.setContent("Excelente análise!"); c4.setUserId(usuario5.getId()); c4.setPostId(p4.getId());
		Comment c5 = new Comment(); c5.setContent("Concordo com você."); c5.setUserId(usuario6.getId()); c5.setPostId(p5.getId());
		Comment c6 = new Comment(); c6.setContent("Ótima resenha!"); c6.setUserId(usuario7.getId()); c6.setPostId(p6.getId());
		Comment c7 = new Comment(); c7.setContent("Texto bem escrito."); c7.setUserId(usuario8.getId()); c7.setPostId(p7.getId());
		Comment c8 = new Comment(); c8.setContent("Informações úteis."); c8.setUserId(usuario9.getId()); c8.setPostId(p8.getId());
		Comment c9 = new Comment(); c9.setContent("Adorei!"); c9.setUserId(usuario10.getId()); c9.setPostId(p9.getId());
		Comment c10 = new Comment(); c10.setContent("Vou assistir por sua causa!"); c10.setUserId(usuario11.getId()); c10.setPostId(p10.getId());
		commentRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));

		// Post Evaluations
		PostEvaluation pe1 = new PostEvaluation(); pe1.setUserId(usuario2.getId()); pe1.setPostId(p1.getId()); pe1.setRating(5);
		PostEvaluation pe2 = new PostEvaluation(); pe2.setUserId(usuario3.getId()); pe2.setPostId(p2.getId()); pe2.setRating(4);
		PostEvaluation pe3 = new PostEvaluation(); pe3.setUserId(usuario4.getId()); pe3.setPostId(p3.getId()); pe3.setRating(3);
		PostEvaluation pe4 = new PostEvaluation(); pe4.setUserId(usuario5.getId()); pe4.setPostId(p4.getId()); pe4.setRating(5);
		PostEvaluation pe5 = new PostEvaluation(); pe5.setUserId(usuario6.getId()); pe5.setPostId(p5.getId()); pe5.setRating(2);
		PostEvaluation pe6 = new PostEvaluation(); pe6.setUserId(usuario7.getId()); pe6.setPostId(p6.getId()); pe6.setRating(4);
		PostEvaluation pe7 = new PostEvaluation(); pe7.setUserId(usuario8.getId()); pe7.setPostId(p7.getId()); pe7.setRating(5);
		PostEvaluation pe8 = new PostEvaluation(); pe8.setUserId(usuario9.getId()); pe8.setPostId(p8.getId()); pe8.setRating(3);
		PostEvaluation pe9 = new PostEvaluation(); pe9.setUserId(usuario10.getId()); pe9.setPostId(p9.getId()); pe9.setRating(4);
		PostEvaluation pe10 = new PostEvaluation(); pe10.setUserId(usuario11.getId()); pe10.setPostId(p10.getId()); pe10.setRating(5);
		postEvaluationRepository.saveAll(Arrays.asList(pe1,pe2,pe3,pe4,pe5,pe6,pe7,pe8,pe9,pe10));
	}
}
