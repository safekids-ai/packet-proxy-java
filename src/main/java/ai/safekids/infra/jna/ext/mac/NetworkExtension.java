package ai.safekids.infra.jna.ext.mac;

import ai.safekids.infra.jna.ext.mac.internal.NetworkExtensionLibrary;
import com.sun.jna.Native;
import org.rococoa.ID;

public abstract class NetworkExtension {

    private static final NetworkExtensionLibrary networkExtensionLibrary;

    static {
        networkExtensionLibrary = Native.load("NetworkExtension", NetworkExtensionLibrary.class);
    }

    private NetworkExtension() {
    }

    public static ID getClass(String className) {
        return networkExtensionLibrary.objc_getClass(className);
    }

}
