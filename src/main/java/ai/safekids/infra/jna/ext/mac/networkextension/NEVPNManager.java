package ai.safekids.infra.jna.ext.mac.networkextension;

import ai.safekids.infra.jna.ext.mac.data.NSArrayRef;
import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import com.sun.jna.Callback;
import org.rococoa.Rococoa;
import org.rococoa.cocoa.foundation.NSObject;
import org.rococoa.ObjCClass;

public abstract class NEVPNManager extends NSObject {
    public static final _Class CLASS = Rococoa.createClass("NEVPNManager", _Class.class);

    public interface LoadFromPreferencesCompletionHandler extends Callback {
        void invoke(NSErrorRef error);
    }

    public interface _Class extends ObjCClass {
        NEVPNManager sharedManager();
    }

    static public final NEVPNManager sharedManager = NEVPNManager.CLASS.sharedManager();

    static public NEVPNManager sharedManager() {
        return sharedManager;
    }

    public abstract void loadFromPreferencesWithCompletionHandler(LoadFromPreferencesCompletionHandler completionHandler);
}
