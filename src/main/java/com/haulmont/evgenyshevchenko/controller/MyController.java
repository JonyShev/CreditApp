package com.haulmont.evgenyshevchenko.controller;

import com.haulmont.evgenyshevchenko.entity.Clients;
import com.haulmont.evgenyshevchenko.entity.Credit;
import com.haulmont.evgenyshevchenko.entity.ParametriCredita;
import com.haulmont.evgenyshevchenko.entity.Payment;
import com.haulmont.evgenyshevchenko.service.ClientsService;
import com.haulmont.evgenyshevchenko.service.CreditService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private CreditService creditService;

    @RequestMapping("/")
    public String showMainPage() {
        return "bank";
    }

    @RequestMapping("/showAllClients")
    public String showAllClients(Model model) {
        List<Clients> allClients = clientsService.getAllClients();
        model.addAttribute("allClients", allClients);

        return "all-clients";
    }

    @RequestMapping("/showAllCredit")
    public String showAllCredit(Model model) {
        List<Credit> allCredit = creditService.getAllCredit();
        model.addAttribute("allCredit", allCredit);

        return "all-credit";
    }

    @RequestMapping("/addNewClients")
    public String addNewClient(Model model) {
        Clients clients = new Clients();
        model.addAttribute("client", clients);
        return "clients-info";
    }

    @RequestMapping("/addNewCredit")
    public String addNewCredit(Model model) {
        Credit credit = new Credit();
        model.addAttribute("credit", credit);
        return "credit-info";
    }

    @RequestMapping("/saveClient")
    public String saveClient(@Valid @ModelAttribute("client") Clients clients, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "clients-info";
        } else {
            clientsService.saveClients(clients);
            return "redirect:/showAllClients";
        }
    }

    @RequestMapping("/saveCredit")
    public String saveCredit(@Valid @ModelAttribute("credit") Credit credit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "credit-info";
        } else {
            creditService.saveCredit(credit);
            return "redirect:/showAllCredit";
        }
    }

    @RequestMapping("/updateInfo")
    public String updateClients(@RequestParam("clientId") String id, Model model) {
        Clients clients = clientsService.getClients(id);
        model.addAttribute("client", clients);
        return "clients-info";
    }

    @RequestMapping("/updateCredit")
    public String updateCredit(@RequestParam("creditId") String id, Model model) {
        Credit credit = creditService.getCredit(id);
        model.addAttribute("credit", credit);
        return "credit-info";
    }

    @RequestMapping("/deleteClient")
    public String deleteClients(@RequestParam("clientId") String id) {
        clientsService.deleteClients(id);
        return "redirect:/showAllClients";
    }

    @RequestMapping("/deleteCredit")
    public String deleteCredit(@RequestParam("creditId") String id) {
        creditService.deleteCredit(id);
        return "redirect:/showAllCredit";
    }

    @RequestMapping("/checkoutCredit")
    public String checkoutCredit(@RequestParam("clientId") String id, Model model) {
        Clients clients = clientsService.getClients(id);
        model.addAttribute("client", clients);
        ParametriCredita parametriCredita = new ParametriCredita();
        model.addAttribute("parametriCredita", parametriCredita);
        return "credit-offer";
    }

    @RequestMapping("/showPayments")
    public String showPayments(@Valid @ModelAttribute("parametriCredita") ParametriCredita parametriCredita,
                               BindingResult bindingResult,
                               Model model) throws ParseException {
        if (bindingResult.hasErrors()) {
            return "credit-offer";
        } else {
            List<Credit> allCredit = creditService.getAllCredit();
            Credit credit = allCredit.stream().filter(x -> x.getLimit() > parametriCredita.getSumCredit())
                    .min((x, y) -> x.getLimit() - y.getLimit()).get();
            model.addAttribute("sumCredit", parametriCredita.getSumCredit());
            //переплата
            int pereplata = (int) (parametriCredita.getSumCredit() * (credit.getPercent() * 0.01));
            model.addAttribute("pereplata", pereplata);
            //всего выплат
            int allPayment = (int) (parametriCredita.getSumCredit() + pereplata);
            model.addAttribute("allPayment", allPayment);
            //процентная ставка
            int percent = credit.getPercent();
            model.addAttribute("percent", percent);
            //дата
            model.addAttribute("data", parametriCredita.getData());
            //Срок платежа
            model.addAttribute("years", parametriCredita.getYears());
            List<Payment> listPayment = getListPayments(parametriCredita, pereplata, percent);
            model.addAttribute("listPayment", listPayment);
            return "payments";
        }
    }

    private List<Payment> getListPayments(ParametriCredita parametriCredita, int pereplata, int percent) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        DecimalFormat doubleFormat = new DecimalFormat("##.00");
        Date docDate = format.parse(parametriCredita.getData());
        List<Payment> listPayment = new ArrayList<>();
        DecimalFormat f = new DecimalFormat("##.00");
        int n = Integer.valueOf((parametriCredita.getYears())) * 12;
        double platezhNotRound =  (parametriCredita.getSumCredit() + pereplata) / n;
        double platezh = (double) Math.round(platezhNotRound * 100) / 100;

        double ostatokNotRound = parametriCredita.getSumCredit() + pereplata;
        double ostatok = (double) Math.round(ostatokNotRound * 100) / 100;
        Payment payment = new Payment();
        payment.setDate(format.format(docDate));
        payment.setPlatezh(0);
        payment.setPercents(0);
        payment.setBodyCredit(0);
        payment.setOstatok(ostatok);
        listPayment.add(payment);
        double percentsNotRound = platezh * (percent * 0.01);
        double percents = (double) Math.round(percentsNotRound * 100) / 100;
        double bodyCreditNotRound = platezh - percents;
        double bodyCredit = (double) Math.round(bodyCreditNotRound * 100) / 100;
        double x = ostatok - platezh;
        for (int i = 0; i < n; i++) {
            Payment payment2 = new Payment();
            Date date = DateUtils.addMonths(docDate, i + 1);
            payment2.setDate(format.format(date));
            payment2.setPlatezh(platezh);
            payment2.setPercents(percents);
            payment2.setBodyCredit(bodyCredit);
            payment2.setOstatok(x);
            listPayment.add(payment2);
            x = x - platezh;
        }
        return listPayment;
    }
}
