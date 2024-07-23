package com.chi.demo02.mvc01todolist;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoservice;

    @RequestMapping(value = "/todo/list", method = RequestMethod.GET)
    public String list(ModelMap model) {
        List<Todo> list = todoservice.findByName("usera");
        model.addAttribute("list", list);
        return "/mvc01/list";
    }

    @RequestMapping(value = "/todo/add", method = RequestMethod.GET)
    public String add(ModelMap model) {
        String name = (String)model.get("name");
        String localDate = LocalDate.now().toString();
        var todo = new Todo(name , "Default name", localDate, false);
        model.put("todo", todo);
        return "/mvc01/add";
    }

    /* v1: @SessionAttribute("name") 以參數傳入，以新 Todo 物件方式新增
     *     (未登入的話會報錯)
     */
    @RequestMapping(value = "/todo/insert/v1", method = RequestMethod.POST)
    public String insertV1(@SessionAttribute("name") String name, @RequestParam Map<String, String> params) {
        todoservice.addOne(new Todo(name, params.get("d_title"), params.get("d_date"), false));
        return "redirect:/todo/list";
    }

    /* v2: 綁定 Todo 物件，同時在 view 引入表單標籤庫綁定
     *     加入驗證 @Valid
     */
    @RequestMapping(value = "/todo/insert/v2", method = RequestMethod.POST)
    public String insertV2(ModelMap model, @Valid Todo todo) {
        String name = (String)model.get("name");
        if(name.isEmpty()) name = "guest";
        todo.setName(name);
        todoservice.addOne(todo);
        return "redirect:/todo/list";
    }

    @RequestMapping(value = "/todo/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int id) {
        todoservice.deleteById(id);
        return "redirect:list";
    }

    // 靜態頁面寫法
    @RequestMapping(value = "/todo/edit", method = RequestMethod.GET)
    public String edit(@RequestParam int id, ModelMap model) {
        Todo todo = todoservice.findById(id);
        model.addAttribute(todo);
        return "mvc01/edit";
    }

    @RequestMapping(value = "/todo/update", method = RequestMethod.POST)
    public String update(@RequestParam int id, ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()) {
            return "mvc01/edit";
        }

        if(todoservice.findById(todo.getId()) != null) {
            String name = (String)model.getAttribute("name");
            todo.setName(name);
            todoservice.updateById(id, todo);
        }

        return "redirect:list";
    }

}
