CREATE PROC pAddUser
@userId VARCHAR(200),
@name VARCHAR(200),
@emailId VARCHAR(200),
@mobile CHAR(10),
@address VARCHAR(200)
AS
BEGIN
	IF NOT EXISTS ( SELECT 1 FROM GroupUsers where userId=@userId OR emailId= @emailId AND name = @name)
	BEGIN
		INSERT INTO GroupUsers VALUES(@userId,@name, @emailId,@mobile, @address,GETDATE(),GETDATE());
	END
END

