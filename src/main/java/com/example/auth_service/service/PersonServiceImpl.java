package com.example.auth_service.service;

import com.example.auth_service.dto.RegisterRequest;
import com.example.auth_service.model.Person;
import com.example.auth_service.repository.PersonRepository;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;;
    private final ModelMapper modelMapper;
    //private final io.opentracing.Tracer tracer;
    //private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Person register(RegisterRequest registerRequest){
        Person person = modelMapper.map(registerRequest,Person.class);
        person.setAdmin(false);
        person.setPassword(person.getPassword());
        return personRepository.save(person);
    }

    @Override
    public Person getPerson(Long id) {
        /*Tracer.SpanBuilder spanBuilder = tracer.buildSpan("CustomSpan")
                .withTag(Tags.SPAN_KIND.getKey(), Tags.SPAN_KIND_SERVER);

        Span span = spanBuilder.start();
        Tags.COMPONENT.set(span, "AppAController");
        span.setTag("testtag", "test");
        span.finish();*/

        /*String message = "test-message";

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("my-topic", message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Sent message=[" + message +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                        + message + "] due to : " + ex.getMessage());
            }
        });*/

        return  personRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    @KafkaListener(topics = "my-topic", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
