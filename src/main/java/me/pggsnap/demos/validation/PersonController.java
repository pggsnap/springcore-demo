package me.pggsnap.demos.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author pggsnap
 * @date 2020/5/4
 */
@RestController
@RequestMapping("/validation/person")
@Validated      // 针对 @RequestParam 形式的参数校验，需要设置
public class PersonController {

    /**
     * 校验 person，如果失败，通过 personBinding 捕获异常
     * @param person
     * @param personBinding
     * @return
     *
     * eg:
     *  curl -L -X POST 'http://127.0.0.1:8080/springcore/validation/person/add' -H 'Content-Type: application/json' -d '{ "birth": "2020-05-22", "email": "pggsnap", "asset": 1000.24 }'
     */
    @PostMapping("/add")
    public String add(@RequestBody @Validated Person person, BindingResult personBinding) {
        if (personBinding.hasErrors()) {
            for (FieldError fieldError : personBinding.getFieldErrors()) {
                System.out.println(fieldError.getField() + " error: " + fieldError.getDefaultMessage());
            }
            // throw exception
        }

        // add person
        return "success";
    }

    /**
     * 校验 person，如果失败，抛出异常，通过全局异常处理类 GlobalExceptionHandler 处理
     * @param person
     * @return
     *
     * eg:
     *  curl -L -X POST 'http://127.0.0.1:8080/springcore/validation/person/update' -H 'Content-Type: application/json' -d '{ "birth": "2020-05-22", "email": "pggsnap", "asset": 1000.2411, "cash": "1200.11" }'
     */
    @PostMapping("/update")
    public String update(@RequestBody @Validated Person person) {
        // update person
        return "success";
    }

    /**
     * @param name
     * @return
     *
     * eg:
     *  curl 'http://127.0.0.1:8080/springcore/validation/person/listpage?name='
     */
    @GetMapping("/listpage")
    public List<Person> listpage(
            @RequestParam(value = "name", required = false) @NotBlank(message = "name不能为空") String name) {
        return null;
    }
}
