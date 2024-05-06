Here is the SQL script for the mySQL data base

```
use bookings;
create table Bookings(
	id int not null auto_increment primary key,
    customer nvarchar(50),
    date nvarchar(30),
    time nvarchar(30),
    timeSlot nvarchar(30)
);
```
