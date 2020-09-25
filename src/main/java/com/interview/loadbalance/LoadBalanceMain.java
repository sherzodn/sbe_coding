package com.interview.loadbalance;

public class LoadBalanceMain {
    /*
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        loadBalance();
    }

    public static void loadBalance(){
        doGetServer(new RoundRobin());
        doGetServer(new IpHash());
    }

    private static void doGetServer(LoadBalance loadBalance) {
        doGetServer(loadBalance, 100);
    }

    private static void doGetServer(LoadBalance loadBalance, int queryTimes) {
        for (int i = 0; i < queryTimes; i++) {
            String serverId = loadBalance.getServer(String.valueOf(i));
            System.out.printf("[%s] index:%s, %s%n", loadBalance.getClass().getSimpleName(), i, serverId);
        }
    }
*/

}
