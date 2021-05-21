package ai.safekids.infra.jna.ext.mac.networkextension;

import org.rococoa.Rococoa;
import org.rococoa.cocoa.foundation.NSObject;
import org.rococoa.ObjCClass;

public abstract class NEVPNManager extends NSObject {
    public static final _Class CLASS = Rococoa.createClass("NEVPNManager", _Class.class);

    public interface _Class extends ObjCClass {
        NEVPNManager sharedManager();
    }

    static public final NEVPNManager sharedManager = NEVPNManager.CLASS.sharedManager();

    static public NEVPNManager sharedManager() {
        return sharedManager;
    }
}
