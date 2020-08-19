package com.monkey.mybatisplus.mapper;

        import com.baomidou.mybatisplus.core.mapper.BaseMapper;
        import com.monkey.mybatisplus.entity.User;
        import com.monkey.mybatisplus.vo.ProductVo;
        import org.apache.ibatis.annotations.Select;

        import java.util.List;

public interface UserMapper extends BaseMapper<User>{
    @Select("select p.*,u.name userName from product p,user u where p.user_id = u.id and u.id = #{id}")
    List<ProductVo> productList(Integer id);
}