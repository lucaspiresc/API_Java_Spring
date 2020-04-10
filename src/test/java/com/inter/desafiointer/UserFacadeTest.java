package com.inter.desafiointer;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.inter.desafiointer.facades.UserFacade;
import com.inter.desafiointer.dto.UserDTO;
import com.inter.desafiointer.entities.User;
import com.inter.desafiointer.repositories.UserRepository;
import com.inter.desafiointer.facades.SecurityFacade;
import com.inter.desafiointer.repositories.UniqueDigitRepository;

import static org.mockito.Mockito.when;

import org.modelmapper.ModelMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserFacadeTest {

	@InjectMocks
	private UserFacade userFacade;

	@Mock
	private UserRepository userRepository;

	@Mock
	private SecurityFacade securityFacade;

	@Mock
	private UniqueDigitRepository uniqueDigitRepository;

	@Mock
	private ModelMapper modelMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void listAllUsersTests(){

		UserDTO userDto = new UserDTO();
		userDto.setUsername("Lucas Teste");
		userDto.setEmail("email@teste.com");
		userDto.setUniqueDigits(new ArrayList<>());

		User user = new User();
		user.setUserId(1L);
		user.setUsername("Lucas Teste");
		user.setEmail("email@teste.com");
		user.setUniqueDigits(new ArrayList<>());

		List<User> users = new ArrayList<User>();
		users.add(user);

		when(userRepository.findAll()).thenReturn(users);

		when(modelMapper.map(user, UserDTO.class)).thenReturn(userDto);

		List<UserDTO> usersDto = userFacade.listAllUsers();
		Assert.assertTrue(!usersDto.isEmpty());
	}

	@Test
	public void getUserByIdTests(){

		UserDTO userDto = new UserDTO();
		userDto.setUserId(1L);
		userDto.setUsername("Lucas Teste");
		userDto.setEmail("email@teste.com");
		userDto.setUniqueDigits(new ArrayList<>());

		User user = new User();
		user.setUserId(1L);
		user.setUsername("Lucas Teste");
		user.setEmail("email@teste.com");
		user.setUniqueDigits(new ArrayList<>());

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));

		when(modelMapper.map(user, UserDTO.class)).thenReturn(userDto);

		userDto = userFacade.getUserById(1L);
		Assert.assertTrue(userDto != null);

		when(userRepository.findById(2L)).thenReturn(Optional.empty());

		userDto = userFacade.getUserById(2L);
		Assert.assertTrue(userDto == null);
	}

	@Test
	public void insertNewUserTests() throws Exception{

		UserDTO userDto = new UserDTO();
		userDto.setUsername("Lucas Teste");
		userDto.setEmail("email@teste.com");
		userDto.setUniqueDigits(new ArrayList<>());

		User user = new User();
		user.setUsername("Lucas Teste");
		user.setEmail("email@teste.com");
		user.setUniqueDigits(new ArrayList<>());

		when(securityFacade.encryptUserData(userDto)).thenReturn(userDto);

		when(modelMapper.map(userDto, User.class)).thenReturn(user);

		when(modelMapper.map(user, UserDTO.class)).thenReturn(userDto);

		when(userRepository.save(user)).thenReturn(user);

		when(uniqueDigitRepository.saveAll(user.getUniqueDigits())).thenReturn(user.getUniqueDigits());

		userDto = userFacade.insertNewUser(userDto);
		Assert.assertTrue(userDto != null);

		when(securityFacade.encryptUserData(userDto)).thenThrow(new Exception());

		userDto = userFacade.insertNewUser(userDto);
		Assert.assertTrue(userDto == null);
	}

	@Test
	public void deleteUserTests(){
		UserDTO userDto = new UserDTO();
		userDto.setUserId(1L);
		userDto.setUsername("Lucas Teste");
		userDto.setEmail("email@teste.com");
		userDto.setUniqueDigits(new ArrayList<>());

		User user = new User();
		user.setUserId(1L);
		user.setUsername("Lucas Teste");
		user.setEmail("email@teste.com");
		user.setUniqueDigits(new ArrayList<>());

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));

		when(modelMapper.map(user, UserDTO.class)).thenReturn(userDto);

		userDto = userFacade.deleteUser(1L);
		Assert.assertTrue(userDto != null);

		when(userRepository.findById(2L)).thenReturn(Optional.empty());

		userDto = userFacade.deleteUser(2L);
		Assert.assertTrue(userDto == null);
	}

	@Test
	public void updateUserTests() throws Exception{

		UserDTO userDto = new UserDTO();
		userDto.setUserId(1L);
		userDto.setUsername("Lucas Teste");
		userDto.setEmail("email@teste.com");
		userDto.setUniqueDigits(new ArrayList<>());

		User user = new User();
		user.setUserId(1L);
		user.setUsername("Lucas Teste");
		user.setEmail("email@teste.com");
		user.setUniqueDigits(new ArrayList<>());

		when(userRepository.findById(1L)).thenReturn(Optional.of(user));

		when(securityFacade.encryptUserData(userDto)).thenReturn(userDto);

		when(modelMapper.map(user, UserDTO.class)).thenReturn(userDto);

		when(userRepository.save(user)).thenReturn(user);

		userDto = userFacade.updateUser(userDto, 1L);
		Assert.assertTrue(userDto != null);

		when(userRepository.findById(2L)).thenReturn(Optional.empty());

		userDto = userFacade.updateUser(userDto, 2L);
		Assert.assertTrue(userDto == null);

		when(securityFacade.encryptUserData(userDto)).thenThrow(new Exception());

		userDto = userFacade.updateUser(userDto, 1L);
		Assert.assertTrue(userDto == null);
	}

}
