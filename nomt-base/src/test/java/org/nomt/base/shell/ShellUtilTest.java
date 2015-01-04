package org.nomt.base.shell;

import static org.junit.Assert.assertEquals;

public class ShellUtilTest
{

    public void testPing()
    {
        assertEquals(true, ShellUtil.getInstance().ping("127.0.0.1"));
    }

}
