package ai.safekids.infra.jna.ext.mac.internal;

import com.sun.jna.Library;
import org.rococoa.ID;

/**
 * JNA Library for plain C calls, standard JNA marshalling applies to these
 */
public interface NetworkExtensionLibrary extends Library {
    ID objc_getClass(String className);
}
