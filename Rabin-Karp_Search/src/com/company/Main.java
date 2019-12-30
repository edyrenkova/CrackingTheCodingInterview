package com.company;

public class Main {

    public static void main(String[] args) {

    }

    /***
     * Efficiently finds a pattern in a String
     * @param pattern
     * @param text
     * @return index where pattern was found or -1 if not found
     */
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
                //hashsum = window.hashCode(); 
                hashsum=(hashsum-text.charAt(i)*Math.pow(31,pattern.length()-1))*31+text.charAt(i+pattern.length());
            }
        }
        return -1;
    }

}
