package ai.safekids.infra.jna.ext.mac;

import ai.safekids.infra.jna.ext.mac.data.CFErrorRef;
import com.sun.jna.Callback;
import com.sun.jna.Native;
import com.sun.jna.platform.mac.CoreFoundation.CFArrayRef;

public class NetworkExtensionEx {
    public static class NEVPNManager{

    }

    public static class NETunnelProviderManager extends NEVPNManager {
        interface LoadAllFromPreferencesCompletionHandler extends Callback {
            void invoke(CFArrayRef managers, CFErrorRef error);
        }

        public static native void loadAllFromPreferencesWithCompletionHandler(LoadAllFromPreferencesCompletionHandler completionHandler);

        static {
            Native.register("NetworkExtension");
        }
    }
}

