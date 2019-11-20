package model;

public interface StringQuery {
	String INSERT_MEMBER = "INSERT INTO jsp_member (id, pass, name) VALUES(?,?,?)";
	String LOGIN_CHECK = "SELECT pass FROM jsp_member WHERE id = ?";
	String INSERT_POSTING = "INSERT INTO jsp_board VALUES(null,?,?,?,?)";
	String SELECT_POSTING = "SELECT no, title, writer, content FROM jsp_board";
}
