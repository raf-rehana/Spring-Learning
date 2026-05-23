package com.example.demo.serviceImp;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public User save(User user) {

        Country country = countryRepository.findById(user.getCountry().getId())
                .orElseThrow(() -> new RuntimeException("Country not found"));
        user.setCountry(country);

        Division division = divisionRepository.findById(user.getDivision().getId())
                .orElseThrow(() -> new RuntimeException("Division not found"));
        user.setDivision(division);


        District district = districtRepository.findById(user.getDistrict().getId())
                .orElseThrow(() -> new RuntimeException("District not found"));
        user.setDistrict(district);

        Department department = deptRepository.findById(user.getDepartment().getId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        user.setDepartment(department);

        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<UserDTO> getUsersByCountryId(Integer countryId) {
        return userRepository.findByCountryId(countryId)
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUsersByDivisionId(Integer divisionId) {
        return userRepository.findByDivisionId(divisionId)
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUsersByDistrictId(Integer districtId) {
        return userRepository.findByDistrictId(districtId)
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUsersByDepartmentId(Integer departmentId) {
        return userRepository.findByDepartmentId(departmentId)
                .stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCountry().getId(),
                user.getCountry().getName(),
                user.getDivision().getId(),
                user.getDivision().getName(),
                user.getDistrict().getId(),
                user.getDistrict().getName(),
                user.getDepartment().getId(),
                user.getDepartment().getName()
        );
    }
}
