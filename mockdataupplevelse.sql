DROP DATABASE IF EXISTS upplevelse;

create database upplevelse;
use upplevelse;

CREATE TABLE address(
	addressId		INT NOT NULL auto_increment PRIMARY KEY,
    streetName		varchar (45),
    streetNumber	varchar (10),
    postalCode		varchar (10),
    county			varchar (45),
    customerId		INT
    );
CREATE TABLE customer(
	customerId 		INT NOT NULL auto_increment PRIMARY KEY,
    firstName 		varchar (45),
    lastName   		varchar (45),
    dob				DATE,
    phone			varchar(20),
    addressId		INT
     );

CREATE TABLE arena(
arenaId				INT NOT NULL auto_increment PRIMARY KEY,
arenaName			varchar(45),
addressId			INT,
inside				BOOLEAN
);

CREATE TABLE concert(
concertId			INT NOT NULL auto_increment PRIMARY KEY,
artistName			varchar(45),
concertDate			DATETIME,
ticketPrice			INT(10),
arenaId				INT
);

CREATE TABLE ticket(
ticketId 			INT NOT NULL auto_increment PRIMARY KEY,
customerId 			INT,
concertId			INT,
purchaseDate		DATETIME
);

CREATE TABLE cusAdd(
cusAddId 		INT NOT NULL auto_increment PRIMARY KEY,
customerId		INT,
addressId		INT
);

ALTER TABLE `upplevelse`.`cusadd` 
ADD CONSTRAINT `cusAddCus`
  FOREIGN KEY (`customerId`)
  REFERENCES `upplevelse`.`customer` (`customerId`)
  ON UPDATE CASCADE,
ADD CONSTRAINT `cusAddAdd`
  FOREIGN KEY (`addressId`)
  REFERENCES `upplevelse`.`address` (`addressId`)
  ON DELETE RESTRICT
  ON UPDATE CASCADE;


ALTER TABLE ticket ADD(
KEY idx_fk_customerId (customerId),
	CONSTRAINT fk_ticket_customer FOREIGN KEY (customerId) REFERENCES customer (customerId),
    KEY idx_fk_concertId (concertId),
    CONSTRAINT fk_ticket_concert FOREIGN KEY (concertId) REFERENCES concert (concertId)
    );

ALTER TABLE address ADD(
    KEY idx_fk_customerId (customerId),
	CONSTRAINT fk_address_customer FOREIGN KEY (customerId) REFERENCES customer (customerId) ON DELETE SET NULL
  );
  
  ALTER TABLE customer ADD(
	KEY idx_fk_addressId (addressId),
    CONSTRAINT fk_customer_address FOREIGN KEY (addressId) REFERENCES address (addressId)
   );
   
   ALTER TABLE concert ADD(
	KEY idx_fk_arenaId (arenaId),
	CONSTRAINT fk_concert_arena FOREIGN KEY (arenaId) REFERENCES arena (arenaId) ON DELETE CASCADE ON UPDATE CASCADE
   );
   
   ALTER TABLE arena ADD(
	KEY idx_fk_addressId (addressId),
	CONSTRAINT fk_concert_address FOREIGN KEY (addressId) REFERENCES address (addressId) ON DELETE CASCADE ON UPDATE CASCADE
   ); 

INSERT INTO customer ( firstName, lastName, dob, phone )
VALUES 	('Otto', 'Kostmann', 19970617, '0708252621'),
		('Pelle', 'Svanslös', 19391230, '0731234567'),
        ('Arnold', 'Schwarzenegger', 19470730, 0708882000),
        ('Benjamin', 'Buttons', 20090116, '0754567890'),
        ('Sebobla', 'Svensson', 19971130, '0713371337');
        
INSERT INTO address (streetName, streetNumber, postalCode, county)
VALUES	('Luthens Gränd', '6', '118 66', 'Stockholm'),
		('Arenavägen', '61', '123 45', 'Stockholm'),
        ('Pacetten', '2', '125 21', 'Stockholm'),
        ('Ellen Keys Gata', '125', '125 64', 'Stockholm'),
        ('Kungens Kurva', '55', '127 43', 'Norrköping'),
        ('Solnavägen', '33', '175 23', 'Solna');

INSERT INTO arena (arenaName, inside)
VALUES 	('Pall Mall Globen', true),
		-- 'Arenavägen 61'
		('Pac Parketten', false),
        --  'Pacetten 2'
        ('Frunkans Arena', true),
        --  'Ellen Keys Gata 125'
        ('Heron City', true),
        --  'Kungens Kurva 55'
        ('Kronofogden Mall Of Scandinavia', true);
        --  'Solnavägen 33'


INSERT INTO concert (artistName, concertDate, ticketPrice)
VALUES 	('Elvisp', 20220308160000, 50),
		('Bat boy', 20220308160000, 1500),
        ('Hamza Hachichi', 20000702123000, 600),
        ('Sergio Dimitrison', 20350308160000, 0),
        ('Bob Marley', 20250505050505, 250);
	