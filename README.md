# 3 Tier App with Docker Containers

##### This is a simple 3 tier application consisting of a frontend, backend, and database, each running in its own Docker container. The frontend runs on port 5173, the backend runs on port 3000, and the database is a MongoDB Docker container.

### Prerequisites

Before you can run this application, you must have the following installed:

- Docker

### Installation and Setup

- Clone this repository to your local machine.
- Open a terminal and navigate to the project directory.
- Build the Dockerfiles in the frontend and backend directories
- Once you successfully built the images, run a mongodb docker container and expose port 27017
- Now run the backend container and expose port 3000
- Now run the frontend container and expose port 5173

#### Please note - Attempting the run the backend container before a mongodb container in already running will not work

#### Please note 2 - In the backend api, make sure to put the mongo container IP in the db connection function

### Once the application is up and running, you can use it as follows:

###### The frontend is accessible at http://localhost:5173. You can interact with the frontend to create and delete data from the database.

###### The backend API is accessible at http://localhost:3000/users. You can use this API to interact with the database programmatically.
