package com.teamnet.examples;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

/**
 * Created by Claudiu.Brandabur on 10-Jul-17.
 */
public class MyUnitTest {

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one","two");

        assertEquals("onetwo",result);
    }

    @Test
    public void testConcatenateNulls() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one",null);

        assertEquals("one",result);
    }

    @Test
    public void testGetBoolean() {
        MyUnit myUnit = new MyUnit();

        assertNotNull(myUnit.getBoolean());

        assertTrue(myUnit.getBoolean() instanceof Boolean);

        assertThat(123, is(123));
        assertThat("a", not(is("b")));
    }


}
