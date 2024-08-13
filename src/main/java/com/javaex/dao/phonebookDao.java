package com.javaex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class phonebookDao {
	
	// 데이터베이스 연결 변수
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    // 데이터베이스 연결 정보
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/phonebook_db";
    private final String id = "phonebook";
    private final String pw = "phonebook";
    
    // 데이터베이스 연결 설정
    private void getConnection() {
        try {
            Class.forName(driver); // JDBC 드라이버 로딩
            conn = DriverManager.getConnection(url, id, pw); // 연결 얻기
        } catch (ClassNotFoundException e) {
			System.out.println("────────────────────── WARNING ──────────────────────");
            System.out.println("            ❌ 오류: 드라이버 로딩 실패         ");
            System.out.println("   원인: " + e.getMessage() );
			System.out.println("─────────────────────────────────────────────────────");
        } catch (SQLException e) {
			System.out.println("────────────────────── WARNING ──────────────────────");
            System.out.println("            ❌ 오류: 데이터베이스 연결 실패       ");
            System.out.println("  원인: " + e.getMessage());
			System.out.println("─────────────────────────────────────────────────────");
        }
    }
    // 자원 해제
    private void close() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
			System.out.println("────────────────────── WARNING ──────────────────────");
            System.out.println("             ❌ 오류: 자원 해제 실패          ");
            System.out.println("  원인: " + e.getMessage());
			System.out.println("─────────────────────────────────────────────────────");
        }
    }
    
    

}
