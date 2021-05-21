package ai.safekids.infra.jna.ext.mac;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.rococoa.ID;
import org.junit.Assert;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.MAC;
import ai.safekids.infra.jna.ext.mac.networkextension.NEVPNManager;

public class NEVPNManagerTest extends TestCase{

    public NEVPNManagerTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( NEVPNManagerTest.class );
    }

    @EnabledOnOs({MAC})
    public void testSharedManager() throws Exception {
        ID manager = NetworkExtension.getClass("NEVPNManger");

        NEVPNManager.sharedManager();

        Assert.assertTrue(true);

    }
}