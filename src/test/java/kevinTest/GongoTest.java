/**
 * Project Name:OnlineParking
 * File Name:GongoTest.java
 * Package Name:kevinTest
 * Date:2015年12月1日下午3:54:25
 * Copyright (c) 2015, ziheng915@vip.qq.com All Rights Reserved.
 *
*/

package kevinTest;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * ClassName:GongoTest <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年12月1日 下午3:54:25 <br/>
 * 
 * @author ziheng
 * @version
 * @since JDK 1.8u60
 * @see
 */
public class GongoTest {
	private Mongo mg = null;
	private DB db;
	private DBCollection users;

	@Before
	public void init() {
		try {
			//mg = new Mongo("172.29.5.99", 27017);
		
			 mg = new Mongo("172.29.5.87", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		// 获取temp DB；如果默认没有创建，mongodb会自动创建
		db = mg.getDB("temp");
		// 获取users DBCollection；如果默认没有创建，mongodb会自动创建
		users = db.getCollection("users");
	}

	@After
	public void destory() {
		if (mg != null)
			mg.close();
		mg = null;
		db = null;
		users = null;
		System.gc();
	}

	public void print(Object o) {
		System.out.println(o);
	}

	public void getAll() {
		DBCursor cur = users.find();

		while (cur.hasNext()) {
			print(cur.next());
		}

	}

	public void add() {
		print("count: " + users.count());
		DBObject user = new BasicDBObject();
		user.put("_id", users.count() + 1);
		user.put("name", "110");
		user.put("age", 22);
		List<DBObject> list = new ArrayList<DBObject>();
		list.add(user);
		print(users.insert(list).getN());

		print("count: " + users.count());
		getAll();
	}

	public void delete() {
		//users.remove(new BasicDBObject("_id", 3)).getN();
		users.remove(new BasicDBObject("_id", new ObjectId("565d5484ebcb87b95d72ab2a"))).getN();
	}

}
