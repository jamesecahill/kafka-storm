#!/bin/bash

sudo apt-get -q update
sudo apt-get -qy install openjdk-6-jre python supervisor
wget --quiet http://ftp.wayne.edu/apache/storm/apache-storm-0.9.4/apache-storm-0.9.4.tar.gz
tar -xzvf apache-storm-0.9.4.tar.gz
cd apache-storm-0.9.4
sudo cp /vagrant/provision/supervisor-worker.conf /etc/supervisor/conf.d/
sudo cp /vagrant/provision/storm.yaml conf/
sudo service supervisor restart
