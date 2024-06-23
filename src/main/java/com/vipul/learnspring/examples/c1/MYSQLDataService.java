package com.vipul.learnspring.examples.c1;

import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MYSQLDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] {1, 2, 3, 4, 5};
	}

}
