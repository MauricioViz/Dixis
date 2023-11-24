CREATE DATABASE bddixis

CREATE TABLE clientes (
idcliente VARCHAR(10) PRIMARY KEY,
razonsocial VARCHAR(30),
ruc VARCHAR(11),
telefono CHAR(9),
direccion VARCHAR(50)
)

CREATE TABLE proveedor
(
idproveedor VARCHAR(10) PRIMARY KEY,
razonsocial VARCHAR(30),
ruc VARCHAR(11),
telefono CHAR(9),
direccion VARCHAR(50)
)

CREATE TABLE productos
(
idproducto VARCHAR(5) PRIMARY KEY,
idproveedor VARCHAR(5) REFERENCES proveedor(idproveedor),
nombre VARCHAR(30),
prec_compra DECIMAL(9,2),
prec_venta DECIMAL(9,2),
cantidad INT
)

CREATE TABLE empleados
(
idempleado VARCHAR(5) PRIMARY KEY,
nombre VARCHAR(20),
apellidos VARCHAR (20),
dni VARCHAR (8),
telefono VARCHAR(9),
sexo CHAR(1)
)

CREATE TABLE usuarios
(
idusuario INT PRIMARY KEY,
idempleado VARCHAR(5) REFERENCES empleados(idempleado),
usuario VARCHAR(20),
pass VARCHAR(20)
)

CREATE TABLE compras
(
idcompra INT PRIMARY KEY,
fecha VARCHAR(15),
subtotal DECIMAL(8,2),
igv DECIMAL(8,2),
total DECIMAL(8,2),
estado VARCHAR(20),
idempleado VARCHAR(5) REFERENCES empleado(idempleado),
idproveedor VARCHAR(5) REFERENCES proveedor(idproveedor)
)

CREATE TABLE detalle_compras
(
idcompra INT REFERENCES compras(idcompra),
idproducto VARCHAR(5) REFERENCES productos (idproducto),
PRIMARY KEY(idcompra,idproducto),
cantidad INT,
precio DECIMAL(8,2),
total DECIMAL (8,2)
)

CREATE TABLE ventas
(
idventa INT PRIMARY KEY,
fecha DATE,
subtotal DECIMAL(8,2),
total DECIMAL(8,2),
idempleado VARCHAR(5) REFERENCES empleados(idempleados),
idcliente VARCHAR(5) REFERENCES clientes(idcliente),
serie VARCHAR(20),
igv DECIMAL(8,2)
)

CREATE TABLE detalle_ventas
(
idventa INT REFERENCES ventas(idventa),
idproducto VARCHAR(5)REFERENCES productos(idproducto),
PRIMARY KEY(idventa,idproducto),
cantidad INT,
precio DECIMAL(8,2),
total DECIMAL(8,2)
)

/*SECCION DE EMPLEADOS*/
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0001', 'Juan', 'Pérez', '47245645', '999581782', 'H');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0002', 'María', 'Gómez', '28784645', '959670455', 'M');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0003', 'Pedro', 'Rodríguez', '75805972', '965263819', 'H');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0004', 'Luisa', 'Sánchez', '61748075', '951420479', 'M');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0005', 'Carlos', 'López', '90166791', '948893761', 'H');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0006', 'Ana', 'Martínez', '45678901', '906343979', 'M');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0007', 'Manuel', 'Torres', '56789012', '961357409', 'H');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0008', 'Sofía', 'Díaz', '67890123', '946501381', 'M');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0009', 'Javier', 'Ramírez', '78901234', '967847572', 'H');
INSERT INTO empleados (idempleado, nombre, apellidos, dni, telefono, sexo)
VALUES ('E0010', 'Elena', 'Vargas', '89012345', '970806932', 'M');

/*SECCION DE CLIENTES*/
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0001', 'PharmaHealth Solutions', '12345678901', '980046204', 'Av. de las Flores');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0002', 'BioMed Pharmaceuticals', '23456789012', '994092090', 'Calle de la Brisa');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0003', 'VitalCare Laboratories', '34567890123', '964599455', 'Jr. de los Pájaros');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0004', 'MedicoPharm Co.', '45678901234', '932150154', 'Av. del Bosque');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0005', 'GlobalRx Innovations', '56789012345', '984254764', 'Calle de la Luna');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0006', 'BioWell Pharmaceuticals', '67890123456', '963949499', 'Jr. de las Estrellas');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0007', 'LifeScience Therapeutics', '78901234567', '985478458', 'Av. de las Palmas');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0008', 'CureLink Pharmaceuticals', '89012345678', '965878458', 'Calle del Sol');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0009', 'HealthMatrix Labs', '90123456789', '975487457', 'Jr. de las Mariposas');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0010', 'WellnessPharma Inc.', '01234567890', '956235148', 'Av. de la Montaña');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0011', 'Biogenetics Research', '12345678911', '985632145', 'Calle de las Rosas');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0012', 'MedicoSolutions Group', '23456789022', '987478521', 'Jr. del Río');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0013', 'VitalScience Pharmaceuticals', '34567890133', '914528459', 'Av. de los Pinos');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0014', 'ApexPharma Labs', '45678901244', '958784142', 'Calle de los Cerezos');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0015', 'MedixSynth Corporation', '56789012355', '987478412', 'Jr. de la Playa');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0016', 'GenoPharma Innovations', '67890123466', '965485125', 'Av. del Prado');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0017', 'BioCure Therapies', '78901234577', '968547451', 'Calle de las Palmeras');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0018', 'PharmaGenix Solutions', '89012345688', '958475415', 'Jr. de las Orquídeas');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0019', 'BioLife Sciences', '90123456799', '968589568', 'Av. de las Amapolas');
INSERT INTO clientes (idcliente, razonsocial, ruc, telefono, direccion)
VALUES ('C0020', 'MediVista Pharmaceuticals', '01234567800', '968586523', 'Calle de los Girasoles');

/*SECCION DE PROVEEDORES*/
INSERT INTO proveedor (idproveedor, razonsocial, ruc, telefono, direccion)
VALUES
('PR001', 'MediWorld Enterprises', '12345678901', '984745847', '123 Main Street'),
('PR002', 'HealthLink Supplies', '23456789012', '965478412', '456 Elm Street'),
('PR003', 'CureTech Distributors', '34567890123', '956256325', '789 Oak Street'),
('PR004', 'CarePro Innovations', '45678901234', '958478475', '567 Pine Street'),
('PR005', 'MedLife Products', '56789012345', '914512478', '890 Maple Street'),
('PR006', 'MedSelect Provisions', '67890123456', '965845874', '678 Birch Street'),
('PR007', 'HealthBridge Products', '78901234567', '968547586', '456 Cedar Street'),
('PR008', 'CureConnect Services', '89012345678', '968586325', '234 Spruce Street'),
('PR009', 'LifeGuard Medical', '90123456789', '901234567', '123 Redwood Street'),
('PR010', 'MediCore Solutions', '01234567890', '958758471', '345 Walnut Street')

/*SECCION DE PRODUCTOS*/
INSERT INTO productos (idproducto, idproveedor, nombre, prec_compra, prec_venta, cantidad)
VALUES
('PD001', 'PR001', 'Guantes de látex', 5.00, 10.00, 100),
('PD002', 'PR002', 'Mascarillas quirúrgicas', 7.50, 15.00, 150),
('PD003', 'PR003', 'Jeringas desechables', 4.50, 9.00, 220),
('PD004', 'PR004', 'Agujas hipodérmicas', 6.00, 12.00, 180),
('PD005', 'PR005', 'Gasas estériles', 8.00, 16.00, 250),
('PD006', 'PR006', 'Termómetro clínico', 10.00, 20.00, 120),
('PD007', 'PR007', 'Vendajes adhesivos', 4.00, 8.00, 270),
('PD008', 'PR008', 'Esparadrapo quirúrgico', 5.50, 11.00, 100),
('PD009', 'PR009', 'Botiquín de primeros auxilios', 12.00, 24.00, 50),
('PD010', 'PR010', 'Sábanas desechables', 3.75, 7.50, 130),
('PD011', 'PR011', 'Batas médicas', 6.50, 13.00, 90),
('PD012', 'PR012', 'Tiritas', 9.00, 18.00, 75),
('PD013', 'PR013', 'Algodón hidrófilo', 7.99, 15.99, 160),
('PD014', 'PR014', 'Apósitos estériles', 11.25, 22.50, 45),
('PD015', 'PR015', 'Solución salina', 5.75, 11.50, 95),
('PD016', 'PR016', 'Sondas urinarias', 6.75, 13.50, 85),
('PD017', 'PR017', 'Bisturí desechable', 8.25, 16.50, 105),
('PD018', 'PR018', 'Muletas', 10.00, 20.00, 65),
('PD019', 'PR019', 'Sillas de ruedas', 6.99, 13.99, 125),
('PD020', 'PR020', 'Nebulizadores', 9.50, 19.00, 75)

/*SECCIÖN DE USUARIOS*/
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (1, 'E0001', 'juanperez', 'udixis01');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (2, 'E0002 ', 'mariagomez', 'udixis02');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (3, 'E0003', 'pedrorodriguez', 'udixis03');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (4, 'E0004', 'luisasanchez', 'dixis04');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (5, 'E0005','carloslopez', 'udixis05');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (6, 'E0006', 'anamartinez', 'udixis06');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (7, 'E0007', 'manueltorres', 'udixis07');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (8, 'E0008', 'sofiadiaz', 'udixis08');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (9, 'E0009','javierramirez', 'udixis09');
INSERT INTO usuarios(idusuario, idempleado, usuario, pass)
VALUES (10, 'E0010', 'elenavargas', 'udixis10');


/*SECCION DE EMPLEADOS*/

CREATE PROCEDURE USPListarempleados()
	SELECT * FROM empleados
	
CALL USPListarempleados()

CREATE PROCEDURE USPAgregarempleado
(
IN codEmp VARCHAR(5),
IN nomEmp VARCHAR(20), 
IN apeEmp VARCHAR(20), 
IN dniEmp VARCHAR(8), 
IN tlfEmp VARCHAR(9),
IN sexoEmp CHAR(1)
)
INSERT INTO empleados VALUES(codEmp,nomEmp,apeEmp,dniEmp,tlfEmp,sexoEmp)

CALL USPAgregarempleado('E0011','Juan','Perez','45847859','987475145','H')

CREATE PROCEDURE USPRemoverempleado(IN codEmp VARCHAR(5))
	DELETE FROM empleados WHERE idempleado = codEmp
	
CALL USPRemoverempleado('E0011')

CREATE PROCEDURE USPModificarempleado
(
IN codEmp VARCHAR(5),
IN nomEmp VARCHAR(20), 
IN apeEmp VARCHAR(20), 
IN dniEmp VARCHAR(8), 
IN tlfEmp VARCHAR(9),
IN sexoEmp CHAR(1)
)
UPDATE empleados
SET nombre = nomEmp,
    apellidos = apeEmp,
    dni = dniEmp,
    telefono = tlfEmp,
    sexo = sexoEmp
WHERE idempleado = codEmp

CALL USPModificarempleado('E0011','Raul','Perez','45847859','987475145','H')

/*BUSQUEDA*/
CREATE PROCEDURE USPBuscarpornombre(IN nomEmp VARCHAR(20))
	SELECT * FROM empleados WHERE nombre LIKE CONCAT(nomEmp,'%')
	
CALL USPBuscarpornombre('j')

/*CORRELATIVO DE EMPLEADO*/
CREATE PROCEDURE USPObtenermaxemp()
	SELECT MAX(idempleado) FROM empleados

CALL USPObtenermaxemp()

CREATE PROCEDURE USPBuscarporcodigo()
	SELECT idempleado FROM empleados

CALL USPBuscarporcodigo()

/*SECCION DE CLIENTES*/
/*LISTAR CLIENTES*/
CREATE PROCEDURE USPListarclientes()
	SELECT * FROM clientes
	
CALL USPListarclientes()

CREATE PROCEDURE USPAgregarcliente
(
IN codCli VARCHAR(10),
IN razSocCli VARCHAR(30), 
IN rucCli VARCHAR(11), 
IN tlfCli VARCHAR(9), 
IN dirCli VARCHAR(50)
)
INSERT INTO clientes VALUES(codCli,razSocCli,rucCli,tlfCli,dirCli)

CALL USPAgregarcliente('C0021','Medical Solution','14574859414','985478458','Av. los Geraneos')

CREATE PROCEDURE USPRemovercliente(IN codCli VARCHAR(10))
	DELETE FROM clientes WHERE idcliente = codCli
	
CALL USPRemovercliente('C0021')

CREATE PROCEDURE USPModificarcliente
(
IN codCli VARCHAR(10),
IN razSocCli VARCHAR(30), 
IN rucCli VARCHAR(11), 
IN tlfCli VARCHAR(9), 
IN dirCli VARCHAR(50)
)
UPDATE clientes
SET razonsocial = razSocCli,
    ruc = rucCli,
    telefono = tlfCli,
    direccion = dirCli
WHERE idcliente = codCli

CALL USPModificarcliente('C0021','Medical Solution','14574859414','985478458','Jr. los Geraneos')

/*CORRELATIVO DE CLIENTE*/
CREATE PROCEDURE USPObtenermaxcli()
	SELECT MAX(idcliente) FROM clientes

CALL USPObtenermaxcli()

CREATE PROCEDURE USPObtenernombrecli(IN razSocCli VARCHAR(30))
	SELECT * FROM clientes WHERE razonsocial LIKE CONCAT(razSocCli,'%')

CALL USPObtenernombrecli('medic')

CREATE PROCEDURE USPObtenercodcli()
	SELECT idcliente FROM clientes 

CALL USPObtenercodcli()

CREATE PROCEDURE USPObtenerrazsoccli(IN codCli VARCHAR(5))
	SELECT razonsocial FROM clientes WHERE idcliente = codCli

CALL USPObtenerrazsoccli('C0001')

CREATE PROCEDURE USPObtenercodcliente(IN cod VARCHAR(5))
	SELECT * FROM clientes WHERE idcliente = cod
	
CALL USPObtenercodcliente('C0001')


/*SECCION DE PROVEEDORES*/
/*LISTAR PROVEEDORES*/
CREATE PROCEDURE USPListarproveedores()
	SELECT * FROM proveedor
	
CALL USPListarproveedores()

/*AGREGAR PROVEEDORES*/
CREATE PROCEDURE USPAgregarproveedor
(
IN codProv VARCHAR(5),
IN razSocProv VARCHAR(30), 
IN rucProv VARCHAR(11), 
IN tlfProv VARCHAR(9), 
IN dirProv VARCHAR(50)
)
INSERT INTO proveedor VALUES(codProv,razSocProv,rucProv,tlfProv,dirProv)

CALL USPAgregarproveedor('PR011','Medical Corp','15478456985','965235456','Av. los Calixes')

/*ELIMINAR PROVEEDORES*/
CREATE PROCEDURE USPRemoverproveedor(IN codProv VARCHAR(5))
	DELETE FROM proveedor WHERE idproveedor = codProv
	
CALL USPRemoverproveedor('PR011')

/*MODIFICAR PROVEEDOR*/
CREATE PROCEDURE USPModificarProveedor
(
IN codProv VARCHAR(5),
IN razSocProv VARCHAR(30), 
IN rucProv VARCHAR(11), 
IN tlfProv VARCHAR(9), 
IN dirProv VARCHAR(50)
)
UPDATE proveedor
SET razonsocial = razSocProv,
    ruc = rucProv,
    telefono = tlfProv,
    direccion = dirProv
WHERE idproveedor = codProv

CALL USPModificarProveedor('PR011','Medical Sol','15423658954','968582451','Jr. los Geraneos')

/*CORRELATIVO DE PROVEEDOR*/
CREATE PROCEDURE USPObtenermaxprov()
	SELECT MAX(idProveedor) FROM proveedor

CALL USPObtenermaxprov()

/*BUSQUEDA*/
CREATE PROCEDURE USPBuscarporrazonsocial(IN razSocProv VARCHAR(30))
	SELECT * FROM proveedor WHERE razonsocial LIKE CONCAT(razSocProv,'%')
	
CALL USPBuscarporrazonsocial('m')

/*OBTENER CODIGO PROVEEDOR*/
CREATE PROCEDURE USPObtenercodproveedor(IN codProv VARCHAR(5))
	SELECT * FROM proveedor WHERE idproveedor = codProv

CALL USPObtenercodproveedor('PR001')

/*SECCION DE PRODUCTOS*/
/*LISTAR PRODUCTOS*/
CREATE PROCEDURE USPListarproductos()
	SELECT * FROM productos

CALL USPListarproductos()

/*AGREGAR PRODUCTOS*/
CREATE PROCEDURE USPAgregarproductos
(
IN codProd VARCHAR(5),
IN codProv VARCHAR(5),
IN nomProd VARCHAR(30), 
IN preComProd DECIMAL(9,2), 
IN preVenProd DECIMAL(9,2), 
IN cantProd INT
)
INSERT INTO productos VALUES(codProd,codProv,nomProd,preComProd,preVenProd,cantProd)

CALL USPAgregarproductos('PD021','PR011','Mascarilla',15.00,16.00,150)

/*ELIMINAR PRODUCTOS*/
CREATE PROCEDURE USPRemoverproducto(IN codProd VARCHAR(5))
	DELETE FROM productos WHERE idproducto = codProd
	
CALL USPRemoverproducto('PD021')

/*MODIFICAR PRODUCTOS*/
CREATE PROCEDURE USPModificarProducto
(
IN codProd VARCHAR(5),
IN codProv VARCHAR(5),
IN nomProd VARCHAR(30), 
IN preComProd DECIMAL(9,2), 
IN preVenProd DECIMAL(9,2), 
IN cantProd INT
)
UPDATE productos
SET idproveedor = codProv,
    nombre = nomProd,
    prec_compra = preComProd,
    prec_venta = preVenProd,
    cantidad = cantProd
WHERE idproducto = codProd

CALL USPModificarProducto('PD021','PR011','Mascarilla',10.00,12.00,100)

/*CORRELATIVO DE PRODUCTO*/
CREATE PROCEDURE USPObtenermaxprod()
	SELECT MAX(idproducto) FROM productos

CALL USPObtenermaxprod()

/*BUSQUEDA*/
CREATE PROCEDURE USPBuscarpordescripcion(IN nomProd VARCHAR(30))
	SELECT * FROM productos WHERE nombre LIKE CONCAT(nomProd,'%')
	
CALL USPBuscarpordescripcion('m')

CREATE PROCEDURE USPBuscarporcod(IN codProd VARCHAR(5))
	SELECT * FROM productos WHERE idproducto = codProd
	
CALL USPBuscarporcod('PD001')

/*SECCIÖN DE USUARIOS*/
/*LISTAR USUARIOS*/
CREATE PROCEDURE USPListarusuarios()
	SELECT * FROM usuarios
	
CALL USPListarusuarios()

/*AGREGAR USUARIOS*/
CREATE PROCEDURE USPAgregarusuarios
(
IN codUsu INT,
IN codEmp VARCHAR(5),
IN nomUsu VARCHAR(20), 
IN passUsu VARCHAR(20)
)
INSERT INTO usuarios VALUES(codUsu,codEmp,nomUsu,passUsu)

CALL USPAgregarusuarios(12,'E0011','raulperez','udixis11')

/*ELIMINAR USUARIOS*/
CREATE PROCEDURE USPRemoverusuario(IN codUsu INT)
	DELETE FROM usuarios WHERE idusuario = codUsu
	
CALL USPRemoverusuario(14)

/*MODIFICAR USUARIOS*/
CREATE PROCEDURE USPModificarusuario
(
IN codUsu INT,
IN codEmp VARCHAR(5),
IN nomUsu VARCHAR(20), 
IN passUsu VARCHAR(20)
)
UPDATE usuarios
SET idempleado = codEmp,
    usuario = nomUsu,
    pass = passUsu
WHERE idusuario = codUsu

CALL USPModificarusuario(11,'E0011','raulperez@gmail.com','udixis11')

/*CORRELATIVO DE USUARIOS*/
CREATE PROCEDURE USPObtenermaxusu()
	SELECT MAX(idusuario) FROM usuarios

CALL USPObtenermaxusu()

/*BUSQUEDA*/
CREATE PROCEDURE USPBuscarporcorreo(IN nomUsu VARCHAR(20))
	SELECT * FROM usuarios WHERE usuario LIKE CONCAT(nomUsu,'%')
	
CALL USPBuscarporcorreo('r')

/*VALIDACION LOGIN*/
CREATE PROCEDURE USPBuscarusuario(IN nomUsu VARCHAR(20), IN passUsu VARCHAR(20))
	SELECT * FROM usuarios WHERE usuario = nomUsu AND pass = passUsu

CALL USPBuscarusuario(' ',' ')

/*SECCIÖN DE VENTAS*/
/*LISTAR*/
CREATE PROCEDURE USPListarventa()
	SELECT * FROM ventas

CALL USPListarventa()

CREATE PROCEDURE USPGuardarventa
(
IN idVenta INT(11),
IN fechaVenta VARCHAR(15),
IN subtotalVen DECIMAL(8,2),  
IN totalVen DECIMAL(8,2), 
IN idEmpVen  VARCHAR(5), 
IN idCliVen VARCHAR(5),
IN serieVen VARCHAR(20),
IN igvVen DECIMAL(8,2)
)
INSERT INTO ventas VALUES(idVenta,fechaVenta,subtotalVen,totalVen,idEmpVen,idCliVen,serieVen,igvVen)

CREATE PROCEDURE USPRemoverventa(IN codVen INT)
	DELETE FROM ventas WHERE idventa = codVen

CALL USPRemoverventa(5)

CREATE PROCEDURE USPObtenermaxven()
	SELECT MAX(idventa) FROM ventas

CALL USPObtenermaxven()

CREATE PROCEDURE USPObtenermaxcompra()
	SELECT MAX(idcompra) FROM compras

CALL USPObtenermaxcompra()

CREATE PROCEDURE USPObtenermaxserie()
	SELECT MAX(serie) FROM ventas
	
CALL USPObtenermaxserie()

CREATE PROCEDURE USPListardetalleventa()
	SELECT * FROM detalle_ventas

CALL USPListardetalleventa()

CREATE PROCEDURE USPGuardardetalleventa
(
IN codVen INT,
IN codProd VARCHAR(5),
IN cant INT,
IN pre DECIMAL(8,2),
IN tot DECIMAL(8,2)
)
INSERT INTO detalle_ventas VALUES(codVen,codProd,cant,pre,tot)

CREATE PROCEDURE USPRemoverdetalleventa(IN codVen INT)
	DELETE FROM detalle_ventas WHERE idventa = codVen

CALL USPRemoverdetalleventa(5)
	
CALL USPListarventa()
CALL USPListardetalleventa()
CALL USPListarproductos()

/*SECCIÖN DE COMPRAS*/
CREATE PROCEDURE USPListarcompra()
	SELECT * FROM compras

CALL USPListarcompra()

CREATE PROCEDURE USPGuardarcompra
(
IN codCom INT,
IN fecCom VARCHAR(15),
IN subCom DECIMAL(8,2),
IN igvCom DECIMAL(8,2),
IN totalCom DECIMAL(8,2),
IN estCom VARCHAR(20),
IN codEmp VARCHAR(5),
IN codProv VARCHAR(5)
)
INSERT INTO compras VALUES(codCom,fecCom,subCom,igvCom,totalCom,estCom,codEmp,codProv) 

CALL USPGuardarcompra(1,'2023-11-02',50,9,59,'RECIBIDO','E0001','PR001')

CREATE PROCEDURE USPRemovercompra(IN codCom INT)
	DELETE FROM compras WHERE idcompra = codCom
	
CALL USPRemovercompra(3)

CREATE PROCEDURE USPListardetallecompra()
	SELECT * FROM detalle_compras

CALL USPListardetallecompra()

CREATE PROCEDURE USPGuardardetallecompra
(
IN codCom INT,
IN codProd VARCHAR(5),
IN cant INT,
IN pre DECIMAL(8,2),
IN tot DECIMAL(8,2)
)
INSERT INTO detalle_compras VALUES(codCom,codProd,cant,pre,tot) 

CREATE PROCEDURE USPRemoverdetallecompra(IN codCom INT)
	DELETE FROM detalle_compras WHERE idcompra = codCom

CALL USPRemovercompra(3)
CALL USPRemoverdetallecompra(3)

CREATE PROCEDURE USPActualizarproducto(IN codProd VARCHAR(5),IN cant INT)
	UPDATE productos SET cantidad = cant WHERE idproducto =  codProd

CALL USPActualizarproducto('PD001',100)

SELECT * FROM producto

SELECT SUM(prec_compra) FROM productos