package com.egabi.eg.projectmanagement.controllers.lkp;


import com.egabi.eg.projectmanagement.model.entities.lkp.LkpBusinessSubLine;
import com.egabi.eg.projectmanagement.model.services.kp.BaseLkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins ={ "http://localhost:8080","http://localhost:81" ,
        "http://localhost:4200" ,
        "http://localhost" ,
        "http://172.31.37.190:4200" ,
        "http://172.31.37.190:80" ,
        "http://172.31.37.190" ,
        "http://10.3.1.245:4040" ,
        "http://10.3.1.245" ,
        "http://10.1.5.158:4200"} )
@RestController
@RequestMapping("/PM/api/lkp/lkpBusinessSubLine")
public class LkpBusinessSubLineController extends LkpController<LkpBusinessSubLine,Long>{

    public LkpBusinessSubLineController(@Autowired BaseLkpService lkpBusinessSubLineService){
        super(lkpBusinessSubLineService);
    }
}


