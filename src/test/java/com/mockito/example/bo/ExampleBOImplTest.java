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

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPlaceExample() throws SQLException, BOException {
		ExampleBOImpl exampleBOImpl = new ExampleBOImpl();
		exampleBOImpl.setExampleDAO(dao);

		Example example = new Example();
		when(dao.create(example)).thenReturn(new Integer(1));
		
		boolean placeExample = exampleBOImpl.placeExample(example);
		assertEquals(true, placeExample);
		verify(dao).create(example);
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
