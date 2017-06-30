package jp.co.regal.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.regal.dto.test.AddressDto;
import jp.co.regal.dto.test.TestDto;
import jp.co.regal.form.FirstForm;
import jp.co.regal.form.TestForm;
import jp.co.regal.service.TestService;


@Controller
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public String test(Model model, @PathVariable int id) {
        TestDto test = testService.getTest(id);
        model.addAttribute("message", "あなたの管轄は以下のとおりです");
        model.addAttribute("test", test);
        return "test";
    }


    @RequestMapping(value = "/checkAddress", method = RequestMethod.GET)
    public String testDelete(Model model) {
    	List<AddressDto> address = testService.getAddress();
        TestForm form = new TestForm();
        model.addAttribute("testForm", form);
        model.addAttribute("address" , address);

        Map<Integer,String> selectAddress = testService.getAddressMap();
        model.addAttribute("selectAddress",selectAddress);

        return "checkAddress";
    }

    @RequestMapping(value = "/checkAddress", method = RequestMethod.POST)
    public String checkAddress(Model model, @ModelAttribute TestForm form) {
        TestDto test = testService.getTest(form.getId());
        model.addAttribute("message", "今回の管轄裁判所は以下のとおりです");
        model.addAttribute("test", test);
        return "test";
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public String top(Model model) {

    	return "top";
    }




    @RequestMapping(value = "/renunciation", method = RequestMethod.GET)
    public String houki(Model model) {

    	return "renunciation";
    }

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public String first(Model model) {
    	FirstForm form = new FirstForm();
    	form.setName("");
    	form.setAddress("");
    	model.addAttribute("first",form);

    	return "first";
    }

    @RequestMapping(value = "/first", method = RequestMethod.POST)
    public String firstinput(Model model, @ModelAttribute FirstForm form) {
    	MyCreatePdf createPdf = new MyCreatePdf();
    	createPdf.createPdf(form);
        model.addAttribute("first", form);
        return "sucsess";
    }
}
