package InnerClasses;

/**
 * Created by jaymilnamow on 5/21/16.
 */
//Factory
public class ConnectionManager {

    private int amountOfConnections;
    private int maximumNumberOfConnections;

    public ConnectionManager(int maxConnect){
        this.maximumNumberOfConnections = maxConnect;
        amountOfConnections = 0;
    }

    public Connection getConnection(String iPAddress, int port){
        if(amountOfConnections < maximumNumberOfConnections){
            amountOfConnections++;
            return new ManagedConnection(iPAddress, port);
        }
        return null;
    }

    public Connection getConnection(String iPAddress, String protocol){
        if(protocol.equals("FTP")){
            if(amountOfConnections < maximumNumberOfConnections){
                amountOfConnections++;
                return new ManagedConnection(iPAddress, 80, protocol );
            }

        }
        else if(protocol.equals("TELNET")){
            if(amountOfConnections < maximumNumberOfConnections){
                amountOfConnections++;
                return new ManagedConnection(iPAddress, 20, protocol);
            }
        }
        else if(protocol.equals("SSH")){
            if(amountOfConnections < maximumNumberOfConnections){
                amountOfConnections++;
                return new ManagedConnection(iPAddress, 23, protocol);
            }
        }
        return null;
    }



    private class ManagedConnection implements Connection{

        private String iPAddress;
        private int port;
        private String protocol;
        private boolean connected;

        public ManagedConnection(String iPAddress, int port, String protocol){
            this.iPAddress = iPAddress;
            this.port = port;
            this.protocol = protocol;
            this.connected = true;
        }

        public ManagedConnection(String iPAddress, int port){
            this.iPAddress = iPAddress;
            this.port = port;
            protocol = "HTTP";
            this.connected = true;

        }

        public String connect(){
            if(connected){
                return "connected";
            }
            else{
                return "Error. Not Connected";
            }
        }

        public String getProtocol(){
            return protocol;
        }

        public String getIPAddress(){
            if(connected){
                return iPAddress;
            }
            return "IP Address has been closed.";
        }

        public int getPort(){
            if(connected){
                return port;
            }
            return 0;
        }

        public void setIPAddress(String iPAddress){
            this.iPAddress = iPAddress;
        }

        public void setPort(int port){
            this.port = port;
        }

        public void setProtocol(String protocol){
            this.protocol = protocol;
        }

        public void close(){
            amountOfConnections--;
            this.connected = false;

        }
    }

}
