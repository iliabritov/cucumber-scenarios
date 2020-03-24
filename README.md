# Test scenario for endpoint api with cucumber

## How to run
	1. Make sure that you install gradle and docker
	2. Run this commands to see tests result
		docker build -t test_server server/.
		docker run --rm -d -p 5000:5000 --name endpoint_server test_server
		cd tests/
		gradle cucumber
	4. Stop docker-container
		docker stop endpoint_server 