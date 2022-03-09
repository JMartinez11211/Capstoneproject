package com.example.Watchmenlog.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Watchmenlog.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report,Integer>{

	List <Report> findByName(String so_name);

	List<Report> findByDate(Date date);

	Optional<Report> findByLid(int log_id);
}
