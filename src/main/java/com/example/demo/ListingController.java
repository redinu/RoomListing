package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ListingController {
	
	@Autowired
	ListingRepository listingRepository;
	
	@RequestMapping("/")
	public String list(Model listModel){
		
		Iterable<Listing> lists = listingRepository.findAll();
		listModel.addAttribute("lists", lists);
		return "list";
	}
	
	
	@RequestMapping(path="/add")
	public String addRoom(Model roomModel){
		roomModel.addAttribute("listing", new Listing());
		return "addForm";
		
	}
	
	@RequestMapping(path="/add", method= RequestMethod.POST)
	public String saveRoom(@Valid Listing room, BindingResult bindingResult){
		
		if(bindingResult.hasErrors()){
			return "addForm";
		}
		
		listingRepository.save(room);
	
		return "redirect:/";
		
	}
	
	@RequestMapping(path="/detail/{id}", method= RequestMethod.GET)
	public String showRoom(@PathVariable Long id, Model showModel){
		
		
		Listing list = listingRepository.findOne(id);
		showModel.addAttribute("room", list);
		showModel.addAttribute("roomId", id);
		return "details";
		
	}
	
	@RequestMapping(path="/delete")
	public String deleteRoom(@RequestParam Long id){
		
		listingRepository.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(path="/filter")
	public String filterListing(@RequestParam String isRented, Model listModel){
		
		Iterable<Listing> lists = listingRepository.findByIsRented(isRented);
		listModel.addAttribute("available",lists);
		return "list";
	}
}
