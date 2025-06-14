-- Inserts para todas as tabelas do sistema

-- USERS
INSERT INTO users (nome, email, senha, data_criacao, ultimo_login, perfil, deleted_at, ativo) VALUES
  ('João da Silva', 'joao@email.com', 'senha123', NOW(), NOW(), 'USER', NULL, true),
  ('Maria Souza', 'maria@email.com', 'senha456', NOW(), NOW(), 'ADMIN', NULL, true),
  ('Carlos Lima', 'carlos@email.com', 'senha789', NOW(), NOW(), 'USER', NOW(), false);

-- SERIES
INSERT INTO series (nome, streaming, gravadora, diretor, atores, temporadas) VALUES
  ('Stranger Things', 'Netflix', '21 Laps', 'The Duffer Brothers', 'Millie Bobby Brown, Finn Wolfhard', 4),
  ('Dark', 'Netflix', 'Wiedemann & Berg', 'Baran bo Odar', 'Louis Hofmann, Karoline Eichhorn', 3),
  ('La Casa de Papel', 'Netflix', 'Vancouver Media', 'Álex Pina', 'Úrsula Corberó, Álvaro Morte', 5);

-- MOVIES
INSERT INTO movies (nome, gravadora, diretor, duracao) VALUES
  ('Inception', 'Warner Bros.', 'Christopher Nolan', 148),
  ('The Matrix', 'Warner Bros.', 'Lana Wachowski, Lilly Wachowski', 136),
  ('Interstellar', 'Paramount Pictures', 'Christopher Nolan', 169);

-- AVALIACAO
INSERT INTO avaliacao (avaliacao, comentario, fk_id_usuario, fk_id_filme) VALUES
  (5, 'Ótimo filme!', 1, 1),
  (4, 'Muito bom!', 2, 2),
  (3, 'Legal, mas poderia ser melhor.', 3, 3);

-- POSTS
INSERT INTO posts (title, content, user_id, movie_id, serie_id, created_at, updated_at) VALUES
  ('Primeira postagem', 'Conteúdo do post 1', 1, 1, NULL, NOW(), NOW()),
  ('Segunda postagem', 'Conteúdo do post 2', 2, NULL, 2, NOW(), NOW()),
  ('Terceira postagem', 'Conteúdo do post 3', 3, 3, NULL, NOW(), NOW());

-- COMMENTS
INSERT INTO comments (content, user_id, post_id, created_at) VALUES
  ('Muito bom!', 1, 1, NOW()),
  ('Gostei do post!', 2, 2, NOW()),
  ('Parabéns pelo conteúdo!', 3, 3, NOW());

-- POST_EVALUATIONS
INSERT INTO post_evaluations (user_id, post_id, rating) VALUES
  (1, 1, 5),
  (2, 2, 4),
  (3, 3, 3);
