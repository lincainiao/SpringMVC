package com.lin.dao;

import com.lin.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserMapperImpl implements UserMapper{
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> getUserList() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        return userList;
    }

    @Override
    public User getUser(Map<String, Object> map) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUser(map);
        return user;
    }

}
