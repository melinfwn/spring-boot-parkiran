package com.lawencon.parkiranboot.repo.jpa.kendaraan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.parkiranboot.model.Kendaraan;

@Repository("kendaraan_repo_jpa")
public class KendaraanJPAImpl implements KendaraanJPA {

	@Autowired
	KendaraanRepo kdRepo;

	@Override
	public Kendaraan checkIn(Kendaraan kendaraan) throws Exception {
		kendaraan.setStatus("Check In");
		kendaraan.setTglIn(LocalDate.now());
		kdRepo.save(kendaraan);
		return kendaraan;
	}

	@Override
	public List<Kendaraan> showCheckIn() throws Exception {
		return kdRepo.findAll();
	}

	@Override
	public List<Kendaraan> showCheckOut() throws Exception {
		return kdRepo.findByStatus("Check Out");
	}

	@Override
	public List<Kendaraan> showByJenis(String jenis) throws Exception {
		return kdRepo.findByJenisKendaraan(jenis);
	}

	@Override
	public List<Kendaraan> findById(Long id) throws Exception {
		return kdRepo.findAllById(id);
	}

	@Override
	public void delete(Long id) throws Exception {
		kdRepo.deleteById(id);

	}

	@Override
	public Kendaraan checkOut(Long id) throws Exception {
		List<Kendaraan> list = new ArrayList<Kendaraan>();
		list = kdRepo.findAllById(id);
		if (list.get(0).getNoPol() != null) {
			Kendaraan k = new Kendaraan();
			k.setJenisKendaraan(list.get(0).getJenisKendaraan());
			k.setNoPol(list.get(0).getNoPol());
			k.setStatus("Check Out");
			k.setTglIn(list.get(0).getTglIn());
			k.setTglOut(LocalDate.now());
			kdRepo.save(k);
			return k;
		}
		return null;
	}

}
