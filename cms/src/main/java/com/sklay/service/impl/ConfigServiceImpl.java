package com.sklay.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.sklay.dao.ConfigDao;
import com.sklay.model.Config;
import com.sklay.model.ConfigPK;
import com.sklay.service.ConfigService;
import com.sklay.core.util.JsonUtils;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	private ConfigDao configDao;

	@Override
	public Config findOne(ConfigPK cpk) {
		return configDao.findOne(cpk);
	}

	@Override
	public void save(Config config) {
		configDao.save(config);
	}

	@Override
	public Iterable<Config> findAll(List<ConfigPK> cpks) {
		return configDao.findAll(cpks);
	}

	@Override
	public Page<Config> findByBiz(Pageable pageable, final String biz,
			final Set<Integer> status) {
		return configDao.findAll(new Specification<Config>() {
			@Override
			public Predicate toPredicate(Root<Config> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<ConfigPK> idExp = root.get("id");
				List<Predicate> ps = new ArrayList<Predicate>();
				ps.add(cb.equal(idExp.get("biz"), biz));
				if (!CollectionUtils.isEmpty(status)) {
					ps.add(root.get("status").in(status));
				}
				return cb.and(ps.toArray(new Predicate[ps.size()]));
			}
		}, pageable);
	}

	@Override
	public <T> T findData(ConfigPK cpk, Class<T> clazz) {
		Config cfg = findOne(cpk);
		if (cfg == null || StringUtils.isEmpty(cfg.getData())) {
			return null;
		} else {
			return JsonUtils.toType(cfg.getData(), clazz);
		}
	}

	@Override
	public void save(ConfigPK cpk, Object data) {
		Config cfg = findOne(cpk);
		if (cfg == null) {
			cfg = new Config();
			cfg.setId(cpk);
		}
		cfg.setData(JsonUtils.toJSON(data));
		configDao.save(cfg);
	}

}
