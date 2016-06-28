package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConfigDao;
import domain.User;
import domain.valueo.Communication;
import domain.valueo.Technology;
import domain.valueo.UserID;
import domain.valueo.Work;

public class ConfigService extends Service{

	private ConfigDao cdao;

	@Override
	void prePare() {
		this.cdao = new ConfigDao(this.con);
	}

	/* 研修の目標1を取得するメソッド */
	public Communication trainGoal1Select(User user){
		Communication communication = null;
		try{
			communication = cdao.getTrain1Goal(user);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return communication;
	}

	/* 研修の目標2を取得するメソッド */
	public Work trainGoal2Select(User user){
		Work work = null;
		try{
			work = cdao.getTrain2Goal(user);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return work;
	}

	/* 研修の目標3を取得するメソッド */
	public Technology trainGoal3Select(User user){
		Technology technology = null;
		try{
			technology = cdao.getTrain3Goal(user);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return technology;
	}

	/* 研修の目標1を更新するメソッド */
	public void TrainGoal1Update(UserID userID, Communication commu){
		try{
			cdao.updateTrainGoal1(userID, commu);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	/* 研修の目標2を更新するメソッド */
	public void TrainGoal2Update(UserID userID, Work work_p){

		try{
			cdao.updateTrainGoal2(userID, work_p);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	/* 研修の目標3を更新するメソッド */
	public void TrainGoal3Update(UserID userID, Technology technology_p){
		try{
			cdao.updateTrainGoal3(userID, technology_p);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	/* 研修の目標3つとも取得するメソッド */
	public List<User> trainGoalSelect(UserID userID){
		List<User> userList = new ArrayList<User>();
		try{
			userList = cdao.getTrainGoal(userID);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return userList;
	}
}
