package ai.safekids.infra.jna.ext.mac.networkextension;

import ai.safekids.infra.jna.ext.mac.data.NSArrayRef;
import ai.safekids.infra.jna.ext.mac.data.NSErrorRef;
import com.sun.jna.Callback;
import org.rococoa.Rococoa;
import org.rococoa.ObjCClass;

public abstract class NETunnelProviderManager extends NEVPNManager{
    public static final _Class CLASS = Rococoa.createClass("NETunnelProviderManager", _Class.class);

    public interface LoadAllFromPreferencesCompletionHandler extends Callback {
        void invoke(NSArrayRef managers, NSErrorRef error);
    }

    public interface _Class extends ObjCClass {
        NETunnelProviderManager loadAllFromPreferencesWithCompletionHandler(LoadAllFromPreferencesCompletionHandler completionHandler);
    }

    public static NETunnelProviderManager loadAllFromPreferencesWithCompletionHandler(LoadAllFromPreferencesCompletionHandler completionHandler) {
        return CLASS.loadAllFromPreferencesWithCompletionHandler(completionHandler);
    }
}
