package service;
import java.sql.SQLException;
import java.util.List;

import db.PointDao;
import domain.Point;
import domain.valueo.PointID;
import domain.valueo.UserID;

public class PointService extends Service {

	private PointDao pdao;

	@Override
	void prePare() {
		this.pdao = new PointDao(this.con);
	}


	// 指摘事項の読み込み
	public List<Point> getPoint(UserID userID) {
		List<Point> pointList;
		try {
			pointList = pdao.getPoint(userID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return pointList;
	}

	public void setPoint(UserID userID, domain.valueo.Point pointWrite) {
		// 指摘事項の保存
		try {
			pdao.setPoint(pointWrite, userID);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void deletePoint(UserID userID, PointID pointID) {
		// 指摘事項の削除
		try {
			pdao.deletePoint(userID, pointID);

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
