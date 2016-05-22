package InnerClasses;

/**
 * Created by jaymilnamow on 5/21/16.
 */
public interface Connection {

    public String getProtocol();

    public void setIPAddress(String ipAddress);

    public void setPort(int port);

    public void setProtocol(String protocol);

    public String getIPAddress();

    public int getPort();

    public String connect();

    public void close();

}
