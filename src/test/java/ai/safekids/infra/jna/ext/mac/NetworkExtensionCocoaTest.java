package ai.safekids.infra.jna.ext.mac;

import com.sun.jna.Pointer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.rococoa.ID;
import org.rococoa.ObjCClass;
import org.rococoa.ObjCObject;
import org.rococoa.Rococoa;
import org.rococoa.cocoa.foundation.NSObject;

import static org.junit.jupiter.api.condition.OS.MAC;

public class NetworkExtensionCocoaTest extends TestCase{

    public static Test suite()
    {
        return new TestSuite( NetworkExtensionCocoaTest.class );
    }


    @EnabledOnOs({MAC})
    public void testSimple() throws Exception {
        NetworkExtension networkExtension = NetworkExtension.INSTANCE;
        Assert.assertNotNull( "Network extension should not be null", networkExtension);

        NEVPNManager manager = NEVPNManager.CLASS.sharedManager();
        Assert.assertNotNull( "NEVPNManager class cannot be null", manager);

        //create a objective C object with proxy java bindings
        //however, the completion handler is a BLOCK and not sure
        //how the callback is supposed to work with this
        ObjCObject callback = Rococoa.proxy(new NEVPNManager.LoadFromPreferencesCompletionHandler_Delegate() {
            @Override
            public void callback(ID reference) {
                System.out.println("Callback");
            }
        });
        final ID delegate = callback.id();
        manager.loadFromPreferencesWithCompletionHandler(delegate);
    }


    public static abstract class NEVPNManager extends NSObject {
        public static final _Class CLASS = Rococoa.createClass("NEVPNManager", _Class.class);

        public interface LoadFromPreferencesCompletionHandler_Delegate {
            void callback(ID reference);
        }

        public interface _Class extends ObjCClass {
            public NEVPNManager sharedManager();
        }

        public abstract void loadFromPreferencesWithCompletionHandler(ID delegate);
    }
}