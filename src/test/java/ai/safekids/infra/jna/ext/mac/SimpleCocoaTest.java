package ai.safekids.infra.jna.ext.mac;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Assert;
import org.junit.jupiter.api.condition.EnabledOnOs;
import static org.junit.jupiter.api.condition.OS.MAC;

import org.rococoa.ObjCClass;
import org.rococoa.Rococoa;
import org.rococoa.cocoa.foundation.NSObject;
import org.rococoa.cocoa.foundation.NSString;

public class SimpleCocoaTest extends TestCase{

    public static Test suite()
    {
        return new TestSuite( SimpleCocoaTest.class );
    }


    @EnabledOnOs({MAC})
    public void testSimple() throws Exception {
        NSMutableArray arr = NSMutableArray.CLASS.arrayWithCapacity(5);
        Assert.assertEquals(0, arr.count());

        NSString testString = NSString.stringWithString("Hello");
        arr.addObject(testString);

        Assert.assertEquals(1, arr.count());
    }


    public static abstract class NSMutableArray extends NSObject {
        public static final _Class CLASS = Rococoa.createClass("NSMutableArray", _Class.class);

        public interface _Class extends ObjCClass {
            NSMutableArray arrayWithCapacity(int numItems);
        }

        public abstract int count();
        public abstract void addObject(NSObject obj);
    }
}