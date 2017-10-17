package com.mockito.example.dao;

import java.sql.SQLException;

import com.mockito.example.dto.Example;

public interface ExampleDAO {
	int create(Example order) throws SQLException;

	Example read(int id) throws SQLException;

	int update(Example order) throws SQLException;

	int delete(int id) throws SQLException;
}
