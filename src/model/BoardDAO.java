package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	
	//Database Connection Area
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String dsn = "jdbc:mysql://gondr.asuscomm.com/kanozo12?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Seoul";
			conn = DriverManager.getConnection(dsn, "kanozo12", "1234");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB Connection Failed");
		}
		return conn;
	}
	
	//Data Posting Area
	public boolean posting(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(StringQuery.INSERT_POSTING);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getContent());
			pstmt.setString(4, dto.getFileName());
			result = pstmt.execute();
			result = true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}
	
	//board page get posts area  
	public ArrayList<BoardDTO> selectPosting(int page) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		if (page <= 0) {
			page = 1;
		}
		int start = (page - 1) * 10;

		String sql = "select no, title, writer from jsp_board ORDER BY no DESC LIMIT ?, 10";

		ArrayList<BoardDTO> userList = new ArrayList<BoardDTO>();

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO dto = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
				userList.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	//post content view area
	public BoardDTO contentView(int bno) {
		BoardDTO dto = new BoardDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String SQL = "SELECT * FROM jsp_board WHERE no = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String filename = rs.getString("filename");
				dto = new BoardDTO(no, title, writer, content, filename);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	//user post info get 
	public BoardDTO modifyView(int bno) {
		BoardDTO dto = new BoardDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String SQL = "SELECT * FROM jsp_board WHERE no = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String fileName = rs.getString("filename");
				dto = new BoardDTO(bno, title, writer, content, fileName);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	//post modify area 
	public void modify(int no, String title, String content, String file) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String SQL = "UPDATE jsp_board SET title = ?, content = ?, filename = ? WHERE no = ?";

		try {
			conn = getConnection();

			pstmt = conn.prepareStatement(SQL);

			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, file);
			pstmt.setInt(4, no);

			int result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Database recode delete area
	public void delete(String no) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String query = "delete from jsp_board where no=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(no));
			int result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {

				e2.printStackTrace();
			}
		}
	}

}
