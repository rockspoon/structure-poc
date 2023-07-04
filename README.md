# Project structure Proof-of-concept

An Android app proof-of-concept (PoC) for a scalable architecture and project structure, with:

- Dynamic and non-dynamic features;
- Instrumented and unit tests;
- Big, medium and small tests;
- Coroutine Flows;
- Koin dependency injection;
- Room database;
- Retrofit + OkHttp client;
- Network service discovery;
- Services;
- Receivers;
- Providers;

See ./docs/project-structure for details.

## Modules

### :feature_localclient

Dynamic module that gives the app the functionality to act as a client in the local network.

### :feature_localserver

Dynamic module that gives the app the functionality to act as a server in the local network.

### :datasource_database

Module that contains the classes for the app database

### :datasource_localclient

Module that contains the classes to make a HTTPS request in the local network to the device acting as a server. 

### :datasource_localserverdatabase

Module that contains the classes for the relational database of the app when the device its acting with the role local server.

When a device is acting as a local server, it keeps in this database the tables with the values of all the PoS until the shift is over. It uses the server as a back up and periodically sync the data. The local server is the single source of truth.

### :datasource_localserverdatastore

Non relational data store used for implementing subscriptions to events of PoS acting with the client role in a pub / sub pattern.

### :datasource_remoteclient

Module that contains the classes to make a HTTPS request in the remote network to the server that backups the information. In a real application, it could be renamed to the company service.
