package com.rtzan.camel.k8s.first.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.rtzan.camel.k8s.common.ApplicationProperties.APP_NAME;
import static org.apache.camel.LoggingLevel.INFO;

@Component
public class FirstRouteBuilder extends RouteBuilder {

    static final String ROUTE_ID_TODO = "route." + APP_NAME + ".first.fromTodo";
    static final String NODE_ID_TODO_DEST = "node.toDestination";

    private final long redeliveryDelay;
    private final int maxRedeliveryAttempts;

    private final int fromTimerPeriod;

    @Autowired
    public FirstRouteBuilder(
            @Value("${exception.redelivery.delay:5000}") long redeliveryDelay,
            @Value("${exception.redelivery.attempts:3}") int maxRedeliveryAttempts,
            @Value("${from.timer.period:50}") int fromTimerPeriod
    ) {
        this.redeliveryDelay = redeliveryDelay;
        this.maxRedeliveryAttempts = maxRedeliveryAttempts;

        this.fromTimerPeriod = fromTimerPeriod;
    }

    @Override
    public void configure() {
        onException(Exception.class)
                .logRetryAttempted(true)
                .redeliveryDelay(redeliveryDelay)
                .maximumRedeliveries(maxRedeliveryAttempts);

        from("timer:first?period=" + fromTimerPeriod).routeId(ROUTE_ID_TODO)
                .log(INFO, "Sending data")
                .to("stream:out").id(NODE_ID_TODO_DEST);

    }
}
