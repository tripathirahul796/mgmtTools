CREATE TABLE dbo.Audit
(relatedId VARCHAR(50),
eventName VARCHAR(50),
descriptions VARCHAR(500),
actionUser VARCHAR(100),
auditDate DATETIME
)

--drop Table Audit