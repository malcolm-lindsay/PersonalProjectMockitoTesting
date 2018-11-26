package com.qa.intergration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.qa.rest.UserEndpoint;
import com.qa.service.business.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserEndpointTest {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private UserEndpoint endpoint;

	@Mock
	private UserService service;

	@Test
	public void testGetAllUser() {
		Mockito.when(service.getAllUsers()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllUsers());
	}

	@Test
	public void testAddUser() {
		Mockito.when(service.addUser(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.addUser(MOCK_VALUE2));
		Mockito.verify(service).addUser(MOCK_VALUE2);
	}

	@Test
	public void testDeleteUser() {
		Mockito.when(service.deleteUser(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteUser(1L));
		Mockito.verify(service).deleteUser(1L);
	}
}



