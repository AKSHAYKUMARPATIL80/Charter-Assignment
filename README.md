# Charter-Assignment
Assignment used for calculating the Rewards

Reaward Calculation project

I am creating the springboot application, in that implementing the controller, service, DAO layer and using MySQL database.
Controller Layer:- adding getmapping method, user directly call this rest api, in this method response is returned in Map format, in this Map storing the each month customers total rewards points seperately.
Service Layer:- In this layer, writting the logic to give rewards point according to our criteria. In this layer, some extra checks are added to get the data correctly like adding some if else conditions for check null data, negative data, adding some collections classes and Map to storing and filtering the data.
DAO Layer:- In this layer, writing one select query to fetch last 3 months records.
