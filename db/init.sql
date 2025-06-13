DROP DATABASE IF EXISTS Mygomoku;
CREATE DATABASE Mygomoku;

USE Mygomoku;

CREATE TABLE Users
(
    User_Id   int AUTO_INCREMENT PRIMARY KEY,
    User_Name char(32) NOT NULL,
    Password  blob     NOT NULL,
    Score     int DEFAULT 500
);

CREATE TABLE Score_Log
(
    Log_Id int AUTO_INCREMENT PRIMARY KEY,
    Value  int NOT NULL,
    Type   char(4)
);

CREATE TABLE Sessions
(
    Session_Id int AUTO_INCREMENT PRIMARY KEY,
    Status     char(4),
    Save_Obj   blob
)

