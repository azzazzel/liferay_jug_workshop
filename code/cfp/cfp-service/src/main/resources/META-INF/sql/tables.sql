create table CFP_Event (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	eventId LONG not null primary key,
	name VARCHAR(75) null,
	date_ DATE null,
	website VARCHAR(1000) null,
	venueId LONG,
	calendarBookingId LONG
);

create table CFP_Speaker (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	speakerId LONG not null primary key,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	bio VARCHAR(75) null
);

create table CFP_Talk (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	talkId LONG not null primary key,
	title VARCHAR(200) null,
	data_ TEXT null,
	structureId LONG,
	templateId LONG
);

create table CFP_Talk_Event (
	companyId LONG not null,
	eventId LONG not null,
	talkId LONG not null,
	primary key (eventId, talkId)
);

create table CFP_Talk_Speaker (
	companyId LONG not null,
	speakerId LONG not null,
	talkId LONG not null,
	primary key (speakerId, talkId)
);

create table CFP_Venue (
	uuid_ VARCHAR(75) null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	venueId LONG not null primary key,
	name VARCHAR(75) null,
	address VARCHAR(1000) null,
	latitude DOUBLE,
	longitude DOUBLE
);