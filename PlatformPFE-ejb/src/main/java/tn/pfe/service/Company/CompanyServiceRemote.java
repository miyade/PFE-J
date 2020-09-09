package tn.pfe.service.Company;

import java.util.List;

import javax.ejb.Remote;

import tn.pfe.entity.Company;

@Remote
public interface CompanyServiceRemote {

	public List<Object> getRecrutedCompayByOrder(int site_id);
}
