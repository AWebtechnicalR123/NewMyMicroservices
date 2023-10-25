package com.project.hotel.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.support.HttpHeaders;
//import org.springframework.http.HttpHeaders;

@Configuration
public class HotelConfiguration extends ElasticsearchConfiguration {
    @Override
    public ClientConfiguration clientConfiguration() {
        HttpHeaders compatibilityHeaders = new HttpHeaders();
        compatibilityHeaders.add("Accept", "application/vnd.elasticsearch+json;compatible-with=7");
        compatibilityHeaders.add("Content-Type", "application/vnd.elasticsearch+json;"
                + "compatible-with=7");

        return ClientConfiguration.builder()
                .connectedTo("localhost:9500")
                .withDefaultHeaders(compatibilityHeaders)
                .build();
    }
}
