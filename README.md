## Order Project
order is java project, built on top of Sprint Boot, WebFlux and backend DB is local Mongo DB.
It provides a couple of webservices:
1. createOneOrder
2. CreateOrders
3. getOrderById
4. getOrderByOrderNo
5. getAllOrders
Users can use embedded SwaggerUI to get details about the API end points and json input format.
### Project assumption
   1. all the orders should be placed by valid customer, order webservices will not create customer related information during order capturing.
   2. Order no is the unique identifier, there should not be more than one orders share the same order no.
   3. Once the order is create, order modification is not allowed.
   4. Order can have more than one order line and each line will have its own shipping address.
### Design
  Backend DB: native Mongo (nosql)
     all the order data(json document) is stored in Orders collection. The benefit of using Mongo db is that the order json document can be directly saved into the colletion and it can be easy retrieved for all the attributes, not need to make any joining condition when any downstream system is trying to get all order related information.
  WebService Layer: Sprint Boot, WebFlux
    with Sprint Boot and WebFlux non-blocking approach, the application can easily handle condurrency with a small set of threads and it can scale effectively. SprintBoot platform takes care of a lot of depenency, such as logging, exception handling there is no need for developer to write big amount of the code.
  UI layer: did not spend time on UI, added SwaggerUI dependency in pom.xml, it automatically generates UI endpoints, it also come with docs for each individual end points. 
### Installation
   download Spring Tool Suite
   install Maven client
###  Testing
   Fuctional testing is Mokito based and for automation is Junit based..

### Regarding about the project
   It is a very fun topic to work on. It can be used as an intermediate layer between the site order taken and backend order processing (such as OMS). The webservice can actually read json from Kafka topic and then does all the data validation before pushing it to the backend order processing layer.
   
   
