package com.webank.blockchain.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.webank.blockchain.domain.Block;
import com.webank.blockchain.domain.Record;
import com.webank.blockchain.mapping.IRecordMapper;
import com.webank.blockchain.util.MyBatisUtil;

/**
 * 区块数据访问
 *
 */
public class RecordDaoImpl implements RecordDao {

	/*
	public List<Block> getAllBlock() {
		//获得会话对象
		SqlSession session=MyBatisUtil.getSqlSession();
		
		try {
			//通过MyBatis实现接口BookTypeDAO，返回实例
			
			BlockDao blockDao=session.getMapper(BlockDao.class);
			return blockDao.getAllBlock();
		} finally {
			session.close();
		}
	}
	*/

	public Record getById(int id) {
		// TODO Auto-generated method stub
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        // 得到AdminInfoMapper接口的实现类对象，IAdminInfoMapper接口的实现类对象由sqlSession.getMapper(IAdminInfoMapper.class)动态构建出来
        IRecordMapper mapper = sqlSession.getMapper(IRecordMapper.class);
        Record record = mapper.getById(1);
        sqlSession.close();
        return record;
	}
 
    /*
    public void SelectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
        List<AdminInfo> bean = mapper.getAll();
        sqlSession.close();
 
        System.out.println(bean.size());
    }*/
 
	public void insert(Record record) {
		// TODO Auto-generated method stub
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IRecordMapper mapper = sqlSession.getMapper(IRecordMapper.class);
    	int result = mapper.add(record);
    	sqlSession.commit();
        sqlSession.close();
        //System.out.println(result);
	}
	
	
	public void insert(Record[] records) {
		// TODO Auto-generated method stub
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IRecordMapper mapper = sqlSession.getMapper(IRecordMapper.class);
        for (int i = 0; i < records.length; i++) {
        	int result = mapper.add(records[i]);
        	sqlSession.commit();
			
		}
        sqlSession.close();
        //System.out.println(result);
	}
 
    /* void Update() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
 
        AdminInfo bean = new AdminInfo();
        bean.setId(12);
        bean.setAdminName("Admin" + System.currentTimeMillis());
 
        int result = mapper.update(bean);
        sqlSession.commit();
        sqlSession.close();
 
        System.out.println(result);
    }
 

    public void Delete() {
 
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
 
        int result = mapper.deleteById(12);
        sqlSession.commit();
        sqlSession.close();
 
        System.out.println(result);
    }
    */
}
