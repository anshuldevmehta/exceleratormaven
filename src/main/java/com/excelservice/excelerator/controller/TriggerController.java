package com.excelservice.excelerator.controller;

import com.excelservice.excelerator.excel.ExcelMapper;
import com.excelservice.excelerator.excel.model.SampleModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("excelerator")
public class TriggerController {

    @GetMapping("/read")
    public List<SampleModel> readExcel()
    {
        File sampleHrl = new File(getClass().getResource("/SampleHRL.xlsx").getPath());
        List<SampleModel> hrlItems = new ArrayList<>();
        try {
           hrlItems = ExcelMapper.mapFromExcel(sampleHrl)
                    .toObjectOf(SampleModel.class)
                    .fromSheet(0) // if this method not used , called all sheets
                    .map();
        }
        catch (Exception e)
        {
            SampleModel sampleExceptionModel=new SampleModel();
            sampleExceptionModel.setName(e.getMessage());
            hrlItems.add(sampleExceptionModel);
        }
        catch (Throwable e) {
            throw new RuntimeException(e);
        }

        return hrlItems;
    }

}
