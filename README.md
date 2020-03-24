# cucumber-scenarios

## How to run
	1. Make sure that you install gradle
	2. Run this commands to see tests result
		docker build -t test_server server/.
		docker run --rm -d -p 5000:5000 --name endpoint_server test_server
		cd tests/
		gradle cucumber
	4. Stop docker-container
		docker kill endpoint_server 