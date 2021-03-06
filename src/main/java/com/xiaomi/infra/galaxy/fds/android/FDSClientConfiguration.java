package com.xiaomi.infra.galaxy.fds.android;

import com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential;
import com.xiaomi.infra.galaxy.fds.android.util.Args;

public class FDSClientConfiguration {

  private static final String URI_HTTP_PREFIX = "http://";
  private static final String URI_HTTPS_PREFIX = "https://";
  private static final String URI_CDN = "cdn";
  private static final String URI_SUFFIX = "fds.api.xiaomi.com";
  private static final String URI_CDN_SUFFIX = "fds.api.mi-img.com";

  /**
   * The default timeout for a connected socket.
   */
  public static final int DEFAULT_SOCKET_TIMEOUT_MS = 50 * 1000;

  /**
   * The default max retry times
   */
  public static final int DEFAULT_MAX_RETRY_TIMES = 3;

  /**
   * The default size of a upload part
   */
  public static final int DEFAULT_UPLOAD_PART_SIZE = 4096;

  /**
   * The amount of time to wait (in milliseconds) for data to be transfered
   * over an established, open connection before the connection is timed out.
   * A value of 0 means infinity, and is not recommended.
   */
  private int socketTimeoutMs = DEFAULT_SOCKET_TIMEOUT_MS;
  /**
   * The default timeout for establishing a connection.
   */
  public static final int DEFAULT_CONNECTION_TIMEOUT_MS = 50 * 1000;
  /**
   * The amount of time to wait (in milliseconds) when initially establishing
   * a connection before giving up and timing out. A value of 0 means
   * infinity, and is not recommended.
   */
  private int connectionTimeoutMs = DEFAULT_CONNECTION_TIMEOUT_MS;

  /**
   * Optional size hint (in bytes) for the low level TCP send buffer. This is
   * an advanced option for advanced users who want to tune low level TCP
   * parameters to try and squeeze out more performance.
   */
  private int socketSendBufferSizeHint = 0;

  /**
   * Optional size hint (in bytes) for the low level TCP receive buffer. This
   * is an advanced option for advanced users who want to tune low level TCP
   * parameters to try and squeeze out more performance.
   */
  private int socketReceiveBufferSizeHint = 0;

  /**
   * The maximum number of times that a failed request will be retried
   */
  private int maxRetryTimes = DEFAULT_MAX_RETRY_TIMES;

  /**
   * The size of each upload part
   */
  private int uploadPartSize = DEFAULT_UPLOAD_PART_SIZE;

  public static final int DEFAULT_THREAD_POOL_CORE_SIZE = 4;

  private int threadPoolCoreSize = DEFAULT_THREAD_POOL_CORE_SIZE;

  public static final int DEFAULT_THREAD_POOL_MAX_SIZE = 10;

  private int threadPoolMaxSize = DEFAULT_THREAD_POOL_MAX_SIZE;

  public static final int DEFAULT_THREAD_POOL_KEEP_ALIVE_SECS = 30;

  private int threadPoolKeepAliveSecs = DEFAULT_THREAD_POOL_KEEP_ALIVE_SECS;

  public static final int DEFAULT_WORK_QUEUE_CAPACITY = 10240;

  private int workQueueCapacity = DEFAULT_WORK_QUEUE_CAPACITY;

  /**
   * The credential of FDS client
   */
  private GalaxyFDSCredential credential;

  private String regionName = "cnbj0";
  private boolean enableHttps = true;
  private boolean enableCdnForUpload = false;
  private boolean enableCdnForDownload = true;

  private boolean enableUnitTestMode = false;
  private String baseUriForUnitTest = "";
  private String endpoint;

  /**
   * Returns the maximum number of retry attempts for failed requests
   */
  public int getMaxRetryTimes() {
    return maxRetryTimes;
  }

  /**
   * Sets the maximum number of retry attempts for failed requests
   */
  public void setMaxRetryTimes(int maxRetryTimes) {
    Args.notNegative(maxRetryTimes, "max retry times");
    this.maxRetryTimes = maxRetryTimes;
  }

  /**
   * Sets the maximum number of retry attempts for failed requests and returns
   * the updated FDSClientConfiguration object.
   *
   * @param maxRetryTimes The maximum number of retry attempts for failed retryable
   *                      requests. This value should not be negative.
   * @return The updated FDSClientConfiguration object.
   */
  public FDSClientConfiguration withMaxRetryTimes(int maxRetryTimes) {
    setMaxRetryTimes(maxRetryTimes);
    return this;
  }

  /**
   * Returns the amount of time to wait (in milliseconds) for data to be
   * transferred over an established, open connection before the connection
   * times out and is closed. A value of 0 means infinity, and isn't
   * recommended.
   *
   * @return The amount of time to wait (in milliseconds) for data to be
   * transferred over an established, open connection before the
   * connection times out and is closed.
   */
  public int getSocketTimeoutMs() {
    return socketTimeoutMs;
  }

  /**
   * Sets the amount of time to wait (in milliseconds) for data to be
   * transferred over an established, open connection before the connection
   * times out and is closed. A value of 0 means infinity, and isn't recommended.
   *
   * @param socketTimeoutMs The amount of time to wait (in milliseconds) for data
   *                      to be transfered over an established, open connection
   *                      before the connection is times out and is closed.
   */
  public void setSocketTimeoutMs(int socketTimeoutMs) {
    this.socketTimeoutMs = socketTimeoutMs;
  }

  /**
   * Sets the amount of time to wait (in milliseconds) for data to be
   * transferred over an established, open connection before the connection
   * times out and is closed, and returns the updated FDSClientConfiguration
   * object so that additional method calls may be chained together.
   *
   * @param socketTimeout The amount of time to wait (in milliseconds) for data
   *                      to be transfered over an established, open connection
   *                      before the connection is times out and is closed.
   * @return The updated FDSClientConfiguration object.
   */
  public FDSClientConfiguration withSocketTimeoutMs(int socketTimeout) {
    setSocketTimeoutMs(socketTimeout);
    return this;
  }

  /**
   * Returns the amount of time to wait (in milliseconds) when initially
   * establishing a connection before giving up and timing out. A value of 0
   * means infinity, and is not recommended.
   *
   * @return The amount of time to wait (in milliseconds) when initially
   * establishing a connection before giving up and timing out.
   */
  public int getConnectionTimeoutMs() {
    return connectionTimeoutMs;
  }

  /**
   * Sets the amount of time to wait (in milliseconds) when initially
   * establishing a connection before giving up and timing out. A value of 0
   * means infinity, and is not recommended.
   *
   * @param connectionTimeoutMs The amount of time to wait (in milliseconds) when
   *                          initially establishing a connection before giving
   *                          up and timing out.
   */
  public void setConnectionTimeoutMs(int connectionTimeoutMs) {
    this.connectionTimeoutMs = connectionTimeoutMs;
  }

  /**
   * Sets the amount of time to wait (in milliseconds) when initially
   * establishing a connection before giving up and timing out, and returns
   * the updated FDSClientConfiguration object so that additional method calls
   * may be chained together.
   *
   * @param connectionTimeout the amount of time to wait (in milliseconds) when initially
   *                          establishing a connection before giving up and timing out.
   * @return The updated FDSClientConfiguration object.
   */
  public FDSClientConfiguration withConnectionTimeoutMs(int connectionTimeout) {
    setConnectionTimeoutMs(connectionTimeout);
    return this;
  }

  /**
   * Returns the optional size hints (in bytes) for the low level TCP send and
   * receive buffers. This is an advanced option for advanced users who want
   * to tune low level TCP parameters to try and squeeze out more performance.
   * <p/>
   * The optimal TCP buffer sizes for a particular application are highly
   * dependent on network configuration and operating system configuration and
   * capabilities. For example, most modern operating systems provide
   * auto-tuning functionality for TCP buffer sizes, which can have a big
   * impact on performance for TCP connections that are held open long enough
   * for the auto-tuning to optimize buffer sizes.
   * <p/>
   * Large buffer sizes (ex: 2MB) will allow the operating system to buffer
   * more data in memory without requiring the remote server to acknowledge
   * receipt of that information, so can be particularly useful when the
   * network has high latency.
   * <p/>
   * This is only a <b>hint</b>, and the operating system may choose not to
   * honor it. When using this option, users should <b>always</b> check the
   * operating system's configured limits and defaults. Most OS's have a
   * maximum TCP buffer size limit configured, and won't let you go beyond
   * that limit unless you explicitly raise the max TCP buffer size limit.
   * <p/>
   * There are many resources available online to help with configuring TCP
   * buffer sizes and operating system specific TCP settings, including:
   * <ul>
   * <li>http://onlamp.com/pub/a/onlamp/2005/11/17/tcp_tuning.html</li>
   * <li>http://fasterdata.es.net/TCP-tuning/</li>
   * </ul>
   *
   * @return A two element array containing first the TCP send buffer size
   * hint and then the TCP receive buffer size hint.
   */
  public int[] getSocketBufferSizeHints() {
    return new int[]{socketSendBufferSizeHint, socketReceiveBufferSizeHint};
  }

  /**
   * Sets the optional size hints (in bytes) for the low level TCP send and
   * receive buffers. This is an advanced option for advanced users who want
   * to tune low level TCP parameters to try and squeeze out more performance.
   * <p/>
   * The optimal TCP buffer sizes for a particular application are highly
   * dependent on network configuration and operating system configuration and
   * capabilities. For example, most modern operating systems provide
   * auto-tuning functionality for TCP buffer sizes, which can have a big
   * impact on performance for TCP connections that are held open long enough
   * for the auto-tuning to optimize buffer sizes.
   * <p/>
   * Large buffer sizes (ex: 2MB) will allow the operating system to buffer
   * more data in memory without requiring the remote server to acknowledge
   * receipt of that information, so can be particularly useful when the
   * network has high latency.
   * <p/>
   * This is only a <b>hint</b>, and the operating system may choose not to
   * honor it. When using this option, users should <b>always</b> check the
   * operating system's configured limits and defaults. Most OS's have a
   * maximum TCP buffer size limit configured, and won't let you go beyond
   * that limit unless you explicitly raise the max TCP buffer size limit.
   * <p/>
   * There are many resources available online to help with configuring TCP
   * buffer sizes and operating system specific TCP settings, including:
   * <ul>
   * <li>http://onlamp.com/pub/a/onlamp/2005/11/17/tcp_tuning.html</li>
   * <li>http://fasterdata.es.net/TCP-tuning/</li>
   * </ul>
   *
   * @param socketSendBufferSizeHint    The size hint (in bytes) for the low level TCP send buffer.
   * @param socketReceiveBufferSizeHint The size hint (in bytes) for the low level TCP receive buffer.
   */
  public void setSocketBufferSizeHints(
      int socketSendBufferSizeHint, int socketReceiveBufferSizeHint) {
    this.socketSendBufferSizeHint = socketSendBufferSizeHint;
    this.socketReceiveBufferSizeHint = socketReceiveBufferSizeHint;
  }

  /**
   * Sets the optional size hints (in bytes) for the low level TCP send and
   * receive buffers, and returns the updated FDSClientConfiguration object so
   * that additional method calls may be chained together.
   * <p/>
   * This is an advanced option for advanced users who want to tune low level
   * TCP parameters to try and squeeze out more performance.
   * <p/>
   * The optimal TCP buffer sizes for a particular application are highly
   * dependent on network configuration and operating system configuration and
   * capabilities. For example, most modern operating systems provide
   * auto-tuning functionality for TCP buffer sizes, which can have a big
   * impact on performance for TCP connections that are held open long enough
   * for the auto-tuning to optimize buffer sizes.
   * <p/>
   * Large buffer sizes (ex: 2MB) will allow the operating system to buffer
   * more data in memory without requiring the remote server to acknowledge
   * receipt of that information, so can be particularly useful when the
   * network has high latency.
   * <p/>
   * This is only a <b>hint</b>, and the operating system may choose not to
   * honor it. When using this option, users should <b>always</b> check the
   * operating system's configured limits and defaults. Most OS's have a
   * maximum TCP buffer size limit configured, and won't let you go beyond
   * that limit unless you explicitly raise the max TCP buffer size limit.
   * <p/>
   * There are many resources available online to help with configuring TCP
   * buffer sizes and operating system specific TCP settings, including:
   * <ul>
   * <li>http://onlamp.com/pub/a/onlamp/2005/11/17/tcp_tuning.html</li>
   * <li>http://fasterdata.es.net/TCP-tuning/</li>
   * </ul>
   *
   * @param socketSendBufferSizeHint    The size hint (in bytes) for the low level TCP send buffer.
   * @param socketReceiveBufferSizeHint The size hint (in bytes) for the low level TCP receive buffer.
   * @return The updated FDSClientConfiguration object.
   */
  public FDSClientConfiguration withSocketBufferSizeHints(
      int socketSendBufferSizeHint, int socketReceiveBufferSizeHint) {
    setSocketBufferSizeHints(socketSendBufferSizeHint, socketReceiveBufferSizeHint);
    return this;
  }

  /**
   * Gets the size of each part uploaded
   */
  public int getUploadPartSize() {
    return uploadPartSize;
  }

  /**
   * Sets the size of each part uploaded
   * <p/>
   * This is an advanced option for advanced users who want to control how the
   * objects will be uploaded
   * <p/>
   * @param uploadPartSize
   */
  public void setUploadPartSize(int uploadPartSize) {
    Args.positive(uploadPartSize, "upload part size");
    this.uploadPartSize = uploadPartSize;
  }

  /**
   * Sets the size of each part uploaded, and return the
   * <p/>
   * This is an advanced option for advanced users who want to control how the
   * objects will be uploaded
   * <p/>
   * @param uploadPartSize
   * @return The updated FDSClientConfiguration object.
   */
  public FDSClientConfiguration withUploadPartSize(int uploadPartSize) {
    setUploadPartSize(uploadPartSize);
    return this;
  }

  public int getThreadPoolCoreSize() {
    return this.threadPoolCoreSize;
  }

  public void setThreadPoolCoreSize(int threadPoolCoreSize) {
    this.threadPoolCoreSize = threadPoolCoreSize;
  }

  public FDSClientConfiguration withThreadPoolCoreSize(int threadPoolCoreSize) {
    setThreadPoolCoreSize(threadPoolCoreSize);
    return this;
  }

  public int getThreadPoolMaxSize() {
    return this.threadPoolMaxSize;
  }

  public void setThreadPoolMaxSize(int threadPoolMaxSize) {
    this.threadPoolMaxSize = threadPoolMaxSize;
  }

  public FDSClientConfiguration withThreadPoolMaxSize(int threadPoolMaxSize) {
    setThreadPoolMaxSize(threadPoolMaxSize);
    return this;
  }

  public int getThreadPoolKeepAliveSecs() {
    return this.threadPoolKeepAliveSecs;
  }

  public void setThreadPoolKeepAliveSecs(int threadPoolKeepAliveSecs) {
    this.threadPoolKeepAliveSecs = threadPoolKeepAliveSecs;
  }

  public FDSClientConfiguration withThreadPoolKeepAliveSecs(
      int threadPoolKeepAliveSecs) {
    setThreadPoolKeepAliveSecs(threadPoolKeepAliveSecs);
    return this;
  }

  public int getWorkQueueCapacity() {
    return this.workQueueCapacity;
  }

  public void setWorkQueueCapacity(int workQueueCapacity) {
    this.workQueueCapacity = workQueueCapacity;
  }

  public FDSClientConfiguration withWorkQueueCapacity(int workQueueCapacity) {
    setWorkQueueCapacity(workQueueCapacity);
    return this;
  }

  /**
   * Gets the credential information of FDS client
   */
  public GalaxyFDSCredential getCredential() {
    return credential;
  }

  /**
   * Sets the credential information of FDS client
   * NOTE: MUST set credential information before calling any method of Client
   */
  public void setCredential(GalaxyFDSCredential credential) {
    Args.notNull(credential, "credential");
    this.credential = credential;
  }

  /**
   * Sets the credential information of FDS client
   * NOTE: MUST set credential information before calling any method of Client
   * @return The updated FDSClientConfiguration object.
   */
  public FDSClientConfiguration withCredential(GalaxyFDSCredential credential) {
    setCredential(credential);
    return this;
  }

  public String getEndpoint() {
    return endpoint;
  }

  /**
   * Set the domain of target request
   * Used by internal uses.
   * @param endpoint
   */
  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  /**
   * Gets the base URI of FDS service
   */
  @Deprecated
  public String getFdsServiceBaseUri() {
    return getBaseUri();
  }

  /**
   * Sets the base URI of FDS service
   * NOTE: MUST set FDS service base URI before calling any method of Client
   */
  @Deprecated
  public void setFdsServiceBaseUri(String fdsServiceBaseUri) {
  }

  /**
   * Sets the base URI of FDS service
   * NOTE: MUST set FDS service base URI before calling any method of Client
   * @return The updated FDSClientConfiguration object.
   */
  @Deprecated
  public FDSClientConfiguration withFdsServiceBaseUri(String fdsServiceBaseUri) {
    return this;
  }

  /**
   * Gets the base URI of CDN service
   */
  @Deprecated
  public String getCdnServiceBaseUri() {
    return getCdnBaseUri();
  }

  /**
   * Sets the base URI of CDN service
   */
  @Deprecated
  public void setCdnServiceBaseUri(String cdnServiceBaseUri) {
  }

  /**
   * Sets the base URI of CDN service
   * @return The updated FDSClientConfiguration object.
   */
  @Deprecated
  public FDSClientConfiguration withCdnServiceBaseUri(String cdnServiceBaseUri) {
    return this;
  }

  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }

  public FDSClientConfiguration withRegionName(String regionName) {
    setRegionName(regionName);
    return this;
  }

  public boolean isHttpsEnabled() {
    return enableHttps;
  }

  public void enableHttps(boolean enableHttps) {
    this.enableHttps = enableHttps;
  }

  public FDSClientConfiguration withHttps(boolean enableHttps) {
    enableHttps(enableHttps);
    return this;
  }

  public boolean isCdnEnabledForUpload() {
    return enableCdnForUpload;
  }

  public void enableCdnForUpload(boolean enableCdnForUpload) {
    this.enableCdnForUpload = enableCdnForUpload;
  }

  public FDSClientConfiguration withCdnForUpload(boolean enableCdnForUpload) {
    enableCdnForUpload(enableCdnForUpload);
    return this;
  }

  public boolean isCdnEnabledForDownload() {
    return enableCdnForDownload;
  }

  public void enableCdnForDownload(boolean enableCdnForDownload) {
    this.enableCdnForDownload = enableCdnForDownload;
  }

  public FDSClientConfiguration withCdnForDownload(
      boolean enableCdnForDownload) {
    enableCdnForDownload(enableCdnForDownload);
    return this;
  }

  boolean isEnabledUnitTestMode() {
    return enableUnitTestMode;
  }

  void enableUnitTestMode(boolean enableUnitTestMode) {
    this.enableUnitTestMode = enableUnitTestMode;
  }

  FDSClientConfiguration withUnitTestMode(boolean enableUnitTestMode) {
    enableUnitTestMode(enableUnitTestMode);
    return this;
  }

  String getBaseUriForUnitTest() {
    return this.baseUriForUnitTest;
  }

  void setBaseUriForUnitTest(String baseUriForUnitTest) {
    this.baseUriForUnitTest = baseUriForUnitTest;
  }

  FDSClientConfiguration withBaseUriForUnitTest(String baseUriForUnitTest) {
    setBaseUriForUnitTest(baseUriForUnitTest);
    return this;
  }

  String getBaseUri() {
    return buildBaseUri(false);
  }

  String getCdnBaseUri() {
    return buildBaseUri(true);
  }

  String getDownloadBaseUri() {
    return buildBaseUri(enableCdnForDownload);
  }

  String getUploadBaseUri() {
    return buildBaseUri(enableCdnForUpload);
  }

  String buildBaseUri(boolean enableCdn) {
    if (enableUnitTestMode) {
      return baseUriForUnitTest;
    }

    StringBuilder sb = new StringBuilder();
    sb.append(enableHttps ? URI_HTTPS_PREFIX : URI_HTTP_PREFIX);

    if (this.endpoint != null && !this.endpoint.isEmpty()) {
      sb.append(this.endpoint);
    } else if (enableCdn) {
      sb.append(URI_CDN + "." + regionName + "." + URI_CDN_SUFFIX);
    } else {
      sb.append(regionName + "." + URI_SUFFIX);
    }
    return sb.toString();
  }
}
