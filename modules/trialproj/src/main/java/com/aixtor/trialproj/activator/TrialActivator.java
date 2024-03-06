package com.aixtor.trialproj.activator;

import com.aixtor.trialproj.constants.TrialprojPortletKeys;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrialActivator implements BundleActivator{

	@Override
	public void start(BundleContext context) throws Exception {
		printer("Start");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		printer("Stop");
	}
	
	
	
	
	//	prints the logs to output text file based on action
	
	public void printer(String action){
	    String message = action + TrialprojPortletKeys.METHODCALL;
	    LocalDateTime currentDateTime = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String formattedDateTime = currentDateTime.format(formatter);
	    String fileName = "D:/logs/bundlelogs.txt";
	        try {
	        FileWriter writer = new FileWriter(fileName);
	        writer.write(message + formattedDateTime);
	        writer.close();
	        System.out.println(action + " method called.");
	    } catch (Exception e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
	}
	
	

}
