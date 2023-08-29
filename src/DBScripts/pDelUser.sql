CREATE PROC pDelUser
@userId VARCHAR(200)
AS
Begin
	SET NOCOUNT ON
	DELETE FROM dbo.GroupUsers WHERE userId = @userId 
END;
