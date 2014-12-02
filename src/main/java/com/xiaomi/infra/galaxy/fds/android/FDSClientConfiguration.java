package com.xiaomi.infra.galaxy.fds.android;

import com.xiaomi.infra.galaxy.fds.android.auth.GalaxyFDSCredential;
import com.xiaomi.infra.galaxy.fds.android.util.Args;

public class FDSClientConfiguration {

  /**
   * The default uri for fds service base uri
   */
  public static final String DEFAULT_FDS_SERVICE_BASE_URI =
      "https://files.fds.api.xiaomi.com";

  /**
   * The default uri for cdn service uri
   */
  public static final String DEFAULT_CDN_SERVICE_URI =
      "https://cdns.fds.api.xiaomi.com";

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

  /**
   * The credential of FDS client
   */
  private GalaxyFDSCredential credential;

  /**
   * The base URI for FDS service
   */
  private String fdsServiceBaseUri = DEFAULT_FDS_SERVICE_BASE_URI;

  /**
   * The base URI for CDN service
   */
  private String cdnServiceBaseUri = DEFAULT_CDN_SERVICE_URI;

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

  private static String trimTailingSlash(String uri) {
    if (uri != null && !uri.isEmpty() && uri.charAt(uri.length() - 1) == '/') {
      uri = uri.substring(0, uri.length() - 1);
    }

    return uri;
  }

  /**
   * Gets the base URI of FDS service
   */
  public String getFdsServiceBaseUri() {
    return fdsServiceBaseUri;
  }

  /**
   * Sets the base URI of FDS service
   * NOTE: MUST set FDS service base URI before calling any method of Client
   */
  public void setFdsServiceBaseUri(String fdsServiceBaseUri) {
    Args.notNull(fdsServiceBaseUri, "FDS service base URI");
    Args.notEmpty(fdsServiceBaseUri, "FDS service base URI");
    this.fdsServiceBaseUri = trimTailingSlash(fdsServiceBaseUri);
  }

  /**
   * Sets the base URI of FDS service
   * NOTE: MUST set FDS service base URI before calling any method of Client
   * @return The updated FDSClientConfiguration object.
   */
  public FDSClientConfiguration withFdsServiceBaseUri(String fdsServiceBaseUri) {
    setFdsServiceBaseUri(fdsServiceBaseUri);
    return this;
  }

  /**
   * Gets the base URI of CDN service
   */
  public String getCdnServiceBaseUri() {
    return cdnServiceBaseUri;
  }

  /**
   * Sets the base URI of CDN service
   */
  public void setCdnServiceBaseUri(String cdnServiceBaseUri) {
    Args.notNull(cdnServiceBaseUri, "CDN service base URI");
    Args.notEmpty(cdnServiceBaseUri, "CDN service base URI");
    this.cdnServiceBaseUri = trimTailingSlash(cdnServiceBaseUri);
  }

  /**
   * Sets the base URI of CDN service
   * @return The updated FDSClientConfiguration object.
   */
  public FDSClientConfiguration withCdnServiceBaseUri(String cdnServiceBaseUri) {
    setCdnServiceBaseUri(cdnServiceBaseUri);
    return this;
  }
}