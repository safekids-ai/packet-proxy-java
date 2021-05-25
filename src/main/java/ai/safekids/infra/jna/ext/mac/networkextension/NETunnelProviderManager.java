package ai.safekids.infra.jna.ext.mac.networkextension;

import ai.safekids.infra.jna.ext.mac.data.NSArrayRef;
import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import com.sun.jna.Callback;
import org.rococoa.Rococoa;
import org.rococoa.ObjCClass;
import org.rococoa.cocoa.foundation.NSArray;

public abstract class NETunnelProviderManager extends NEVPNManager {
    public static final _Class CLASS = Rococoa.createClass("NETunnelProviderManager", _Class.class);

    public interface LoadAllFromPreferencesCompletionHandler extends Callback {
        void callback(NSArrayRef managers, NSErrorRef error);
    }

    public static NETunnelProviderManager new_() {
        return Rococoa.create("NETunnelProviderManager", NETunnelProviderManager.class);
    }

    public interface _Class extends ObjCClass {
        void loadAllFromPreferencesWithCompletionHandler(LoadAllFromPreferencesCompletionHandler completionHandler);
    }

    public static void loadAllFromPreferencesWithCompletionHandler(LoadAllFromPreferencesCompletionHandler completionHandler) {
        CLASS.loadAllFromPreferencesWithCompletionHandler(completionHandler);
    }

    public abstract NSArray copyAppRules();
}
