package com.example.demo.serviceImp;
import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Department;
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
    public Course save(Course course) {
        Integer departmentId = course.getDepartment().getId();
        Department department = deptRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with this ID"));
        course.setDepartment(department);
        return courseRepository.save(course) ;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll() ;
    }

    @Override
    public Optional<Course> getById(Integer id) {
        return courseRepository.findById(id) ;
    }

    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDTO> getCourseByDepartmentId(Integer departmentId) {
        List<Course> list = courseRepository.findByDepartmentId(departmentId);

        return  list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourseByDepartmentName(String departmentName) {
        List<Course> list = courseRepository.findByDepartmentName(departmentName);
        return  list.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private CourseDTO convertToDTO(Course course) {

        return new CourseDTO(
                course.getId(),
                course.getCourseName(),
                course.getDepartment().getId(),
                course.getDepartment().getDepartmentName()

        );
    }


}
