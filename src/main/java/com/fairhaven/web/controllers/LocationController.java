<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairhaven.web.controllers;

// Import log4j class
import com.fairhaven.db.dao.DAOFactory;
import com.fairhaven.db.entities.Location;
import com.fairhaven.web.forms.LocationZipFormbackingBean;
import java.util.Collection;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam
 */
@Controller
@RequestMapping(path = "/locations")
public class LocationController {

    private static final Logger logger = Logger.getLogger(LocationController.class.getName());

    @Resource
    private DAOFactory daof;

    /**
     *
     * @return
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView locationsIndex() {
        Collection<Location> locations = this.daof.getLocationDAO().findAll();
        ModelAndView mav = new ModelAndView("com.fairhaven.locations");
        mav.addObject("locations", locations);
        mav.addObject("zipBean", new LocationZipFormbackingBean());
        return mav;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView locationsIndex(@PathVariable("id") Location location) {
        Collection<Location> locations = this.daof.getLocationDAO().findAll();
        ModelAndView mav = new ModelAndView("com.fairhaven.locations");
        mav.addObject("locations", locations);
        mav.addObject("zipBean", new LocationZipFormbackingBean());
        return mav;
    }

    @RequestMapping(path = "/zip", method = RequestMethod.POST)
    public ModelAndView findLocation(@ModelAttribute("zipBean") @Valid LocationZipFormbackingBean zipBean, BindingResult results) {

        ModelAndView mav;

        if (results.hasErrors()) {
            mav = this.locationsIndex();
            mav.addObject("zipBean", zipBean);
        } else {
            mav = this.locationsIndex();
            mav.addObject("locations", this.daof.getLocationDAO().search(zipBean.getZip(), "zip"));
            mav.addObject("search_results", true);
            mav.addObject("zipBean", zipBean);

        }

        return mav;
    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fairhaven.web.controllers;



// Import log4j class
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam
 */

@Controller
@RequestMapping(path = "/locations")
public class LocationController {

    private static final Logger logger = Logger.getLogger(LocationController.class.getName());
    
<<<<<<< HEAD
    /**
     *
     * @return
     */
    @RequestMapping(path = "/locations.htm", method = RequestMethod.GET)
=======
    @RequestMapping(path = "/", method = RequestMethod.GET)
>>>>>>> login
    public ModelAndView news(){
        return new ModelAndView("com.fairhaven.locations");
    }

}
>>>>>>> 2bf9b035f0db61dbe80228b054532731c6f55b2d
