package com.app.service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.UsersDTO;
import com.app.dto.UsersPostDTO;
import com.app.entity.Users;
import com.app.repository.UsersRepository;
import com.app.service.UsersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Users addUser(UsersPostDTO usersPostDTO) {
        Users user = convertToEntity(usersPostDTO);
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public Users updateUser(Long userId, UsersDTO usersDTO) {
        Optional<Users> existingUserOptional = usersRepository.findById(userId);
        if (existingUserOptional.isPresent()) {
            Users existingUser = existingUserOptional.get();
            Users updatedUser = convertToEntity(usersDTO);
            updatedUser.setId(existingUser.getId());
            updatedUser.setPassword(existingUser.getPassword());
            return usersRepository.save(updatedUser);
        }
        return null;
    }
    
    @Override
	public AuthResp authenticateEmp(AuthRequest request) {
		// autheticate emp
		Users user = usersRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email or Password !!!!!"));
		// => valid login --> map Entity --> DTO
		// ModelMapper API : public T map(Object src , Class<T> class)
		return modelMapper.map(user, AuthResp.class);
	}

    @Override
    public List<Users> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users findUserById(Long userId) {
        return usersRepository.findById(userId).orElse(null);
    }

    @Override
    public List<Users> findUsersByBookingCarId(Long carId) {
        return usersRepository.findByBookingCarId(carId);
    }

    private Users convertToEntity(UsersPostDTO usersPostDTO) {
        return modelMapper.map(usersPostDTO, Users.class);
    }
    
    private Users convertToEntity(UsersDTO usersDTO) {
        return modelMapper.map(usersDTO, Users.class);
    }

    private UsersDTO convertToDTO(Users users) {
        return modelMapper.map(users, UsersDTO.class);
    }
}
