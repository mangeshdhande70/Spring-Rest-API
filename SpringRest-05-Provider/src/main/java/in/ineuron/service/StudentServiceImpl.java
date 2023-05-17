package in.ineuron.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.model.Student;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentDao iStudentDao;

	@Override
	public String saveStudent(Student student) {
		
		Student save = iStudentDao.save(student);
		
		return save!=null?"success":"failed";
	}

	@Override
	public List<Student> getAllStudent() {
		
		List<Student> all = iStudentDao.findAll();
	
		return all;
	}

	@Override
	public Optional<Student> getStudentById(Integer id) {
		
		return iStudentDao.findById(id);
	}

}
