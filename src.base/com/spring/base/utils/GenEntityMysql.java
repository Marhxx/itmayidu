package com.spring.base.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
/**
 * 
 * @author lcx
 *
 * 2017年3月14日上午11:57:21
 *
 */
public class GenEntityMysql {
	private String packageOutPath = "com.spring.api.entity";// 指定实体生成所在包的路径
//	private String packageOutPath = "com.spring.common.entity";// 指定实体生成所在包的路径
	private String authorName = "lcx";// 作者名字
	private String tablename = "tb_pay_record";// 表名
	private String fileName = "src";
//	private String fileName = "src.common";
	private String[] colnames; // 列名数组
	private String[] colnamesOld; // 列名数组(未做处理的)
	private String[] colTypes; // 列名类型数组
	private int[] colSizes; // 列名大小数组
	private boolean f_util = false; // 是否需要导入包java.util.*
	private boolean f_sql = false; // 是否需要导入包java.sql.*
	

	// 数据库连接
	private static final String URL = "jdbc:mysql://192.168.0.253:3306/feifeitui";
	private static final String NAME = "fft";
	private static final String PASS = "fft!@#";
	private static final String DRIVER = "com.mysql.jdbc.Driver";

	/*
	 * 构造函数
	 */
	public GenEntityMysql() {
		// 创建连接
		Connection con;
		// 查要生成实体类的表
		String sql = "select * from " + tablename;
		PreparedStatement pStemt = null;
		try {
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			con = DriverManager.getConnection(URL, NAME, PASS);
			pStemt = con.prepareStatement(sql);
			ResultSetMetaData rsmd = pStemt.getMetaData();
			int size = rsmd.getColumnCount(); // 统计列
			colnames = new String[size];
			colnamesOld = new String[size];
			colTypes = new String[size];
			colSizes = new int[size];
			for (int i = 0; i < size; i++) {
				colnamesOld[i] = rsmd.getColumnName(i + 1);
				colnames[i] = replaceUnderlineAndfirstToUpper(rsmd.getColumnName(i + 1),"_","");
				colTypes[i] = rsmd.getColumnTypeName(i + 1);

				if (colTypes[i].equalsIgnoreCase("datetime")) {
//					f_util = true;
					f_sql = true;
				}
				if (colTypes[i].equalsIgnoreCase("image")
						|| colTypes[i].equalsIgnoreCase("text")) {
					f_sql = true;
				}
				colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
			}

			String content = parse(colnames, colTypes, colSizes);

			try {
				File directory = new File("");
				// System.out.println("绝对路径："+directory.getAbsolutePath());
				// System.out.println("相对路径："+directory.getCanonicalPath());
				String path = this.getClass().getResource("").getPath();

				System.out.println(path);
				System.out.println(fileName+"/?/"
						+ path.substring(path.lastIndexOf("/com/",
								path.length())));
				// String outputPath = directory.getAbsolutePath()+
				// "/src/"+path.substring(path.lastIndexOf("/com/",
				// path.length()), path.length()) + initcap(tablename) +
				// ".java";
//				String outputPath = directory.getAbsolutePath() + "/src/"
//						+ this.packageOutPath.replace(".", "/") + "/"
//						+ initcap(tablename) + ".java";
				String outputPath = directory.getAbsolutePath() + "/"+fileName+"/"
						+ this.packageOutPath.replace(".", "/") + "/"
						+ initcap(replaceUnderlineAndfirstToUpper(tablename,"_","")) + ".java";
				FileWriter fw = new FileWriter(outputPath);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(content);
				pw.flush();
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// try {
			// con.close();
			// } catch (SQLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}
	}

	/**
	 * 功能：生成实体类主体代码
	 * 
	 * @param colnames
	 * @param colTypes
	 * @param colSizes
	 * @return
	 */
	private String parse(String[] colnames, String[] colTypes, int[] colSizes) {
		StringBuffer sb = new StringBuffer();

		
		sb.append("package " + this.packageOutPath + ";\r\n");
		sb.append("\r\n");
		// 判断是否导入工具包
		if (f_util) {
//			sb.append("import java.util.Date;\r\n");
		}
		if (f_sql) {
			sb.append("import javax.persistence.*;\r\n");
			sb.append("import java.sql.*;\r\n");
		}
		// 注释部分
		sb.append("   /**\r\n");
		sb.append("    * " + tablename + " 实体类\r\n");
		sb.append("    * " + new Date() + " " + this.authorName + "\r\n");
		sb.append("    */ \r\n");
		//Table部分
		sb.append("\r\n\r\n@Entity\n");
		sb.append("@Table(name = \""+tablename+"\")\n");
		// 实体部分
//		sb.append("\r\n\r\npublic class " + initcap(replaceUnderlineAndfirstToUpper(tablename,"_","")) + " implements java.io.Serializable {\r\n");
		sb.append("public class " + initcap(replaceUnderlineAndfirstToUpper(tablename,"_","")) + " implements java.io.Serializable {\r\n");
		processAllAttrs(sb);// 属性
		processAllMethod(sb);// get set方法
		sb.append("}\r\n");

		// System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 * 功能：生成所有属性
	 * 
	 * @param sb
	 */
	private void processAllAttrs(StringBuffer sb) {

		for (int i = 0; i < colnames.length; i++) {
			sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " "
					+ colnames[i] + ";\r\n");
		}

	}

	/**
	 * 功能：生成所有方法
	 * 
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {

		for (int i = 0; i < colnames.length; i++) {
			if (i == 0){
				sb.append("\t@Id\n");
				sb.append("\t@GeneratedValue(strategy = GenerationType.IDENTITY)\n");
				sb.append("\t@Column(name = \""+colnamesOld[i]+"\", unique = true, nullable = false)\n");
				sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get"
						+ initcap(colnames[i]) + "(){\r\n");
				sb.append("\t\treturn " + colnames[i] + ";\r\n");
				sb.append("\t}\r\n");
				sb.append("\tpublic void set" + initcap(colnames[i]) + "("
						+ sqlType2JavaType(colTypes[i]) + " " + colnames[i]
						+ "){\r\n");
				sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
				sb.append("\t}\r\n");
			}else {
				sb.append("\t@Column(name = \""+colnamesOld[i]+"\")\n");
				sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get"
						+ initcap(colnames[i]) + "(){\r\n");
				sb.append("\t\treturn " + colnames[i] + ";\r\n");
				sb.append("\t}\r\n");
				sb.append("\tpublic void set" + initcap(colnames[i]) + "("
						+ sqlType2JavaType(colTypes[i]) + " " + colnames[i]
						+ "){\r\n");
				sb.append("\t\tthis." + colnames[i] + "=" + colnames[i] + ";\r\n");
				sb.append("\t}\r\n");
			}
		}

	}

	/**
	 * 功能：将输入字符串的首字母改成大写
	 * 
	 * @param str
	 * @return
	 */
	private String initcap(String str) {

		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}

		return new String(ch);
	}

	/**
	 * 功能：获得列的数据类型
	 * 
	 * @param sqlType
	 * @return
	 */
	private String sqlType2JavaType(String sqlType) {

		if (sqlType.equalsIgnoreCase("bit")) {
			return "boolean";
		} else if (sqlType.equalsIgnoreCase("tinyint")) {
//			return "byte";
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("smallint")) {
//			return "short";
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("int")) {
//			return "int";
			return "Integer";
		} else if (sqlType.equalsIgnoreCase("bigint")) {
//			return "long";
			return "Long";
		} else if (sqlType.equalsIgnoreCase("float")) {
			return "float";
		} else if (sqlType.equalsIgnoreCase("decimal")
				|| sqlType.equalsIgnoreCase("numeric")
				|| sqlType.equalsIgnoreCase("real")
				|| sqlType.equalsIgnoreCase("money")
				|| sqlType.equalsIgnoreCase("smallmoney")
				|| sqlType.equalsIgnoreCase("double")) {
//			return "double";
			return "Double";
		} else if (sqlType.equalsIgnoreCase("varchar")
				|| sqlType.equalsIgnoreCase("char")
				|| sqlType.equalsIgnoreCase("nvarchar")
				|| sqlType.equalsIgnoreCase("nchar")
				|| sqlType.equalsIgnoreCase("text")) {
			return "String";
		} else if (sqlType.equalsIgnoreCase("datetime")) {
//			return "Date";
			return "Timestamp";
		} else if (sqlType.equalsIgnoreCase("image")) {
			return "Blod";
		}

		return null;
	}
	/** 
	* 首字母大写 
	*  
	* @param srcStr 
	* @return 
	*/  
	public static String firstCharacterToUpper(String srcStr) {  
	   return srcStr.substring(0, 1).toUpperCase() + srcStr.substring(1);  
	}  
	/** 
	* 替换字符串并让它的下一个字母为大写 
	* @param srcStr 
	* @param org 
	* @param ob 
	* @return 
	*/  
	public static String replaceUnderlineAndfirstToUpper(String srcStr,String org,String ob)  
	{  
	   String newString = "";  
	   int first=0;  
	   while(srcStr.indexOf(org)!=-1)  
	   {  
	    first=srcStr.indexOf(org);  
	    if(first!=srcStr.length())  
	    {  
	     newString=newString+srcStr.substring(0,first)+ob;  
	     srcStr=srcStr.substring(first+org.length(),srcStr.length());  
	     srcStr=firstCharacterToUpper(srcStr);  
	    }  
	   }  
	   newString=newString+srcStr;  
	   return newString;  
	}  
	/**
	 * 出口 TODO
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		new GenEntityMysql();
//		System.out.println(replaceUnderlineAndfirstToUpper("tb_servcie_order","_",""));
	}

}
