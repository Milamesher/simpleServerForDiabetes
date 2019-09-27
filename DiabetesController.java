package com.diabetes.simpleserver;

import com.diabetes.simpleserver.DAO.DaoImpl;
import com.diabetes.simpleserver.model.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.diabetes.simpleserver.model.Card;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ejb.EJB;

/**
 * Created by Milamesher on 12.09.2019.
 */
@RestController
@RequestMapping("/diabetesCard")
public class DiabetesController {

    @RequestMapping(value = "/put", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String put(@RequestBody String data) {
        System.out.println(data);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Card card=null;
        try {
            DaoImpl d = new DaoImpl();
            card = gson.fromJson(data, Card.class);
            for (int i=0; i<card.getPar().size(); i++) {
                Parameter p = card.getPar().get(i);
                p.setCard(card);
            }
            d.save(card);
        }
        catch (JsonSyntaxException e) {
            return "{status: \"error\",errorname: \"_errorname_\"}".replace("_errorname_","Не удалось распарсить json!");
        }
        return "{status: \"ok\"}";
    }
}