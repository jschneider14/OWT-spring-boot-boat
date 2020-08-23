DROP TABLE IF EXISTS boat;
DROP TABLE IF EXISTS boat_type;

CREATE TABLE boat_type (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE boat (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  description VARCHAR(500),
  type_id INT NOT NULL,
  FOREIGN KEY (type_id) REFERENCES boat_type(id)
);

insert into boat_type (name) values
('Man-powered boats'),
('Sailboats'),
('Motorboats');

insert into boat (name, description,type_id) values
('Boat 1', 'A brief description of the boat 1',1),
('Boat 2', 'A brief description of the boat 2',2),
('Boat 3', 'A brief description of the boat 3',3),
('Boat 4', 'A brief description of the boat 4',3),
('Boat 5', 'A brief description of the boat 5',2),
('Boat 11', 'A brief description of the boat 11',1),
('Boat 12', 'A brief description of the boat 12',2),
('Boat 13', 'A brief description of the boat 13',3),
('Boat 14', 'A brief description of the boat 14',3),
('Boat 15', 'A brief description of the boat 15',2),
('Boat 21', 'A brief description of the boat 21',1),
('Boat 22', 'A brief description of the boat 22',2),
('Boat 23', 'A brief description of the boat 23',3),
('Boat 24', 'A brief description of the boat 24',3),
('Boat 25', 'A brief description of the boat 25',2),
('Boat 31', 'A brief description of the boat 31',1),
('Boat 32', 'A brief description of the boat 32',2),
('Boat 33', 'A brief description of the boat 33',3),
('Boat 34', 'A brief description of the boat 34',3),
('Boat 35', 'A brief description of the boat 35',2);