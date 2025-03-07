package org.elves.webui.service;

import dto.Img2ImgDTO;
import dto.Txt2ImgDTO;
import vo.Img2ImgVO;
import vo.ModelVO;
import vo.Txt2ImgVO;

import java.util.List;

public interface WebuiService {
    Txt2ImgVO txt2Img(Txt2ImgDTO txt2ImgDTO) throws Exception;

    Img2ImgVO img2img(Img2ImgDTO img2ImgDTO) throws Exception;

    List<ModelVO> getModel() throws Exception;
}
