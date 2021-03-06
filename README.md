# Biblioteca system

## Overview
A spring application for the biblioteca system.

## Run through docker

- Setup app and local database
```shell
docker-compose up app
```

## Endpoints

When setup the local app and db successfully, you can curl with the endpoints
1. get all book information
```shell
curl -i http://localhost:8080/getAll
```

2. select book by its id
```shell
curl -i http://localhost:8080/get/{book_id}
```

3. lend a book by its id
```shell
curl -i http://localhost:8080/lend/{book_id} -d "username=Yuting1"
```

4. return a book by its id
```shell
curl -i http://localhost:8080/return/{book_id} -d "username=Yuting1"
```

4. login with username and password
```shell
curl -i http://localhost:8080/login?username="Yuting1"&password="password1"
```

5. get borrowed book record for a specific user with his/her username
```shell
curl -i http://localhost:8080/record/Yuting1
```

## In progress
1. Frontend page (A frontend react app: https://github.com/liyuting1010/biblioteca_react_yutingli)
2. Lend book will insert record in `borrow_records` table.
