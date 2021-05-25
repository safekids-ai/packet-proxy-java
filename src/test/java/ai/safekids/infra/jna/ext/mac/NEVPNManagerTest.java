package ai.safekids.infra.jna.ext.mac;

import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import ai.safekids.infra.jna.ext.mac.networkextension.NEVPNManager;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Assert;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.rococoa.cocoa.foundation.NSError;

import static org.junit.jupiter.api.condition.OS.MAC;

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
        NEVPNManager manager = NEVPNManager.new_();


        NEVPNManager.LoadFromPreferencesCompletionHandler completionHandler = new NEVPNManager.LoadFromPreferencesCompletionHandler() {
            @Override
            public void invoke(NSError error) {
                Assert.assertEquals(true, true);
            }
        };

        manager.loadFromPreferencesWithCompletionHandler(completionHandler);

        Assert.assertTrue(true);

    }
}