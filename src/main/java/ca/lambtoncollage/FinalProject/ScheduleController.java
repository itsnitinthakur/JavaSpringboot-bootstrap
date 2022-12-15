package ca.lambtoncollage.FinalProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class ScheduleController {

	@Autowired
	private Schedule schedule;
	
	@GetMapping("/totalcount")
	public Integer totalCount() {
		return schedule.getSchedule();
	}
}
