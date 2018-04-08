package Service;

import Entity.Student;

import java.util.List;

public interface IStudentService {
    int deleteByPrimaryKey(long uid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(long uid);

    List<Student> selectByCondition(Student record);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}
