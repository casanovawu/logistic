package com.suzz.platform.config;

import org.redisson.Redisson;
import org.redisson.RedissonShutdownException;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.BaseCodec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.*;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author subo
 * @date 2022/5/21 0:54
 **/
public class RedissonClientFactory implements FactoryBean<RedissonClient> {

    private final Object lock;
    public static final String SINGLE = "single";
    public static final String CLUSTER = "cluster";
    public static final String MASTER_SLAVE = "master-slave";
    private Config config;
    private RedissonClient client;
    private static boolean isLinux = false;
    private String[] hostsAndPorts;
    private String type;
    private int thread;
    private int timeout;
    private String password;
    private int initConnectionSize;
    private int minimumIdleSize;
    private int database;

    public void setPassword(String password) {
        if (!StringUtils.isEmpty(password)) {
            this.password = password;
        }

    }
    public RedissonClientFactory(String hostsAndPortsStr, String type,int database) {
        this.lock = new Object[0];
        this.config = new Config();
        this.client = null;
        this.thread = 5;
        this.timeout = 2000;
        this.initConnectionSize = 8;
        this.minimumIdleSize = 4;
        this.database = database;
        String[] hostsAndPorts = hostsAndPortsStr.split(",");
        this.hostsAndPorts = hostsAndPorts;
        this.type = type;
    }


    public RedissonClientFactory(String hostsAndPortsStr, String type, int thread,int database) {
        this.lock = new Object[0];
        this.config = new Config();
        this.client = null;
        this.thread = 5;
        this.timeout = 2000;
        this.initConnectionSize = 8;
        this.minimumIdleSize = 4;
        this.database = database;
        String[] hostsAndPorts = hostsAndPortsStr.split(",");
        this.init(hostsAndPorts, type, thread, 2000);
    }


    private void init(String[] hostsAndPorts, String type, int thread, int timeout) {
        this.hostsAndPorts = hostsAndPorts;
        this.type = type;
        this.thread = thread;
        this.timeout = timeout;
    }

    public void initClientConfig(BaseCodec codec) {
        this.config.setThreads(this.thread);
        if (isLinux) {
            this.config.setTransportMode(TransportMode.EPOLL);
        }

        if (Objects.isNull(codec)) {
            codec = new JsonJacksonCodec();
        }

        this.config.setNettyThreads(this.initConnectionSize);
        this.config.setThreads(this.minimumIdleSize);
        this.config.setCodec(codec);
        if (CLUSTER.equals(this.type) && this.hostsAndPorts.length > 3) {
            ClusterServersConfig csc = this.config.useClusterServers();
            String[] var3 = this.hostsAndPorts;
            int var4 = var3.length;

            for (int var5 = 0; var5 < var4; ++var5) {
                String str = var3[var5];
                csc.addNodeAddress(new String[]{str});
            }

            csc.setTimeout(this.timeout);
            csc.setPassword(this.password);
            csc.setMasterConnectionMinimumIdleSize(this.minimumIdleSize);
            csc.setMasterConnectionPoolSize(this.initConnectionSize);
            csc.setSlaveConnectionMinimumIdleSize(this.minimumIdleSize);
            csc.setSlaveConnectionPoolSize(this.initConnectionSize);
        } else if (MASTER_SLAVE.equals(this.type) && this.hostsAndPorts.length == 2) {
            MasterSlaveServersConfig msc = this.config.useMasterSlaveServers();
            msc.setMasterAddress(this.hostsAndPorts[0]);
            msc.addSlaveAddress(this.hostsAndPorts[1]);
            msc.setTimeout(this.timeout);
            msc.setPassword(this.password);
            if (this.database > 0) {
                msc.setDatabase(this.database);
            }

            msc.setMasterConnectionMinimumIdleSize(this.minimumIdleSize);
            msc.setMasterConnectionPoolSize(this.initConnectionSize);
            msc.setSlaveConnectionMinimumIdleSize(this.minimumIdleSize);
            msc.setSlaveConnectionPoolSize(this.initConnectionSize);
        } else {
            if (!SINGLE.equals(this.type) || this.hostsAndPorts.length != 1) {
                String var10002 = this.type;
                throw new RedissonShutdownException("redisson config error for model:" + var10002 + " with hosts:" + this.hostsAndPorts.toString());
            }

            SingleServerConfig ssc = this.config.useSingleServer();
            ssc.setAddress("redis://"+this.hostsAndPorts[0]);
            ssc.setTimeout(this.timeout);
            ssc.setPassword(this.password);
            if (this.database > 0) {
                ssc.setDatabase(this.database);
            }

            ssc.setConnectionMinimumIdleSize(this.minimumIdleSize);
            ssc.setConnectionPoolSize(this.initConnectionSize);
        }

    }

    public RedissonClient getObject() throws Exception {
        synchronized (this.lock) {
            if (this.client == null) {
                this.client = Redisson.create(this.config);
            }
            return this.client;
        }
    }

    public Class<?> getObjectType() {
        return RedissonClient.class;
    }

    public boolean isSingleton() {
        return false;
    }

    static {
        String os = System.getProperties().getProperty("os.name");
        isLinux = os.indexOf("Windows") < 0 && os.indexOf("Mac") < 0;
    }
}
