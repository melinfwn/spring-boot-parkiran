package com.lawencon.parkiranboot.repo.jpa.kendaraan;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lawencon.parkiranboot.model.Kendaraan;

@Repository
public interface KendaraanRepo extends JpaRepository<Kendaraan, Long> {
	List<Kendaraan> findByStatus(String status);

	List<Kendaraan> findAllById(Long id);

	List<Kendaraan> findByJenisKendaraan(String jenisKendaraan);

	List<Kendaraan> findByTglOut(LocalDate tglOut);

}
