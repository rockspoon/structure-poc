# Offline support

## Connections between devices

- *WiFi* network service discovery
- *WiFi* direct
- Remote server as a router or P2P
- Bluetooth

An automatic switcher between the ways to connect two devices can be created since they do not impact data consistency.

### *WiFi* direct vs *WiFi* network service discovery use cases

*WiFi* direct has a range of up to 200 meters according to the [*WiFi* alliance](http://www.wi-fi.org/discover-wi-fi/wi-fi-direct). But it's important to notice that this range is only achieved when no obstacles are presented and only for some devices. For most devices, the range may be [between 32 to 95 meters](https://www.diffen.com/difference/Bluetooth_vs_*WiFi*). A range of 32 meters should be a good enough for a high number of establishments, but as now -we- (I) don't have data to confirm it.

*WiFi* discovery may have higher ranges thanks to repeater and better routers' antennas. The drawback is the need for these devices, and an extra chance that a failure of this devices results in the unavailability of the service.

It's a safe assumption that restaurants and bars will have *WiFi* routers, so this should not be a big problem for our implementation. The *WiFi* direct may be beneficial for small fairs and street vendors.

## Use cases

As a minimum, the following situations describes a typical usage of the three main roles the PoS can assume:

- Kitchen app is pulling data from remote server to check which orders to prepare.
- Waiter app is sending data to the remote server to put status of orders "to be prepared".
- Counter app is pulling data from remote server and putting data in remote server orders "as paid".

The following situations are common disturbances that can happen for the PoS regarding connectivity:

- A long internet failure happens on all apps and router.
- A long internet failure happens on router and waiter, but not kitchen and counter.
- A long server failure happens.
- A short server failure happens.
- A short internet failure happens on counter.
- A long router failure happens, but all PoS have internet.
- A short router failure happens.

The follow options represent different offline support implementations to address the limited connectivity.

### Option 1: Local server as a single source of truth

They only use remote server to backup the data and do some operations like some payments. If remote server is not working, backup is delayed. That's how the SAT works.

The basic ones like placing orders and etc., use the server only as backup. The others that requires processing like payments with QR and etc, degrades gracefully, accepting only money payment and card with GPS internet.

This turn out to be the most resilient and simple architecture. Failures are eventually resolved and only one device need to have cell network internet for the system to have extra resilience.

The main disadvantage of this is the high usage of the counter device. It's unknown the necessity of memory and CPU for the counter device. We must benchmark the performance of the devices when dealing with multiple devices. We also need to benchmark the capacity of simultaneous connections to a single the routers.

#### Cases

##### A long internet failure happens on all apps and router, but router continue to work.

All the clients will continue to send requests to the local server with the *WiFi* network discovery.

The local server (counter) will work as normal but it will not sync data.

Some payment methods will become unavailable.

##### A long router failure happens, but all devices have internet.

The apps will use *WiFi* direct to talk to each other. If out of range, waiter will have to pass close to the counter to sync the orders.

...Or

Counter will know that a long router failure happened when trying again in 3 seconds to contact other PoS without success.

Counter will then sync all it's data as well a request to stop being used as a server to the remote server.

Other devices will know that they should use remote server because they will have a server unavailable exception trying to use local server and will request remote server for instructions on what to do. Remote server will respond if local server already synced all data and can be used or when to check again (5 seconds probably).

Counter will check periodically if router is restored. When router is restored, counter can pull all data from server and request to be used as a server again to the remote server.

Other devices will know that they should use local server because when they make a request to remote server it will return a message instructing to find the local server.

### Option 2: Remote server as a single source of the truth

If remote server is not working, local server is used as contingency.

A problem is that if remote server stop working, some states necessary to complete orders may be unavailable on the local server.

The clients will then have to send all their data to the local server so it can construct it's database. The local server will not be able to verify if the data is valid until the connection with the remote server is reestablished.

The rule to enter contingency mode is 2 retries attempt, 3 seconds apart, returning serve unavailable http error.

### Option 3: Remote serve as single source of truth, with local server pulling data.

In this strategy the local server will be constantly pulling data from the main server to keep in sync. There is no guarantee that the data will be completely sync at the time of remote server failure.

### Option 4: The entity creator is the source of truth for that entity

In this strategy, the device that creates an order will only notify a predefined set of devices according to the entity and event. 

For example, in case of remote server unavailable, the device of a waiter will send only to the device of the kitchen that the order should be prepared. After the order is closed, the device of the waiter will notify only the counter about the necessity of payment, and not the kitchen.

This come with the price that no device will have all the orders information until the internet is restored and all devices sync their orders. Also, only the device that creates an order can change its status. For example, if a customer direct itself to the counter and ask to close the bill, the counter will not be able to do it on behalf of the waiter.









## Draft

If remote server becomes unavailable, I can't use the local sever to do the operations because there is no garantee that the local server will have all the data.

I can put the local server to always pull data, but still no guarantees of complete data.

I can make all the PoS send their database data to the local server, to it reconstructs the data from the local server. It's important to notice that errors on individual PoS will not be able to be verified. A important one is the timestamp. If one pos is with incorrect clock, when the local server decides which data is the freshest in the sync resolution strategy, there will be errors.

This is strategy will only works also if the operation on the data is stateless. If the PoS data are not enough to reconstruct the server data, this will not work.


?? configuration ??

?? selection of server ??

The server will auto select itself and have a service. I can find the service by its name, but I don't know how each PoS will know for sure that that is the server and not another device messing around the network. The server may create a secret static token and the user may insert it at first connection, similar of how some paring devices works. The device can also pair with the remote server, it's safe assume internet connection at first use since it needs it to install the app.

TODO
Make the Api Client for the client
Make the order repository
Make the api client for the push noitification
Make the sync service

