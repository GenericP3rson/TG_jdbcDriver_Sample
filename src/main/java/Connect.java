import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
 
import com.tigergraph.jdbc.Driver;
 
public class Connect {
  public static void main(String[] args) {
	Properties properties = new Properties();
	properties.put("username", "tigergraph");
	properties.put("password", "tigergraph");
	properties.put("graph", "AMLSim");

	try {
		com.tigergraph.jdbc.Driver driver = new Driver();
		try (Connection con =
			driver.connect("jdbc:tg:http://localhost:14240", properties)) {
			try (Statement stmt = con.createStatement()) {
				String query = "builtins stat_vertex_number";
				try (java.sql.ResultSet rs = stmt.executeQuery(query)) {
					do {
					java.sql.ResultSetMetaData metaData = rs.getMetaData();
					// Gets the name of the designated column (1-based indexing)
					System.out.print(metaData.getColumnName(1));
					for (int i = 2; i <= metaData.getColumnCount(); ++i) {
						System.out.print("\t" + metaData.getColumnName(i));
					}
					System.out.println("");
					while (rs.next()) {
						System.out.print(rs.getObject(1));
						for (int i = 2; i <= metaData.getColumnCount(); ++i) {
						Object obj = rs.getObject(i);
						System.out.println("\t" + String.valueOf(obj));
						}
					}
					} while (!rs.isLast());
				}
				query = "builtins stat_edge_number";
				try (java.sql.ResultSet rs = stmt.executeQuery(query)) {
					do {
					java.sql.ResultSetMetaData metaData = rs.getMetaData();
					// Gets the name of the designated column (1-based indexing)
					System.out.print(metaData.getColumnName(1));
					for (int i = 2; i <= metaData.getColumnCount(); ++i) {
						System.out.print("\t" + metaData.getColumnName(i));
					}
					System.out.println("");
					while (rs.next()) {
						System.out.print(rs.getObject(1));
						for (int i = 2; i <= metaData.getColumnCount(); ++i) {
						Object obj = rs.getObject(i);
						System.out.println("\t" + String.valueOf(obj));
						}
					}
					} while (!rs.isLast());
				}
				query = "run interpreted(account_id=?)";
				String query_body = "INTERPRET QUERY (STRING account_id) FOR GRAPH AMLSim {\n" +
									"seed = {Account.*};\n" +
									"S1 = SELECT s FROM seed:s WHERE s.id == account_id;\n" +
									"PRINT S1;\n" + 
									"}";
				try (java.sql.PreparedStatement pstmt = con.prepareStatement(query)) {
				pstmt.setString(1, "9913");
				pstmt.setString(2, query_body); // The query body is passed as a parameter.
				try (java.sql.ResultSet rs = pstmt.executeQuery()) {
					do {
					java.sql.ResultSetMetaData metaData = rs.getMetaData();
					System.out.println("Table: " + metaData.getCatalogName(1));
					System.out.print(metaData.getColumnName(1));
					for (int i = 2; i <= metaData.getColumnCount(); ++i) {
						System.out.print("\t" + metaData.getColumnName(i));
					}
					System.out.println("");
					while (rs.next()) {
						System.out.print(rs.getObject(1));
						for (int i = 2; i <= metaData.getColumnCount(); ++i) {
						Object obj = rs.getObject(i);
						System.out.println("\t" + String.valueOf(obj));
						}
					}
					} while (!rs.isLast());
				}
				} catch (SQLException e) {
				System.out.println( "Failed to createStatement: " + e);
				}
			}
		} catch (SQLException e) {System.out.println(e);}
	} catch (SQLException e) {System.out.println(e);}
  }
}