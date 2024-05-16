package com.user.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.user.demo.DAOImpl.UserActivityDAOIRepositorympl;
import com.user.demo.model.Activity;

@Service
public class UserActivityService {

	/*
	 * List<Activity> fetchStuydentlist();
	 * 
	 * Activity saveActivity(Activity activity); Activity updateActivity (Activity
	 * activity, Long activityid ); void deleteActivitybyId(Long activityid);
	 */

	@Autowired
	UserActivityDAOIRepositorympl userActivityDAOIRepositorympl;

	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		return userActivityDAOIRepositorympl.putActivitytoDB(activity,namedParameterJdbcTemplate);
	}

	
	public boolean deleteActivityById(Long Id) {
		return userActivityDAOIRepositorympl.deleteActivityById(Id);
	}
}
