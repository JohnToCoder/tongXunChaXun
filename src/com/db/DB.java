package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.namelist;
import com.model.voiceList;

public class DB{
	Connection ct;
	PreparedStatement pstmt;
	ResultSet rs;
	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String url = "jdbc:derby:";
	String dbName = "E://Program Files//db-derby-10.10.2.0-bin//bin//tongXLDB;";
		//连接
		public DB(){
						try {
							Class.forName(driver);
							try {
								ct = DriverManager.getConnection(url+dbName+"create=true");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
		}
		//执行插入
		public boolean addVoiceInfo(voiceList voicelist){
			try {
				//ct = DriverManager.getConnection(url+dbName+"create=true");
				System.out.println("Connected to and created database");
				String sql = ("insert into voicelist (name,datetime,longth,style,tonum,place,toll) values(?,?,?,?,?,?,?)");
				pstmt = ct.prepareStatement(sql);
				pstmt.setString(1,voicelist.getName() );
				pstmt.setString(2,voicelist.getDatetime());
				pstmt.setString(3,voicelist.getLongth());
				pstmt.setString(4,voicelist.getStyle());
				pstmt.setString(5, voicelist.getToNum());
				pstmt.setString(6,voicelist.getPlace());
				pstmt.setString(7,voicelist.getToll());
				pstmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		//判断人名是否存在
		public boolean checkName(String persion){
			String sql = ("select name from namelist where name='"+persion+"'");
			try {
			  //  ct = DriverManager.getConnection(url+dbName+"create=true");
				pstmt = ct.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				//DriverManager.getConnection("jdbc:derby:E://Program Files//db-derby-10.10.2.0-bin//bin//tongXLDB;shutdown=true;");
				if(rs.next()){
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		//插入用户名
		public boolean addName(namelist name){
			String sql = ("insert into namelist (name) values(?)");
			try {
			//	ct = DriverManager.getConnection(url+dbName+"create=true");
				pstmt = ct.prepareStatement(sql);
				pstmt.setString(1, name.getName());
				pstmt.executeUpdate();
				//DriverManager.getConnection("jdbc:derby:E://Program Files//db-derby-10.10.2.0-bin//bin//tongXLDB;shutdown=true;");
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;	
		}
		//查询数据库的namelist表，把用户名返回到数组里面
		public String[] nameShow(){
			String sql = ("select name from namelist");
			try {
				pstmt = ct.prepareStatement(sql);
				rs = pstmt.executeQuery();
				ArrayList<String> NAME= new ArrayList();
				while(rs.next()){
					rs.getString(1);
					NAME.add(rs.getString(1));
				}
				String[] array = new String[NAME.size()];
				NAME.toArray(array);
				return array;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		
		//查询相同的电话号码
		public ArrayList<String> listCompare(String name1,String name2){
			ArrayList<String> numTmp1 =new ArrayList<String>(),numTmp2 =new ArrayList<String>(),numTmp3 =new ArrayList<String>();
			String[] num4=null,num5=null,num3=null;
			int i=0,j=0;
			System.out.println(name1+'\n');
			System.out.println(name2);
			String sql1 = ("select tonum from voicelist where name='"+name1+"'");
			String sql2 = ("select tonum from voicelist where name='"+name2+"'");
			//获得一的号码
			try {
				pstmt = ct.prepareStatement(sql1);
				rs = pstmt.executeQuery();
				int k = 0;
					while(rs.next()){
						numTmp1.add(rs.getString(1));
						System.out.println(numTmp1.get(k).toString());
						k++;
					}
				/*if(NUM1.size()!=0){
				num1=new String[NUM1.size()];
				}*/
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//获得二的号码
			try {
				pstmt = ct.prepareStatement(sql2);
				rs = pstmt.executeQuery();
				int v = 0;
				while(rs.next()){
					numTmp2.add(rs.getString(1));
					System.out.println(numTmp2.get(v).toString());
					v++;
				}
				/*String[] num2=new String[rs.getRow()];
				while(rs.next()){
					num2[j]=rs.getString(1);
					j++;
				}/*if(NUM2.size()!=0){
				num2=new String[NUM2.size()];
				}*/
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//进行比较 获取相同的
			if(numTmp1.size()>0&&numTmp2.size()>0){
			for(int x=0;x<numTmp1.size();x++){
				for(int y=0;y<numTmp2.size();y++){
					if(numTmp1.get(x).toString().equals(numTmp2.get(y).toString()))
						numTmp3.add(numTmp1.get(x).toString());
					else
						continue;
				}
			}
			}
			}
			if(numTmp3.size()>0){
			num3 = new String[numTmp3.size()];
			}
			return num3;			
		}
		//进行数据库信息的查询，并返回VOICELIST的集合；
		public ArrayList<voiceList> showResult(String[] num){
			ArrayList<voiceList> al=new ArrayList<>();
			try {
				for(int i=0;i<num.length;i++){
				pstmt=ct.prepareStatement("select * from voicelist where tonum='"+num[i]+"'");
					pstmt.setString(1, num[i]);
					rs=pstmt.executeQuery();
					while(rs.next()){
						voiceList vslist=new voiceList();
						vslist.setId(rs.getInt(1));
						vslist.setName(rs.getString(2));
						vslist.setDatetime(rs.getString(3));
						vslist.setLongth(rs.getString(4));
						vslist.setStyle(rs.getString(5));
						vslist.setToNum(rs.getString(6));
						vslist.setPlace(rs.getString(7));
						vslist.setToll(rs.getString(8));
						al.add(vslist);
					}
				}
				return al;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;	
		}
		//关闭
		public static void closeJDBC(Connection ct,PreparedStatement pstmt,ResultSet rs){
			if(rs!=null)
			{try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(ct!=null)
			{try {
				ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
			if(pstmt!=null)
			{try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}

}

