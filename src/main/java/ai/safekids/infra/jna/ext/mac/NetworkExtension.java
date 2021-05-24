package ai.safekids.infra.jna.ext.mac;

import com.sun.jna.Native;
import com.sun.jna.Library;

public interface NetworkExtension extends Library {
    NetworkExtension INSTANCE = Native.load("NetworkExtension", NetworkExtension.class);
}
