package org.snailgary.thrift.test;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.junit.Test;
import org.snailgary.thrift.impl.CrossPlatformService;

public class ThriftClient {


    @Test
    public void test() throws TException {
        TTransport transport = new TSocket("localhost", 9090);
        transport.open();

        TProtocol protocol = new TBinaryProtocol(transport);
        CrossPlatformService.Client client = new CrossPlatformService.Client(protocol);

        boolean result = client.ping();
        System.out.println(result);
        System.out.println(client.get(1));
        transport.close();
    }

}
