package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


/**
 * 使用连接池技术管理数据库连接
 * @author ZengHongfu
 *
 */
public class DBUtil {
	//数据库连接池
	private static BasicDataSource ds;
	//为不同线程管理连接
	private static ThreadLocal<Connection> tl;
	
	static{
		try {
			//加载配置文件
			Properties prop=new Properties();
			InputStream is=DBUtil.class.getClassLoader().getResourceAsStream("util/config.properties");
			prop.load(is);
			is.close();
			
			//初始化连接池
			ds=new BasicDataSource();
			//设置驱动
			ds.setDriverClassName(prop.getProperty("driver"));
//			ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			//设置url
			ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
			//设置数据库用户名
			ds.setUsername("system");
			//设置数据库密码
			ds.setPassword("362423");
			//初始连接池大小
			ds.setInitialSize(1);
			//允许最大数量
//			ds.setMaxTotal(2);
			//设置等待时间
//			ds.setMaxWaitMillis(Integer.parseInt(prop.getProperty("maxwait")));
			//设置最大空闲数量
//			ds.setMaxIdle(Integer.parseInt(prop.getProperty("maxidle")));
			//设置最小空闲数量
//			ds.setMinIdle(Integer.parseInt(prop.getProperty("minidle")));
			
			//初始化线程本地
			tl=new ThreadLocal<Connection>();		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException{
		/**
		 * 通过连接池获取一个空闲连接
		 */
		Connection conn=ds.getConnection();
		tl.set(conn);
		return conn;
	}
	
	public static void closeConnection(){
		try {
			Connection conn=tl.get();
			if(conn!=null){
				//恢复连接为自动提交事务
				conn.setAutoCommit(true);
				/**
				 * 通过连接池获取的Connection
				 * 的close（）方法实际上并没有将连接关闭
				 * 而是将连接归还
				 */
				conn.close();
				tl.remove();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

