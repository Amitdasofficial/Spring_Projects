package org.jsp.hibernatetemplatedemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.jsp.hibernatetemplatedemo.dto.Merchant;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class MerchantDao {
	HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public Merchant saveMerchant(Merchant merchant) {
		template.save(merchant);
		return merchant;
	}

	@Transactional
	public Merchant updateMerchant(Merchant merchant) {
		template.update(merchant);
		return merchant;
	}

	@Transactional
	public boolean deleteMerchant(int id) {
		Merchant merchant = findById(id);
		if (merchant != null) {
			template.delete(merchant);
			return true;
		}
		return false;
	}

	public Merchant findById(int id) {
		return template.get(Merchant.class, id);
	}
	public List<Merchant> findAll()
	{
		return template.loadAll(Merchant.class);
	}
}
