package fun;

public class RegisterFUN {
    /**
     * 注册方法
     *
     * @param user  用户
     * @param pass1 pass1
     * @param pass2 pass2
     * @param phone 电话
     * @return {@link String}
     */
    public static String Register(String user, String pass1, String pass2, String phone){
        if (user.trim().equals("")||pass1.trim().equals("")||pass2.trim().equals("")||phone.trim().equals("")){
            return "输入不能为空";
        }

        if (phone.length()!=11){
            return "手机号输入错误";
        }
        if (JBDC_User.querryUserbyPhone(phone)!=null){
            return "该用户已注册";
        }
        if (pass1.equals(pass2)==false){
            return "两次输入的密码不相同";
        }
        if (pass1.length()<6){
            return "密码不能小于6位";
        }
        return "";
    }
}
