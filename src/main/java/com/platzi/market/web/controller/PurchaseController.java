package com.platzi.market.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.service.PurchaseService;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@GetMapping("/all")
	public ResponseEntity<List<Purchase>> getAll() {
		return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
	}

	@GetMapping("customer/{id}")
	public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") String customerId) {

		return purchaseService.getByClient(customerId).map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@PostMapping("/save")
	public  ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
		return new ResponseEntity<>(purchaseService.save(purchase),HttpStatus.CREATED);
	}

}
