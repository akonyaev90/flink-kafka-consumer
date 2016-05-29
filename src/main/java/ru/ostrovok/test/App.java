package ru.ostrovok.test;

import java.util.Properties;

public class App 
{
    public static void main( String[] args )
    {

        Properties properties = new Properties();
        properties.setProperty("zookeeper.connect", "akonyaev-test-1.dev.hc.ru:2181");
        properties.setProperty("group.id", "test");
        DataStream<String> stream = env.addSource(new FlinkKafkaConsumer08<>("test-topic", new SimpleStringSchema(), properties)).print();

    }
}
