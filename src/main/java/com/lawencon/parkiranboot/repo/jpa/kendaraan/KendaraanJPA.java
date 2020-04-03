package com.lawencon.parkiranboot.repo.jpa.kendaraan;

import java.util.List;
import com.lawencon.parkiranboot.model.Kendaraan;

public interface KendaraanJPA {
	abstract Kendaraan checkIn(Kendaraan kendaraan) throws Exception;

	abstract Kendaraan checkOut(Long id) throws Exception;

	abstract List<Kendaraan> showCheckIn() throws Exception;

	abstract List<Kendaraan> showCheckOut() throws Exception;

	abstract List<Kendaraan> showByJenis(String jenis) throws Exception;

	abstract List<Kendaraan> findById(Long id) throws Exception;

	abstract void delete(Long id) throws Exception;

}
