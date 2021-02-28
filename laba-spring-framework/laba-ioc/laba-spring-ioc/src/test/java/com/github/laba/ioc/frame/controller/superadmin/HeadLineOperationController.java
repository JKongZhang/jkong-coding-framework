package com.github.laba.ioc.frame.controller.superadmin;

//
//import com.github.laba.ioc.core.annotation.Controller;
//import com.github.laba.ioc.entity.bo.HeadLine;
//import com.github.laba.ioc.entity.dto.Result;
//import com.github.laba.ioc.entity.test.Paper_url;
//import com.github.laba.ioc.frame.com.github.laba.mvc.service.HeadLineService;
//import com.github.laba.ioc.inject.annotation.Autowired;
//
//import javax.management.Query;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//@RequestMapping(value = "headline")
//public class HeadLineOperationController {
//    @Autowired(value = "HeadLineServiceImpl")
//    private HeadLineService headLineService;
//    //添加
//    @RequestMapping(value = "add",method = RequestMethod.POST)
//  public ModelAndView addHeadLine(@RequestParam("lineName") String lineName,
//                                  @RequestParam("lineLink") String lineLink,
//                                  @RequestParam("lineImg") String lineImg,
//                                  @RequestParam("priority") Integer priority){
//        HeadLine headLine = new HeadLine();
//        headLine.setLineName(lineName);
//        headLine.setLineImg(lineImg);
//        headLine.setLineLink(lineLink);
//        headLine.setPriority(priority);
//        //TODO
//        Result<Boolean> result = headLineService.addHeadLine(headLine);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setView("addHeadline.jsp").addViewData("result",result);
//        return  modelAndView;
//    }
//    @RequestMapping(value = "toadd",method = RequestMethod.GET)
//    public ModelAndView toAddPage(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setView("addHeadline.jsp");
//        return modelAndView;
//    }
//    //删除
//    @RequestMapping(value = "remove",method = RequestMethod.GET)
//     public void emoveHeadLine(){
//        Query query = QueryFactory.createQuery();
//        Paper_url paper_url = new Paper_url();
//        paper_url.setPaper_id(222);
//        query.delete(paper_url);
//        //TODO
//        System.out.println("删除headline");
//    }
//    //修改
//   public Result<Boolean>  modifyHeadLine(HttpServletRequest req, HttpServletResponse resp){
//        //TODO
//        return headLineService.modifyHeadLine(new HeadLine());
//    }
//    //查询
//
//    public Result<HeadLine> queryHeadlineById(){
//        //TODO
//        return headLineService.queryHeadlineById(1);
//    }
//    //获取头条列表
//    @ResponseBody
//    @RequestMapping(value = "query",method = RequestMethod.GET)
//    public Result<List<HeadLine>>  queryHeadline(){
//        return headLineService.queryHeadline(null,1,100);
//    }
//}
