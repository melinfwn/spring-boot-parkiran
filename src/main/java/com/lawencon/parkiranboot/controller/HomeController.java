package com.lawencon.parkiranboot.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.parkiranboot.model.Kendaraan;
import com.lawencon.parkiranboot.model.UserLogin;
import com.lawencon.parkiranboot.service.KendaraanService;
import com.lawencon.parkiranboot.service.UserService;

@RestController
public class HomeController extends BaseController {

	@Autowired
	private KendaraanService kendaraanService;

	@Autowired
	private UserService userService;
	
	@PostMapping("/home/checkin")
	public ResponseEntity<Kendaraan> CheckIn(@RequestBody String content, @RequestHeader("Authorization") String authorization) {
		Kendaraan k = new Kendaraan();
		try {
			k = new ObjectMapper().readValue(content, Kendaraan.class);
			String[] auth = super.authUser(authorization);
			kendaraanService.checkIn(k, auth[0], auth[1]);
			return new ResponseEntity<>(k, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(k, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/home/checkout")
	public ResponseEntity<String> checkOut(@RequestParam("id") Long id, @RequestHeader("Authorization") String authorization) {
		try {
			String[] auth = super.authUser(authorization);
			kendaraanService.checkOut(id, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal.", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/home/getjenis")
	public ResponseEntity<List<Kendaraan>> getJenis(@RequestParam("jenisKendaraan") String jenisKendaraan,
			@RequestHeader("Authorization") String authorization) {
		List<Kendaraan> list = new ArrayList<Kendaraan>();
		try {
			String[] auth = super.authUser(authorization);
			list = kendaraanService.showByJenis(jenisKendaraan, auth[0], auth[1]);
			return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/home/getid")
	public ResponseEntity<List<Kendaraan>> getById(@RequestParam("id") Long id,
			@RequestHeader("Authorization") String authorization) {
		List<Kendaraan> list = new ArrayList<Kendaraan>();
		try {
			String[] auth = super.authUser(authorization);
			list = kendaraanService.findById(id, auth[0], auth[1]);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/home/listin")
	public ResponseEntity<?> showCheckIn(@RequestHeader("Authorization") String authorization) {
		List<Kendaraan> listCheckIn = new ArrayList<Kendaraan>();
		try {
			String[] auth = super.authUser(authorization);
			listCheckIn = kendaraanService.showCheckIn(auth[0], auth[1]);
			return new ResponseEntity<>(listCheckIn, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listCheckIn, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/home/listout")
	public ResponseEntity<List<Kendaraan>> showCheckOut(@RequestHeader("Authorization") String authorization) {
		List<Kendaraan> listCheckOut = new ArrayList<Kendaraan>();
		try {
			String[] auth = super.authUser(authorization);
			listCheckOut = kendaraanService.showCheckOut(auth[0], auth[1]);
			return new ResponseEntity<>(listCheckOut, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listCheckOut, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/home/delete")
	public ResponseEntity<String> delete(@RequestParam("id") Long id, @RequestHeader("Authorization") String authorization) {
		try {
			String[] auth = super.authUser(authorization);
			kendaraanService.delete(id, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Gagal.", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/home/user")
	public ResponseEntity<List<UserLogin>> showUser(@RequestHeader("Authorization") String authorization) {
		List<UserLogin> list = new ArrayList<UserLogin>();
		try {
			String[] auth = super.authUser(authorization);
			userService.findByUsernamePassword(auth[0], auth[1]);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}

}
