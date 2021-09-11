create procedure add_product (IN pname varchar(100),IN pprice decimal (10,2))
insert into eproduct (name,price) values (pname,pprice)
