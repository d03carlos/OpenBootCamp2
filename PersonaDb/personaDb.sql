create database prueba;
use prueba;
create table persona
(
id_persona int primary key auto_increment,
nombre varchar(150),
edad int
);

delimiter //
create procedure ingresarPersona(_nombre varchar(150), _edad int)
begin
insert into persona(nombre, edad)values(_nombre, _edad);
end //
delimiter ;

delimiter $$
create procedure listarPersona()
begin
select *from persona;
end $$;
delimiter ; 

delimiter //
create procedure eliminarPersona(id int)
begin
delete from persona where id_persona=id;
end //
delimiter ;
call ingresarPersona('jana', 20);
select *from persona;
call listarPersona();
