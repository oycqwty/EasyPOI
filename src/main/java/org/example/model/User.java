package org.example.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by Kevin on 2020/10/28
 */

@Data
public class User {
//    @Excel(name = "编号",suffix = ".No")
    @ExcelIgnore
    private Integer id;
    @Excel(name = "姓名",orderNum = "2")
    private String name;
    @Excel(name = "年龄",orderNum = "3")
    private Integer age;
    @Excel(name = "生日",width = 40,orderNum = "1",exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    @Excel(name = "状态",replace = {"激活_1","锁定_0"})
    private Integer status;

    @ExcelIgnore //直接获取是list的json,要处理重新定义字段 easypoi会调用get方法返回
    private List<String> habbys;

    @Excel(name = "爱好",width = 20,orderNum = "4")
    private String habbysStr;

    public String getHabbysStr() {
        StringBuilder sb = new StringBuilder();
        for (String habby : habbys) {
            sb.append(habby).append("-");
        }
        return sb.toString();
    }
}
