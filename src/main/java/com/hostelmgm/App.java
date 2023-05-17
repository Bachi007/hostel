package com.hostelmgm;

import org.apache.log4j.Logger;

import exception.globalException;

import java.util.*;
import serviceImpl.*;
/**
 * Hello world!
 *
 */
public class App 
{
	static Logger log=Logger.getLogger(App.class);
	static Scanner bs=new Scanner(System.in);
	static loginnregisterImpl ln=new loginnregisterImpl();
    public static void main( String[] args )throws globalException 
    {
        log.info( "\t\t\t\t\t*******Welcome to Hostel Management********" );
        
        log.info("\nPress 1 for Registration \nPress 2 for Login");
        int ch=bs.nextInt();
        switch(ch) {
        case 1-> ln.registration();
        case 2-> ln.login();
        }
    }
}
