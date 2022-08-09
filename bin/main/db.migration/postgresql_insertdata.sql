--liquibase formatted sql
--changeset sivalingam:6
create table account(

  id int(20)  ,
  balance varchar(15) ,	
  accountName varchar(40) ,
  dateOpened varchar(15) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

--liquibase formatted sql
--changeset sivalingam:7
insert into  account(id,balance,accountName,dateOpened) values(1,'100000.11', 'sivalingam','16/22/2222')
insert into  account(id,balance,accountName,dateOpened) values(2,'33443.011','sri','13/3/2222')