package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRabinKarp {
    private static final String[] texts={"doe are hearing me","doe are hparing ear", "doe are hparing ea"};
    private static final String[] patterns = {"ear", "ear", "ear"};
    private static final int[]results = {9,16,-1};

    @Test
    public void testRabinKarp(){
        for(int i=0;i<texts.length;i++){
            assertEquals("Pattern is not found correctly", results[i], Main.Rabin_Karp(patterns[i],texts[i]));
        }
    }

}
