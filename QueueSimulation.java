import java.util.*;
public class QueueSimulation {

	static int detailsOfQueue(Queue q,int rate) {
		int n=0;
		for(int i=q.front;i<=q.rear;i++) {
			n+=q.array[i];
		}
		return n/rate;
	}
	
	static int detailsOfQueue1(Queue q,int rate) {
		int n=0;
		for(int i=q.front;i<q.rear;i++) {
			n+=q.array[i];
		}
		return n/rate;
	}
	
	static void servicingQueue(Queue item1,Queue item2,Queue id1,Queue id2,int rate1,int rate2,byte c1,byte c2,byte t2) {
		//Counter 1 Serving......
		if(item1.size!=0 && c1==1) {
			System.out.println("\nCounter 1 Is Working.........");
			if(item1.front()<=rate1) {
				item1.dequeue();
				System.out.println("\nCustomer With ID: "+id1.dequeue()+" Leaves The Queue 1");
				System.out.println("\nCounter 1 Will Now Serve Customer ID:"+id1.front());
			}
			else {
				item1.array[item1.front]-=rate1;
				System.out.println("\nCounter 1 Still Servicing Customer with ID:"+id1.front());
				System.out.println("Items left:"+item1.front());
			}
		}
		else if(item1.size!=0 && c1==0 && id1.front()!=0){
			System.out.println("\nCounter 1 Will Get Closed When It Gets Empty");
			if(item1.front()<=rate1) {
				item1.dequeue();
				System.out.println("\nCustomer With ID: "+id1.dequeue()+" Leaves The Queue 1");
				System.out.println("\nCounter 1 Will Now Serve Customer ID:"+id1.front());
			}
			else {
				item1.array[item1.front]-=rate1;
				System.out.println("\nCounter 1 Still Servicing Customer with ID:"+id1.front());
				System.out.println("Items left:"+item1.front());
			}
		}
		else if(item1.size==0 && c1==0 || id1.front()==0) {
			System.out.println("\nCounter 1 Is Closed............");
		}
		else {
			System.out.println("\nCounter 1 Is Empty...........");
		}
		
		//Counter 2 Serving......
		if(item2.size!=0 && c2==1) {
			System.out.println("\nCounter 2 Is Working........");
			if(item2.front()<=rate2) {
				item2.dequeue();
				System.out.println("\nCustomer With ID: "+id2.dequeue()+" Leaves The Queue 2");
				System.out.println("\nCounter 2 Will Now Serve Customer ID:"+id2.front());
			}
			else {
				item2.array[item2.front]-=rate2;
				System.out.println("\nCounter 2 Still Servicing Customer with ID:"+id2.front());
				System.out.println("\nItems left:"+item2.front());
			}
		}
		else if(item2.size!=0 && c2==0 && id2.front()!=0){
			System.out.println("\nCounter 2 Will Get Closed When It Gets Empty");
			if(item2.front()<=rate2) {
				item2.dequeue();
				System.out.println("\nCustomer With ID: "+id2.dequeue()+" Leaves The Queue 2");
				System.out.println("\nCounter 2 Will Now Serve Customer ID:"+id2.front());
			}
			else {
				item2.array[item2.front]-=rate2;
				System.out.println("\nCounter 2 Still Servicing Customer with ID:"+id2.front());
				System.out.println("\nItems left:"+item2.front());
			}
		}
		else if(item2.size==0 && c2==0 || id2.front()==0) {
			System.out.println("\nCounter 2 Is Closed............");
		}
		else {
			System.out.println("\nCounter 2 Is Empty...........");
		}
		
		//Last Customer Changes the queue according to speed
		if(t2%3==0) {
			if(item2.size>=2 && item1.size>=2) {
				if(detailsOfQueue1(item1,rate1)>detailsOfQueue(item2,rate2)) {
					if(c2==1) {
						System.out.println("\nSecond Queue is Faster Than First Queue");
						System.out.println("\nCustomer Id:"+id1.rear()+" From First Queue Moves To Second Queue ");
						item2.enqueue(item1.rear());
						id2.enqueue(id1.rear());
						item1.rear--;
						id1.rear--;
					}
					else {
						System.out.println("\nSecond Queue is Faster Than First Queue");
						System.out.println("\nBut Queue 2 Is Closed So No Transfers From Queue 1 To Queue 2");
					}
				}
				else if(detailsOfQueue(item1,rate1)<detailsOfQueue1(item2,rate2)){
					if(c1==1) {
						System.out.println("\nFirst Queue is Faster Than Second Queue");
						System.out.println("\nCustomer Id:"+id2.rear()+" From Second Queue Moves To First Queue ");
						item1.enqueue(item2.rear());
						id1.enqueue(id2.rear());
						item2.rear--;
						id2.rear--;
					}
					else {
						System.out.println("\nFirst Queue is Faster Than Second Queue");
						System.out.println("\nBut Queue 1 Is Closed So No Transfers From Queue 2 To Queue 1");
					}
				}
			}
		}
	
	}
	
	static void newCustomer(Queue item1,Queue item2,Queue id1,Queue id2,int rate1,int rate2,int id,int items,byte choice,byte c1,byte c2) {
		//New Customer.......
		if(choice<5) {
			System.out.println("\nCustomer Enters Queue According To Speed Of Queue:");
			if(detailsOfQueue(item1,rate1)==detailsOfQueue(item2,rate2)) {
				if(c1==1) {
					System.out.println("\nBoth Queues Work At Same Speed");
					System.out.println("\nThe Customer Enters Queue 1:");
					id1.enqueue(id);
					item1.enqueue(items);
				}
				else{
					System.out.println("\nBoth Queues Work At Same Speed But Queue 1 Is Closed So Enter In Queue 2");
					System.out.println("\nThe Customer Enters Queue 1:");
					id2.enqueue(id);
					item2.enqueue(items);
				}
			}
			
			else if(detailsOfQueue(item1,rate1)>detailsOfQueue(item2,rate2)) {
				if(c2==1) {
					System.out.println("\nQueue 2 Is Faster");
					System.out.println("\nThe Customer Enters Queue 2:");
					id2.enqueue(id);
					item2.enqueue(items);
					System.out.println("Last ID OF 2:"+id2.rear());
					System.out.println("Last Items of 2:"+item2.rear());
				}
				else{
					System.out.println("\nQueue 2 Is Closed So No Customer Enters Queue 2 ");
					System.out.println("\nThe Customer Enters Queue 1:");
					id1.enqueue(id);
					item1.enqueue(items);
				}
			}
			
			else {
				if(c1==1) {
					System.out.println("\nQueue 1 Is Faster");
					System.out.println("\nThe Customer Enters Queue 1:");
					id1.enqueue(id);
					item1.enqueue(items);
				}
				else {
					System.out.println("\nQueue 1 Is Closed So No Customer Enters Queue 1 ");
					System.out.println("\nThe Customer Enters Queue 2:");
					id2.enqueue(id);
					item2.enqueue(items);
				}
			}
		}
		
		else {
			System.out.println("\nCustomer Enters Queue According To Lenghts Of Queue:");
			if(id1.size==id2.size) {
				if(c1==1) {
					System.out.println("\nBoth Queues Have Same Length");
					System.out.println("\nThe Customer Enters Queue 1:");
					id1.enqueue(id);
					item1.enqueue(items);
				}
				else  {
					System.out.println("\nBoth Queues Have Same Length\nBut Queue 1 Is Closed");
					System.out.println("\nThe Customer Enters Queue 2:");
					id2.enqueue(id);
					item2.enqueue(items);
				}
			}
			else if(id1.size>id2.size) {
				if(c2==1) {
					System.out.println("\nQueue 2 Is Smaller");
					System.out.println("\nThe Customer Enters Queue 2:");
					id2.enqueue(id);
					item2.enqueue(items);
				}
				else {
					System.out.println("\nQueue 2 Is Closed So Enter In Queue 1");
					System.out.println("\nThe Customer Enters Queue 1:");
					id1.enqueue(id);
					item1.enqueue(items);
				}
			}
			else {
				if(c1==1) {
					System.out.println("\nQueue 1 Is Smaller");
					System.out.println("\nThe Customer Enters Queue 1:");
					id1.enqueue(id);
					item1.enqueue(items);
				}
				else {
					System.out.println("\nQueue 1 Is Closed So Enter Queue 2");
					System.out.println("\nThe Customer Enters Queue 2:");
					id2.enqueue(id);
					item2.enqueue(items);		
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Random rand=new Random();
		int rate1,rate2,items,id=1;
		byte c=0,t=1,choice,t1=1,c1=1,c2=1,t2=1;
		String name;
		
		rate1=rand.nextInt(10-8)+8;
		rate2=rand.nextInt(10-8)+8;
		
		Queue id1=new Queue(100);
		Queue id2=new Queue(100);
		
		Queue item1=new Queue(100);
		Queue item2=new Queue(100);
		
		System.out.println("\nRate To Serve Item/Sec Of Counter 1:"+rate1);
		System.out.println("\nRate To Serve Item/Sec Of Counter 2:"+rate2);
		
		//customerAdd ca=new customerAdd();
		while(t<100) {
			System.out.println("-------------------------------------------------------------------------");
			choice=(byte) ((byte) rand.nextInt(100-1)+1);
			
			if(choice<50 || c==0) {
				if(c1==1 || c2==1) {
					//New Customer.......
					System.out.println("\nNew Customer Added");
					System.out.println("\nThe ID Of Customer:"+id);
					items=rand.nextInt(200-100)+100;
					System.out.println("\nNo. Of items of customer:"+items);
					choice=(byte) ((byte) rand.nextInt(10-1)+1);
					c++;
					newCustomer(item1,item2,id1,id2,rate1,rate2,id,items,choice,c1,c2);
					id++;
				}
				
				else{
					System.out.println("\nBoth Queues Are Closed So No New Customer To Be Served\nServiving Of Counters Continue");
				}
				
				//Servicing Queues.........
				servicingQueue(item1,item2,id1,id2,rate1,rate2,c1,c2,t2);
				t2++;
			}
			
			else if(item1.size!=0 || item2.size!=0){
				//Servicing Queues............
				System.out.println("\nSimulation Continues.......");
				servicingQueue(item1,item2,id1,id2,rate1,rate2,c1,c2,t2);	
				t2++;
			}	
			
			else {
				System.out.println("\nBoth Counters Are Closed And Also Empty So Simulation Stops");
				t1=110;
			}
			
			if(id1.front()>0) {
				System.out.println("\n\n\tCounter 1");
				for(int i=item1.front;i<=item1.rear ;i++) {
						System.out.println("\tID:"+id1.array[i]+"\tItems:"+item1.array[i]);
				}
			}
			
			if(id2.front()>0) {
				System.out.println("\n\n\tCounter 2");
				for(int i=item2.front;i<=item2.rear ;i++) {
						System.out.println("\tID:"+id2.array[i]+"\tItems:"+item2.array[i]);
				}
			}
			
			if(t1==10) {
				t1=1;
				System.out.println("\n\n");
				System.out.println("1.Close Counter 1");
				System.out.println("2.Close Counter 2");
				System.out.println("3.ReOpen Counter 1");
				System.out.println("4.ReOpen Counter 2");
				System.out.println("5.Continue Simulation");
				System.out.println("Enter Your Choice");
				choice=input.nextByte();
				switch(choice) {
				case 1:
					System.out.println("\nCounter 1 Closed");
					c1=0;
					break;
				case 2:
					System.out.println("\nCounter 2 Closed");
					c2=0;
					break;
				case 3:
					if(c1==0) {
						System.out.println("\nCounter 1 Re-Opened");
						c1=1;
					}
					else {
						System.out.println("\nCounter 1 is Already Working");
					}
					break;
				case 4:
					if(c2==0) {
						System.out.println("\nCounter 1 Re-Opened");
						c2=1;
					}
					else {
						System.out.println("\nCounter 1 is Already Working");
					}
					break;
				case 5:
					break;
				}
			}
			else {
				t1++;
			}
			t++;
			System.out.println("-------------------------------------------------------------------------");
		}
	}

}
