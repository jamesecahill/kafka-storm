package com.test.storm;

import java.util.Map;
import java.util.UUID;

import backtype.storm.Config;
import backtype.storm.StormSubmitter;
import backtype.storm.spout.SchemeAsMultiScheme;
import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Tuple;
import storm.kafka.BrokerHosts;
import storm.kafka.KafkaSpout;
import storm.kafka.SpoutConfig;
import storm.kafka.StringScheme;
import storm.kafka.ZkHosts;

public class TestKafkaTopology {
    public static void main(String ... args) throws Exception {
        BrokerHosts hosts = new ZkHosts("192.168.111.100:2181");
        SpoutConfig spoutConfig = new SpoutConfig(hosts, "test2", "/" + "test2", UUID.randomUUID().toString());
        spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        KafkaSpout spout = new KafkaSpout(spoutConfig);

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("kafkaInput", spout);
        builder.setBolt("logger", new BaseRichBolt() {
            private OutputCollector coll;

            public void declareOutputFields(OutputFieldsDeclarer arg0) { }

            public void prepare(Map arg0, TopologyContext arg1, OutputCollector arg2) {
                coll = arg2;
            }

            public void execute(Tuple arg0) {
                System.out.println(arg0.getValueByField(StringScheme.STRING_SCHEME_KEY));
                coll.ack(arg0);
            }
        }).shuffleGrouping("kafkaInput");

        Config conf = new Config();
        conf.setNumWorkers(2);
        StormSubmitter.submitTopology("Test Kafka Reader", conf, builder.createTopology());
    }
}
