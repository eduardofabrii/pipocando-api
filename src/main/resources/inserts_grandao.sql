-- USERS
INSERT INTO users (nome, email, senha, data_criacao, ultimo_login, perfil, deleted_at, ativo) VALUES
('João da Silva', 'joao@email.com', 'senha123', NOW(), NOW(), 'USER', NULL, true),
('Maria Souza', 'maria@email.com', 'senha456', NOW(), NOW(), 'ADMIN', NULL, true),
('Carlos Lima', 'carlos@email.com', 'senha789', NOW(), NOW(), 'USER', NULL, true),
('Ana Paula', 'ana@email.com', 'senhaabc', NOW(), NOW(), 'USER', NULL, true),
('Bruno Torres', 'bruno@email.com', 'senha321', NOW(), NOW(), 'USER', NULL, true),
('Fernanda Dias', 'fernanda@email.com', 'senha654', NOW(), NOW(), 'ADMIN', NULL, true),
('Lucas Mendes', 'lucas@email.com', 'senha987', NOW(), NOW(), 'USER', NULL, true),
('Patricia Alves', 'patricia@email.com', 'senhaqwe', NOW(), NOW(), 'USER', NULL, true),
('Rafael Costa', 'rafael@email.com', 'senhazxc', NOW(), NOW(), 'USER', NULL, true),
('Juliana Ramos', 'juliana@email.com', 'senhaasd', NOW(), NOW(), 'USER', NULL, true);

-- SERIES
INSERT INTO series (nome, streaming, gravadora, diretor, atores, temporadas) VALUES
('Stranger Things', 'Netflix', '21 Laps', 'The Duffer Brothers', 'Millie Bobby Brown, Finn Wolfhard', 4),
('Dark', 'Netflix', 'Wiedemann & Berg', 'Baran bo Odar', 'Louis Hofmann, Karoline Eichhorn', 3),
('La Casa de Papel', 'Netflix', 'Vancouver Media', 'Álex Pina', 'Úrsula Corberó, Álvaro Morte', 5),
('Breaking Bad', 'AMC', 'Sony Pictures', 'Vince Gilligan', 'Bryan Cranston, Aaron Paul', 5),
('The Witcher', 'Netflix', 'Platige Image', 'Lauren Schmidt', 'Henry Cavill, Anya Chalotra', 2),
('Friends', 'NBC', 'Warner Bros.', 'David Crane', 'Jennifer Aniston, Courteney Cox', 10),
('The Office', 'NBC', 'Deedle-Dee Productions', 'Greg Daniels', 'Steve Carell, Rainn Wilson', 9),
('Game of Thrones', 'HBO', 'HBO', 'David Benioff', 'Emilia Clarke, Kit Harington', 8),
('The Mandalorian', 'Disney+', 'Lucasfilm', 'Jon Favreau', 'Pedro Pascal, Gina Carano', 3),
('Lost', 'ABC', 'Bad Robot', 'J.J. Abrams', 'Matthew Fox, Evangeline Lilly', 6);

-- MOVIES
INSERT INTO movies (nome, gravadora, diretor, duracao) VALUES
('Inception', 'Warner Bros.', 'Christopher Nolan', 148),
('The Matrix', 'Warner Bros.', 'Lana Wachowski, Lilly Wachowski', 136),
('Interstellar', 'Paramount Pictures', 'Christopher Nolan', 169),
('Titanic', '20th Century Fox', 'James Cameron', 195),
('Avatar', '20th Century Fox', 'James Cameron', 162),
('Forrest Gump', 'Paramount Pictures', 'Robert Zemeckis', 142),
('The Godfather', 'Paramount Pictures', 'Francis Ford Coppola', 175),
('Pulp Fiction', 'Miramax', 'Quentin Tarantino', 154),
('The Shawshank Redemption', 'Columbia Pictures', 'Frank Darabont', 142),
('Jurassic Park', 'Universal Pictures', 'Steven Spielberg', 127);

-- AVALIACAO
INSERT INTO avaliacao (avaliacao, comentario, fk_id_usuario, fk_id_filme) VALUES
(5, 'Ótimo filme!', 1, 1),
(4, 'Muito bom!', 2, 2),
(3, 'Legal, mas poderia ser melhor.', 3, 3),
(5, 'Incrível!', 4, 4),
(2, 'Não gostei tanto.', 5, 5),
(4, 'Vale a pena assistir.', 6, 6),
(5, 'Um clássico!', 7, 7),
(3, 'Esperava mais.', 8, 8),
(4, 'Bom roteiro.', 9, 9),
(5, 'Sensacional!', 10, 10);

-- POSTS
INSERT INTO posts (title, content, user_id, movie_id, serie_id, created_at, updated_at, category) VALUES
('Primeira postagem', 'Conteúdo do post 1', 1, 1, NULL, NOW(), NOW(), 'Filmes'),
('Segunda postagem', 'Conteúdo do post 2', 2, NULL, 2, NOW(), NOW(), 'Séries'),
('Terceira postagem', 'Conteúdo do post 3', 3, 3, NULL, NOW(), NOW(), 'Filmes'),
('Quarta postagem', 'Conteúdo do post 4', 4, NULL, 4, NOW(), NOW(), 'Séries'),
('Quinta postagem', 'Conteúdo do post 5', 5, 5, NULL, NOW(), NOW(), 'Filmes'),
('Sexta postagem', 'Conteúdo do post 6', 6, NULL, 6, NOW(), NOW(), 'Séries'),
('Sétima postagem', 'Conteúdo do post 7', 7, 7, NULL, NOW(), NOW(), 'Filmes'),
('Oitava postagem', 'Conteúdo do post 8', 8, NULL, 8, NOW(), NOW(), 'Séries'),
('Nona postagem', 'Conteúdo do post 9', 9, 9, NULL, NOW(), NOW(), 'Filmes'),
('Décima postagem', 'Conteúdo do post 10', 10, NULL, 10, NOW(), NOW(), 'Séries');

-- COMMENTS
INSERT INTO comments (content, user_id, post_id, created_at) VALUES
('Muito bom!', 1, 1, NOW()),
('Gostei do post!', 2, 2, NOW()),
('Parabéns pelo conteúdo!', 3, 3, NOW()),
('Excelente análise!', 4, 4, NOW()),
('Concordo com você.', 5, 5, NOW()),
('Ótima resenha!', 6, 6, NOW()),
('Texto bem escrito.', 7, 7, NOW()),
('Informações úteis.', 8, 8, NOW()),
('Adorei!', 9, 9, NOW()),
('Vou assistir por sua causa!', 10, 10, NOW());

-- POST_EVALUATIONS
INSERT INTO post_evaluations (user_id, post_id, rating) VALUES
(1, 1, 5),
(2, 2, 4),
(3, 3, 3),
(4, 4, 5),
(5, 5, 2),
(6, 6, 4),
(7, 7, 5),
(8, 8, 3),
(9, 9, 4),
(10, 10, 5);