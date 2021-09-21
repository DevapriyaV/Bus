package com.brs.controller;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.brs.entity.Bus;
import com.brs.exceptions.BusNotFoundException;
import com.brs.service.IBusService;


@RestController
@RequestMapping(path="/bus")

public class BusController {
	Logger log=Logger.getLogger("BusController");
	@Autowired
	private IBusService busservice;
	@PostMapping("addBus")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus){
		 log.info("bus added");
	     return new ResponseEntity<Bus>(busservice.addBus(bus),HttpStatus.OK);
	}	
	
	@PutMapping("updatebus")
	public ResponseEntity<Bus> updatebus(@RequestBody Bus bus) throws BusNotFoundException {
		return new ResponseEntity<Bus>(busservice.updateBus(bus), HttpStatus.OK);
	}
	
	@DeleteMapping("deletebus/{busid}")
	public ResponseEntity<Bus> deleteBus(@PathVariable("busid") int busId) throws BusNotFoundException{
		return new ResponseEntity<Bus>(busservice.deleteBus(busId),HttpStatus.OK);
		
	}
	
	@GetMapping("view/{busid}")
	public ResponseEntity<Bus> getBusById(@PathVariable("busid") int busId) throws BusNotFoundException{
		return new ResponseEntity<Bus>(busservice.viewBus(busId) , HttpStatus.OK);
	}
	
	@GetMapping("allbus")
	public ResponseEntity <List<Bus>>getAllBus(){
		return new ResponseEntity<List<Bus>>(busservice.viewAllBus(), HttpStatus.OK);
	}
}