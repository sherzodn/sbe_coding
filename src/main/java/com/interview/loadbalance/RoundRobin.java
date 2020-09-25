package com.interview.loadbalance;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoundRobin implements LoadBalance{
    private static Integer position = 0;
    @Override
    public String getServer(String clientId) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>(servers);
        String target;
        synchronized (position){
            if (position > serverList.size() - 1){
                position = 0;
            }
            target = serverList.get(position);
            position++;
        }
        return target;
    }
}
