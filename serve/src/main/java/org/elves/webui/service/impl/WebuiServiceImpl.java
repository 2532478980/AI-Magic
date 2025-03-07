package org.elves.webui.service.impl;

import dto.Img2ImgDTO;
import dto.Txt2ImgDTO;
import org.elves.webui.service.WebuiService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vo.Img2ImgVO;
import vo.ModelVO;
import vo.Txt2ImgVO;

import java.util.*;

@Service
public class WebuiServiceImpl implements WebuiService {
    private final RestTemplate restTemplate;

    public WebuiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 文生图
     * @param txt2ImgDTO
     * @return
     * @throws Exception
     */
    @Override
    public Txt2ImgVO txt2Img(Txt2ImgDTO txt2ImgDTO) throws Exception{
        // 定义接口地址
        String url = "http://localhost:7861/sdapi/v1/txt2img";

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 构建请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", txt2ImgDTO.getPrompt());
        requestBody.put("steps", txt2ImgDTO.getSteps());
        requestBody.put("cfg_scale", txt2ImgDTO.getCfgScale());

        // 构建请求体
        HttpEntity<Txt2ImgDTO> requestEntity = new HttpEntity<>(txt2ImgDTO, headers);
        // 调用接口
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, requestEntity, Map.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> responseBody = responseEntity.getBody();
            if (responseBody != null) {
                Txt2ImgVO txt2ImgVO = new Txt2ImgVO();
                txt2ImgVO.setImages((List<String>) responseBody.get("images"));
                txt2ImgVO.setParameters(responseBody.get("parameters"));
                txt2ImgVO.setInfo((String) responseBody.get("info"));
                return txt2ImgVO;
            } else {
                throw new Exception("接口返回数据为空");
            }
        } else {
            throw new Exception("接口调用失败，状态码：" + responseEntity.getStatusCodeValue());
        }
    }

    @Override
    public Img2ImgVO img2img(Img2ImgDTO img2ImgDTO)throws Exception {
        // 定义接口地址
        String url = "http://localhost:7861/sdapi/v1/img2img";

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 构建请求体
        HttpEntity<Img2ImgDTO> requestEntity = new HttpEntity<>(img2ImgDTO, headers);

        // 调用接口
        ResponseEntity<Map> responseEntity = restTemplate.postForEntity(url, requestEntity, Map.class);

        // 检查响应状态
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            Map<String, Object> responseBody = responseEntity.getBody();
            if (responseBody != null) {
                // 封装返回结果
                Img2ImgVO img2ImgVO = new Img2ImgVO();
                img2ImgVO.setImages((List<String>) responseBody.get("images"));
                img2ImgVO.setParameters(responseBody.get("parameters"));
                img2ImgVO.setInfo((String) responseBody.get("info"));
                return img2ImgVO;
            } else {
                throw new Exception("接口返回空数据");
            }
        } else {
            throw new Exception("接口调用失败，状态码：" + responseEntity.getStatusCodeValue());
        }
    }

    @Override
    public List<ModelVO> getModel()throws Exception {
        // 定义接口地址
        String url = "http://localhost:7861/sdapi/v1/sd-models";

        // 调用接口
        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class);

        // 检查响应状
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            int i=0;
            List<Map<String, Object>> responseBody = (List<Map<String, Object>>) responseEntity.getBody();

            if (responseBody != null) {
                // 封装返回数据
                List<ModelVO> modelList = new ArrayList<>();
                for (Map<String, Object> item : responseBody) {
                    ModelVO model = new ModelVO();
                    model.setTitle((String) item.get("title"));
                    model.setModelName((String) item.get("model_name"));
                    model.setHash((String) item.get("hash"));
                    model.setSha256((String) item.get("sha256"));
                    model.setFilename((String) item.get("filename"));
                    model.setConfig((String) item.get("config"));
                    modelList.add(model);
                }
                return modelList;
            } else {
                throw new Exception("接口返回数据为空");
            }
        } else {
            throw new Exception("接口调用失败，状态码：" + responseEntity.getStatusCodeValue());
        }
    }
}


