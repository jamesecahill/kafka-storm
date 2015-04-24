## Storm and Kafka Test Environment

This is a simple vagrant setup to create and provision storm and kafka on 3 VMs.

 * **kafka**: The kafka vm, running supervisor, zookeeper, and kafka on 192.168.111.100
 * **nimbus**: The storm numbus VM, running supervisor, nimbus, and the storm UI on 192.168.111.101
 * **worker1**: The storm worker VM, running a supervised supervisor on 192.168.111.102

The storm-code directory contains a simple storm topology for deployment and test. More details
to follow on that project...

### Usage

 * ```vagrant up```
 * wait
 * http://192.168.111.101:8080... verify the worker and nimbus are up
 * deploy the topology
 * send some messages
