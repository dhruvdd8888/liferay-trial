create index IX_CC283A89 on Employee_AuditLogs (action[$COLUMN_LENGTH:75$]);
create index IX_E4624EAA on Employee_AuditLogs (moduleName[$COLUMN_LENGTH:75$]);
create index IX_7DEA2593 on Employee_AuditLogs (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_98D4F4D5 on Employee_AuditLogs (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D74E9269 on employee_auditlogs (action[$COLUMN_LENGTH:75$]);
create index IX_C2D9B68A on employee_auditlogs (moduleName[$COLUMN_LENGTH:75$]);
create index IX_526C2573 on employee_auditlogs (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1B956CB5 on employee_auditlogs (uuid_[$COLUMN_LENGTH:75$], groupId);