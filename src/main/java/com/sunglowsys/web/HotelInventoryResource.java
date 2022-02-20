package com.sunglowsys.web;

import com.sunglowsys.domain.HotelInventory;
import com.sunglowsys.service.HotelInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@Controller
@RequestMapping("/")
public class HotelInventoryResource {

    private final Logger log = LoggerFactory.getLogger (HotelInventoryResource.class);

    private final HotelInventoryService hotelInventoryService;

    public HotelInventoryResource(HotelInventoryService hotelInventoryService) {
        this.hotelInventoryService = hotelInventoryService;

    }

    @GetMapping
    public String home(Pageable pageable, Model model) throws URISyntaxException {
        log.debug ("REST request to save hotelInventory:{}", pageable);
        Page<HotelInventory> page = hotelInventoryService.findAll (pageable);
        List<HotelInventory> hotelInventories = page.getContent ();
        model.addAttribute ("hotelInventory", hotelInventories);
        return "index";
    }

    @GetMapping
    public String createHotelInventory(Model model){
        HotelInventory hotelInventory = new HotelInventory ();
        model.addAttribute ("hotelInventory",hotelInventory );
        return "add-hotelInventory";
    }

    @PostMapping()
    public String create(@ModelAttribute("hotelInventory") HotelInventory hotelInventory) {
        if (hotelInventory.getId () == null) {
            hotelInventoryService.save (hotelInventory);
        }else {
            hotelInventoryService.save (hotelInventory);
        }
        return "redirect:/";
    }

    @GetMapping
    public String update(@PathVariable  Model model,Long id){
        HotelInventory hotelInventory1 = hotelInventoryService.findById (id).get ();
        model.addAttribute ("hotelInventory" ,hotelInventory1);
        return "add-hotelInventory";
    }

    @GetMapping("/delete/hotelInventory/{id}")
    public String delete(@PathVariable Long id){
        hotelInventoryService.delete (id);
        return "redirect:/";
    }

}