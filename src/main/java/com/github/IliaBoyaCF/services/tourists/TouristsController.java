package com.github.IliaBoyaCF.services.tourists;

import com.github.IliaBoyaCF.database.TouristQueries;
import com.github.IliaBoyaCF.database.entities.Tourist;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TouristsController {

    @GetMapping("/tourists")
    public List<TouristRepresentation> getAllTourists() {
        return TouristQueries.getTourists().stream()
                .map(t -> new TouristRepresentation(t.getId(), t.getFirstname(), t.getPassportData(), t.getGender()))
                .toList();
    }

    @GetMapping("/add_tourist")
    public TouristRepresentation addTourist(@RequestParam(value = "firstname") String firstname,
                                            @RequestParam(value = "passport_info") String passportInfo,
                                            @RequestParam(value = "gender") String gender) {
        Tourist tourist = new Tourist(firstname, passportInfo, gender);

        TouristQueries.addNew(tourist);

        return new TouristRepresentation(tourist.getId(), tourist.getFirstname(), tourist.getPassportData(), tourist.getGender());
    }

}
