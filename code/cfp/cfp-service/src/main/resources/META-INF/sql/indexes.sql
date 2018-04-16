create index IX_729D8850 on CFP_Event (companyId, groupId);
create index IX_E586C842 on CFP_Event (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_CF487744 on CFP_Event (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E513C537 on CFP_Speaker (companyId, groupId, email[$COLUMN_LENGTH:75$]);
create index IX_B9B12DA7 on CFP_Speaker (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A126F1E9 on CFP_Speaker (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_2D28B546 on CFP_Talk (companyId, groupId);
create index IX_37C4BAB8 on CFP_Talk (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_4A2C8F3A on CFP_Talk (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1C6A80C9 on CFP_Talk_Event (companyId);
create index IX_75429C26 on CFP_Talk_Event (eventId);
create index IX_57F79A on CFP_Talk_Event (talkId);

create index IX_BA1C2344 on CFP_Talk_Speaker (companyId);
create index IX_459BB5C6 on CFP_Talk_Speaker (speakerId);
create index IX_EB16DEFF on CFP_Talk_Speaker (talkId);

create index IX_5266C265 on CFP_Venue (companyId, groupId);
create index IX_7D118397 on CFP_Venue (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_878403D9 on CFP_Venue (uuid_[$COLUMN_LENGTH:75$], groupId);