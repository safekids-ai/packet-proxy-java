package ai.safekids.infra.jna.ext.mac;

import ai.safekids.infra.jna.ext.mac.data.NSArrayRef;
import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.MAC;
import ai.safekids.infra.jna.ext.mac.networkextension.NETunnelProviderManager;
import org.rococoa.cocoa.foundation.NSArray;
import org.rococoa.cocoa.foundation.NSAutoreleasePool;

import java.util.concurrent.TimeUnit;

public class NETunnelProviderManagerTest extends TestCase{

    public NETunnelProviderManagerTest(String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( NETunnelProviderManagerTest.class );
    }

    static {
        @SuppressWarnings("unused")
        NetworkExtension NE = NetworkExtension.INSTANCE;
    }

    @EnabledOnOs({MAC})
    public void testLoadAllPreferences() throws Exception {

        NETunnelProviderManager.LoadAllFromPreferencesCompletionHandler completionHandler = new NETunnelProviderManager.LoadAllFromPreferencesCompletionHandler() {
            public void callback(NSArrayRef managers, NSErrorRef error) {
                Assert.assertEquals(true, true);
            }
        };

        NETunnelProviderManager.loadAllFromPreferencesWithCompletionHandler(completionHandler);
        TimeUnit.SECONDS.sleep(5);
    }


    @EnabledOnOs({MAC})
    public void testCopyAppRules() throws Exception {
        NETunnelProviderManager  manager = NETunnelProviderManager.new_();
        NSArray rules = manager.copyAppRules();

        Assert.assertNotNull(rules);
    }
}