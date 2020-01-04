package org.snailgary;

import org.apache.thrift.transport.TTransportException;
import org.snailgary.thrift.impl.CrossPlatformServiceServer;

public class Application {

    public static void main(String[] args) throws TTransportException {
        CrossPlatformServiceServer serviceServer = new CrossPlatformServiceServer();
        serviceServer.start();
    }

}
