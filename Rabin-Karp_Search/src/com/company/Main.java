package com.company;
import org.junit.Test;
import static org.junit.Assert.*;
public class Main {

    public static void main(String[] args) {

    }

    public static int Rabin_Karp(String pattern, String text){
        int pattern_hash=pattern.hashCode();
        String window=text.substring(0,pattern.length());
        double hashsum=window.hashCode();
        for(int i=0;i<=text.length()-pattern.length();i++){
            if(hashsum==pattern_hash && pattern.equals(window)){
                return i;
            }
            //TODO: fix this if statement (change the for loop)
            if(i!=text.length()-pattern.length()) {
                window = text.substring(i + 1, i + pattern.length() + 1);
                //hashsum = window.hashCode(); ~calculating hash is O(p), p - pattern size
                hashsum=(hashsum-text.charAt(i)*Math.pow(31,pattern.length()-1))*31+text.charAt(i+pattern.length()); //
            }
        }
        return -1;
    }
    private static final String[] texts={"doe are hearing me","doe are hparing ear", "doe are hparing ea"};
    private static final String[] patterns = {"ear", "ear", "ear"};
    private static final int[]results = {9,16,-1};

    @Test
    public void testRabinKarp(){
        for(int i=0;i<texts.length;i++){
            assertEquals("Pattern is not found correctly", results[i], Rabin_Karp(patterns[i],texts[i]));
        }
    }
}
