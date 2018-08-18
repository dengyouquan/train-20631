package io.choerodon.demo.api.controller.v1;

import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Program: train-20631
 * @Description:
 * @Author: Youquan Deng
 * @Create: 2018-08-18 10:20
 **/
@RestController
//@ConfigurationProperties(prefix = "person")
public class HelloController {
    @Value("${person.name}")
    private String name;
    @Value("${person.id}")
    private String id;

    @GetMapping("/hello")
    @Permission(level = ResourceLevel.SITE, permissionPublic = true)
    @ApiOperation(value = "hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("hello，" + id + "，" + name, HttpStatus.OK);
    }

}
