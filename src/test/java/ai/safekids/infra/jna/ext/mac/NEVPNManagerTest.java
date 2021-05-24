package ai.safekids.infra.jna.ext.mac;

import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Assert;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.MAC;
import ai.safekids.infra.jna.ext.mac.networkextension.NEVPNManagerOld;

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
        NEVPNManagerOld.sharedManager();

        Assert.assertTrue(true);

    }

    @EnabledOnOs({MAC})
    public void testLoadPreferences() throws Exception {
        NEVPNManagerOld manager = NEVPNManagerOld.sharedManager();


        NEVPNManagerOld.LoadFromPreferencesCompletionHandler completionHandler = new NEVPNManagerOld.LoadFromPreferencesCompletionHandler() {
            @Override
            public void invoke(NSErrorRef error) {
                Assert.assertEquals(true, true);
            }
        };

        manager.loadFromPreferencesWithCompletionHandler(completionHandler);

        Assert.assertTrue(true);

    }
}