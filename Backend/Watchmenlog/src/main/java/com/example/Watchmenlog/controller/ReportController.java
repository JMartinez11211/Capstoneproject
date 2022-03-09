package com.example.Watchmenlog.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Watchmenlog.exception.ResourceNotFoundException;
import com.example.Watchmenlog.model.Report;
import com.example.Watchmenlog.repository.ReportRepository;



@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class ReportController {

	@Autowired
	private ReportRepository reportRepo;
	
	// view all reports
	@GetMapping("/allreports")
	public List <Report> getAllReports(){
		
		return reportRepo.findAll();
		
	}
	
	//add a new report 
	@PostMapping("/addreport")
	public Report newReport(@RequestBody Report rp) {
		
		return reportRepo.save(rp);
		
	}
	
	//get by report log id number
	@GetMapping("/report/{log_id}")
	public ResponseEntity<Report> getReportByName(@PathVariable int log_id)
	{
		Report r= reportRepo.findByLid(log_id).orElseThrow(() ->  new ResourceNotFoundException("Report not found"));
		return ResponseEntity.ok(r);                 
	}
	
	//get by security officer name
	@GetMapping("/report/name/{so_name}")
	public List<Report> getReportByName(@PathVariable String so_name)
	{
		List <Report> report= reportRepo.findByName(so_name);
		if(report.isEmpty())
		{
			System.out.println(new ResourceNotFoundException("Reports from Security Officer "+ so_name +" not found"));
		}
		
		return reportRepo.findByName(so_name);              
	}
	
	//get by dates
	@GetMapping("/report/date/{date}")
	public List<Report> getReportBydate(@PathVariable Date date)
	{
		List <Report> report= reportRepo.findByDate(date);
		if(report.isEmpty())
		{
			System.out.println(new ResourceNotFoundException("No reports from "+ date +" found"));
		}
		
		return reportRepo.findByDate(date);                     
	}
	
	// update a report
	@PutMapping("/report/update/{log_id}")
	public ResponseEntity<Report> updateReport(@PathVariable int log_id, @RequestBody Report report)
	{
		Report r= reportRepo.findById(log_id).orElseThrow(() ->  new ResourceNotFoundException("Report not found"));
		r.setSo_name(report.getSo_name());
	    r.setDate(report.getDate());
	    r.setTime(report.getTime());
	    r.setReport(report.getReport());
	    Report updatedReport=reportRepo.save(r);
	    return ResponseEntity.ok(updatedReport);
	}
	
	
	
	// delete by report log id number
	@DeleteMapping("/report/{log_id}")
	public String deleteReport(@PathVariable int log_id)
	{
		reportRepo.findByLid(log_id).orElseThrow(() ->  new ResourceNotFoundException("Report not found"));
	    reportRepo.deleteById(log_id);
	    return "Report log: "+ log_id +" hasbeen removed from the database.";
	}
	
	
	
	
}
