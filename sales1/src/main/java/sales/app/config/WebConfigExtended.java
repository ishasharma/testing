package sales.app.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.athena", "com.spartan", "sales.app" })
public class WebConfigExtended extends WebConfig {
}
