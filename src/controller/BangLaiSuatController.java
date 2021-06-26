package controller;

import model.dao.LoaiSTKDAO;
import model.pojo.LoaiSTK;
import ui.BangLaiSuat;

import java.util.List;

public class BangLaiSuatController {
    BangLaiSuat bangLaiSuat;

    public BangLaiSuatController(BangLaiSuat bangLaiSuat){
        this.bangLaiSuat=bangLaiSuat;
        List<LoaiSTK> list= LoaiSTKDAO.layDSLoaiSTK();
        bangLaiSuat.showBangLaiSuat(list);
    }

}
