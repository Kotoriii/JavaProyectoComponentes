insert into cadena_hotelera (idCadena_Hotelera, nombre)
values ('1', "DogeBarcelo");
insert into hotel (idHotel, Nombre, Ubicacion, Cadena_Hotelera_idCadena_Hotelera)
values ('1', "Doge", "Such Place", '1');

insert into usuarios (id, idHotel, nombre, contrasenna, rol, salario, precioPorHora,
keywords, correo, horaEntrada, horaSalida, estado)
values ('123', '1', "Miguel", "m123", "FrontDesk", '123321', '123', "front,desk,recep",
 "m@dogebarcelo.cr", '09:00:00', '17:00:00', "Activo"),
('234', '1', "Maria", "m234", "Recepcion", '45612', '45', "front,desk,recep",
 "maria@dogebarcelo.cr", '09:00:00', '17:00:00', "Inactivo"), 
('345', '1', "Josue", "j345", "Administrador", '807500', '6000', "jefe,admin,imp",
 "josue@dogebarcelo.cr", '11:00:00', '19:00:00', "Activo"), 
('456', '1', "Sofia", "s456", "Finanzas", '625000', '4000', "pagos,finanzas,cuentas",
 "sofia@dogebarcelo.cr", '08:00:00', '16:30:00', "Activo"),
('789', '1', "Paulo", "p789", "Cobro", '625000', '4000', "pagos,finanzas,cuentas,cobros",
 "pablo@dogebarcelo.cr", '08:00:00', '16:30:00', "Activo"),
('890', '1', "Melissa", "m890", "Gerente RH", '825000', '6200', "gerente,rh,aprob",
 "melissa@dogebarcelo.cr", '10:00:00', '18:00:00', "Activo"),
('901', '1', "Kenneth", "k901", "Miscelaneo", '350000', '1500', "misc,limpiesa",
 "kenneth@dogebarcelo.cr", '12:00:00', '20:00:00', "Inactivo"),
('012', '1', "Antony", "a012", "Finanzas", '625000', '4000', "pagos,finanzas,cuentas",
 "sofia@dogebarcelo.cr", '08:00:00', '16:30:00', "Inactivo"),
('147', '1', "Jennifer", "j147", "Miscelaneo", '350000', '1500', "misc,limpiesa",
 "jennifer@dogebarcelo.cr", '06:00:00', '14:00:00', "Activo"),
('258', '1', "Manuel", "a012", "Administrador", '807500', '6000', "jefe,admin,imp",
 "manuel@dogebarcelo.cr", '08:00:00', '16:30:00', "Activo");

insert into permisos (idUsuario, desdeFecha, hastaFecha, tipo, estado)
values ('123', "2014-08-21", "2014-08-23", "otros", '0'),
('012', "2014-08-21", "2014-08-25", "vacaciones", '0'),
('123', "2014-09-02", "2014-09-04", "vacaciones", '0'),
('123', "2014-08-28", "2014-08-28", "ausencia", '0'),
('901', "2014-09-05", "2014-09-05", "incapacidad", '0'),
('456', "2014-08-21", "2014-08-22", "incapacidad", '0'),
('789', "2014-09-02", "2014-09-02", "otros", '0'),
('901', "2014-09-06", "2014-09-10", "ausencia", '0'),
('147', "2014-08-21", "2014-08-24", "incapacidad", '0'),
('147', "2014-09-02", "2014-09-02", "vacaciones", '0');