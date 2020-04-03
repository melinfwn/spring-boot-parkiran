package com.lawencon.parkiranboot.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.lawencon.parkiranboot.model.Kendaraan;
import com.lawencon.parkiranboot.model.UserLogin;
import com.lawencon.parkiranboot.repo.hibernate.BaseHibernate;
import com.lawencon.parkiranboot.repo.hibernate.kendaraan.KendaraanHibernateImpl;
import com.lawencon.parkiranboot.repo.hibernate.userlogin.UserHibernateImpl;
import com.lawencon.parkiranboot.repo.jpa.kendaraan.KendaraanJPAImpl;
import com.lawencon.parkiranboot.repo.jpa.userlogin.UserLoginJPAImpl;

@Service
@Transactional
public class KendaraanServiceImpl extends BaseHibernate implements KendaraanService {

	@Autowired
	@Qualifier("kendaraan_repo_jpa")
	private KendaraanJPAImpl kendaraanService;

	@Autowired
	private UserLoginJPAImpl userService;

	@Override
	public Kendaraan checkIn(Kendaraan kendaraan, String username, String password) throws Exception {
		if (checkUser(username, password) == false) {
			return null;
		} else {
			return kendaraanService.checkIn(kendaraan);

		}
	}

	public Boolean checkUser(String username, String password) {
		List<UserLogin> list = new ArrayList<UserLogin>();
		list = userService.findByUsernamePassword(username, password);
		if (list.isEmpty()) {
			return false;
		} else
			return true;
	}

	@Override
	public Kendaraan checkOut(Long id, String username, String password) throws Exception {
		if (checkUser(username, password) == false) {
			return null;
		} else {
			return kendaraanService.checkOut(id);
		}
	}

	@Override
	public List<Kendaraan> showCheckIn(String username, String password) throws Exception {
		if (checkUser(username, password) == false) {
			return null;
		} else {
			return kendaraanService.showCheckIn();

		}
	}

	@Override
	public List<Kendaraan> showCheckOut(String username, String password) throws Exception {
		if (checkUser(username, password) == false) {
			return null;
		} else {
			return kendaraanService.showCheckOut();

		}
	}

	@Override
	public List<Kendaraan> showByJenis(String jenis, String username, String password) throws Exception {
		if (checkUser(username, password) == true) {
			kendaraanService.showByJenis(jenis);
			return kendaraanService.showByJenis(jenis);
		}
		return null;
	}

	@Override
	public List<Kendaraan> findById(Long id, String username, String password) throws Exception {
		if (checkUser(username, password) == false) {
			return null;
		} else {
			return kendaraanService.findById(id);

		}
	}

	@Override
	public String delete(Long id, String username, String password) throws Exception {
		if (checkUser(username, password) == false) {
			return "Gagal Hapus User tidak valid !";
		} else {
			kendaraanService.delete(id);
			return "Berhasil hapus";
		}

	}

}
