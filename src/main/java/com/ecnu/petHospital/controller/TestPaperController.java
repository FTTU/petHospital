package com.ecnu.petHospital.controller;

import com.ecnu.petHospital.param.PageParam;
import com.ecnu.petHospital.result.CommonResult;
import com.ecnu.petHospital.result.Result;
import com.ecnu.petHospital.service.TestPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/paper")
public class TestPaperController {

    @Autowired
    private TestPaperService testPaperService;

    @PostMapping("/getPaperList")
    public Result<?> getQuestionList(@RequestParam PageParam pageParam){

        return CommonResult.success().data(testPaperService.getTestPaperList(pageParam));
    }
}