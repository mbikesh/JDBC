package usermanagement.Util;

public class QueryUtil {
    public static final String SAVE_SQL="insert into user_tbl(username,password,mobileNo,salary,enable,dob) VALUES (?,?,?,?,?,?)";
    public static final String UPDATE_SQL="update user_tbl set username=?,password=?,mobileNo=?,salary=?,enable=?,dob=? where id=?";
    public static final String DELETE_SQL="delete from user_tbl where id=?";
    public static final String SELECT_SQL="select * from user_tbl";
    public static final String GET_BY_ID_SQL="select * from user_tbl where id=?";

}
