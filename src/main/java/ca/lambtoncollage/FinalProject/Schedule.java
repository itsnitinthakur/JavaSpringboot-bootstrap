package ca.lambtoncollage.FinalProject;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Schedule {
	
	@Min(0)
	private Integer Schedule = 0;
	
	public void increment() {
		Schedule++;
	}

	@Autowired
	private ClientCache clientCache;
	
	//@Scheduled(fixedDelay=3000)
	public Integer clientCount() {
		increment();
		return Schedule;
	}
}
