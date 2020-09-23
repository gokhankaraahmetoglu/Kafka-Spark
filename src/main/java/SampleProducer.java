import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
public class SampleProducer {
    public SampleProducer(){
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092"); //burası aracılığı ile bağlanıyor kafka'ya.
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //producer record ile data gönderilir.

        ProducerRecord producerRecord = new ProducerRecord("channel","name","Selam");


        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        kafkaProducer.send(producerRecord);
        kafkaProducer.close();
    }
    public SampleProducer(String a){
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092"); //burası aracılığı ile bağlanıyor kafka'ya.
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //producer record ile data gönderilir.

        ProducerRecord producerRecord = new ProducerRecord("infos","name",a);


        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        kafkaProducer.send(producerRecord);
        kafkaProducer.close();
        kafkaProducer.flush();

    }
}
//https://www.youtube.com/watch?v=bwXWIx5dZjw