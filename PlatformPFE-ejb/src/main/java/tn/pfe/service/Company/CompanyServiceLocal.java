package tn.pfe.service.Company;

import java.util.List;

import javax.ejb.Local;

import tn.pfe.entity.Company;

	@Local
	public interface CompanyServiceLocal {
	
		public List<Object> getRecrutedCompayByOrder(int site_id);
	
	}
