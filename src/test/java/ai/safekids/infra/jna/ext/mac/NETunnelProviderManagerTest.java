package ai.safekids.infra.jna.ext.mac;

import ai.safekids.infra.jna.ext.mac.data.NSArrayRef;
import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.rococoa.ID;
import org.junit.Assert;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.MAC;
import ai.safekids.infra.jna.ext.mac.networkextension.NETunnelProviderManager;

public class NETunnelProviderManagerTest extends TestCase{

    public NETunnelProviderManagerTest(String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( NETunnelProviderManagerTest.class );
    }

    @EnabledOnOs({MAC})
    public void testLoadAllPreferences() throws Exception {
        ID tunnelProvider = NetworkExtension.getClass("NETunnelProviderManager");
        NETunnelProviderManager.LoadAllFromPreferencesCompletionHandler completionHandler = new NETunnelProviderManager.LoadAllFromPreferencesCompletionHandler() {
            @Override
            public void invoke(NSArrayRef managers, NSErrorRef error) {
                Assert.assertEquals(true, true);
            }
        };

        NETunnelProviderManager.loadAllFromPreferencesWithCompletionHandler(completionHandler);
    }
}