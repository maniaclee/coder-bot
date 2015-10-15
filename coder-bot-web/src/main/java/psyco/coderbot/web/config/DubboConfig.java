package psyco.coderbot.web.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * Created by lipeng on 15/10/15.
 */
public class DubboConfig {

    @Value("${dubbo.registry.url}")
    private String dubboRegistryUrl;


    @Bean
    public RegistryConfig registry() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(dubboRegistryUrl);
        registryConfig.setProtocol("zookeeper");
        return registryConfig;
    }

    @Bean
    public ApplicationConfig application(@Value("${dubbo.app}") String appName) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(appName);
        return applicationConfig;
    }

    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig mc = new MonitorConfig();
        mc.setProtocol("registry");
        return mc;
    }
}
