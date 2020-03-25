# Test scenario for endpoint api with cucumber

## Description
	The project consists of 2 part
		1. Server simulating endpoint
		2. Test scenario for our server
	By task description it's not clear how we can find out from which 
	user the request was generated. To do this, I implement a token. 
	It's generated from the test for each request and determines by 
	token which company the user belongs to.


## How to run
	1. Make sure that you install gradle and docker
	2. Run this commands to see tests result
		docker build -t test_server server/.
		docker run --rm -d -p 5000:5000 --name endpoint_server test_server
		cd tests/
		gradle cucumber
	4. Stop docker-container
		docker stop endpoint_server 
