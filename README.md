# Queue-Simulation-in-Java
In this project I try to replicate the everyday scenario of Queue Simulation in java. In this project I have considered 2 Queues for simulation. The start of program is done by creating a customer at random with given random number of items that are to be served. Also, along with that the rate at which two queues simulate also get assigned randomly i.e. items/sec. The simulation replicates that one simulation of while loop is equivalent to 1 second. The Counter1 gets started as the entry of customer and when a second customer enters as load on Counter1 is higher the Counter2 starts to work. After 10 iterations equals to 10 seconds, a list appears with 5 options:<br/>
1)Close Counter1<br/>
2)CLose Counter2<br/>
3)Re-open Counter1<br/>
4)Re-open Counter2<br/>
5)Continue Simulation<br/>
If a counter is selected to be closed it closes when every customer standing in the queue is served. The customer at the last of any queue gets to change the queue if the other queue has less load to serve. Once a counter closed the customers cannot transfer. After every 10 iterations as we get above options we can re-open the counters we have closed. Every new customer generated randomly will be added to the counter that has less items to be served in total and not with number of customers.
