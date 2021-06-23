import controller.LoginController;
import model.dao.NguoiDungDAO;
import model.pojo.NguoiDung;
import org.mindrot.jbcrypt.BCrypt;
import ui.Login;

public class Main {
    public static void main(final String[] args) {
//        String pass= BCrypt.hashpw("admin",BCrypt.gensalt());
//        NguoiDung admin=new NguoiDung("admin"," ","215234234","0986798098","admin",pass,0);
//        boolean check=NguoiDungDAO.ThemND(admin);
//        if (check)
//            System.out.println("Thanh cong");
//        else
//            System.out.println("Loi");

        Login login=new Login();
        LoginController loginController=new LoginController(login);
        loginController.showLoginView();
    }
}