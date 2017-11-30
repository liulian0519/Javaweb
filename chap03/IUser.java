package xupt.se.ttms.idao;

/**
 * 定义对登陆用户表的增删改查接口
 * @author 张荣
 */
public interface IUser
{
    // 判断用户名、密码是否正确
    public boolean isExist(String userName, String userPass);

    // 增、删、改、查
}
