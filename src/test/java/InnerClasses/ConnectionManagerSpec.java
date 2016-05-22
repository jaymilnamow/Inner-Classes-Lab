package InnerClasses;

import static javafx.scene.input.KeyCode.M;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by jaymilnamow on 5/21/16.
 */
public class ConnectionManagerSpec {

    ConnectionManager testConnection;

    @Before
    public void initiate() {
        testConnection = new ConnectionManager(2);
        Connection testConnection1 = testConnection.getConnection("100.100.100.100", 55);
    }

    @Test
    public void getManagedConnectionTest(){
        Connection testConnection2 = testConnection.getConnection("200.200.200.200", "FTP");
        String expectedIP = "200.200.200.200";
        String actualIP = testConnection2.getIPAddress();
        assertEquals(expectedIP,actualIP);

        int expectedPort = 80;
        int actualPort = testConnection2.getPort();
        assertEquals(expectedPort,actualPort);

        String expectedProtocol = "FTP";
        String actualProtocol = testConnection2.getProtocol();
        assertEquals(expectedProtocol,actualProtocol);

        assertNull(testConnection.getConnection("300.300.300.300","TELNET"));
    }

    @Test
    public void petPortTest(){
        Connection testConnection3 = testConnection.getConnection("111.111.111.111", "SSH");
        testConnection3.close();
        String expectedIP = "IP Address has been closed.";
        String actualIP = testConnection3.getIPAddress();
        assertEquals(expectedIP,actualIP);

        int expectedPort = 0;
        int actualPort = testConnection3.getPort();
        assertEquals(expectedPort,actualPort);

        String expectedProtocol = "SSH";
        String actualProtocol = testConnection3.getProtocol();
        assertEquals(expectedProtocol,actualProtocol);

        assertNotNull(testConnection.getConnection("111.111.111.111", "SSH"));
    }






}
