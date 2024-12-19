package yahvya.practitionner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahvya.practitionner.datacontracts.practitionner.PractionnerService;
import yahvya.practitionner.datacontracts.practitionner.Practitionner;
import yahvya.practitionner.response.Response;

/**
 * @brief practitionner
 */
@RestController
@RequestMapping(path = "/practitionner")
public class PractitionnerController {
    @Autowired
    private PractionnerService practionnerService;

    /**
     * @brief create a practionner
     * @param practitionner practionner form
     * @return response
     */
    @PostMapping(path="/create")
    public Response create(@RequestBody Practitionner practitionner){
        Practitionner createdPractitionner = practionnerService.createPractitionner(practitionner);
        return new Response(createdPractitionner != null,createdPractitionner);
    }

    /**
     * @brief modify a practionner
     * @param practitionner practionner form
     * @return response
     */
    @PostMapping(path="/modify")
    public Response modify(@RequestBody Practitionner practitionner){
        Practitionner modifiedPractitionner = practionnerService.modifyPractitionner(practitionner);
        return new Response(modifiedPractitionner != null,modifiedPractitionner);
    }

    /**
     * @brief delete a practionner
     * @param practitionner practionner form
     * @return response
     */
    @PostMapping(path= "/delete")
    public Response delete(@RequestBody Practitionner practitionner){
        return new Response(practionnerService.deletePractitionner(practitionner),null);
    }

    /**
     * @brief delete a practionner
     * @return response
     */
    @GetMapping(path="/list")
    public Response listPractitionner(){
        return new Response(true,this.practionnerService.getAll());
    }

    /**
     * @brief get a practionner info
     * @param practitionnerId id
     * @return response
     */
    @GetMapping(path="/info/{practitionnerId}")
    public Response getInfo(@PathVariable String practitionnerId){
        Practitionner founded = this.practionnerService.getById(practitionnerId);
        return new Response(founded != null,founded);
    }
}
