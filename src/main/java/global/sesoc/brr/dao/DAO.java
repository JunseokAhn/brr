package global.sesoc.brr.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 개인?���? �??�� DB처리�? ?��?��
 */
@Repository
public class DAO {
	@Autowired
	private SqlSession session;
	
	

}
