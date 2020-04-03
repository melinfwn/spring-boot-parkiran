package com.lawencon.parkiranboot.repo.hibernate.kendaraan;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.parkiranboot.model.Kendaraan;
import com.lawencon.parkiranboot.repo.hibernate.BaseHibernate;

@Repository("kendaraan_repo_hibernate")
public class KendaraanHibernateImpl extends BaseHibernate implements KendaraanHibernate {

	@Override
	public Kendaraan checkIn(Kendaraan kendaraan) throws Exception {
		kendaraan.setStatus("Check In");
		kendaraan.setTglIn(LocalDate.now());
		em.persist(kendaraan);
		return kendaraan;
	}

	@Override
	public Boolean validNomor(Kendaraan kendaraan) throws Exception {
		Kendaraan k = null;
		Query q = em.createQuery("from Kendaraan where noPol = :noParam");
		q.setParameter("noParam", kendaraan.getNoPol());
		try {
			k = (Kendaraan) q.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (k != null) {
			if (k.getNoPol().replaceAll("\\s+", "").substring(0, 1).equalsIgnoreCase("B")) {
				try {
					Integer.parseInt(kendaraan.getNoPol().substring(1, 5));
					if (kendaraan.getNoPol().substring(1, 5).length() <= 4
							&& kendaraan.getNoPol().substring(1, 5).length() >= 1) {
						try {
							Integer.parseInt(kendaraan.getNoPol().substring(5, 8));
							return false;
						} catch (Exception e) {
							if (k.getNoPol().equalsIgnoreCase(kendaraan.getNoPol())
									&& k.getTglIn().equals(kendaraan.getTglIn())) {
								return false;
							} else {
								return true;
							}
						}
					} else
						return false;
				} catch (Exception e) {
					return false;
				}
			} else
				return false;
		}
		return false;
	}

	@Override
	public Kendaraan checkOut(Long id) throws Exception {
		Query q = em.createQuery(" from Kendaraan where id = :idParam");
		q.setParameter("idParam", id);
		Kendaraan k = new Kendaraan();
		k = (Kendaraan) q.getSingleResult();
		k.setStatus("Check Out");
		k.setTglOut(LocalDate.now());
		em.merge(k);
		return k;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kendaraan> showCheckIn() throws Exception {
		Query q = em.createQuery(" from Kendaraan");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kendaraan> showCheckOut() throws Exception {
		Query q = em.createQuery(" from Kendaraan where status = :idParam");
		q.setParameter("idParam", "Check Out");
		return q.getResultList();
	}
//	

	@SuppressWarnings("unchecked")
	@Override
	public List<Kendaraan> showByJenis(String jenis) throws Exception {
		Query q = em.createQuery(" from Kendaraan where jenisKendaraan = :idParam");
		q.setParameter("idParam", jenis);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kendaraan> findById(Long id) throws Exception {
		Query q = em.createQuery(" from Kendaraan where id = :idParam");
		q.setParameter("idParam", id);
		return q.getResultList();
	}

	@Override
	public void delete(Long id) throws Exception {
		Query q = em.createQuery(" from Kendaraan where id = :idParam");
		q.setParameter("idParam", id);
		Kendaraan m = new Kendaraan();
		m = (Kendaraan) q.getSingleResult();
		em.remove(m);

	}

}
