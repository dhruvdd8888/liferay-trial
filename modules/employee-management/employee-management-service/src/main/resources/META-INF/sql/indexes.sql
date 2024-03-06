create index IX_E5EEBC78 on EMPLOYEE_Branch (name[$COLUMN_LENGTH:75$]);
create index IX_C73CA12D on EMPLOYEE_Branch (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_63E58EEF on EMPLOYEE_Branch (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_68EF3ECC on EMPLOYEE_City (cityName[$COLUMN_LENGTH:75$]);
create index IX_986472BA on EMPLOYEE_City (stateId);
create index IX_736336B6 on EMPLOYEE_City (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FA95F2B8 on EMPLOYEE_City (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_8B4DD9A8 on EMPLOYEE_Department (name[$COLUMN_LENGTH:75$]);
create index IX_E669765D on EMPLOYEE_Department (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_F1A5F01F on EMPLOYEE_Department (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D91DE8CB on EMPLOYEE_Designation (name[$COLUMN_LENGTH:75$]);
create index IX_4584E900 on EMPLOYEE_Designation (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FD33AF82 on EMPLOYEE_Designation (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6C412D16 on EMPLOYEE_Employee (branchId);
create index IX_F7103746 on EMPLOYEE_Employee (departmentId);
create index IX_11169FE6 on EMPLOYEE_Employee (firstName[$COLUMN_LENGTH:75$]);
create index IX_36A293F9 on EMPLOYEE_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C981C4BB on EMPLOYEE_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_3136FF9B on EMPLOYEE_State (countryId);
create index IX_C6B20046 on EMPLOYEE_State (stateName[$COLUMN_LENGTH:75$]);
create index IX_DC0A23DA on EMPLOYEE_State (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_59DD8DC on EMPLOYEE_State (uuid_[$COLUMN_LENGTH:75$], groupId);