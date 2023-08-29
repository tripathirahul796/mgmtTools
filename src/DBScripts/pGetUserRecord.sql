CREATE PROC pGetUserRecord
@userId VARCHAR(200),
@name VARCHAR(200),
@emailId VARCHAR(200),
@mobile CHAR(10)
AS
Begin
	SET NOCOUNT ON
	SELECT userId,name,emailId, mobile, address, dateAdded, lastUpdate FROM GroupUsers
		WHERE userId = @userId OR mobile = @mobile OR emailId LIKE '%' + @emailId + '%'  OR name LIKE '%' + @name + '%';

END;
