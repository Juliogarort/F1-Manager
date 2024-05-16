-- Crear la base de datos
DROP DATABASE IF EXISTS f1_manager;
CREATE DATABASE IF NOT EXISTS f1_manager;
USE f1_manager;

-- creación tabla usuarios
CREATE TABLE IF NOT EXISTS Users (
    id_user INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(50),
    contrasena VARCHAR(50)
);
-- Creación de la tabla Pilotos
CREATE TABLE IF NOT EXISTS Pilotos (
    id_pilotos INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(70),
    nacionalidad VARCHAR(50),
    fecha_nacimiento DATE
);

-- Creación de la tabla Coches
CREATE TABLE IF NOT EXISTS Coches (
    id_coches INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    modelo VARCHAR(50),
    fabricante VARCHAR(50),
    año_fabricacion INT
);

-- Creación de la tabla Pistas
CREATE TABLE IF NOT EXISTS Pistas (
    id_pistas INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    pais VARCHAR(50),
    longitud_km FLOAT,
    record_vuelta VARCHAR(10)
);

-- Creación de la tabla Escuderias
CREATE TABLE IF NOT EXISTS Escuderias (
    id_escuderia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100),
    jefe_de_equipo VARCHAR(50),
    sede VARCHAR(100)
);

INSERT INTO Pilotos (nombre, nacionalidad, fecha_nacimiento) VALUES
('Nikita Mazepin', '*********', '1999-03-02'),
('Max Verstappen', 'Países Bajos', '1997-09-30'),
('Charles Leclerc', 'Mónaco', '1997-10-16'),
('Valtteri Bottas', 'Finlandia', '1989-08-28'),
('Daniel Ricciardo', 'Australia', '1989-07-01'),
('Carlos Sainz Vazquez de Castro (El Matador)(Smooth Operator)', 'España', '1994-09-01'),
('Fernando Alonso Díaz (El Nano)', 'España', '1981-07-29'),
('Lando Norris', 'Reino Unido', '1999-11-13'),
('Pierre Gasly', 'Francia', '1996-02-07'),
('Esteban Ocon', 'Francia', '1996-09-17');


-- Inserción de datos en la tabla Coches
INSERT INTO Coches (modelo, fabricante, año_fabricacion) VALUES
('Mercedes W13', 'Mercedes', 2023),
('Red Bull RBPT', 'Red Bull Racing', 2023),
('Ferrari SF23', 'Ferrari', 2023),
('Williams FW45', 'Williams', 2023),
('McLaren MCL38', 'McLaren', 2023),
('Aston Martin AMR24', 'Aston Martin', 2023),
('Alpine A522', 'Alpine', 2023),
('AlphaTauri AT25', 'AlphaTauri', 2023),
('Alfa Romeo C42', 'Alfa Romeo Racing', 2023),
('Haas VF-23', 'Haas F1 Team', 2023);

-- Inserción de datos en la tabla Pistas
INSERT INTO Pistas (nombre, pais, longitud_km, record_vuelta) VALUES
('Circuit de Barcelona-Catalunya', 'España', 4.655, '1:16.119'),
('Autódromo Internacional do Algarve', 'Portugal', 4.653, '1:18.149'),
('Red Bull Ring', 'Austria', 4.318, '1:02.742'),
('Silverstone Circuit', 'Reino Unido', 5.891, '1:27.097'),
('Circuit de Monaco', 'Mónaco', 3.337, '1:10.166'),
('Baku City Circuit', 'Azerbaiyán', 6.003, '1:38.416'),
('Circuit Paul Ricard', 'Francia', 5.842, '1:32.740'),
('Spielberg Circuit', 'Austria', 4.326, '1:02.742'),
('Sochi Autodrom', 'Rusia', 5.848, '1:34.586'),
('Yas Marina Circuit', 'Emiratos Árabes Unidos', 5.554, '1:36.812');

-- Inserción de datos en la tabla Escuderias
INSERT INTO Escuderias (nombre, jefe_de_equipo, sede) VALUES
('Mercedes-AMG Petronas Formula One Team', 'Toto Wolff', 'Brackley, Reino Unido'),
('Red Bull Racing Honda', 'Christian Horner', 'Milton Keynes, Reino Unido'),
('Scuderia Ferrari HP', 'Frédéric Vasseur', 'Maranello, Italia'),
('Williams Racing', 'James P. Vowles', 'Grove, Reino Unido'),
('McLaren F1 Team', 'Andrea Stella', 'Woking, Reino Unido'),
('Aston Martin Aramco Cognizant Formula One Team', 'Mike Krack', 'Silverstone, Reino Unido'),
('Alpine F1 Team', 'Bruno Famin', 'Enstone, Reino Unido'),
('Visa CashApp RB', 'Laurent Mekies', 'Faenza, Italia'),
('Stake F1 Team', 'Alessandro Alunni Bravi', 'Hinwil, Suiza'),
('Haas F1 Team', 'Ayao Komatsu', 'Kannapolis, Estados Unidos');

-- Mostrar todos los datos de la tabla de Usuarios
SELECT * FROM Users;

-- Mostrar todos los datos de la tabla Pilotos
SELECT * FROM Pilotos;

-- Mostrar todos los datos de la tabla Coches
SELECT * FROM Coches;

-- Mostrar todos los datos de la tabla Pistas
SELECT * FROM Pistas;

-- Mostrar todos los datos de la tabla Escuderias
SELECT * FROM Escuderias;