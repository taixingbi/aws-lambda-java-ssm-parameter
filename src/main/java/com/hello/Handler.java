package com.hello;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Handler implements RequestStreamHandler {
    private static final Logger logger = LoggerFactory.getLogger(Handler.class.getName());
    @Override
    public void handleRequest(
        InputStream inputStream, OutputStream outputStream, Context context)
        throws IOException {

        logger.debug("\n------------------start---------------------");

        logger.debug("------------------end---------------------\n");
    }
}



//public class Handler implements RequestStreamHandler{
//    private static final Logger logger = LoggerFactory.getLogger(Handler.class.getName());
//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    @Override
//    public void handleRequest(InputStream input, OutputStream output,
//                              Context context)    {
//        logger.debug("\n------------------start---------------------");
//
//        logger.debug("------------------end---------------------\n");
//    }
//}





