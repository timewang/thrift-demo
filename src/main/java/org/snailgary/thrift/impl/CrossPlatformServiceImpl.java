package org.snailgary.thrift.impl;

import org.apache.thrift.TException;

import java.util.Collections;
import java.util.List;

public class CrossPlatformServiceImpl implements CrossPlatformService.Iface {

    @Override
    public CrossPlatformResource get(int id)
            throws InvalidOperationException, TException {
        System.out.println("get method " + id);
        CrossPlatformResource crossPlatformResource = new CrossPlatformResource();
        crossPlatformResource.setId(1);
        crossPlatformResource.setName("test");
        return crossPlatformResource;
    }

    @Override
    public void save(CrossPlatformResource resource)
            throws InvalidOperationException, TException {
        System.out.println("save method");
    }

    @Override
    public List<CrossPlatformResource> getList()
            throws InvalidOperationException, TException {
        return Collections.emptyList();
    }

    @Override
    public boolean ping() throws InvalidOperationException, TException {
        return true;
    }

}
