package controller;

import model.dao.LoaiSTKDAO;
import model.dao.ThamSoDAO;
import model.pojo.BangThamSo;
import model.pojo.LoaiSTK;
import ui.BangLaiSuat;

import java.util.List;

public class BangLaiSuatController {
    BangLaiSuat bangLaiSuat;

    public BangLaiSuatController(BangLaiSuat bangLaiSuat){
        this.bangLaiSuat=bangLaiSuat;
        List<LoaiSTK> stks= LoaiSTKDAO.layDSLoaiSTKHD();
        List<BangThamSo> qd= ThamSoDAO.layDSThamSoHD();
        bangLaiSuat.showBangLaiSuat(stks);
        bangLaiSuat.showQuyDinh(qd);
    }

}
