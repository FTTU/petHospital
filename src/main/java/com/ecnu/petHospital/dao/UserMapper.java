package com.ecnu.petHospital.dao;

import com.ecnu.petHospital.entity.User;
import com.ecnu.petHospital.vo.UserVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends MyMapper<User> {

    //根据用户名获取用户
    @Select("SELECT * FROM user WHERE username=#{username};")
    User getUserByUsername(@Param("username") String username);

    //根据用户id获取用户
    @Select("select * from user where id=#{id};")
    UserVO getUserById(Integer id);

    @Select("select count(*) from user")
    int getCountOfUser();

    //插入新用户
    @Insert("insert into user(id,username,password,email,admin) values (#{id},#{username},#{password},#{email},#{admin});")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);

    //更新用户密码
    @Update("update user set password=#{password} where id=#{id}")
    int updatePasswordById(@Param("id") Integer id,
                           @Param("password") String password);

    //更新用户名
    @Update("update user set username=#{username} where id=#{id}")
    int updateUsernameById(@Param("id") Integer id,
                           @Param("username") String username);

    //更新电话
    @Update("update user set telephone=#{telephone} where id=#{id};")
    int updateTelephoneById(@Param("id") Integer id,
                            @Param("telephone") String telephone);

    //更新邮箱
    @Update("update user set email=#{email} where id=#{id};")
    int updateEmailById(@Param("id") Integer id,
                        @Param("email") String email);

    //更改权限
    @Update("update user set admin=#{admin} where id=#{id}")
    int updatePermission(@Param("id") Integer id,
                         @Param("admin") Integer admin);

    //根据用户名获取用户列表
    @Results(
            id = "userList", value = {
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    }
    )

    //获取所有用户
    //@ResultMap("userList")
    @Select("SELECT * FROM user order by id desc;")
    List<User> getUserList();

    //删除用户
    @Delete("delete from user where id = #{id};")
    int deleteUserById(Integer id);
}
