package ru.ostrovok.test;

import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer08;
import org.apache.flink.streaming.util.serialization.SimpleStringSchema;

import java.util.Properties;




public class App 
{
    public static void main( String[] args )
    {

        Properties properties = new Properties();
        properties.setProperty("zookeeper.connect", "akonyaev-test-1.dev.hc.ru:2181");
        properties.setProperty("group.id", "test");
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(5000);
        DataStreamSink<String> stream = env.addSource(new FlinkKafkaConsumer08<>("test-topic", new SimpleStringSchema(), properties)).print();

    }
}
