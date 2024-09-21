show tables;

create table hoewon(
	idx 			int					 	not null auto_increment primary key,
	name 			varchar(30)   not null,
	age 			int						default 20,
	gender  	char(2)				default '여자';
	joinday 	datetime 			default now();
	address 	varchar(20)
);

desc hoewon;

select * from hoewon;
