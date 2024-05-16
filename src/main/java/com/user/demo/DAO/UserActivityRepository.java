package com.user.demo.DAO;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.user.demo.model.Activity;

@Repository
public interface UserActivityRepository  {
	
	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate);
	
	public Boolean deleteActivityById(Long Id);
}
