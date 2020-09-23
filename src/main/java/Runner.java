import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.io.*;
public class Runner {
    public static void main(String[] args )throws IOException {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092"); //burası aracılığı ile bağlanıyor kafka'ya.
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        //producer record ile data gönderilir.

        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuffer sb = new StringBuffer();
        String line;
        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        while ((line=br.readLine())!=null)
        {
            ProducerRecord producerRecord = new ProducerRecord("infos","name",line);
            kafkaProducer.send(producerRecord);
        }
        fr.close();

        kafkaProducer.close();
        kafkaProducer.flush();
        System.out.println("Dosya okunmus ve StringBuffer'a yazıldı. Yazılması gereken: 53728 ");

    }
}
