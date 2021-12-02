package de.hfu.osse;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class UtilTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        for(int i = 1; i <= 7; i++)
        assertTrue( Util.istErstesHalbjahr(i) );
    }
    @Test
    public void shouldAnswerWithFalse(){
        for(int i = 8; i<=12; ++i)
        assertFalse(Util.istErstesHalbjahr(i));
    }
    @Test
    public void shouldThrowException(){
        try{
            Util.istErstesHalbjahr(13);
            fail("Should have thrown Exception");
        }catch (Exception e){}
    }
}
