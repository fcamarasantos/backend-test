-- Carga inicial de dados para a tabela estabelecimento, incluindo o campo email
INSERT INTO estabelecimento (nome, cnpj, endereco, telefone, email, vagas_motos, vagas_carros)
VALUES
    ('Estacionamento Central', '12.345.678/0001-00', 'Rua Principal, 123', '(85) 1234-5678', 'contato@central.com', 10, 50),
    ('Estacionamento Norte', '98.765.432/0001-99', 'Avenida Norte, 456', '(85) 8765-4321', 'contato@norte.com', 15, 30);

-- Carga inicial de dados para a tabela veiculo
INSERT INTO veiculo (marca, modelo, cor, placa, tipo)
VALUES
    ('Toyota', 'Corolla', 'Prata', 'ABC-1234', 'CARRO'),
    ('Honda', 'Civic', 'Preto', 'DEF-5678', 'CARRO'),
    ('Yamaha', 'Fazer', 'Azul', 'GHI-9101', 'MOTO'),
    ('Honda', 'CB500', 'Vermelha', 'JKL-1213', 'MOTO');

-- Carga inicial de dados para a tabela entrada_saida
-- Assume-se que os veículos com IDs 1 e 2 já tenham registros de entrada
INSERT INTO entrada_saida (veiculo_id, entrada, saida)
VALUES
    (1, '2024-10-14 08:00:00', '2024-10-14 10:00:00'),
    (2, '2024-10-14 09:00:00', '2024-10-14 11:30:00');

-- Inserindo entradas sem saída registrada
INSERT INTO entrada_saida (veiculo_id, entrada)
VALUES
    (3, '2024-10-14 12:00:00'),
    (4, '2024-10-14 12:30:00');