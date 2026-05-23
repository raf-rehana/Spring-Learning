package com.example.demo.service;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    List<User> findAll();
    Optional<User> getById(Integer id);
    void delete(Integer id);

    List<UserDTO> getUsersByCountryId(Integer countryId);
    List<UserDTO> getUsersByDivisionId(Integer divisionId);
    List<UserDTO> getUsersByDistrictId(Integer districtId);
    List<UserDTO> getUsersByDepartmentId(Integer departmentId);
}
