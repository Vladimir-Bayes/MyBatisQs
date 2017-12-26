package org.fkit.test;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fkit.domain.User;


public class MyBatisTest {

	public static void main(String[] args) throws Exception {
		// ��ȡmybatis-config.xml�ļ�
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		// ��ʼ��mybatis������SqlSessionFactory���ʵ��
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);
		// ����Sessionʵ��
		SqlSession session = sqlSessionFactory.openSession();
		// ����User����
		User user = new User("admin", "��", 26);
		// ��������
		session.insert("org.fkit.mapper.UserMapper.save", user);
		// �ύ����
		session.commit();
		// �ر�Session
		session.close();
	}

}
