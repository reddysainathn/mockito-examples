package com.mockito.example.bo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mockito.example.bo.exception.BOException;
import com.mockito.example.dao.ExampleDAO;
import com.mockito.example.dto.Example;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

public class ExampleBOImplTest {

	@Mock
	ExampleDAO dao;

	@Mock
	ExampleBOImpl exampleBOImpl;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	    exampleBOImpl = new ExampleBOImpl();
		exampleBOImpl.setExampleDAO(dao);
	}

	@Test
	public void testPlaceExample() throws SQLException, BOException {
		Example example = new Example();
		when(dao.create(example)).thenReturn(new Integer(1));
		
		boolean placeExample = exampleBOImpl.placeExample(example);
		assertEquals(true, placeExample);
		verify(dao).create(example);
	}
	
	@Test(expected=BOException.class)
	public void testPlaceExample_Throw_Exception() throws SQLException, BOException {
		Example example = new Example();
		when(dao.create(example)).thenThrow(SQLException.class);
		boolean placeExample = exampleBOImpl.placeExample(example);
	}

	@Test
	public void testCancelExample() {

	}

	@Test
	public void testDeleteExample() {

	}

	@Test
	public void testGetExampleDAO() {

	}

	@Test
	public void testSetExampleDAO() {

	}

}
