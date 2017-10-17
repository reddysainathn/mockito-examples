package com.mockito.example.bo;

import com.mockito.example.bo.exception.BOException;
import com.mockito.example.dto.Example;

public interface ExampleBO {

	boolean placeExample(Example example) throws BOException;

	boolean cancelExample(int id) throws BOException;

	boolean deleteExample(int id) throws BOException;

}
