package ez.spring.vertx;

import java.util.Collections;
import java.util.List;

import ez.spring.vertx.deploy.DeployProps;
import io.vertx.core.VertxOptions;

public class VertxProps extends VertxOptions {
  /**
   * whether to join a cluster
   */
  private boolean clustered = false;
  /**
   * timeout of joining to the cluster.
   * unit: {@link java.util.concurrent.TimeUnit#MILLISECONDS}.
   * less than 0 means wait forever
   */
  private long clusterJoinTimeout = 30_000L;
  /**
   * timeout of deploy all configured verticles(in beans and config files).
   * unit: {@link java.util.concurrent.TimeUnit#MILLISECONDS}.
   * less than 0 means wait forever
   */
  private long deployTimeout = 120_000L;
  /**
   * order of {@link ez.spring.vertx.deploy.AutoDeployer} in spring application listeners
   */
  private int autoDeployerOrder = 0;
  /**
   * verticles to deploy at vertx start(after main verticle deployed).
   *
   * @see DeployProps
   */
  private List<DeployProps> verticles = Collections.emptyList();

  public boolean isClustered() {
    return clustered;
  }

  public VertxProps setClustered(boolean clustered) {
    this.clustered = clustered;
    return this;
  }

  public int getAutoDeployerOrder() {
    return autoDeployerOrder;
  }

  public VertxProps setAutoDeployerOrder(int autoDeployerOrder) {
    this.autoDeployerOrder = autoDeployerOrder;
    return this;
  }

  public long getClusterJoinTimeout() {
    return clusterJoinTimeout;
  }

  public VertxProps setClusterJoinTimeout(long clusterJoinTimeout) {
    this.clusterJoinTimeout = clusterJoinTimeout;
    return this;
  }

  public long getDeployTimeout() {
    return deployTimeout;
  }

  public VertxProps setDeployTimeout(long deployTimeout) {
    this.deployTimeout = deployTimeout;
    return this;
  }

  public List<DeployProps> getVerticles() {
    return verticles;
  }

  public VertxProps setVerticles(List<DeployProps> verticles) {
    this.verticles = verticles;
    return this;
  }
}