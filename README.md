# bonify-bank-management-service

### Challenge

Given the following content of a csv file:
name;bank_identifier
Postbank;10010010
Eurocity;10030700
Commerzbank;10040000
Raiffeisenbank;22163114
1. Write a program which imports the entries of the csv file into a database of your
choice (preferably PostgreSQL)
2. Fetch the record with the bank identifier 10040000 from DB and print the name
of the related bank to system out.

The main use cases of this service are as below.

Load Bank details from CSV file to DB
Get Bank name based on bank identifier


### Implementation 
This is service using https://projects.spring.io/spring-boot, using Maven for compiling and building the application.This service uses H2 in memory database for loading bank details and getting bank name by bank Id. Used Spring Data JPA repository for backend operations with H2. For change in any application status this application monitors that using HRRecruitingAppStatusEventListner and log (*) in output.
### List of API's

1. ``POST /bank/records`` - load bank details from CSV file(bonify-bank-management-service\src\main\resources\data\bank_details_upload_file.csv) to DB 

2. ``GET /bank/{id}`` - get/print bank name based on bank id.

# Specifications


*********************************************************************************************


### 1. Load bank details

Every Time when you want to load bank details from CSV file to DB, this endpoint will be called.


#### Request sample
POST /bank/records HTTP/1.1
Content-Type: application/json

#### Success response sample

```
201 Created
```
===============================================================================================================================================
### 2. Get Bank Name By Id

Get loaded bank name by its bank id

#### Request sample
GET /bank/{id} HTTP/1.1
Content-Type: application/json

#### Success response sample
```
 {
    "name": "Raiffeisenbank"
}
```
	    
### Build
You can build using:

  $ mvn clean install

### Run
You can run using:

  $ mvn spring-boot:run

