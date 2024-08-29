package com.TicketBooking.Ticket.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TicketBooking.Ticket.Pojo.Cinema;
import com.TicketBooking.Ticket.Pojo.PVRAvailableShows;
import com.TicketBooking.Ticket.Pojo.PVRshow;
import com.TicketBooking.Ticket.Service.PvrService;

@RestController
@RequestMapping("/pvrApi")
public class PvrController {

	@Autowired
    PvrService pvrservice;
	
	@PostMapping("/addPVRDetails")
	public ResponseEntity<List<Cinema>> addCinemaDetails(@RequestBody List<Cinema> pvrcine)
	{
		List<Cinema> addPVRdetails = pvrservice.addCinemaDetails(pvrcine);
		return ResponseEntity.ok(addPVRdetails);
	}
	
	@GetMapping("/getpvrDetails")
	public ResponseEntity<List<Cinema>> cinemaDetails()
	{
		List<Cinema> cinemaDetails = pvrservice.cinemaDetails();
		return ResponseEntity.ok(cinemaDetails);
	}
	
	@PostMapping("/addShow")
	public ResponseEntity<List<PVRshow>> addcinemaShowTime(@RequestBody List<PVRshow> addShow)
	{
		List<PVRshow> addShowDetails = pvrservice.addcinemaShowTime(addShow);
		return ResponseEntity.ok(addShowDetails);
	}
	@GetMapping("/getCinemaShows/{Cinema}")
	public ResponseEntity<List<PVRshow>> getCinemashowtime(@PathVariable String Cinema)
	{
		List<PVRshow> getCinemaShows = pvrservice.getCinemashowtime(Cinema);
		return ResponseEntity.ok(getCinemaShows);
	}
	@GetMapping("/getShow/{showTime}")
	public ResponseEntity<List<PVRshow>> cinemaShowTime(@PathVariable String showTime)
	{
		List<PVRshow> showDetails = pvrservice.cinemaShowTime(showTime);
		return ResponseEntity.ok(showDetails);
	}

	//Movie Management Service
	
	@PostMapping("/addPVRShow")
	public ResponseEntity<List<PVRAvailableShows>> addMovieDetails(@RequestBody List<PVRAvailableShows> addshowDetails)
	{
		List<PVRAvailableShows> addPVRShows = pvrservice.addShowDetails(addshowDetails);
		return ResponseEntity.ok(addPVRShows);
	}
	
	@GetMapping("/availableMovies")
	public ResponseEntity<List<Map<String,Object>>> getMovieDetails()
	{
		List<Map<String,Object>>  getAvailableMovies = pvrservice.getMovieDetails();
		if(getAvailableMovies != null)
		{
			return ResponseEntity.ok(getAvailableMovies);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
	}
	
	
	
}
