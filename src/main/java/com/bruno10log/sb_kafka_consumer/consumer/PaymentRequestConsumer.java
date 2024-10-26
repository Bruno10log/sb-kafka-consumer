package com.bruno10log.sb_kafka_consumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentRequestConsumer {

    private static final Logger LOG = LoggerFactory
            .getLogger(PaymentRequestConsumer.class);

    @KafkaListener(
        topics = "${topics.payment.request.topic}",
        groupId = "payment-request-consumer-1",
        concurrency = "2"
    )
    public void consume(ConsumerRecord<?, String> consumerRecord) {
        System.out.println("\n");

     //   if(consumerRecord.partition() == 1) {
            LOG.info("partition = " + consumerRecord.partition());
            LOG.info(consumerRecord.value());
     //   }


    }
}
