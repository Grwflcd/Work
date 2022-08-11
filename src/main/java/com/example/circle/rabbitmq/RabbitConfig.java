package com.example.circle.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue() {
        return new Queue("queue");
    }

    @Bean
    public Queue queue2() {
        return new Queue("springboot-queue");
    }

    /*
     * 创建路由
     * */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    /*
     * 创建三个队列，分别是 A,B,C
     * */
    @Bean
    public Queue amessage() {
        return new Queue("queueA");
    }

    @Bean
    public Queue bmessage() {
        return new Queue("queueB");
    }

    @Bean
    public Queue cmessage() {
        return new Queue("queueC");
    }


    /*
     * 路由绑定队列
     * */

    @Bean
    public Binding bindingExchange_A(Queue amessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(amessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchange_B(Queue bmessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(bmessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchange_C(Queue cmessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(cmessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingExchange__A(Queue amessage, DirectExchange directExchange) {
        return BindingBuilder.bind(amessage).to(directExchange).with("key");
    }

    @Bean
    public Binding bindingExchange__B(Queue bmessage, DirectExchange directExchange) {
        return BindingBuilder.bind(bmessage).to(directExchange).with("key123");
    }

    @Bean
    public Binding bindingExchange__C(Queue cmessage, DirectExchange directExchange) {
        return BindingBuilder.bind(cmessage).to(directExchange).with("key");
    }

    @Bean
    public Binding bindingExchangeA(Queue amessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(amessage).to(topicExchange).with("key.*");
    }

    @Bean
    public Binding bindingExchangeB(Queue bmessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(bmessage).to(topicExchange).with("*.key");
    }

    @Bean
    public Binding bindingExchangeC(Queue cmessage, TopicExchange topicExchange) {
        return BindingBuilder.bind(cmessage).to(topicExchange).with("key.#");
    }
}
