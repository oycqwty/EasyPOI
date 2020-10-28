package org.example;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.example.model.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        List<User> users = getUsers();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户信息列表", "用户信息"), User.class, users);
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\ouyangchuangqi\\Desktop\\666.xls");
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }
    public static List<User>  getUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setAge(10+i);
            user.setName(i+":kevin");
            user.setBirthday(new Date());
            if (i % 2 == 0) {
                user.setStatus(0);
                user.setHabbys(Arrays.asList("嘻嘻","哈哈"));
            } else {
                user.setStatus(1);
                user.setHabbys(Arrays.asList("嗷嗷","哦哦"));
            }
            users.add(user);
        }
        return users;
    }
}
