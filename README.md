# Spring Cloud Hystrix and Dashboard

A simple Example to demonstrate spring cloud hystrix and dashboard

what advantage does hystrix provide to your application

failure on a service sometime can bring down the whole cluster.
because, if there is a failure in the service, and let us say that there are thousands of requests flowing into that service which is failing or holding up the queue. 
what happens in it will start eating up the threads in the servlet container.
in other words it will start to consume all the user threads in the tomcat server

in this case it prevents one service bringing down the whole cluster

it also provides you a fallback in case of some failure

it also isolates the service from the cluster, by stopping all requests to this instance

it gives u realtime metrics about the service and it continuously monitors the instances

now let us look What is meant by Circuit Breaker
for this u need to understand the electrical world circuit breaker. because the meaning is same

Its the same meaning as an electrical switch tripping
A circuit breaker shuts off the electrical flow or trips your switch to protect the circuit from overheating and causing damage

let us try to put this meaning into a software
it prevents one service bringing down the whole cluster, but opening up the circuit and isolating the service from other services
