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
 * ```vagrant ssh kafka```
 * cd to kafka directory
 * ```bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test```
 * deploy the topology
   * ```mvn package``` storm-code
   * on nimbus: ```bin/storm jar /vagrant/storm-code/target/storm-kafka-topology-0.0.1-SNAPSHOT.jar com.test.storm.TestKafkaTopology```
 * send some messages (```bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test```)
