package com.infiniteskills.mvc.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.infiniteskills.mvc.data.entities.Resource;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model){
		
//		replaced with @Modelattribute methodss
		/*List<String> options = getTypes();
		model.addAttribute("typeOptions", options);

		List<String> radios =getRadios(); 
		model.addAttribute("radioOptions", radios);

		List<String> checks = getChecks();
		model.addAttribute("checkOptions", checks);
*/
		
//		model.addAttribute("resource",new Resource());
		return "resource_add";
	}
	
	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource){
		
		System.out.println("Inovking review");
		return "resource_review";
		
	}
	
	
	
	@ModelAttribute("resource")
	public Resource getResource(){
		return new Resource();
	}
	
	
	@ModelAttribute("typeOptions")
	public List<String> getTypes(){
		return new LinkedList<>(Arrays.asList(new String[]{"Material","Other","Staff","Technical Equipment"}));	
		}
	
	
	@ModelAttribute("radioOptions")
	public List<String> getRadios(){
		return new LinkedList<>(Arrays.asList(new String[]{"Hours","Piece","Tons"}));		}
	
	
	@ModelAttribute("checkOptions")
	public List<String> getChecks(){
		return new LinkedList<>(Arrays.asList(new String[]{"Lead Time","Special Rate","Requires Approval"}));
		}
	
	
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource){
		System.out.println("Invoking the save() method.");
//		return "resource_add";
		System.out.println(resource);
		return "redirect:/resource/add";
	}
}
