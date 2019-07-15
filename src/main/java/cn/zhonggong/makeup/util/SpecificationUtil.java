package cn.zhonggong.makeup.util;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class SpecificationUtil<T> {

	private String search;

	public SpecificationUtil() {

	}

	public SpecificationUtil(String search) {
		this.search = search;
	}

	@SuppressWarnings("serial")
	public Specification<T> getSpe(String[] ints, String... strings) {
		return new Specification<T>() {
			@SuppressWarnings("deprecation")
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<Predicate>();
				// 按int属性查询
				if (NumberUtils.isNumber(search) && search.length() < 10) {
					for (String is : ints) {
						Path<Integer> $name = root.get(is);
						Predicate _name = criteriaBuilder.equal($name, Integer.valueOf(search));
						predicates.add(_name);
					}
				}
				// String属性
				for (String s : strings) {
					Path<String> $name = root.get(s);
					Predicate _name = criteriaBuilder.like($name, "%" + search + "%");
					predicates.add(_name);
				}
				return criteriaBuilder.or(predicates.toArray(new Predicate[] {}));
			}
		};
	}
}
