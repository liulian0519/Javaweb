package xupt.se.ttms.model;

import java.io.Serializable;

public class User implements Serializable
{
    private int user_id;// 主键
    private String user_no;
    private String user_pass;
    private String user_type;

    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public String getUser_no()
    {
        return user_no;
    }

    public void setUser_no(String user_no)
    {
        this.user_no = user_no;
    }

    public String getUser_pass()
    {
        return user_pass;
    }

    public void setUser_pass(String user_pass)
    {
        this.user_pass = user_pass;
    }

    public String getUser_type()
    {
        return user_type;
    }

    public void setUser_type(String user_type)
    {
        this.user_type = user_type;
    }

}