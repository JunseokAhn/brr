package global.sesoc.brr.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.brr.mapper.GoogleMapsMapper;
import global.sesoc.brr.vo.LocationVO;
import global.sesoc.brr.vo.NearbyToiletVO;

@Repository
public class GoogleMapsDAO {

	@Autowired
	SqlSession session;

	public ArrayList<NearbyToiletVO> getNearbyToilet(LocationVO lo) {
		// TODO Auto-generated method stub
		GoogleMapsMapper mapper = session.getMapper(GoogleMapsMapper.class);
		ArrayList<NearbyToiletVO> list = mapper.getNearbyToilet(lo);
		return list;
	}
}
