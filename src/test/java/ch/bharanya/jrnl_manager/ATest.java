package ch.bharanya.jrnl_manager;

import ch.bharanya.jrnl_manager.conf.Config;
import org.junit.Before;

/**
 * Created by XMBomb on 28.12.2016.
 */
public abstract class ATest {
    @Before
    public void setTestMode(){
        Config.testMode = true;
    }
}
