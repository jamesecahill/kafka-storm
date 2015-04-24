# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.define "kafka" do |kafka|
    kafka.vm.box = "ubuntu/trusty64"

    kafka.vm.hostname = "kafka"

    kafka.vm.provider "virtualbox" do |vb|
      # Customize the amount of memory on the VM:
      vb.memory = "2048"
    end

    kafka.vm.network "private_network", type: "static", ip: "192.168.111.100", netmask: "255.255.255.0"

    kafka.vm.provision "shell", path: "provision/kafka.sh"
  end

  config.vm.define "nimbus" do |nimbus|
    nimbus.vm.box = "ubuntu/trusty64"

    nimbus.vm.hostname = "nimbus"

    nimbus.vm.provider "virtualbox" do |vb|
      # Customize the amount of memory on the VM:
      vb.memory = "2048"
    end

    nimbus.vm.network "private_network", type: "static", ip: "192.168.111.101", netmask: "255.255.255.0"

    nimbus.vm.provision "shell", path: "provision/storm-nimbus.sh"
  end

  config.vm.define "worker1" do |worker1|
    worker1.vm.box = "ubuntu/trusty64"

    worker1.vm.hostname = "worker1"

    worker1.vm.provider "virtualbox" do |vb|
      # Customize the amount of memory on the VM:
      vb.memory = "2048"
    end

    worker1.vm.network "private_network", type: "static", ip: "192.168.111.102", netmask: "255.255.255.0"

    worker1.vm.provision "shell", path: "provision/storm-worker.sh"
  end
end
