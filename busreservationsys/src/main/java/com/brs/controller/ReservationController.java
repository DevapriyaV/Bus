package com.brs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brs.entity.Reservation;
import com.brs.exceptions.ReservationNotFoundException;
import com.brs.service.IBusService;
import com.brs.service.IReservationService;

@Controller
@RequestMapping("rest/api")

public class ReservationController {

	@Autowired
	IReservationService reservationService;
	
	@Autowired
	IBusService customerService;
	
	
	
	@GetMapping("/reservations/{id}")
	public ResponseEntity<Reservation> viewReservation(@PathVariable("id") Long id) throws ReservationNotFoundException{
		return new ResponseEntity<Reservation>(reservationService.viewReservation(id),HttpStatus.OK);
	}
	
	
	
	@PostMapping("/reservations")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
		Reservation newVal = reservationService.addReservation(reservation);
		return new ResponseEntity<Reservation>(newVal,HttpStatus.OK);
	}
	
	@PutMapping("/reservations/update")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
		Reservation newVal = reservationService.updateReservation(reservation);
		return new ResponseEntity<Reservation>(newVal,HttpStatus.OK);
	}
	
	@GetMapping("/reservations")
	public ResponseEntity<List<Reservation>> viewAllReservation(){
		List<Reservation> lstReservation = reservationService.viewAllReservation();
		return new ResponseEntity<List<Reservation>>(lstReservation,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/reservations/{id}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Long id){
		Reservation deleted = reservationService.deleteReservation(id);
		return new ResponseEntity<Reservation>(deleted,HttpStatus.OK);
		
	}
	
}
