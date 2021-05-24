package ai.safekids.infra.jna.ext.mac.networkextension;

import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import com.sun.jna.Callback;
import org.rococoa.Rococoa;
import org.rococoa.cocoa.foundation.NSObject;
import org.rococoa.ObjCClass;

public abstract class NEVPNManagerOld extends NSObject {
    public static final _Class CLASS = Rococoa.createClass("NEVPNManager", _Class.class);

    public interface LoadFromPreferencesCompletionHandler extends Callback {
        void invoke(NSErrorRef error);
    }

    public interface _Class extends ObjCClass {
        NEVPNManagerOld sharedManager();
    }

    static public final NEVPNManagerOld sharedManager = NEVPNManagerOld.CLASS.sharedManager();

    static public NEVPNManagerOld sharedManager() {
        return sharedManager;
    }

    public abstract void loadFromPreferencesWithCompletionHandler(LoadFromPreferencesCompletionHandler completionHandler);
}
