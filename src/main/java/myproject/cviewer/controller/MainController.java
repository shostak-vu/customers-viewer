package myproject.cviewer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myproject.cviewer.dto.Admin;
import myproject.cviewer.dto.BlackList;
import myproject.cviewer.dto.Client;
import myproject.cviewer.service.AdminService;
import myproject.cviewer.service.BlackListService;
import myproject.cviewer.service.ClientService;

@Controller
public class MainController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private BlackListService blackListService;

    @RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
    public String start(Model model){
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth != null){
    		model.addAttribute("clientsList", clientService.getAll());
    	}
    	return "index";
    }
    
    @RequestMapping(value="/clients", method = RequestMethod.GET)
    public String clientsList(Model model){
    	
    		model.addAttribute("clientsList", clientService.getAll()); 
    	    	   	
        return "clientsList";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddView(Model model) {    	
    	model.addAttribute("clientAttribute", new Client()); 
    	return "addClient";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(
    		@ModelAttribute("clientAttribute") Client client, 
    		Model model) {    	
    	clientService.create(client);
    	return "redirect:/clients";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(
    		@RequestParam(value="id", required = true) Integer id, 
    		Model model) {  
    	Client client = clientService.getById(id);
    	clientService.delete(client);      
    	return "redirect:/clients";
    }
    
    @RequestMapping(value = "/change", method = RequestMethod.GET)
    public String change(
    		@RequestParam(value="id", required = true) Integer id, 
    		Model model) {
    	Client client = clientService.getById(id);
        model.addAttribute("clientAttribute", client); 
        return "editClient";
    }
        
   
    @RequestMapping(value = "/saveedit", method = RequestMethod.POST)
    public String saveEdit(@ModelAttribute("clientAttribute") Client client) {
    	clientService.update(client);  
    	return "redirect:/clients";
    }
    
    @RequestMapping(value="/blacklist", method = RequestMethod.GET)
    public String blackList(Model model){
    	
    		model.addAttribute("blacklistAtribute", blackListService.getAll()); 
    	    	   	
        return "blacklist";
    }
    
    @RequestMapping(value = "/toblacklist", method = RequestMethod.GET)
    public String toblacklist(
    		@RequestParam(value="id", required = true) Integer id, 
    		Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String name = auth.getName();
    	Admin admin = adminService.getByEmail(name);
    	System.out.println(admin.toString());
    	Client client = clientService.getById(id);
    	blackListService.create(client, admin, "Added from view");
        return "redirect:blacklist";
    }
    
    @RequestMapping(value = "/deleteblocked", method = RequestMethod.GET)
    public String deleteBlocked(
    		@RequestParam(value="id", required = true) Integer id, 
    		Model model) {  
    	BlackList blackListitem = blackListService.getById(id);
    	blackListService.delete(blackListitem);
    	return "redirect:/blacklist";
    }
    
    @RequestMapping(value = "/changeblocked", method = RequestMethod.GET)
    public String changeblocked(
    		@RequestParam(value="id", required = true) Integer id, 
    		Model model) {
    	BlackList blackListitem = blackListService.getById(id);
        model.addAttribute("blacklistItemAttribute", blackListitem);
        model.addAttribute("clientId", blackListitem.getClient().getId());
        model.addAttribute("adminId", blackListitem.getAdmin().getId());
        return "editBlocked";
    }
    @RequestMapping(value = "/saveBlocked", method = RequestMethod.POST)
    public String saveBlocked(@ModelAttribute("blacklistItemAttribute") BlackList blacklistItem) {
    	blackListService.update(blacklistItem);  
    	return "redirect:/blacklist";
    }
    
}
