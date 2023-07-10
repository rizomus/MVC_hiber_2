package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.PersonServiseInterface;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonServiseInterface personServise;

    @Autowired
    public PeopleController(PersonServiseInterface personServise) {
        this.personServise = personServise;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personServise.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personServise.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User user) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/new";

        personServise.save(user);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personServise.show(id));
        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid User user, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";

        personServise.update(id, user);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personServise.delete(id);
        return "redirect:/people";
    }
}