package com.user.demo.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.user.demo.DAO.UserActivityRepository;
import com.user.demo.model.Activity;

@Service
public class UserActivityDAOIRepositorympl implements UserActivityRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Boolean putActivitytoDB(Activity activity, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {

		try {
			KeyHolder holder = new GeneratedKeyHolder();

			final String sql = "insert into activity (id, user, activity, date, details,points) values(:id,:user,:activity,:date,:details,:points);";

			SqlParameterSource parameters = new MapSqlParameterSource().addValue("id", activity.getId())
					.addValue("user", activity.getUser()).addValue("activity", activity.getActivity())
					.addValue("date", activity.getDate()).addValue("details", activity.getDetails())
					.addValue("points", activity.getPoints());

			int output = namedParameterJdbcTemplate.update(sql, parameters, holder);

			if (output == 1) {
				return true;
			} else {
				return false;
			}
			/*
			 * try { final String sql =
			 * "insert into activity (id, user, activity, date, details,points) values(?,?,?,?,?,?);"
			 * ; int output = jdbcTemplate.update(sql,
			 * activity.getId(),activity.getActivity(), activity.getUser(),
			 * activity.getDate(), activity.getDetails(), activity.getPoints()); if (output
			 * == 1) { return true; } else { return false; } } catch (Exception e) { return
			 * false; }
			 */
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Boolean deleteActivityById(Long Id) {
		final String DELETE_SQL = "Delete from " + "activity" + " where " + "id" + " =\"" + Id + "\"";

		int out_delete = jdbcTemplate.update(DELETE_SQL);
		System.out.println("Delete status  " + out_delete);
		return true;
	}

}
