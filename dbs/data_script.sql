CREATE TABLE IF NOT EXISTS alumnos (
    matricula INT NOT NULL,
    nombre STRING NOT NULL,
    apellido STRING NOT NULL,
    PRIMARY KEY ( matricula )
);

CREATE TABLE IF NOT EXISTS materias (
    clave INT NOT NULL,
    nombre STRING NOT NULL,
    creditos INT NOT NULL,
    PRIMARY KEY ( clave )
);

CREATE TABLE IF NOT EXISTS calificaciones (
    matricula INT NOT NULL,
    clave INT NOT NULL,
    calificacion INT NOT NULL,
    UNIQUE ( matricula, clave ),
    FOREIGN KEY ( matricula ) REFERENCES alumnos ( matricula ),
    FOREIGN KEY ( clave ) REFERENCES materias ( clave )
);

INSERT INTO materias
    ( clave, nombre, creditos )
VALUES
    ( 45865, "Mecanismos", 6 ),
    ( 37965, "Robotica", 7 ),
    ( 68799, "Vibraciones mecanicas", 8 ),
    ( 97346, "Control", 6 ),
    ( 37158, "Microcontroladores", 7 ),
    ( 49201, "Sistemas digitales", 6 ),
    ( 77455, "Quimica", 6 ),
    ( 87615, "Programacion", 7 ),
    ( 93806, "Algebra", 6 ),
    ( 42295, "Calculo", 6 );

INSERT INTO alumnos
    ( matricula, nombre, apellido )
VALUES
    ( 3570, "Erika", "Valdes" ),
    ( 5731, "Guillermo", "Farias" ),
    ( 3497, "Miguel", "Zapata" ),
    ( 5428, "Ruben", "Mendoza" ),
    ( 2851, "Perla", "Villanueva" ),
    ( 7793, "Yanuario", "Rivera" ),
    ( 4201, "Salomon", "Aleman" );

INSERT INTO calificaciones
    ( matricula, clave, calificacion )
VALUES
    ( 3570, 45865, 39 ),
    ( 3570, 37965, -1 ),
    ( 3570, 68799, 69 ),
    ( 3570, 97346, 46 ),
    ( 3570, 37158, 81 ),
    ( 3570, 49201, 53 ),
    ( 3570, 77455, 60 ),
    ( 3570, 87615, -1 ),
    ( 3570, 93806, 64 ),
    ( 3570, 42295, -1 ),
    ( 5731, 45865, 74 ),
    ( 5731, 37965, 94 ),
    ( 5731, 68799, -1 ),
    ( 5731, 97346, 77 ),
    ( 5731, 37158, 86 ),
    ( 5731, 49201, 86 ),
    ( 5731, 77455, 44 ),
    ( 5731, 87615, 71 ),
    ( 5731, 93806, 76 ),
    ( 5731, 42295, 51 ),
    ( 3497, 45865, 74 ),
    ( 3497, 37965, 56 ),
    ( 3497, 68799, 38 ),
    ( 3497, 97346, 88 ),
    ( 3497, 37158, -1 ),
    ( 3497, 49201, 95 ),
    ( 3497, 77455, 94 ),
    ( 3497, 87615, 44 ),
    ( 3497, 93806, -1 ),
    ( 3497, 42295, 68 ),
    ( 5428, 45865, 62 ),
    ( 5428, 37965, 44 ),
    ( 5428, 68799, 79 ),
    ( 5428, 97346, 86 ),
    ( 5428, 37158, 46 ),
    ( 5428, 49201, 60 ),
    ( 5428, 77455, -1 ),
    ( 5428, 87615, 38 ),
    ( 5428, 93806, 54 ),
    ( 5428, 42295, 80 ),
    ( 2851, 45865, 87 ),
    ( 2851, 37965, 92 ),
    ( 2851, 68799, 56 ),
    ( 2851, 97346, -1 ),
    ( 2851, 37158, 52 ),
    ( 2851, 49201, 98 ),
    ( 2851, 77455, 85 ),
    ( 2851, 87615, 54 ),
    ( 2851, 93806, 98 ),
    ( 2851, 42295, 94 ),
    ( 7793, 45865, 50 ),
    ( 7793, 37965, 51 ),
    ( 7793, 68799, -1 ),
    ( 7793, 97346, -1 ),
    ( 7793, 37158, -1 ),
    ( 7793, 49201, 100 ),
    ( 7793, 77455, 87 ),
    ( 7793, 87615, -1 ),
    ( 7793, 93806, 88 ),
    ( 7793, 42295, 67 ),
    ( 4201, 45865, 88 ),
    ( 4201, 37965, 62 ),
    ( 4201, 68799, -1 ),
    ( 4201, 97346, 89 ),
    ( 4201, 37158, 98 ),
    ( 4201, 49201, -1 ),
    ( 4201, 77455, 96 ),
    ( 4201, 87615, 80 ),
    ( 4201, 93806, 93 ),
    ( 4201, 42295, 39 );