package org.elves.webui.controller;

import dto.Img2ImgDTO;
import dto.Txt2ImgDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elves.webui.service.WebuiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import result.Result;
import vo.Img2ImgVO;
import vo.ModelVO;
import vo.Txt2ImgVO;

import java.util.List;

@RestController
@Slf4j
@Api(tags = "在线生图模块")
@RequestMapping("/webui")
public class WebuiContronller {
    @Autowired
    private WebuiService webuiService;

    @PostMapping("/txt2img")
    @ApiOperation(value = "文生图")
    public Result<Txt2ImgVO> txt2img(@RequestBody Txt2ImgDTO txt2ImgDTO) {
        log.info("文生图，{}", txt2ImgDTO);
        try {
            return Result.success(webuiService.txt2Img(txt2ImgDTO));
        } catch (Exception e) {
            throw new RuntimeException("生成图片失败：" + e.getMessage());
        }
    }
    @PostMapping("/img2img")
    @ApiOperation(value = "图生图")
    public Result<Img2ImgVO> img2img(@RequestBody Img2ImgDTO img2ImgDTO) {
        log.info("图生图，{}", img2ImgDTO);
        try {
            return Result.success(webuiService.img2img(img2ImgDTO));
        } catch (Exception e) {
            throw new RuntimeException("生成图片失败：" + e.getMessage());
        }
    }
    @GetMapping("/models")
    @ApiOperation(value = "图生图")
    public Result<List<ModelVO>> getModel() {
        log.info("获取模型，{}");
        try {
            return Result.success(webuiService.getModel());
        } catch (Exception e) {
            throw new RuntimeException("生成图片失败：" + e.getMessage());
        }
    }
}
