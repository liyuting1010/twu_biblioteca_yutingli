# Biblioteca system

## Overview
A spring application for the biblioteca system.

## Run through docker

- Setup app and local database
```shell
docker-compose up app
```

## Example

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
curl -i http://localhost:8080/lend/{book_id}
```
