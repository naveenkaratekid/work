package com.example.rp.test.lagomendpoints.api;

import static com.lightbend.lagom.javadsl.api.Service.*;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
//import com.lightbend.lagom.javadsl.api.transport.Method;
public interface StringService extends Service {
   /*ServiceCall<NotUsed, String> reverse(String word);
    ServiceCall<NotUsed, String> upper(String word);
    ServiceCall<NotUsed, String> lower(String word);*/

    ServiceCall<NotUsed, String> action(String actionName, String word);
    ServiceCall<NotUsed, String> main();
    //ServiceCall<NotUsed, List<String>> addToList(String item);
    
    @Override
    default Descriptor descriptor() {
        // @formatter:off
        return named("hello").withCalls(
                pathCall("/api/stringservice/:action/:word", this::action),
                pathCall("/api/stringservice/hello", this::main)
                //restCall(Method.GET, "/api/upper/:word", this::upper),
                //restCall(Method.GET, "/api/lower/:word", this::lower)
        ).withAutoAcl(true);
        // @formatter:off
    }
}
