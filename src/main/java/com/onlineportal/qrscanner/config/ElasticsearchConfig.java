//package com.onlineportal.qrscanner.config;
//
//import org.apache.http.impl.client.HttpClients;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//import org.springframework.data.elasticsearch.client.ClientConfiguration;
//import org.springframework.data.elasticsearch.client.RestClients;
//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.onlineportal.qrscanner.elasticRepository")
//public class ElasticsearchConfig {
//
//    @Bean
//    public ElasticsearchOperations elasticsearchOperations() {
//        // Configure the Elasticsearch client (the default is fine for most cases)
//        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//                .connectedTo("elasticsearch:9201")  // Update with your actual Elasticsearch URL
//                .withHttpClient(HttpClients.createDefault())
//                .build();
//
//        // Use the RestClient to create the ElasticsearchRestClient instance
//        ElasticsearchRestClient client = RestClients.create(clientConfiguration).rest();
//
//        return new ElasticsearchTemplate(client); // ElasticsearchTemplate is still available but wrapped around the new client
//    }
//}
