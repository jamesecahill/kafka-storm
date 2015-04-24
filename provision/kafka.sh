#!/bin/bash

wget --quiet http://supergsego.com/apache/kafka/0.8.2.0/kafka_2.10-0.8.2.0.tgz
sudo apt-get -q update
sudo apt-get -qy install openjdk-7-jre zookeeper supervisor
tar -xzvf kafka_2.10-0.8.2.0.tgz
sudo cp /vagrant/provision/supervisor-kafka.conf /etc/supervisor/conf.d/
sudo cp /vagrant/provision/supervisor-zk.conf /etc/supervisor/conf.d/0-supervisor-zk.conf
sudo service supervisor restart
