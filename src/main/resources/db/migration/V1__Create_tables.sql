CREATE TABLE estabelecimento (
                                 id BIGSERIAL PRIMARY KEY,
                                 nome VARCHAR(100) NOT NULL,
                                 cnpj VARCHAR(18) NOT NULL,
                                 endereco VARCHAR(255) NOT NULL,
                                 telefone VARCHAR(20) NOT NULL,
                                 vagas_motos INT NOT NULL,
                                 vagas_carros INT NOT NULL
);

CREATE TABLE veiculo (
                         id BIGSERIAL PRIMARY KEY,
                         marca VARCHAR(50) NOT NULL,
                         modelo VARCHAR(50) NOT NULL,
                         cor VARCHAR(50) NOT NULL,
                         placa VARCHAR(10) NOT NULL,
                         tipo VARCHAR(5) NOT NULL
);

CREATE TABLE entrada_saida (
                               id BIGSERIAL PRIMARY KEY,
                               veiculo_id BIGINT,
                               entrada TIMESTAMP NOT NULL,
                               saida TIMESTAMP,
                               FOREIGN KEY (veiculo_id) REFERENCES veiculo(id)
);