package com.vote.controller.backend;

import com.vote.controller.base.BaseController;
import com.vote.service.backend.VoteStatisticsService;
import com.vote.util.Const;
import com.vote.util.PageData;
import com.vote.util.VoteSingleAction;
import com.vote.util.enums.ResponseCode;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
public class VoteStatisticsController extends BaseController{

    @Autowired
    private VoteStatisticsService voteStatisticsService;

    @RequestMapping(value = "getBollotJSON.do",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getBollotJSON(@Param("name") String name){
        Map<String,Object> result = new HashMap<>();
        PageData pageData = voteStatisticsService.getBollotJSON(name);
        result.put("pd",pageData);
        return result;
    }
    @RequestMapping("isVote.do")
    @ResponseBody
    public Map<String,Object> voteItem(@Param("ip")String ip,@Param("city")String city,@Param("id")String voteid){
        Map<String,Object> result = new HashMap<>();
        ServletContext sc = request.getSession().getServletContext();
        VoteSingleAction vsa = (VoteSingleAction) sc.getAttribute(voteid);
        if (vsa == null) {
            vsa = VoteSingleAction.getCleanVoteSingleAction();
        }
        if (vsa.put(city,ip)){
            result.put(Const.CODE, ResponseCode.成功.getCode());
        }else{
            result.put(Const.CODE, ResponseCode.错误.getCode());
        }
        sc.setAttribute(voteid,vsa);
        return result;
    }

//    @Param("url")String url
    @RequestMapping("createEWM.do")
    public void createEWM(){
//        String url = "http://10.12.26.49:8080/jsp/a/show.jsp";
        String url = "http://10.12.26.49:8080/index.html";
        ByteArrayOutputStream out= QRCode.from(url).to(ImageType.PNG).stream();
        response.reset();
        response.setContentType("image/png");
        response.setContentLength(out.size());
        try {
            OutputStream os = response.getOutputStream();
            BufferedOutputStream bout = new BufferedOutputStream(os);
            bout.write(out.toByteArray());
            bout.close();
            os.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
