package com.example.demo.serviceImp;
import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Subject;
import com.example.demo.repository.DeptRepository;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public Subject save(Subject subject) {
        Integer departmentId = subject.getDepartment().getId();
        Department department = deptRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with this ID"));
        subject.setDepartment(department);
        return courseRepository.save(subject) ;
    }

    @Override
    public List<Subject> findAll() {
        return courseRepository.findAll() ;
    }

    @Override
    public Optional<Subject> getById(Integer id) {
        return courseRepository.findById(id) ;
    }

    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> getSubjectByDepartmentId(Integer departmentId) {
        List<Subject> list = courseRepository.findByDepartmentId(departmentId);

        return  list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getSubjectByDepartmentName(String departmentName) {
        List<Subject> list = courseRepository.findByDepartmentName(departmentName);
        return  list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private CourseDTO convertToDTO(Subject subject) {

        return new CourseDTO(
                subject.getId(),
                subject.getName(),
                subject.getDepartment().getId(),
                subject.getDepartment().getName()

        );
    }


}
