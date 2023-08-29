CREATE PROC pGetAllUserRecord

AS
Begin
	SET NOCOUNT ON
	SELECT userId,name,emailId, mobile, address, dateAdded, lastUpdate FROM GroupUsers
END;
