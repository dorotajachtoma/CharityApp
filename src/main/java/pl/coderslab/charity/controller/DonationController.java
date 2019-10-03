package pl.coderslab.charity.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/donations")
public class DonationController {

    private DonationRepository donationRepository;
    private CategoryRepository categoryRepository;
    private InstitutionRepository institutionRepository;

    public DonationController(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @ModelAttribute(name = "categories")
    public List<Category> categoryList(){
        return categoryRepository.findAll();
    }

    @ModelAttribute(name = "institutions")
    public List<Institution> institutionsList(){
        return institutionRepository.findAll();
    }

    @RequestMapping(value = "/add-donation",method = RequestMethod.GET)
    public String saveDonation(Model model){
        model.addAttribute("donation",new Donation());
        return "add-donation";
    }

    @RequestMapping(value = "/add-donation", method = RequestMethod.POST)
    public String saveDonationPost(@Valid Donation donation, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/add-donation";
        }else{
            donation.setCategories(donation.getCategories());
            donationRepository.save(donation);
            return "redirect:/";
        }
    }

}
