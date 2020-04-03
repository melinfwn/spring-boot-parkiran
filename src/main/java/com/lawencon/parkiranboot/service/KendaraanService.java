package com.lawencon.parkiranboot.service;

import java.util.List;

import com.lawencon.parkiranboot.model.Kendaraan;
import com.lawencon.parkiranboot.model.UserLogin;

public interface KendaraanService {
	abstract Kendaraan checkIn(Kendaraan kendaraan, String username, String password) throws Exception;
	abstract Kendaraan checkOut(Long id, String username, String password) throws Exception;
	abstract List<Kendaraan> showCheckIn(String username, String password) throws Exception;
	abstract List<Kendaraan> showCheckOut(String username, String password) throws Exception;
	abstract List<Kendaraan> showByJenis(String jenis, String username, String password) throws Exception;
	abstract List<Kendaraan> findById(Long id, String username, String password) throws Exception;
	abstract String delete(Long id, String username, String password) throws Exception;
	abstract Boolean validNomor(Kendaraan kendaraan) throws Exception;
}
