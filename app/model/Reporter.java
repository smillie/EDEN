package model;

import java.util.LinkedList;
import java.util.Queue;

import com.google.gson.annotations.Expose;


public class Reporter {
	
	
	private class Event {

		@Expose private String title;
		@Expose private String description;
		
		public Event(String title, String description) {
			this.title = title;
			this.description = description;
		}
		
	}

	@Expose private Queue<Event> events;
	
	private static Reporter reporterInstance;
	
	public static Reporter getInstance() {
		
		if (reporterInstance == null) {
			reporterInstance = new Reporter();
		}
		return reporterInstance;

	}
	
	private Reporter() {
		this.events = new LinkedList<>();
	}
	
	public void record(String title, String description) {
		this.events.add(new Event(title, description));
	}
	
	public void flush() {
		events.clear();
	}

}
