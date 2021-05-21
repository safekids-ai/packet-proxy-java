package ai.safekids.infra.jna.ext.mac;

import ai.safekids.app.AppTest;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.sun.jna.platform.mac.CoreFoundation;
import org.junit.Assert;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.MAC;
import ai.safekids.infra.jna.ext.mac.NetworkExtensionEx;
import ai.safekids.infra.jna.ext.mac.data.CFErrorRef;

public class NetworkExtensionExTest extends TestCase{

    public NetworkExtensionExTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( NetworkExtensionExTest.class );
    }

    @EnabledOnOs({ MAC})
    public void testLoadAllPreferences() throws Exception {
        NetworkExtensionEx.NETunnelProviderManager.LoadAllFromPreferencesCompletionHandler completionHandler = new NetworkExtensionEx.NETunnelProviderManager.LoadAllFromPreferencesCompletionHandler() {
            @Override
            public void invoke(CoreFoundation.CFArrayRef managers, CFErrorRef error) {
                Assert.assertEquals(true, true);
            }
        };

        NetworkExtensionEx.NETunnelProviderManager.loadAllFromPreferencesWithCompletionHandler(completionHandler);
    }
}