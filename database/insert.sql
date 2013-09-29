use plm;

insert into `Role`(id,name) values (1,"Stakeholder");
insert into `Role`(id,name) values (2,"Project Leader");

insert into `User`(id,name,password) values (1,"auser","apassword");
insert into `User`(id,name,password) values (2,"anotheruser","apassword");

insert into `Project`(id,name) values(1,"My First Project");

insert into `UserProject`(id,userId,roleId,projectId) values(1,1,2,1);
insert into `UserProject`(id,userId,roleId,projectId) values(2,2,1,1);
