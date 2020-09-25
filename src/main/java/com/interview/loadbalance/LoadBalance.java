package com.interview.loadbalance;

public interface LoadBalance {
    String getServer(String clientId);
}
