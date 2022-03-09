package com.example.Watchmenlog.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "report_log")
public class Report {

	@Id
	@Column(name="log_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lid;
	@Column(name="so_id")
	private int sid;
	@Column(name="so_name")
	private String name;
	private Date date;
	private Time time;
	private String report;
	
	
	
	public Report() {}
	
	
	public Report(int log_id, int so_id, String so_name, Date date, Time time, String report) {
		super();
		this.lid = log_id;
		this.sid = so_id;
		this.name = so_name;
		this.date = date;
		this.time = time;
		this.report = report;
	}

	public int getLog_id() {
		return lid;
	}

	public void setLog_id(int log_id) {
		this.lid = log_id;
	}

	public int getSo_id() {
		return sid;
	}

	public void setSo_id(int so_id) {
		this.sid = so_id;
	}

	public String getSo_name() {
		return name;
	}

	public void setSo_name(String so_name) {
		this.name = so_name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
	
	
	
	
	
}
