package ai.safekids.infra.jna.ext.mac;

import ai.safekids.infra.jna.ext.mac.data.NSArrayRef;
import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import ai.safekids.infra.jna.ext.mac.networkextension.NETunnelProviderManager;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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

    static {
        @SuppressWarnings("unused")
        NetworkExtension NE = NetworkExtension.INSTANCE;
    }

    @EnabledOnOs({MAC})
    public void testSharedManager() throws Exception {
        NEVPNManager.sharedManager();

        Assert.assertTrue(true);

    }

    @EnabledOnOs({MAC})
    public void testLoadPreferences() throws Exception {
        NEVPNManager manager = NEVPNManager.sharedManager();

        NEVPNManager.LoadFromPreferencesCompletionHandler completionHandler = new NEVPNManager.LoadFromPreferencesCompletionHandler() {
            @Override
            public void invoke(NSErrorRef error) {
                Assert.assertEquals(true, true);
            }
        };

        manager.loadFromPreferencesWithCompletionHandler(completionHandler);

        Assert.assertTrue(true);

    }
}