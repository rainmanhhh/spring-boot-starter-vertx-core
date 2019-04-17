package ez.spring.vertx.httpServer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ez.spring.vertx.VertxConfiguration;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;

@Import(VertxConfiguration.class)
@ConfigurationProperties("vertx.http-server")
@Configuration
public class HttpServerConfiguration {
    private boolean enabled = false;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @ConditionalOnMissingBean(HttpServer.class)
    @Bean
    public HttpServer httpServer(
            Vertx vertx,
            HttpServerOptions options
    ) {
        return isEnabled() ? vertx.createHttpServer(options) : null;
    }

    @ConfigurationProperties("vertx.http-server.options")
    @ConditionalOnMissingBean(HttpServerOptions.class)
    @Bean
    public HttpServerOptions httpServerOptions() {
        return new HttpServerOptions();
    }
}
