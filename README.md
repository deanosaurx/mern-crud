# 3 Tier App with Docker Containers

##### This is a simple 3 tier application consisting of a frontend, backend, and database, each running in its own Docker container. The frontend runs on port 5173, the backend runs on port 3000, and the database is a MongoDB Docker container.

### Prerequisites

Before you can run this application, you must have the following installed:

- Docker
- Docker-compose

### Installation and Setup

- Clone this repository to your local machine.
- Open a terminal and navigate to the project directory (docker-compose location).
- Build the images using docker-compose

```bash
docker-compose up -d
```

###### After provisioning thte container, The frontend should be accessible at http://ec2-54-73-155-72.eu-west-1.compute.amazonaws.com:5173. You can interact with the frontend to create and delete data from the database.

###### The backend API is accessible at http://ec2-54-73-155-72.eu-west-1.compute.amazonaws.com:3000/users. You can use this API to interact with the database programmatically.


