package com.mockito.example.bo;

import java.sql.SQLException;

import com.mockito.example.bo.exception.BOException;
import com.mockito.example.dao.ExampleDAO;
import com.mockito.example.dto.Example;

public class ExampleBOImpl implements ExampleBO {

	private ExampleDAO exampleDAO;

	public boolean placeExample(Example example) throws BOException {
		try {
			int result = exampleDAO.create(example);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public boolean cancelExample(int id) throws BOException {
		try {
			Example result = exampleDAO.read(id);
			result.setStatus("Cancelled");
			int result1 = exampleDAO.update(result);
			if (result1 == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public boolean deleteExample(int id) throws BOException {
		try {
			int result = exampleDAO.delete(id);
			if (result == 0) {
				return false;
			}
		} catch (SQLException e) {
			throw new BOException(e);
		}
		return true;
	}

	public ExampleDAO getExampleDAO() {
		return exampleDAO;
	}

	public void setExampleDAO(ExampleDAO exampleDAO) {
		this.exampleDAO = exampleDAO;
	}

}
