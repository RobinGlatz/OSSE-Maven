package de.hfu.osse;

import java.util.Scanner;

public class Upper 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println(in.nextLine().toUpperCase());
        in.close();
    }
}
