# kabaddi-tournament
Match scheduler for a tournament

---------------Assessment--------------------
Build a RESTful service that generates the round robin schedule for the PRO-Kabaddi event that conforms to the following constraints
- Accept N number of teams
- Each team must play against every other team once home and away
- Maximum 2 matches per day are allowed
- No team should play on consecutive days

-----------------Process to start------------

Step.1	- Import Maven Project in eclipse
Step.2	- Update maven repository
Step.3	- Run the KabaddiApplication.java file
Step.4 	- After the application get up, hit this URL from Postman or any browser - 
			http://localhost:8082/kabaddi/schedule?teamIds=1,2,3,4,5,&startDate=20181221
			
Note : 	startDate should be in "yyyyMMdd" format
		check for port number of the localhost before hitting the above mentioned URL
		you can also get to see the schedule in the console, after you hit the URL

